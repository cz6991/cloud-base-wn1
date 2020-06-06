package com.example.user.feign;

import com.example.commonresource.entity.MyPage;
import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "order",fallback = OrderFeignFallBack.class)
public interface OrderFeign {
    @GetMapping(value = "hello")
    public MyRsp findHello();

    @RequestMapping(method = RequestMethod.POST,value = "/getOrder")
    public MyRsp getOrderHead(Order order);

    @PostMapping(value = "/pageOrder")
    public MyRsp getByPage(MyParam myParam);

}
