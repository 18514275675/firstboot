package com.luheng.service;

import com.luheng.model.UserEntity;

import java.util.List;

public interface HelloService {

    public void updateWithLock(UserEntity userEntity);

    public List<UserEntity> getList(UserEntity userEntity);
}
