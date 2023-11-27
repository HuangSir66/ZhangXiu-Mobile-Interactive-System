package com.example.culture_service.controller;

import com.example.culture_service.domain.UserSilkwormNumber;
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
public class GetUserSilkWormNumberController {
    @Autowired
    private UserSilkwormNumberServiceImpl userSilkwormNumberService;
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
}
