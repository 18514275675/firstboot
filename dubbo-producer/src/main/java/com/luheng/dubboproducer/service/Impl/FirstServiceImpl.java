package com.luheng.dubboproducer.service.Impl;

import com.luheng.dubboapi.service.FirstService;

public class FirstServiceImpl implements FirstService {

    @Override
    public String selectStr(String param) {
        return "调用selectStr方法成功!";
    }

}
