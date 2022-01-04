package com.example.mail.Pojo;

public class Pay_goods {
    private int pid;
    private int oid;
    private int uid;
    private int state;
    private int gcount;

    public Pay_goods(int pid, int oid, int uid, int state, int gcount) {
        this.pid = pid;
        this.oid = oid;
        this.uid = uid;
        this.state = state;
        this.gcount = gcount;
    }
    public Pay_goods(){

    }
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getGcount() {
        return gcount;
    }

    public void setGcount(int gcount) {
        this.gcount = gcount;
    }
}
