package com.example.culture_service.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.culture_service.domain.*;
import com.example.culture_service.mapper.*;
import com.example.culture_service.service.UserService;
import com.example.culture_service.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@RestController
@RequestMapping
public class RegisterController {

    @Resource
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAssetMapper userAssetMapper;

    @Autowired
    private UserSilkwormNumberMapper userSilkwormNumberMapper;

    @Autowired
    private SysColorMapper sysColorMapper;

    @Autowired
    private SysColorCountMapper sysColorCountMapper;


    @PostMapping("/register/")
    public JsonResult<User> register(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();
        String name = requestUser.getName();
        String sex  = requestUser.getSex();

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username).eq(User::getPassword, password);

        Map<String, Object> user = userService.getMap(queryWrapper);

        JsonResult<User> jsonResult;


        if (user != null) {
            System.out.println("账号已存在");
            jsonResult = new JsonResult<>("404", "账号已存在");
            return jsonResult;
        } else {
            User user_info = new User();
            user_info.setName(name);
            user_info.setPassword(password);
            user_info.setUsername(username);
            user_info.setSex(sex);
            userMapper.insert(user_info);

            UserAsset userAsset = new UserAsset();
            userAsset.setUserId(user_info.getId());
            userAssetMapper.insert(userAsset);

            List<SysColor> ColorList = sysColorMapper.selectList(null);
            /*
              先写死，后面从数据库读取
             */
            List<String> StatuList = Arrays.asList("幼蚕","青年蚕","老蚕");
            for(String statu:StatuList){
                UserSilkwormNumber userSilkwormNumber = new UserSilkwormNumber();
                userSilkwormNumber.setUserId(user_info.getId());
                userSilkwormNumber.setSilkwormStatu(statu);
                userSilkwormNumberMapper.insert(userSilkwormNumber);
            }
            for(SysColor sysColor:ColorList){
                String color = sysColor.getColor();
                SysColorCount sysColorCount = new SysColorCount();
                sysColorCount.setColor(color);
                sysColorCount.setUserId(user_info.getId());
                sysColorCountMapper.insert(sysColorCount);
            }


            jsonResult = new JsonResult<>("200", "注册成功");
            return jsonResult;
        }
    }


}
