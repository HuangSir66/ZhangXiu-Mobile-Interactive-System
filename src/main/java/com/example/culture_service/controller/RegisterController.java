package com.example.culture_service.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.culture_service.domain.User;
import com.example.culture_service.domain.UserAsset;
import com.example.culture_service.mapper.UserAssetMapper;
import com.example.culture_service.mapper.UserMapper;
import com.example.culture_service.service.UserService;
import com.example.culture_service.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

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


    @PostMapping("/register")
    public JsonResult<User> register(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(User::getUsername, username).like(User::getPassword, password);

        Map<String, Object> user = userService.getMap(queryWrapper);

        JsonResult<User> jsonResult;


        if (user != null) {
            System.out.println("账号已存在");
            jsonResult = new JsonResult<>("200", "账号已存在");
            return jsonResult;
        } else {
            User user_info = new User();
            user_info.setName(generateRandomChineseString(5));
            user_info.setPassword(password);
            user_info.setUsername(username);
            userMapper.insert(user_info);

            UserAsset userAsset = new UserAsset();
            userAsset.setUserId(user_info.getId());
            userAssetMapper.insert(userAsset);

            jsonResult = new JsonResult<>("200", "注册成功");
            return jsonResult;
        }
    }

    private String generateRandomChineseString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 生成一个随机的汉字
            char chineseChar = (char) (0x4e00 + random.nextInt(0x9fa5 - 0x4e00 + 1));
            sb.append(chineseChar);
        }
        return sb.toString();
    }

}
