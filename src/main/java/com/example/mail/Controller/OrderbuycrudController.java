package com.example.mail.Controller;

import com.example.mail.Pojo.Order;
import com.example.mail.Pojo.Orderbuy;
import com.example.mail.ResultSet.CodeMsg;
import com.example.mail.ResultSet.PagehelpResult;
import com.example.mail.ResultSet.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "orderbuy增删查改")
@RequestMapping(value = "/v1/orderbuy")
@CrossOrigin(origins = "*")
public class OrderbuycrudController {
    @Autowired
    private com.example.mail.Service.PinpinService pinpinService;

    @RequestMapping(value = "/getOrderBuyList", method = RequestMethod.GET)
    public PagehelpResult<List<Orderbuy>> getOrderBuyList(@RequestParam(defaultValue = "1") String page, @RequestParam(defaultValue = "5") String pagesize){
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(pagesize));
        List<Orderbuy> list = pinpinService.queryOrderBuyList();
        PageInfo<Orderbuy> pageInfo = new PageInfo<>(list);
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    @RequestMapping(value = "/addUserToBuyOrder", method = RequestMethod.POST)
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

    @RequestMapping(value = "/queryOrderBuyListById", method = RequestMethod.GET)
    public PagehelpResult<List<Orderbuy>> queryOrderBuyListById(@RequestParam String userID, @RequestParam(defaultValue = "1") String page, @RequestParam(defaultValue = "5") String pagesize){
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(pagesize));
        List<Orderbuy> list = pinpinService.queryOrderbuyListByUserID(Integer.parseInt(userID));
        PageInfo<Orderbuy> pageInfo = new PageInfo<>(list);
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    @RequestMapping(value = "/addOrderBuy", method = RequestMethod.POST)
    public Result<String> addOrderBuy(@RequestBody Orderbuy orderbuy){
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

    @RequestMapping(value = "/deleteOrderBuy", method = RequestMethod.DELETE)
    public Result<String> deleteOrderbuy(@RequestParam String orderbuyID){
        int id = Integer.parseInt(orderbuyID);
        try{
            pinpinService.deleteOrderbuy(id);
        }catch (Exception e){
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("deleteOrderBuy");
    }

    @RequestMapping(value = "/updateOrderBuy", method = RequestMethod.PUT)
    public Result<String> updateOrderBuy(@RequestBody Orderbuy orderbuy){
        try{
            pinpinService.updateOrderbuy(orderbuy);
        }catch (Exception e){
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success updateOrder");
    }
}
