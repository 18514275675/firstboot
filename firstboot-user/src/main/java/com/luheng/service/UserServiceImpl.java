package com.luheng.service;

import org.springframework.stereotype.Service;

@Service("userService233")
public class UserServiceImpl implements UserService {
    @Override
    public String getUserName() {

        return "userName:张三!";
    }
}
