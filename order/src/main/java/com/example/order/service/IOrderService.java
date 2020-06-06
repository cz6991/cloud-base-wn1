package com.example.order.service;


import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.Order;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IOrderService {

    public PageInfo<Order> pageOrder(MyParam<Order> myParam);
}
