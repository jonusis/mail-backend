package com.example.mail.Pojo;

public class PU2orders {
    private int kind;
    private int id;
    private String userID;
    private String orderID;

    public PU2orders() {
    }

    public PU2orders(int kind, int id, String userID, String orderID) {
        this.kind = kind;
        this.id = id;
        this.userID = userID;
        this.orderID = orderID;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
}
