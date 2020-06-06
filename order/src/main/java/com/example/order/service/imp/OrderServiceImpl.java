package com.example.order.service.imp;

import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.Order;
import com.example.order.mapper.OrderMapper;
import com.example.order.service.IOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl  implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    public PageInfo<Order> pageOrder(MyParam<Order> myParam){

        PageHelper.startPage(myParam.getPageParam().getPageNum(),myParam.getPageParam().getPageSize());
        PageHelper.orderBy(myParam.getOrderParam()[0]);

        List<Order> orders = orderMapper.pageOrder(myParam.getT());
        return new PageInfo<>(orders);
    }
}
