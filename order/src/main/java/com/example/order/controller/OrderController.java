package com.example.order.controller;

import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.Order;
import com.example.order.feign.UserFeign;
import com.example.order.service.IOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderController {
    @Value("${eureka.client.region}")
    private String region;
    @Value("${eureka.instance.metadata-map.zone}")
    private String zone;
    @Autowired
    private UserFeign userFeign;

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/hello")
    public MyRsp hello(){
        return MyRsp.success("区域:"+region+",机房:"+zone);
    }

    @RequestMapping("getUser")
    public String getUser(){
        return userFeign.visitUser();
    }
    @PostMapping("getOrder")
    public Object getOrder(@RequestBody Order order){
        return MyRsp.success(new Order(order.getOrderId(), "这是订单信息",new Date()));
    }

    @PostMapping("/pageOrder")
    public MyRsp pageOrder(@RequestBody MyParam<Order> myParam){
        System.out.println(myParam);
        return MyRsp.success(orderService.pageOrder(myParam));
    }
}
