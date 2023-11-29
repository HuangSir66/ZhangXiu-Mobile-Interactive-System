package com.example.culture_service.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.culture_service.domain.*;
import com.example.culture_service.mapper.*;
import com.example.culture_service.service.UserService;
import com.example.culture_service.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @PostMapping("/register")
    public JsonResult<User> register(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();
        String name = requestUser.getName();

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(User::getUsername, username).like(User::getPassword, password);

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
            userMapper.insert(user_info);

            UserAsset userAsset = new UserAsset();
            userAsset.setUserId(user_info.getId());
            userAssetMapper.insert(userAsset);

            List<SysColor> ColorList = sysColorMapper.selectList(null);
            List<String> SizeList = Arrays.asList("大只", "中只", "小只");
            List<String> StatuList = Arrays.asList("幼蚕","青年蚕","老蚕");
            for(SysColor sysColor: ColorList){
                for(String size:SizeList){
                    for(String statu:StatuList){
                        String color = sysColor.getColor();
                        UserSilkwormNumber userSilkwormNumber = new UserSilkwormNumber();
                        userSilkwormNumber.setUserId(user_info.getId());
                        userSilkwormNumber.setSilkwormColor(color);
                        userSilkwormNumber.setSilkwormSize(size);
                        userSilkwormNumber.setSilkwormStatu(statu);
                        userSilkwormNumberMapper.insert(userSilkwormNumber);
                    }
                }
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
