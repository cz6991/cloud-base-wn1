package com.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user")
public interface UserFeign {

    @GetMapping(value = "/getUser")
    public String visitUser();
}
