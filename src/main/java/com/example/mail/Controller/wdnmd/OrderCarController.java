package com.example.mail.Controller.wdnmd;


import com.example.mail.Pojo.Goods;
import com.example.mail.Pojo.OrderCar;
import com.example.mail.Pojo.Orderbuy;
import com.example.mail.Pojo.OrderCar;
import com.example.mail.ResultSet.CodeMsg;
import com.example.mail.ResultSet.PagehelpResult;
import com.example.mail.ResultSet.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
@Api(tags = "拼拼OrdercarController")
@CrossOrigin(origins = "*")


public class OrderCarController {
    @Autowired
    private com.example.mail.Service.PinpinService pinpinService;

    @RequestMapping(value = "/post/car", method = RequestMethod.POST)
    public Result<String> addOrdercar(@RequestBody OrderCar ordercar){
        try {
            pinpinService.addOrdercar(ordercar);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success addOrdercar");
    }


    @RequestMapping(value = "/car/list", method = RequestMethod.GET)
    public PagehelpResult<List<OrderCar>> queryOrderCarList(@RequestParam(defaultValue = "1") String page, @RequestParam(defaultValue = "5") String pagesize){
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(pagesize));
        List<OrderCar> list = pinpinService.queryOrderCarList();
        PageInfo<OrderCar> pageInfo = new PageInfo<>(list);
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public Result<String> addUserToCarOrder(@RequestParam String ordercarID, @RequestParam String userID){
        int uid = Integer.parseInt(userID);
        int orderID = Integer.parseInt(ordercarID);
        try{
            String res = pinpinService.userJoinOrderCar(uid,orderID);
            return Result.success(res);
        }catch (Exception e){
            return Result.error(new CodeMsg(0, e.toString()));
        }
    }

    @RequestMapping(value = "/car/list/queryOrderCarListById", method = RequestMethod.GET)
    public PagehelpResult<List<OrderCar>> queryOrderCarListById(@RequestParam String userID,@RequestParam(defaultValue = "1") String page, @RequestParam(defaultValue = "5") String pagesize){
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(pagesize));
        List<OrderCar> list = pinpinService.queryOrderCarListByUserID(Integer.parseInt(userID));
        PageInfo<OrderCar> pageInfo = new PageInfo<>(list);
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }


}
