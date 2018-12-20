package com.luheng.mapper;

import com.luheng.model.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository   此处的这个@Repository注解可加可不加,因为在application.properties中,配置了Mapper的路径
public interface UserMapper {

    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);
}
