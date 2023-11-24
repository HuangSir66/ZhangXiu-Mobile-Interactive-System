package com.example.culture_service.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.culture_service.domain.User;
import com.example.culture_service.mapper.UserMapper;
import com.example.culture_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping
public class RegisterController {

    @Resource
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    @PostMapping("/register")
    public String register(@RequestBody User requestUser){

        String username = requestUser.getUsername();

        String password = requestUser.getPassword();

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(User::getUsername, username).like(User::getPassword, password);

        Map<String, Object> user = userService.getMap(queryWrapper);

        if (user != null) {
            System.out.println("账号已存在");
            return "账号已存在";
        } else {
            User user_info = new User();
            user_info.setName("xiaohuang");
            user_info.setPassword(password);
            user_info.setUsername(username);
            userMapper.insert(user_info);
            return "注册成功";
        }

    }

}
