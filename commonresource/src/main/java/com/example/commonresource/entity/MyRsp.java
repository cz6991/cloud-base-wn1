package com.example.commonresource.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyRsp {

    private  int code; //success 2000


    private String msg;


    private Object context;


    public  static MyRsp  success(Object context){
        MyRsp rsp = new MyRsp();

        rsp.setMsg("请求成功");
        rsp.setCode(2000);
        rsp.setContext(context);

        return  rsp;
    }

    public  MyRsp msg(String msg){
        this.setMsg(msg);
        return this;
    }

    public static MyRsp fail(){
        MyRsp rsp = new MyRsp();
        rsp.setMsg("访问失败");
        rsp.setCode(5000);
        rsp.setContext(null);
        return rsp;
    }
}
