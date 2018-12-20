package com.luheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.luheng.mapper")
//@EnableScheduling
public class FirstbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstbootApplication.class, args);
    }
}

