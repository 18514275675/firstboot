package com.luheng.service.impl;

import com.luheng.mapper.UserMapper;
import com.luheng.model.UserEntity;
import com.luheng.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public void updateWithLock(UserEntity userEntity) {
        UserEntity modifyUser = userMapper.selectUserWithLock(userEntity);
        modifyUser.setUserName("王五_锁表更新测试");
        userMapper.update(modifyUser);

//        UserEntity modifyUser = sqlSessionTemplate.selectOne("com.luheng.mapper.UserMapper.selectUserWithLock",user);
//        modifyUser.setUserName("text");
//        sqlSessionTemplate.update("com.luheng.mapper.UserMapper.selectUserWithLock",modifyUser);
    }
}
