package com.example.message.controller;

import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.PhoneEntity;
import com.example.commonresource.entity.TextEmailEntity;
import com.example.message.service.EmailService;
import com.example.message.service.PhoneMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    EmailService emailService;

    @Autowired
    PhoneMsgService phoneMsgService;

    @PostMapping("/sendTextMail")
    public Object sendTextMail(@RequestBody TextEmailEntity emailEntity){
        emailService.sendTextMail(emailEntity);
        return MyRsp.success("发送成功");
    }

    @PostMapping("/sendPhoneMsg")
    public MyRsp sendPhoneMsg(@RequestBody MyParam<PhoneEntity> myParam){
        phoneMsgService.sendPhoneMsg(myParam.getT().getPhone());
        return MyRsp.success("发送短信成功");
    }
}
