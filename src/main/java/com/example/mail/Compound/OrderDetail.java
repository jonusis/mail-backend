package com.example.mail.Compound;

import com.example.mail.Pojo.Business;
import com.example.mail.Pojo.Order;
import com.example.mail.Pojo.User;

import java.util.List;

public class OrderDetail {
    private List<User> users;
    private Business business;
    private Order order;

    public OrderDetail(List<User> users, Business business, Order order) {
        this.users = users;
        this.business = business;
        this.order = order;
    }

    public OrderDetail() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
