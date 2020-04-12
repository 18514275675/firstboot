package com.luheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@MapperScan("com.luheng.mapper")
@SpringBootApplication(scanBasePackages = {"com.luheng.configuration"})
@ImportResource("dubbo/dubbo-web.xml")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}

