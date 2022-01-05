package com.example.mail.controller;

import com.example.mail.Pojo.Order;
import com.example.mail.Pojo.OrderDetail;
import com.example.mail.Pojo.PagehelpResult;
import com.example.mail.Pojo.Result;
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

    @RequestMapping(value = "/queryOrderDetailById", method = RequestMethod.GET)
    public Result<OrderDetail> queryOrderDetailById(@RequestParam String oid){
        int id = Integer.parseInt(oid);
        return OrdercrudService.queryOrderDetailById(id);
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
        return OrdercrudService.queryOrderByOid(id);
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
