package com.team.repository;

import com.team.entity.Price;
import com.team.entity.PriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceMapper {
    int countByExample(PriceExample example);

    int deleteByExample(PriceExample example);

    int deleteByPrimaryKey(Integer dishesId);

    int insert(Price record);

    int insertSelective(Price record);

    List<Price> selectByExample(PriceExample example);

    Price selectByPrimaryKey(Integer dishesId);

    int updateByExampleSelective(@Param("record") Price record, @Param("example") PriceExample example);

    int updateByExample(@Param("record") Price record, @Param("example") PriceExample example);

    int updateByPrimaryKeySelective(Price record);

    int updateByPrimaryKey(Price record);
}