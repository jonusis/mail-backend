package com.example.mail.Service;

import com.example.mail.Mapper.*;
import com.example.mail.Pojo.*;
import com.example.mail.ResultSet.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PinpinService {
    @Autowired
    OrderbuyMapper orderbuyMapper;

    @Autowired
    OrderCarMapper ordercarMapper;

    @Autowired
    P2OrdersMapper p2OrdersMapper;

    @Autowired
    CommentsMapper commentsMapper;

    @Autowired
    UserMapper userMapper;

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
                    return "You have joined this buy order";
                }
            }
            chooseOrderbuy.setNumExist(chooseOrderbuy.getNumExist() + 1);
            if(chooseOrderbuy.getNumExist() == chooseOrderbuy.getNumNeed()){
                chooseOrderbuy.setFull(1);
            }
            orderbuyMapper.updateOrderBuy(new Orderbuy(chooseOrderbuy));
            p2OrdersMapper.addP2Order(new P2Orders(pid + 1,0,uid,orderID));
            return "user add success";
        }
    }
    public List<Orderbuy> queryOrderbuyListByUserID(int userID) {
        return orderbuyMapper.queryOrderBuyListByUserID(userID);
    }

    public List<String> getUserPicByOid(int id) {
        List<Integer> uidList = p2OrdersMapper.getUidByOid(id);
        List<String> userPic = new ArrayList<>();
        for(int i = 0; i < uidList.size(); i++) {
            userPic.add(userMapper.queryUserById(uidList.get(i)).getHeadPicture());
        }
        return userPic;
    }

    public void addComments(String content, int orderbuyID, int ordercarID, String userID) {
        int id = commentsMapper.selectIdMaxComments();
        Date datetime = new Date();
        commentsMapper.addComments(id + 1,datetime,content,orderbuyID,ordercarID,userID);
    }

    public List<Comments> queryCommentsList() {
        return commentsMapper.queryCommentsList();
    }

    public void updateComments(int id, Date datetime, String content, int orderbuyID, int ordercarID, String userID) {
        commentsMapper.updateComments(id,datetime,content,orderbuyID,ordercarID,userID);
    }

    public void deleteComments(int id) {
        commentsMapper.deleteComments(id);
    }

    public List<Map> getCommentsDetailByOid(int id) {
        List<Map> commentsDetail = new ArrayList<>();
        List<Integer> uidList = commentsMapper.getUidByOid(id);
        List<Comments> commentsList = commentsMapper.queryCommentsList();
        for (int i = 0; i < commentsList.size(); i++) {
            Map<String,String> map = new HashMap<>();
            map.put("username",userMapper.queryUserById(uidList.get(i)).getAccount());
            map.put("headpicture",userMapper.queryUserById(uidList.get(i)).getHeadPicture());
            map.put("content",commentsList.get(i).getContent());
            map.put("datatime",commentsList.get(i).getDatetime().toString());
            commentsDetail.add(map);
        }
        return commentsDetail;
    }
}
