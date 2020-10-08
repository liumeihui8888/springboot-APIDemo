package com.example.demo.entity;

public class Response {
    Object result;
    String msg;
    int code;
    Boolean isTure = true;

    public Response() {
    }

    public Response(String msg, int code, Boolean isTure,Object result) {
        this.msg = msg;
        this.code = code;
        this.isTure = isTure;
        this.result=result;
    }
    public void setResponse(String msg,int code,Boolean isTure,Object result){
        this.msg=msg;
        this.code=code;
        this.isTure=isTure;
        this.result=result;

    }
    public Response(String msg, int code, Boolean isTure) {
        this.msg = msg;
        this.code = code;
        this.isTure = isTure;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Boolean getTure() {
        return isTure;
    }

    public void setTure(Boolean isTure) {
        this.isTure = isTure;
    }

}
