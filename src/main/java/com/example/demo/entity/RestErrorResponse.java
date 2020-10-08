package com.example.demo.entity;

import com.alibaba.fastjson.JSONObject;

public class RestErrorResponse {
    private Integer errorCode;
    private String msg;
    private Object details;
    private JSONObject result;
    private RestErrorResponse(){

    }
    public static RestErrorResponse build(){
        return new RestErrorResponse();
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public RestErrorResponse setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RestErrorResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getDetails() {
        return details;
    }

    public RestErrorResponse setDetails(Object details) {
        this.details = details;
        return this;
    }

    public String getResult() {
        result=new JSONObject();
        JSONObject errorJson=new JSONObject();
        errorJson.put("code",errorCode);
        errorJson.put("message",msg);
        errorJson.put("details",details);
        result.put("error",errorJson);
        return result.toString();
    }

    public void setResult(JSONObject result) {
        this.result = result;
    }
}
