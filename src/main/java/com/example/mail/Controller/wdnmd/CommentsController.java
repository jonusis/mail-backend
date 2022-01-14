package com.example.mail.Controller.wdnmd;

import com.example.mail.Pojo.Comments;
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
@RequestMapping(value = "/comments")
@Api(tags = "拼拼Comments")
@CrossOrigin(origins = "*")
public class CommentsController {
    @Autowired
    private com.example.mail.Service.PinpinService pinpinService;

    @RequestMapping(value = "/addComments", method = RequestMethod.POST)
    public Result<String> addComments(@RequestParam String orderID,@RequestBody Comments comments){
        String content = comments.getContent();
        int orderbuyID = Integer.parseInt(orderID);
        int ordercarID = comments.getOrdercarID();
        String userID = comments.getUserID();
        pinpinService.addComments(content,
                orderbuyID, ordercarID, userID);
        return Result.success("success addComments");
    }

    @RequestMapping(value = "/queryCommentsList", method = RequestMethod.GET)
    public PagehelpResult<List<Comments>> queryCommentsList(@RequestParam(defaultValue = "1") String page, @RequestParam(defaultValue = "5") String pagesize){
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(pagesize));
        List<Comments> list = pinpinService.queryCommentsList();
        PageInfo<Comments> pageInfo = new PageInfo<>(list);
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    @RequestMapping(value = "/updateComments", method = RequestMethod.PUT)
    public Result<String> updateComments(@RequestBody Comments comments){
        int id = comments.getId();
        Date datetime = new Date();
        String content = comments.getContent();
        int orderbuyID = comments.getOrderbuyID();
        int ordercarID = comments.getOrdercarID();
        String userID = comments.getUserID();
        pinpinService.updateComments(id,datetime,content,orderbuyID,ordercarID,userID);
        return Result.success("success updateBusiness");
    }

    @RequestMapping(value = "/deleteComments", method = RequestMethod.DELETE)
    public Result<String> deleteComments(@RequestParam String id){
        pinpinService.deleteComments(Integer.parseInt(id));
        return Result.success("success deleteComments");
    }
}
