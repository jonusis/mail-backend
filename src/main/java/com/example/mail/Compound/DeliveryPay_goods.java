package com.example.mail.Compound;

import com.example.mail.Pojo.Delivery;
import com.example.mail.Pojo.Pay_goods;

public class DeliveryPay_goods {
    private Delivery delivery;
    private Pay_goods pay_goods;

    public DeliveryPay_goods(Delivery delivery, Pay_goods pay_goods) {
        this.delivery = delivery;
        this.pay_goods = pay_goods;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Pay_goods getPay_goods() {
        return pay_goods;
    }

    public void setPay_goods(Pay_goods pay_goods) {
        this.pay_goods = pay_goods;
    }
}
