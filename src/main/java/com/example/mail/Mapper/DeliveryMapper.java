package com.example.mail.Mapper;

import com.example.mail.Pojo.Delivery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeliveryMapper {
    Delivery getDeliveryByUidOid(int uid, int oid);

    List<Delivery> queryDeliveryList();

    Delivery queryDeliveryByDid(int did);

    List<Delivery> queryDeliveryByUid(int uid);

    Delivery queryDeliveryByOid(int oid);

    void addDelivery(Delivery Delivery);

    void updateDelivery(Delivery Delivery);

    void deleteDelivery(int did);

    int selectIdMaxDelivery();

    //List<Delivery> selectDeliveryLogin(String account,String password);
}
