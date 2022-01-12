package com.example.mail.Controller.wdnmd;

import com.example.mail.Pojo.Address;
import com.example.mail.Pojo.OrderCar;
import com.example.mail.Pojo.Orderbuy;
import com.example.mail.Pojo.P2Orders;
import com.example.mail.ResultSet.CodeMsg;
import com.example.mail.ResultSet.PagehelpResult;
import com.example.mail.ResultSet.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/order")
@Api(tags = "拼拼OrderbuyController")
@CrossOrigin(origins = "*")
public class OrderbuyController {
    @Autowired
    private com.example.mail.Service.PinpinService pinpinService;

    @RequestMapping(value = "/post/buy", method = RequestMethod.POST)
    public Result<String> addOrderbuy(@RequestBody Orderbuy orderbuy){
        String time = orderbuy.getTime();
        String tel = orderbuy.getTel();
        String qq = orderbuy.getQq();
        String wechat = orderbuy.getWechat();
        int numNeed = orderbuy.getNumNeed();
        String heading = orderbuy.getHeading();
        String content = orderbuy.getContent();
        String postID = orderbuy.getPostID();
        int kind = orderbuy.getKind();
        String location = orderbuy.getLocation();
        String picture = orderbuy.getPicture();
        try {
            pinpinService.addOrderbuy(time,tel,qq,wechat,numNeed,heading,content,postID,kind,location,picture);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success addOrderbuy");
    }

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public Result<Map> getOrderbuyDetailByid(@RequestParam String orderID){
        int id = Integer.parseInt(orderID);
        List<String> userPicture = new ArrayList<>();
        List<Map> comments = new ArrayList<>();
        Map res = new HashMap<>();
        try {
            Orderbuy orderbuy = pinpinService.getOrderBuyById(id);
            res.put("datatime",orderbuy.getDatetime().toString());
            res.put("kind",orderbuy.getKind());
            res.put("location",orderbuy.getLocation());
            res.put("timeBuy",orderbuy.getTime());
            res.put("numNeed",orderbuy.getNumNeed());
            res.put("numExist",orderbuy.getNumExist());
            res.put("picture",orderbuy.getPicture());
            res.put("content",orderbuy.getContent());
            res.put("heading",orderbuy.getHeading());
            if(orderbuy.getFull() == 0){
                res.put("full",false);
            } else {
                res.put("full",true);
            }

            userPicture = pinpinService.getUserPicByOid(id);
            res.put("userPicture",userPicture);

            comments = pinpinService.getCommentsDetailByOid(id);
            res.put("comments",comments);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(res);
    }

    @RequestMapping(value = "/buy/list", method = RequestMethod.GET)
    public PagehelpResult<List<Orderbuy>> getOrderBuyList(@RequestParam(defaultValue = "1") String kind,@RequestParam(defaultValue = "1") String page, @RequestParam(defaultValue = "5") String pagesize){
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(pagesize));
        List<Orderbuy> list = pinpinService.getOrderbuyList(Integer.parseInt(kind));
        PageInfo<Orderbuy> pageInfo = new PageInfo<>(list);
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public Result<String> addUserToBuyOrder(@RequestParam String orderbuyID, @RequestParam String userID){
        int uid = Integer.parseInt(userID);
        int orderID = Integer.parseInt(orderbuyID);
        try{
            String res = pinpinService.userJoinOrderBuy(uid,orderID);
            return Result.success(res);
        }catch (Exception e){
            return Result.error(new CodeMsg(0, e.toString()));
        }
    }

    @RequestMapping(value = "/buy/list/queryOrderBuyListById", method = RequestMethod.GET)
    public PagehelpResult<List<Orderbuy>> queryOrderBuyListById(@RequestParam String userID, @RequestParam(defaultValue = "1") String page, @RequestParam(defaultValue = "5") String pagesize){
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(pagesize));
        List<Orderbuy> list = pinpinService.queryOrderbuyListByUserID(Integer.parseInt(userID));
        PageInfo<Orderbuy> pageInfo = new PageInfo<>(list);
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }
}

