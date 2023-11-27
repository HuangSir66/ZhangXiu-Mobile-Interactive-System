package com.example.culture_service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.culture_service.domain.User;
import com.example.culture_service.domain.UserSilkwormNumber;
import com.example.culture_service.mapper.UserMapper;
import com.example.culture_service.mapper.UserSilkwormNumberMapper;
import com.example.culture_service.service.UserService;
import com.example.culture_service.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
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

    @Autowired
    private UserMapper userMapper;
    @Test
    public void getUserInfo(){
        User user_info = userMapper.selectUserWithAssetById(1728630967578398722L);
        System.out.println(user_info);




    }
    @Autowired
    private UserSilkwormNumberMapper userSilkwormNumberMapper;

    @Test
    public void gerSilkWormInfo(){
        UserSilkwormNumber userSilkwormNumber = new UserSilkwormNumber();
        userSilkwormNumber.setUserId(1728064772806651906L);
        userSilkwormNumberMapper.insert(userSilkwormNumber);


    }
}





















