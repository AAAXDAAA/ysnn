package com.ysnn.api.common;


import lombok.Data;

import java.util.function.Function;

@Data
public class R {
    private int code;
    private String message;
    private String type;
    private Boolean success;
    private Object data;
    private Object data2;

    public static R success(String message){
        R r = new R();
        r.setCode(200);
        r.setMessage(message);
        r.setType("success");
        r.setData(null);
        return r;
    }

    public static R success(String message, Object data){
        R r = success(message);
        r.setData(data);
        return r;
    }

    public static R success(String message, Object data,Object data2){
        R r = success(message);
        r.setData(data);
        r.setData2(data2);
        return r;
    }


    public static R warning (String message){
        R r = error(message);
        r.setCode(400);
        r.setType("Warning");
        return r;
    }

    public static R error(String message){
        R r = success(message);
        r.setSuccess(false);
        r.setCode(440);
        r.setType("error");
        return r;
    }
    public static R fatal(String message) {
        R r = error(message);
        r.setCode(500);
        return r;
    }


}
