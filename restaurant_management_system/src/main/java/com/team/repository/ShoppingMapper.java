package com.team.repository;

import com.team.entity.Shopping;
import com.team.entity.ShoppingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShoppingMapper {
    int countByExample(ShoppingExample example);

    int deleteByExample(ShoppingExample example);

    int deleteByPrimaryKey(Integer shoppingId);

    int insert(Shopping record);

    int insertSelective(Shopping record);

    List<Shopping> selectByExample(ShoppingExample example);

    Shopping selectByPrimaryKey(Integer shoppingId);

    int updateByExampleSelective(@Param("record") Shopping record, @Param("example") ShoppingExample example);

    int updateByExample(@Param("record") Shopping record, @Param("example") ShoppingExample example);

    int updateByPrimaryKeySelective(Shopping record);

    int updateByPrimaryKey(Shopping record);
}