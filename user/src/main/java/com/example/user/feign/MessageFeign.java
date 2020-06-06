package com.example.user.feign;

import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.PhoneEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "message", fallback = MessageFeignFallBack.class)
public interface MessageFeign {

    @PostMapping(value = "/sendPhoneMsg")
    public MyRsp sendPhoneMsg(MyParam<PhoneEntity> myParam);
}
