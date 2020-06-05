package com.team.repository;

import com.team.entity.IngredientTotal;
import com.team.entity.IngredientTotalExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientTotalMapper {
    int countByExample(IngredientTotalExample example);

    int deleteByExample(IngredientTotalExample example);

    int deleteByPrimaryKey(Date ingredientDate);

    int insert(IngredientTotal record);

    int insertSelective(IngredientTotal record);

    List<IngredientTotal> selectByExample(IngredientTotalExample example);

    IngredientTotal selectByPrimaryKey(Date ingredientDate);

    int updateByExampleSelective(@Param("record") IngredientTotal record, @Param("example") IngredientTotalExample example);

    int updateByExample(@Param("record") IngredientTotal record, @Param("example") IngredientTotalExample example);

    int updateByPrimaryKeySelective(IngredientTotal record);

    int updateByPrimaryKey(IngredientTotal record);
}