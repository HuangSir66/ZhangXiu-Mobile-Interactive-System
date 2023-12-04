package com.example.culture_service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.culture_service.domain.User;
import com.example.culture_service.domain.UserAsset;
import com.example.culture_service.mapper.UserAssetMapper;
import com.example.culture_service.service.UserAssetService;
import com.example.culture_service.service.impl.UserServiceImpl;
import com.example.culture_service.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserAssetService userAssetService;


    @Autowired
    private UserAssetMapper userAssetMapper;


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



    /*
    添加金币
     */

    @PutMapping("/userinfo/addcoins/{userId}/")
    public JsonResult<String> addCoinNumber(@PathVariable Long userId, @RequestBody UserAsset userAsset) {

        Integer coin = userAsset.getCoinNumber();
        try {
            userAssetService.addCoinNumber(userId, coin);
            return new JsonResult<>("200", "金币增加成功", null);
        } catch (Exception e) {
            return new JsonResult<>("500", "金币增加失败", null);
        }
    }


    /*
    扣除用户金币

     */
    @PutMapping("/userinfo/subcoins/{userId}/")
    public JsonResult<String> subCoinNumber(@PathVariable Long userId, @RequestBody UserAsset userAsset) {

        Integer coin = userAsset.getCoinNumber();
        // 查询用户资产
        QueryWrapper<UserAsset> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);

        UserAsset existingUserAsset = userAssetMapper.selectOne(queryWrapper);

        if (existingUserAsset != null) {
            if (existingUserAsset.getCoinNumber() - coin >= 0) {
                // 金币充足，执行减法操作
                existingUserAsset.setCoinNumber(existingUserAsset.getCoinNumber() - coin);
                userAssetMapper.updateById(existingUserAsset);
                return new JsonResult<>("200", "金币扣除成功", null);
            } else {
                // 金币不足，返回错误信息
                return new JsonResult<>("400", "金币不足", null);
            }
        } else {
            // 用户不存在，返回错误信息
            return new JsonResult<>("404", "用户不存在", null);
        }
    }
}
