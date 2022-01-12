package com.example.mail.Service;

import com.example.mail.Mapper.OrderCarMapper;
import com.example.mail.Mapper.OrderbuyMapper;
import com.example.mail.Mapper.P2OrdersMapper;
import com.example.mail.Mapper.UserMapper;
import com.example.mail.Pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PinpinService {
    @Autowired
    OrderbuyMapper orderbuyMapper;

    @Autowired
    OrderCarMapper ordercarMapper;

    @Autowired
    P2OrdersMapper p2OrdersMapper;

    public void addOrdercar(OrderCar ordercar) {
        int cid = ordercarMapper.selectIdMaxOrderCar();
        int pid = p2OrdersMapper.selectIdMaxP2Order();
        p2OrdersMapper.addP2Order(new P2Orders(pid + 1,1,Integer.parseInt(ordercar.getPostID()),ordercar.getId()));
        ordercarMapper.addOrderCar(new OrderCar(cid+1,ordercar.getTime(),ordercar.getTel(),ordercar.getQq(),ordercar.getWechat(),ordercar.getNumNeed(),1,ordercar.getHeading(),ordercar.getContent(),ordercar.getPostID(),0,ordercar.getPlaceA(),ordercar.getPlaceB()));
        return;
    }

    public List<OrderCar> queryOrderCarList() {
        return ordercarMapper.queryOrderCarList();
    }

    public String userJoinOrderCar(int uid,int orderId){
        OrderCar chooseOrderCar = ordercarMapper.selectOrderCarById(orderId).get(0);
        int pid = p2OrdersMapper.selectIdMaxP2Order();
        if(chooseOrderCar.getFull() == 1){
            return "this order has fulled";
        }else{
            List<P2Orders> list = p2OrdersMapper.searchP2OrdersList(orderId,1);
            for(P2Orders p2Orders : list){
                if(p2Orders.getUserID() == uid){
                    return "You have joined this car order";
                }
            }
            chooseOrderCar.setNumExist(chooseOrderCar.getNumExist() + 1);
            if(chooseOrderCar.getNumExist() == chooseOrderCar.getNumNeed()){
                chooseOrderCar.setFull(1);
            }
            ordercarMapper.updateOrderCar(new OrderCar(chooseOrderCar));
            p2OrdersMapper.addP2Order(new P2Orders(pid + 1,1,uid,orderId));
            return "user add success";
        }
    }

    public List<OrderCar> queryOrderCarListByUserID(int userID) {
        return ordercarMapper.queryOrderCarListByUserID(userID);
    }

    public void addOrderbuy(String time, String tel, String qq, String wechat, int numNeed, String heading, String content, String postID, int kind,String location, String picture) {
        int id = orderbuyMapper.selectIdMaxOrderBuy();
        int pid = p2OrdersMapper.selectIdMaxP2Order();
        Date datetime = new Date();
        p2OrdersMapper.addP2Order(new P2Orders(pid + 1,0,Integer.parseInt(postID),id));
        orderbuyMapper.addOrderBuy(id + 1,datetime,time,tel,qq,wechat,numNeed,heading,content,postID,kind,location,picture);
        return;
    }

    public List<Orderbuy> queryOrderBuyList() {
        return orderbuyMapper.queryOrderBuyList();
    }

    public List<Orderbuy> getOrderbuyList(int kind) {
        return orderbuyMapper.getOrderBuyList(kind);
    }

    public Orderbuy getOrderBuyById(int id) {
        return orderbuyMapper.selectOrderBuyById(id).get(0);
    }

    public String userJoinOrderBuy(int uid, int orderID) {
        Orderbuy chooseOrderbuy = orderbuyMapper.selectOrderBuyById(orderID).get(0);
        int pid = p2OrdersMapper.selectIdMaxP2Order();
        if(chooseOrderbuy.getFull() == 1){
            return "this order has fulled";
        }else{
            List<P2Orders> list = p2OrdersMapper.searchP2OrdersList(orderID,0);
            for(P2Orders p2Orders : list){
                if(p2Orders.getUserID() == uid){
                    return "You have joined this car order";
                }
            }
            chooseOrderbuy.setNumExist(chooseOrderbuy.getNumExist() + 1);
            if(chooseOrderbuy.getNumExist() == chooseOrderbuy.getNumNeed()){
                chooseOrderbuy.setFull(1);
            }
            orderbuyMapper.updateOrderBuy(new Orderbuy(chooseOrderbuy));
            p2OrdersMapper.addP2Order(new P2Orders(pid + 1,1,uid,orderID));
            return "user add success";
        }
    }
    public List<Orderbuy> queryOrderbuyListByUserID(int userID) {
        return orderbuyMapper.queryOrderBuyListByUserID(userID);
    }


}
