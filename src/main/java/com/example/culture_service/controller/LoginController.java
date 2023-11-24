package com.example.culture_service.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.culture_service.domain.User;
import com.example.culture_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(User::getUsername, username).like(User::getPassword, password);

        Map<String, Object> user = userService.getMap(queryWrapper);

        if (user != null) {
            System.out.println("登录成功");
            return "登录成功";
        } else {
            System.out.println("登录失败");
            return "登录失败";
        }
    }

}
