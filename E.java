package com.example.demo;

public enum E{

    /**
     * 业务异常码范围
     */
    issue("a");


    private String msg;

    E(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
