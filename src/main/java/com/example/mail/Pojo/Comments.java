package com.example.mail.Pojo;

import java.util.Date;

public class Comments {
    private int id;
    private Date datetime;
    private String content;
    private int orderbuyID;
    private int ordercarID;
    private String userID;

    public Comments() {
    }

    public Comments(int id, String content, int orderbuyID, int ordercarID, String userID) {
        this.id = id;
        this.datetime = new Date();
        this.content = content;
        this.orderbuyID = orderbuyID;
        this.ordercarID = ordercarID;
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOrderbuyID() {
        return orderbuyID;
    }

    public void setOrderbuyID(int orderbuyID) {
        this.orderbuyID = orderbuyID;
    }

    public int getOrdercarID() {
        return ordercarID;
    }

    public void setOrdercarID(int ordercarID) {
        this.ordercarID = ordercarID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
