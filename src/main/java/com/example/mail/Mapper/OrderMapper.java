package com.example.mail.Mapper;

import com.example.mail.Pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    List<Order> queryOrderList();

    Order queryOrderByOid(int oid);

    List<Order> queryOrderByBid(int bid);

    List<Order> queryOrderByGid(int gid);

    void addOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(int oid);

    int selectIdMaxOrder();
}
