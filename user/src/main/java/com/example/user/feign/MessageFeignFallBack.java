package com.example.user.feign;

import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.PhoneEntity;
import org.springframework.stereotype.Component;

@Component
public class MessageFeignFallBack implements MessageFeign{

    @Override
    public MyRsp sendPhoneMsg(MyParam<PhoneEntity> myParam) {
        return MyRsp.fail().msg("短信发送失败");
    }
}
