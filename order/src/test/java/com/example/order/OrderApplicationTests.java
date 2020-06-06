package com.example.order;

import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.Order;
import com.example.order.mapper.OrderMapper;
import com.example.order.service.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrderApplicationTests {

	@Autowired
	private OrderMapper orderMapper;

	@Test
	void contextLoads() {
		Order order1 = new Order("", "order1", null);
		List<Order> orders = orderMapper.pageOrder(order1);
		for (Order order : orders) {
			System.out.println(order.toString());
		}

	}

}
