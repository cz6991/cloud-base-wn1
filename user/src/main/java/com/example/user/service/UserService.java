package com.example.user.service;

import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.PhoneEntity;

public interface UserService {

    String getByPhone(MyParam<PhoneEntity> myParam);

    boolean deleteByKey(String key);
}
