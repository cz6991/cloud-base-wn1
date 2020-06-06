package com.example.user.service;

import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.PhoneEntity;
import com.example.user.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private RedisUtils redisUtils;
    @Override
    public String getByPhone(MyParam<PhoneEntity> myParam) {
        return redisUtils.get(myParam.getT().getPhone());

    }

    @Override
    public boolean deleteByKey(String key) {
        return redisUtils.delete(key);
    }
}
