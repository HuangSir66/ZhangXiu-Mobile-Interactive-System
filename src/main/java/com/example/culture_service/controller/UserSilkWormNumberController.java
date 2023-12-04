package com.example.culture_service.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.culture_service.domain.UserSilkwormNumber;
import com.example.culture_service.mapper.UserSilkwormNumberMapper;
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

    @Autowired
    private UserSilkwormNumberMapper userSilkwormNumberMapper;
    /*
    获取用户蚕只种类数量
     */
    @GetMapping("/silkworm_number/{userid}")
    public JsonResult<List<UserSilkwormNumber>> getSilkworm(@PathVariable Long userid) {
        try {
            // 1. 查询指定用户的蚕信息
            List<UserSilkwormNumber> userSilkwormNumber = userSilkwormNumberService.getSilkwormNumberByUserId(userid);

            // 2. 判断是否找到蚕丝数
            if (userSilkwormNumber != null && !userSilkwormNumber.isEmpty()) {
                // 3. 返回成功的响应
                return new JsonResult<>("200", "获取成功", userSilkwormNumber);
            } else {
                // 4. 返回未找到蚕丝数的响应
                return new JsonResult<>("404", "未找到蚕丝数");
            }
        } catch (Exception e) {
            // 5. 返回失败的响应
            return new JsonResult<>("500", "获取失败");
        }
    }



    @GetMapping("/silkworm_number/ripe_silkworm_grow/{userid}")
    public JsonResult<List<UserSilkwormNumber>> addRipeSilkworm(@PathVariable Long userid) {
        try {
            // 1. 查询指定用户的蚕信息
            List<UserSilkwormNumber> silkworms = userSilkwormNumberService.getSilkwormNumberByUserId(userid);

            // 2. 修改蚕的状态数量
            for (UserSilkwormNumber silkworm : silkworms) {
                if ("熟蚕".equals(silkworm.getSilkwormStatu())) {
                    // 熟蚕数量加一
                    silkworm.setSilkwormNumber(silkworm.getSilkwormNumber() + 1);
                    UpdateWrapper<UserSilkwormNumber> updateWrapper = new UpdateWrapper<>();
                    updateWrapper.eq("id", silkworm.getId());
                    userSilkwormNumberService.update(silkworm, updateWrapper);
                } else if ("蚁蚕".equals(silkworm.getSilkwormStatu())) {
                    // 蚁蚕数量减一
                    silkworm.setSilkwormNumber(silkworm.getSilkwormNumber() - 1);
                    // 在更新时使用UpdateWrapper指定更新条件
                    UpdateWrapper<UserSilkwormNumber> updateWrapper = new UpdateWrapper<>();
                    updateWrapper.eq("id", silkworm.getId());
                    userSilkwormNumberService.update(silkworm, updateWrapper);
                }
            }

            // 4. 返回修改后的结果
            return new JsonResult<>("200","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult<>("400","修改失败");
        }
    }


    @GetMapping("/silkworm_number/ant_silkworm_grow/{userid}")
    public JsonResult<List<UserSilkwormNumber>> addAntSilkworm(@PathVariable Long userid) {
        try {
            // 1. 查询指定用户的蚕信息
            List<UserSilkwormNumber> silkworms = userSilkwormNumberService.getSilkwormNumberByUserId(userid);

            // 2. 修改蚕的状态数量
            for (UserSilkwormNumber silkworm : silkworms) {
                if ("熟蚕".equals(silkworm.getSilkwormStatu())) {
                    // 熟蚕数量加一
                    silkworm.setSilkwormNumber(silkworm.getSilkwormNumber() - 1);
                    UpdateWrapper<UserSilkwormNumber> updateWrapper = new UpdateWrapper<>();
                    updateWrapper.eq("id", silkworm.getId());
                    userSilkwormNumberService.update(silkworm, updateWrapper);
                } else if ("蚁蚕".equals(silkworm.getSilkwormStatu())) {
                    // 蚁蚕数量减一
                    silkworm.setSilkwormNumber(silkworm.getSilkwormNumber() + 1);
                    // 在更新时使用UpdateWrapper指定更新条件
                    UpdateWrapper<UserSilkwormNumber> updateWrapper = new UpdateWrapper<>();
                    updateWrapper.eq("id", silkworm.getId());
                    userSilkwormNumberService.update(silkworm, updateWrapper);
                }
            }

            // 4. 返回修改后的结果
            return new JsonResult<>("200","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult<>("400","修改失败");
        }
    }
}
