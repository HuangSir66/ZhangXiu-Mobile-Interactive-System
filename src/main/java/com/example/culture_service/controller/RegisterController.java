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

    @Autowired
    private UserSilkwormStatuMapper userSilkwormStatuMapper;

    /**
     * 处理用户注册请求的接口
     *
     * @param requestUser 请求体中的用户对象
     * @return JsonResult 包含注册结果的 JSON 对象
     */
    @PostMapping("/register/")
    public JsonResult<User> register(@RequestBody User requestUser) {
        // 从请求中获取用户信息
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();
        String name = requestUser.getName();
        String sex = requestUser.getSex();

        // 构建查询条件
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username).eq(User::getPassword, password);

        // 查询数据库中是否已存在相同账号密码的用户
        Map<String, Object> user = userService.getMap(queryWrapper);

        JsonResult<User> jsonResult;

        // 如果用户已存在，则返回账号已存在的信息
        if (user != null) {
            System.out.println("账号已存在");
            jsonResult = new JsonResult<>("404", "账号已存在");
            return jsonResult;
        } else {
            // 如果用户不存在，则创建新用户
            User user_info = new User();
            user_info.setName(name);
            user_info.setPassword(password);
            user_info.setUsername(username);
            user_info.setSex(sex);
            userMapper.insert(user_info);

            // 创建用户资产信息
            UserAsset userAsset = new UserAsset();
            userAsset.setUserId(user_info.getId());
            userAssetMapper.insert(userAsset);

            // 获取颜色列表和蚕的状态列表
            List<SysColor> colorList = sysColorMapper.selectList(null);
            List<UserSilkwormStatu> statuList = userSilkwormStatuMapper.selectList(null);

            // 初始化用户蚕的数量和颜色计数信息
            for (UserSilkwormStatu statu : statuList) {
                UserSilkwormNumber userSilkwormNumber = new UserSilkwormNumber();
                userSilkwormNumber.setUserId(user_info.getId());
                userSilkwormNumber.setSilkwormStatu(statu.getStatu());
                userSilkwormNumberMapper.insert(userSilkwormNumber);
            }
            for (SysColor sysColor : colorList) {
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
