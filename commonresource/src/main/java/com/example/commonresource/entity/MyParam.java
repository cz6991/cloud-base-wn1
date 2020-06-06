package com.example.commonresource.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyParam<T> {

    private MyPage pageParam ;

    private String[] orderParam ;

    private T t;

}
