package com.team.repository;

import com.team.entity.Ingredient;
import com.team.entity.IngredientExample;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientMapper {
    int countByExample(IngredientExample example);

    int deleteByExample(IngredientExample example);

    int deleteByPrimaryKey(Integer ingredientId);

    int insert(Ingredient record);

    int insertSelective(Ingredient record);

    List<Ingredient> selectByExample(IngredientExample example);

    Ingredient selectByPrimaryKey(Integer ingredientId);

    List<Ingredient> selectByDate(Date ingredientDate);//添加

    int updateByExampleSelective(@Param("record") Ingredient record, @Param("example") IngredientExample example);

    int updateByExample(@Param("record") Ingredient record, @Param("example") IngredientExample example);

    int updateByPrimaryKeySelective(Ingredient record);

    int updateByPrimaryKey(Ingredient record);
}