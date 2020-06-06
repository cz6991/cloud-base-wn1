package com.example.eureka;

import com.example.commonresource.entity.TextEmailEntity;
import com.example.eureka.feign.MessageFeign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EurekaApplicationTests {

	@Autowired
	MessageFeign messageFeign;
	@Test
	void contextLoads() {
		messageFeign.sendTextMail(TextEmailEntity.setToAndText("783577172@qq.com","123123"));
	}

}
