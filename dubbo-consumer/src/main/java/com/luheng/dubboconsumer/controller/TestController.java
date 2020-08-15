package com.luheng.dubboconsumer.controller;

import com.luheng.dubboconsumer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/method")
    public String testMethod() {
        String result = testService.testMethod();
        return result;
    }
}
