package com.team.repository;

import com.team.entity.Restaurant;
import com.team.entity.RestaurantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantMapper {
    int countByExample(RestaurantExample example);

    int deleteByExample(RestaurantExample example);

    int deleteByPrimaryKey(Integer restaurantId);

    int insert(Restaurant record);

    int insertSelective(Restaurant record);

    List<Restaurant> selectByExample(RestaurantExample example);

    Restaurant selectByPrimaryKey(Integer restaurantId);

    List<Restaurant> selectAll();//添加

    int updateByExampleSelective(@Param("record") Restaurant record, @Param("example") RestaurantExample example);

    int updateByExample(@Param("record") Restaurant record, @Param("example") RestaurantExample example);

    int updateByPrimaryKeySelective(Restaurant record);

    int updateByPrimaryKey(Restaurant record);
}