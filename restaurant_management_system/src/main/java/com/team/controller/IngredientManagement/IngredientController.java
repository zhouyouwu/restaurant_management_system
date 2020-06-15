package com.team.controller.IngredientManagement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.team.entity.Ingredient;
import com.team.entity.IngredientTotal;
import com.team.repository.IngredientMapper;
import com.team.repository.IngredientTotalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**当天原料信息管理增删改查
 * getIngredient（get）
 * addIngredient（post）
 * updateIngredient（post）
 * deleteIngredient（get）
 */
@RestController
@RequestMapping(value = "/Ingredient")
public class IngredientController {
    @Autowired
    private IngredientMapper ingredientMapper;
    @Autowired
    private IngredientTotalMapper ingredientTotalMapper;

    private final GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd");
    private final Gson gson = gsonBuilder.create();

    /**查询所有当天原料信息
     *
     * @return
     * "[{\"ingredientId\":2,
     * \"ingredientDate\":\"2020-06-05\",
     * \"ingredientName\":\"土豆\",
     * \"ingredientCount\":80.0,
     * \"ingredientPrice\":3.0,
     * \"addDecrease\":1}]"
     */
    @GetMapping(value = "/getIngredient")
    public String getIngredient(Date date){
        List<Ingredient> ingredientList = ingredientMapper.selectByDate(date);
        return gson.toJson(ingredientList);
    }

    /**用于添加当天原料信息
     * {
     * 	"ingredientName":"土豆",
     * 	"ingredientCount":100,
     * 	"ingredientPrice":1.5,
     * 	"addDecrease":1
     * }
     * 同时url上要绑定餐厅的id
     * 当天第一次发送请求添加数据，则会自动生成今天的ingredient_total表数据
     * @param ingredient
     * @param restaurantId
     * @return
     * 成功返回添加的全部信息
     * 失败返回"{\"ingredientId\":-1}"
     */
    @PostMapping(value = "/addIngredient")
    public String addIngredient(@RequestBody Ingredient ingredient, @RequestParam Integer restaurantId){
        ingredient.setIngredientDate(new Date(System.currentTimeMillis()));
        //测试总计原料表有没有今天的项，有则直接添加原材料，没有则添加总计项，再加原料
        if(ingredientTotalMapper.selectByPrimaryKey(ingredient.getIngredientDate()) == null){
            IngredientTotal newIngredientTotal = new IngredientTotal();
            newIngredientTotal.setIngredientDate(ingredient.getIngredientDate());
            newIngredientTotal.setDetails(gson.toJson(ingredient));
            newIngredientTotal.setRestaurantId(restaurantId);
            if (ingredientTotalMapper.insert(newIngredientTotal) <= 0)
                return "{\"ingredientId\":-1,\"message\":\"总计创建失败\"}";
        }
        if(ingredientMapper.insert(ingredient) > 0){
            return gson.toJson(ingredient);
        }else {
            return "{\"ingredientId\":-1}";
        }
    }

    /**修改当天的原料信息
     * {
     * 	"ingredientId":2,必须选项
     * 	"ingredientDate":"2020-6-5",可选
     * 	"ingredientName":"土豆",可选
     * 	"ingredientCount":80,可选
     * 	"ingredientPrice":3,可选
     * 	"addDecrease":1可选
     * }
     * 建议只修改数目和价格，其余出错删除
     * @param ingredient
     * @return
     * 成功返回修改后全部数据
     * 失败返回"{\"ingredientId\":-1}"
     */
    @PostMapping(value = "/updateIngredient")
    public String updateIngredient(@RequestBody Ingredient ingredient){
        if(ingredientMapper.updateByPrimaryKeySelective(ingredient) > 0){
            return gson.toJson(ingredientMapper.selectByPrimaryKey(ingredient.getIngredientId()));
        }else {
            return "{\"ingredientId\":-1}";
        }
    }

    /**get请求根据id删除那条数据项
     *
     * @param ingredientId
     * @return
     * 成功返回"{\"ingredientId\":0}"
     * 失败返回"{\"ingredientId\":-1}"
     */
    @GetMapping(value = "/deleteIngredient")
    public String deleteIngredient(@RequestParam Integer ingredientId){
        if(ingredientMapper.deleteByPrimaryKey(ingredientId) > 0){
            return "{\"ingredientId\":0}";
        }else {
            return "{\"ingredientId\":-1}";
        }
    }
}
