package com.example.mail.Mapper;

import com.example.mail.Pojo.Delivery;
import com.example.mail.Pojo.Pay_goods;
import com.example.mail.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Pay_goodsMapper {
    Pay_goods getPay_goodsByUidOid(int uid, int oid);

    Pay_goods queryPay_goodsByOidUid(int oid, int uid);

    List<User> queryUsersByOid(int oid);

    List<Pay_goods> queryPay_goodsList();

    Pay_goods queryPay_goodsByPid(int pid);

    List<Pay_goods> queryPay_goodsByOid(int oid);

    List<Pay_goods> queryPay_goodsByUid(int uid);

    void addPay_goods(Pay_goods Pay_goods);

    void updatePay_goods(Pay_goods Pay_goods);

    void deletePay_goods(int pid);

    int selectIdMaxPay_goods();
}
