package com.example.mail.Pojo;

public class P2Orders {
    int id;
    int kind;
    int userID;
    int orderID;

    public P2Orders(int id, int kind, int userID, int orderID) {
        this.id = id;
        this.kind = kind;
        this.userID = userID;
        this.orderID = orderID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getId() {
        return id;
    }

    public int getKind() {
        return kind;
    }

    public int getUserID() {
        return userID;
    }

    public int getOrderID() {
        return orderID;
    }
}
