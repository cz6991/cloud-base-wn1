package com.example.message.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.example.message.service.PhoneMsgService;
import com.example.message.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PhoneMsgServiceImpl implements PhoneMsgService {
    @Autowired
    private RedisUtils redisUtils;
    @Override
    public void sendPhoneMsg(String toPhone) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G1iRUa3GrGxahGcf5Uo", "g9QXIe1d10gp3pQY8ooYcn6GUoj1qY");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", toPhone);
        request.putQueryParameter("SignName", "源码教室");
        request.putQueryParameter("TemplateCode", "SMS_192195638");
        //生成随机验证码
        Random random = new Random();
        int code = random.nextInt(9999);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            //验证短信是否发送成功
            boolean ok = response.getData().indexOf("OK") > 1;
            if(ok==true){
                //写入redis数据库
                redisUtils.set(toPhone,Integer.toString(code));
            }
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
}
