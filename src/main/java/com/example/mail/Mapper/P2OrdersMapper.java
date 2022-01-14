package com.example.mail.Mapper;

import com.example.mail.Pojo.Order;
import com.example.mail.Pojo.OrderCar;
import com.example.mail.Pojo.P2Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface P2OrdersMapper {
    List<P2Orders> searchP2OrdersList(int orderID, int kind);

    void addP2Order(P2Orders p2Orders);

    int selectIdMaxP2Order();

    List<Integer> getUidByOid(int id);

    List<Integer> getBuyUidByOid(int id);
}
