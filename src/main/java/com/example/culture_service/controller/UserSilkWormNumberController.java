package com.example.culture_service.controller;

import com.example.culture_service.domain.UserSilkwormNumber;
import com.example.culture_service.service.impl.UserSilkwormNumberServiceImpl;
import com.example.culture_service.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/user")
public class UserSilkWormNumberController {
    @Autowired
    private UserSilkwormNumberServiceImpl userSilkwormNumberService;
    /*
    获取用户蚕只种类数量
     */
    @GetMapping("/silkworm_number/{userid}")
    public JsonResult<List<UserSilkwormNumber>> getSilkworm(@PathVariable Long userid){
        try{
            List<UserSilkwormNumber> userSilkwormNumber = userSilkwormNumberService.getSilkwormNumberByUserId(userid);
            if(userSilkwormNumber!=null && !userSilkwormNumber.isEmpty()){
                return new JsonResult<>("200", "获取成功", userSilkwormNumber);
            }else{
                return new JsonResult<>("404", "未找到蚕丝数");
            }
        }catch (Exception e) {
            return new JsonResult<>("500", "获取失败");
        }
    }
}
