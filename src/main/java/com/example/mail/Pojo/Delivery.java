package com.example.mail.Pojo;

public class Delivery {
    private int did;
    private int uid;
    private int oid;
    private int state;

    public Delivery(int did, int uid, int oid, int state) {
        this.did = did;
        this.uid = uid;
        this.oid = oid;
        this.state = state;
    }

    public Delivery() {
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
