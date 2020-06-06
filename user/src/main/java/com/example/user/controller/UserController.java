package com.example.user.controller;

import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.Order;
import com.example.commonresource.entity.PhoneEntity;
import com.example.user.feign.MessageFeign;
import com.example.user.feign.OrderFeign;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    OrderFeign orderFeign;

    @Autowired
    MessageFeign messageFeign;

    @Autowired
    UserService userService;



    @RequestMapping("/findHello")
    public MyRsp findHello(){
        return orderFeign.findHello();
    }

    @RequestMapping("getUser")
    public  String getUser(){
        return "我是User";
    }

    @PostMapping("/visitGetOrderHead")
    public Object visitGetOrderHead(@RequestBody Order order){

        System.out.println(order.toString());

        return MyRsp.success(orderFeign.getOrderHead(order));
    }

    @PostMapping("/getByPage")
    public Object getByPage(@RequestBody MyParam<Order> myParam){

        System.out.println("进入UserController");
        return orderFeign.getByPage(myParam);
    }
    //发送验证码
    @PostMapping("/sendPhoneMsg")
    public MyRsp sendPhoneMsg(@RequestBody MyParam<PhoneEntity> myParam){
        return messageFeign.sendPhoneMsg(myParam);
    }

    //登陆比较redis里的验证码是否一致
    @PostMapping("/login")
    public MyRsp login(@RequestBody MyParam<PhoneEntity> myParam){
        String code = userService.getByPhone(myParam);
        //开始比较
        boolean equals = myParam.getT().getCode().equals(code);
        if(equals==true){
            //删除redis键
            userService.deleteByKey(myParam.getT().getPhone());
           return MyRsp.success("登陆成功");

        }else {
            return MyRsp.fail().msg("登陆失败");
        }
    }
}
