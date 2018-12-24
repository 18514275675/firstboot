package com.luheng.controller;

import com.luheng.configuration.ReadProperties;
import com.luheng.enums.UserSexEnum;
import com.luheng.mapper.UserMapper;
import com.luheng.model.UserEntity;
import com.luheng.service.HelloService;
import com.luheng.service.impl.HelloServiceImpl;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RestController
@Controller
public class HelloController {

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private ReadProperties readProperties;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private HelloService helloService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    //此处返回值为Json格式,因为本类上添加了@RestController注解,会将控制器方法的返回值自动转为json
    @RequestMapping("/HelloSpringBoot")
    public String hello(){
//        User user = new User();
//        user.setId(1l);
//        user.setUserName("李四2");
//        user.setPassWord("123");
//        user.setEmail("444030191@163.com");
//        user.setRegTime(System.currentTimeMillis()+"");
//        User save = userRepository.save(user);
//        String localIp = readProperties.getLocalIp();
//        String localName = readProperties.getLocalName();
//        ValueOperations ops = redisTemplate.opsForValue();
//        ops.set("001","value001value");
//        ops.set("002","value002value");
//        ops.set("003","value003value");
//
//        Object o = ops.get("001");
//
//        ValueOperations<String, String> strOps = stringRedisTemplate.opsForValue();
//        strOps.set("String_测试1","String_value1");
//        strOps.set("String_测试2","String_value2");
//        strOps.set("String_测试3","String_value3");

//        UserEntity userEntity = new UserEntity();
//        userEntity.setUserName("luheng");
//        userEntity.setPassWord("123");
//        userMapper.insert(userEntity);
//        List<UserEntity> list = userMapper.getAll();
//        String userName = list.get(0).getUserName();

        //此处未引用thymeleaf模板引擎,在未配置任何mvc前缀,后缀的情况下,默认跳转到src/resources/static文件夹中的页面
        //若引用了thymeleaf模板引擎,则默认跳转到src/resources/templates文件夹中的页面
        UserEntity user = new UserEntity();
        user.setId(3l);
        helloService.updateWithLock(user);
        return "/myHtml.html";
    }

    @RequestMapping("/getJsonData")
    @ResponseBody
    public List<UserEntity> getJsonData(UserEntity user){
        List<UserEntity> list = helloService.getList(user);
        System.out.println(user.getUserName());
        return list;
    }
}
