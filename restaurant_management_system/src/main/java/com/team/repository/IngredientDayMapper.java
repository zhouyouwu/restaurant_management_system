package com.team.repository;

import com.team.entity.IngredientDay;
import com.team.entity.IngredientDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDayMapper {
    int countByExample(IngredientDayExample example);

    int deleteByExample(IngredientDayExample example);

    int deleteByPrimaryKey(Integer ingredientId);

    int insert(IngredientDay record);

    int insertSelective(IngredientDay record);

    List<IngredientDay> selectByExample(IngredientDayExample example);

    IngredientDay selectByPrimaryKey(Integer ingredientId);

    int updateByExampleSelective(@Param("record") IngredientDay record, @Param("example") IngredientDayExample example);

    int updateByExample(@Param("record") IngredientDay record, @Param("example") IngredientDayExample example);

    int updateByPrimaryKeySelective(IngredientDay record);

    int updateByPrimaryKey(IngredientDay record);
}