package com.example.mail.Mapper;

import com.example.mail.Pojo.Order;
import com.example.mail.Pojo.OrderCar;
import com.example.mail.Pojo.Orderbuy;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderCarMapper {
    List<OrderCar> queryOrderCarList();

    void addOrderCar(OrderCar ordercar);

    int selectIdMaxOrderCar();

    void deleteOrderCar(int id);

    void updateOrderCar(OrderCar orderCar);

    List<OrderCar> selectOrderCarById(int id);

    List<OrderCar> queryOrderCarListByUserID(int userID);
}
