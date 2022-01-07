package com.example.mail.Controller;

import com.example.mail.Pojo.*;
import com.example.mail.Compound.OrderDetail;
import com.example.mail.ResultSet.PagehelpResult;
import com.example.mail.ResultSet.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "orders增删查改")
@RequestMapping(value = "/v1/orders")
@CrossOrigin(origins = "*")
public class OrdercrudController {
    @Autowired
    private com.example.mail.Service.OrdercrudService OrdercrudService;
    @Autowired
    private com.example.mail.Service.Pay_goodscrudService pay_goodscrudService;
    @Autowired
    private com.example.mail.Service.DeliverycrudService DeliverycrudService;
    @Autowired
    private com.example.mail.Service.GoodscrudService GoodscrudService;

    @RequestMapping(value = "/searchUser", method = RequestMethod.GET)
    public PagehelpResult<List<Order>> searchOrder(@RequestParam(defaultValue = "1000") String state, @RequestParam(defaultValue = "0") String total_price, @RequestParam(defaultValue = "1",required = false) String pageNum, @RequestParam(defaultValue = "8",required = false) String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        int stateInt = Integer.parseInt(state);
        int total_priceInt = Integer.parseInt(total_price);
        PageHelper.startPage(pagenum,pagesize);
        List<Order> orderList = OrdercrudService.searchOrder(state,total_price);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(orderList,pageNumber,PageSize);
    }

    @RequestMapping(value = "/queryGoodsByOid", method = RequestMethod.GET)
    public Goods queryGoodsByOid(@RequestParam String oid){
        int oidInt = Integer.parseInt(oid);
        int gid = OrdercrudService.queryOrderByOid(oidInt).getGid();
        return GoodscrudService.queryGoodsByGid(gid);
    }

    @RequestMapping(value = "/getDeliveryByUidOid", method = RequestMethod.GET)
    public Result<Delivery> getDeliveryByUidOid(@RequestParam String uid,@RequestParam String oid){
        int uidInt = Integer.parseInt(uid);
        int oidInt = Integer.parseInt(oid);
        return Result.success(DeliverycrudService.getDeliveryByUidOid(uidInt,oidInt));
    }

    @RequestMapping(value = "/getPay_goodsByUidOid", method = RequestMethod.GET)
    public Result<Pay_goods> getPay_goodsByUidOid(@RequestParam String uid, @RequestParam String oid){
        int uidInt = Integer.parseInt(uid);
        int oidInt = Integer.parseInt(oid);
        return Result.success(pay_goodscrudService.queryPay_goodsByOidUid(uidInt,oidInt));
    }

    @RequestMapping(value = "/queryOrderDetailByOid", method = RequestMethod.GET)
    public Result<OrderDetail> queryOrderDetailById(@RequestParam String oid){
        int id = Integer.parseInt(oid);
        return OrdercrudService.queryOrderDetailByOid(id);
    }

    @RequestMapping(value = "/queryOrderList", method = RequestMethod.GET)
    public PagehelpResult<List<Order>> queryOrderList(@RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        return OrdercrudService.queryOrderList(pagenum,pagesize);
    }

    @RequestMapping(value = "/queryOrderByOid", method = RequestMethod.GET)
    public Result<Order> queryOrderByOid(@RequestParam String oid){
        int id = Integer.parseInt(oid);
        return Result.success(OrdercrudService.queryOrderByOid(id));
    }

    @RequestMapping(value = "/queryOrderByBid", method = RequestMethod.GET)
    public PagehelpResult<List<Order>> queryOrderByBid(@RequestParam String bid, @RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        int id = Integer.parseInt(bid);
        return OrdercrudService.queryOrderByBid(id,pagenum,pagesize);
    }

    @RequestMapping(value = "/queryOrderByGid", method = RequestMethod.GET)
    public PagehelpResult<List<Order>> queryOrderByGid(@RequestParam String gid, @RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        int id = Integer.parseInt(gid);
        return OrdercrudService.queryOrderByGid(id,pagenum,pagesize);
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public Result<String> addOrder(@RequestBody Order order){
        int state = order.getState();
        String start_time = order.getStart_time();
        String end_time = order.getEnd_time();
        int total_price = order.getTotal_price();
        String introduction = order.getIntroduction();
        int bid = order.getBid();
        int gid = order.getGid();
        return OrdercrudService.addOrder(state,start_time,end_time,total_price,introduction,bid,gid);
    }

    @RequestMapping(value = "/updateOrder", method = RequestMethod.PUT)
    public Result<String> updateOrder(@RequestBody Order order){
        int oid = order.getOid();
        int state = order.getState();
        String start_time = order.getStart_time();
        String end_time = order.getEnd_time();
        int total_price = order.getTotal_price();
        String introduction = order.getIntroduction();
        int bid = order.getBid();
        int gid = order.getGid();
        return OrdercrudService.updateOrder(oid,state,start_time,end_time,total_price,introduction,bid,gid);
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.DELETE)
    public Result<String> deleteOrder(@RequestParam String oid){
        int id = Integer.parseInt(oid);
        return OrdercrudService.deleteOrder(id);
    }
}
