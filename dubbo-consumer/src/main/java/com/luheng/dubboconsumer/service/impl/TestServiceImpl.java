package com.luheng.dubboconsumer.service.impl;

import com.luheng.dubboconsumer.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String testMethod() {
        return "testMethod调用成功";
    }
}
