package com.example.mail.Pojo;

public class Type {
    private int tid;
    private String broadHeading;
    private String type;
    private String url;

    public Type(int tid, String broadHeading, String type, String url) {
        this.tid = tid;
        this.broadHeading = broadHeading;
        this.type = type;
        this.url = url;
    }

    public Type() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getBroadHeading() {
        return broadHeading;
    }

    public void setBroadHeading(String broadHeading) {
        this.broadHeading = broadHeading;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
