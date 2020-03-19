package com.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sys.dao")
public class CarApplication {
    //springboot启动主类
    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }

}
