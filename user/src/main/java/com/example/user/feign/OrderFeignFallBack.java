package com.example.user.feign;

import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderFeignFallBack implements OrderFeign{
    @Override
    public MyRsp findHello() {
        return MyRsp.success("Order走丢了");
    }

    @Override
    public MyRsp getOrderHead(Order order) {
        return null;
    }

    @Override
    public MyRsp getByPage(MyParam myParam) {
        return null;
    }
}
