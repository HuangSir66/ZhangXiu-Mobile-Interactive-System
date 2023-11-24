package com.example.culture_service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.culture_service.domain.User;
import com.example.culture_service.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
@SpringBootTest
public class MybatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        long count = userService.count();
        System.out.println("总记录数："+count);
    }

    @Test
    public void testGetUser(){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(User::getUsername,"小s").like(User::getPassword,"123456");
        Map<String,Object> user = userService.getMap(queryWrapper);
        if(user!=null){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}
