package com.example.mail.Controller.wdnmd;

import com.example.mail.Pojo.Address;
import com.example.mail.Pojo.Orderbuy;
import com.example.mail.ResultSet.CodeMsg;
import com.example.mail.ResultSet.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result<Map> getOrderbuyDetailByid(@RequestParam String id){
        int idInt = Integer.parseInt(id);
        List<String> userPicture = null;
        List<Map> comments = null;
        Map res = null;
        try {
            Orderbuy orderbuy = pinpinService.getOrderById(idInt);
            res.put("datatime",orderbuy.getDatetime());
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
            res.put("userPicture",userPicture);
            res.put("comments",comments);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(res);
    }

    @RequestMapping(value = "/buyList", method = RequestMethod.GET)
    public Result<String> getOrderbuyList(){
        try {
            List<Orderbuy> orderbuyList = pinpinService.getOrderbuyList();
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success getOrderbuyList");
    }
}
