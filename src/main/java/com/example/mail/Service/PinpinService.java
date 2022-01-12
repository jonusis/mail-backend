package com.example.mail.Service;

import com.example.mail.Mapper.OrderbuyMapper;
import com.example.mail.Mapper.UserMapper;
import com.example.mail.Pojo.Comments;
import com.example.mail.Pojo.Orderbuy;
import com.example.mail.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PinpinService {
    @Autowired
    OrderbuyMapper orderbuyMapper;

    public void addOrderbuy(String time, String tel, String qq, String wechat, int numNeed, String heading, String content, String postID, int kind,String location, String picture) {
        int id = orderbuyMapper.selectIdMaxOrderbuy();
        Date datetime = new Date();
        orderbuyMapper.addOrderbuy(id,datetime,time,tel,qq,wechat,numNeed,heading,content,postID,kind,location,picture);
        return;
    }
}
