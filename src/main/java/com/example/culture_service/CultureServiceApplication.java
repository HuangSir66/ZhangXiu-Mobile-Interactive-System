package com.example.culture_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.culture_service.mapper")
public class CultureServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CultureServiceApplication.class, args);
    }

}
