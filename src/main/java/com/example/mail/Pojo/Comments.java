package com.example.mail.Pojo;

import java.time.DateTimeException;

public class Comments {
    private int id;
    private DateTimeException datetime;
    private String content;
    private int orderbuyID;
    private int ordercarID;
    private String userID;

    public Comments() {
    }

    public Comments(int id, DateTimeException datetime, String content, int orderbuyID, int ordercarID, String userID) {
        this.id = id;
        this.datetime = datetime;
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

    public DateTimeException getDatetime() {
        return datetime;
    }

    public void setDatetime(DateTimeException datetime) {
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
