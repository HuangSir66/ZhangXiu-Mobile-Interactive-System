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

    @Autowired
    private UserSilkwormNumberServiceImpl userSilkwormNumberService;

    @Autowired
    private SysColorCountServiceImpl sysColorCountService;
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
    获取用户蚕只种类数量
     */
    @GetMapping("/silkworm_number/{userid}")
    public JsonResult<List<UserSilkwormNumber>> getSilkworm(@PathVariable Long userid){
        try{
            List<UserSilkwormNumber> userSilkwormNumber = userSilkwormNumberService.getSilkwormNumberByUserId(userid);
            if(userSilkwormNumber!=null){
                return new JsonResult<>("200", "获取成功", userSilkwormNumber);
            }else{
                return new JsonResult<>("404", "未找到蚕丝数");
            }
        }catch (Exception e) {
            return new JsonResult<>("500", "获取失败");
        }
    }

    /*
    获取用户颜料数量
     */
    @GetMapping("/color_count/{userid}")
    public JsonResult<List<SysColorCount>> getColorCount(@PathVariable Long userid){
        try{
            List<SysColorCount> sysColorCounts = sysColorCountService.getColorCountByUserId(userid);
            if(sysColorCounts!=null){
                return new JsonResult<>("200", "获取成功", sysColorCounts);
            }else{
                return new JsonResult<>("404", "未找到颜料");
            }
        }catch (Exception e) {
            return new JsonResult<>("500", "获取失败");
        }
    }


}
