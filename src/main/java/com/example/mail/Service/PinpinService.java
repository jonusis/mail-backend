package com.example.mail.Service;

import com.example.mail.Mapper.*;
import com.example.mail.Pojo.*;
import com.example.mail.ResultSet.CodeMsg;
import com.example.mail.ResultSet.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

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

    public Result<String> userJoinOrderCar(int uid,int orderId){
        OrderCar chooseOrderCar = ordercarMapper.selectOrderCarById(orderId).get(0);
        int pid = p2OrdersMapper.selectIdMaxP2Order();
        if(chooseOrderCar.getFull() == 1){
            return Result.error(new CodeMsg(400,"this order has fulled"));
        }else{
            List<P2Orders> list = p2OrdersMapper.searchP2OrdersList(orderId,1);
            for(P2Orders p2Orders : list){
                if(p2Orders.getUserID() == uid){
                    return Result.error(new CodeMsg(400,"you have joined this order"));
                }
            }
            chooseOrderCar.setNumExist(chooseOrderCar.getNumExist() + 1);
            if(chooseOrderCar.getNumExist() == chooseOrderCar.getNumNeed()){
                chooseOrderCar.setFull(1);
            }
            ordercarMapper.updateOrderCar(new OrderCar(chooseOrderCar));
            p2OrdersMapper.addP2Order(new P2Orders(pid + 1,1,uid,orderId));
            return Result.success("user add success");
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

    @Async("asyncServiceExecutor")
    public CompletableFuture<List<Orderbuy>> getOrderbuyList(int kind) {
        return CompletableFuture.completedFuture(orderbuyMapper.getOrderBuyList(kind));
    }

    public Orderbuy getOrderBuyById(int id) {
        return orderbuyMapper.selectOrderBuyById(id).get(0);
    }

    public Result<String> userJoinOrderBuy(int uid, int orderID) {
        String lockKey = "productKey";
        String clientId = UUID.randomUUID().toString();
        Boolean result;
        try {
            result = redisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 10, TimeUnit.SECONDS);
            while (!result) {
                Thread.sleep(15000);
                result = redisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 10, TimeUnit.SECONDS);
            }
            Orderbuy chooseOrderbuy = orderbuyMapper.selectOrderBuyById(orderID).get(0);
            int pid = p2OrdersMapper.selectIdMaxP2Order();
            if (chooseOrderbuy.getFull() == 1) {
                return Result.error(new CodeMsg(400, "这个订单已经满了"));
            } else {
                List<P2Orders> list = p2OrdersMapper.searchP2OrdersList(orderID, 0);
                for (P2Orders p2Orders : list) {
                    if (p2Orders.getUserID() == uid) {
                        return Result.error(new CodeMsg(400, "你已经加入过这个订单了"));
                    }
                }
                chooseOrderbuy.setNumExist(chooseOrderbuy.getNumExist() + 1);
                if (chooseOrderbuy.getNumExist() == chooseOrderbuy.getNumNeed()) {
                    chooseOrderbuy.setFull(1);
                }
                orderbuyMapper.updateOrderBuy(new Orderbuy(chooseOrderbuy));
                p2OrdersMapper.addP2Order(new P2Orders(pid + 1, 0, uid, orderID));
                return Result.success("加入订单成功");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(clientId.equals(redisTemplate.opsForValue().get(lockKey))){
                redisTemplate.delete(lockKey);
            }
        }
        return Result.error(new CodeMsg(400, "error"));
    }
    public List<Orderbuy> queryOrderbuyListByUserID(int userID) {
        return orderbuyMapper.queryOrderBuyListByUserID(userID);
    }

    public List<Orderbuy> queryOrderbuyListComments(int userID) {
        List<Integer> list = commentsMapper.getOidByUid(userID);
        List<Orderbuy> res = new ArrayList<>();
        for(int id : list){
            res.add(orderbuyMapper.selectOrderBuyById(id).get(0));
        }
        return res;
    }
    public List<Orderbuy> queryOrderBuyListJoin(int userID) {
        List<Integer> list = p2OrdersMapper.getOidByUid(userID);
        List<Orderbuy> res = new ArrayList<>();
        for(int id : list){
            res.add(orderbuyMapper.selectOrderBuyById(id).get(0));
        }
        return res;
    }
    public List<String> getUserPicByOid(int id) {
        List<Integer> uidList = p2OrdersMapper.getBuyUidByOid(id);
        List<String> userPic = new ArrayList<>();
        for(int i = 0; i < uidList.size(); i++) {
            userPic.add(userMapper.queryUserById(uidList.get(i)).getHeadPicture());
        }
        return new ArrayList<>(userPic);
    }

    public List<User> getUserInfoByOid(int id) {
        List<Integer> uidList = p2OrdersMapper.getBuyUidByOid(id);
        List<User> userInfo = new ArrayList<>();
        for(int i = 0; i < uidList.size(); i++) {
            userInfo.add(userMapper.queryUserById(uidList.get(i)));
        }
        return new ArrayList<User>(userInfo);
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
        List<Comments> commentsList = commentsMapper.queryCommentsListByorderbuyID(id);

        for (int i = 0; i < commentsList.size(); i++) {
            Map<String,String> map = new HashMap<>();
            int tempuid = Integer.parseInt(commentsList.get(i).getUserID());
            map.put("username",userMapper.queryUserById(tempuid).getName());
            map.put("headpicture",userMapper.queryUserById(tempuid).getHeadPicture());
            map.put("content",commentsList.get(i).getContent());
            map.put("datatime",commentsList.get(i).getDatetime().toString());
            commentsDetail.add(map);
        }
        return commentsDetail;
    }

    public void deleteOrderbuy(int id) {
        orderbuyMapper.deleteOrderBuy(id);
    }

    public void updateOrderbuy(Orderbuy orderbuy) {
        orderbuyMapper.updateOrderBuy(orderbuy);
    }

    public void deleteOrdercar(int id) {
        ordercarMapper.deleteOrderCar(id);
    }

    public void updateOrderCar(OrderCar orderCar) {
        ordercarMapper.updateOrderCar(orderCar);
    }
}
