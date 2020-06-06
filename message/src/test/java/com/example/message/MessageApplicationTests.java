package com.example.message;

import com.example.message.service.PhoneMsgService;
import com.example.message.util.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageApplicationTests {
	@Autowired
	private RedisUtils redisUtils;
	@Test
	void contextLoads() {
		redisUtils.set("sex","man");
	}

}
