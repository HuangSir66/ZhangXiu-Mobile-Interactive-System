package com.example.culture_service.controller;

import com.example.culture_service.domain.SysColorCount;
import com.example.culture_service.domain.User;
import com.example.culture_service.domain.UserSilkwormNumber;
import com.example.culture_service.service.impl.SysColorCountServiceImpl;
import com.example.culture_service.service.impl.UserServiceImpl;
import com.example.culture_service.service.impl.UserSilkwormNumberServiceImpl;
import com.example.culture_service.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class GetUserInfoController {

    @Autowired
    private UserServiceImpl userService;




    /*
    获取用户所有信息
     */
    @GetMapping("/userinfo/{userId}")
    public JsonResult<User> getUserWithAssetById(@PathVariable Long userId) {
        try {
            User userWithAsset = userService.getUserWithAssetById(userId);
            if (userWithAsset != null) {
                return new JsonResult<>("200", "查询成功", userWithAsset);
            } else {
                return new JsonResult<>("404", "用户不存在");
            }
        } catch (Exception e) {
            return new JsonResult<>("500", "查询失败");
        }
    }







}
