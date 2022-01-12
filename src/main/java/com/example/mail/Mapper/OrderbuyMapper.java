package com.example.mail.Mapper;

import com.example.mail.Pojo.OrderCar;
import com.example.mail.Pojo.Orderbuy;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface OrderbuyMapper {
    void addOrderBuy(int id, Date datetime, String time, String tel, String qq, String wechat, int numNeed, String heading, String content, String postID, int kind, String location, String picture);

    List<Orderbuy> queryOrderBuyList();

    int selectIdMaxOrderBuy();

    List<Orderbuy> getOrderBuyList(int kind);

    List<Orderbuy> queryOrderBuyListByUserID(int userID);

    List<Orderbuy> selectOrderBuyById(int id);

    void deleteOrderBuy(int id);

    void updateOrderBuy(Orderbuy orderbuy);
}
