package com.team.repository;

import com.team.entity.Order;
import com.team.entity.OrderExample;

import java.sql.Date;
import java.util.List;

import com.team.entity.ShoppingDishes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);//修改

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer orderId);

    List<Order> selectAll();//添加

    List<Order> selectByDate(Date orderDate);//添加

    List<ShoppingDishes> selectByDateDishesId(@Param("orderDate") Date orderDate, @Param("dishesId") Integer dishesId);//添加 返回点菜的数量

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}