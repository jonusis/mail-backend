package com.example.mail.ResultSet;

public class PagehelpResult<T> {

    private int code;
    private String msg;
    private T data;
    private int pageNum;
    private int pageMaxSize;


    public static <T> PagehelpResult<T> success(T data,int pageNum, int pageAllNum){
        return new PagehelpResult<T>(data,pageNum,pageAllNum);
    }

    public static <T> PagehelpResult<T> error(CodeMsg codeMsg, int pageNum, int pageAllNum){
        return new  PagehelpResult<T>(codeMsg,new MyPageInfo(pageNum,pageAllNum));
    }

    private PagehelpResult(T data,int pageNum,int pageMaxSize) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
        this.pageNum = pageNum;
        this.pageMaxSize = pageMaxSize;
    }

    private PagehelpResult(CodeMsg codeMsg,MyPageInfo pageInfo) {
        if(codeMsg == null) {
            return;
        }

        if(pageInfo == null) {
            return;
        }
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
        this.pageNum = pageInfo.getPageNum();
        this.pageMaxSize = pageInfo.getAllPageNum();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageMaxSize() {
        return pageMaxSize;
    }
}

