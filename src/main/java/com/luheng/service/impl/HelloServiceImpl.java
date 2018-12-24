package com.luheng.service.impl;

import com.luheng.mapper.UserMapper;
import com.luheng.model.UserEntity;
import com.luheng.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public void updateWithLock(UserEntity userEntity) {
        //通过for update 开启数据库行级锁,防止并发
        UserEntity modifyUser = userMapper.selectUserWithLock(userEntity);
        modifyUser.setUserName("王五_锁表更新测试");
        userMapper.update(modifyUser);
    }

    @Override
    public List<UserEntity> getList(UserEntity userEntity){
        List<UserEntity> list = userMapper.getList(userEntity);
        return list;
    }
}
