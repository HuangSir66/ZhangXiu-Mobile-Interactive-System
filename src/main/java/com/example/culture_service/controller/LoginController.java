package com.example.culture_service.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.culture_service.domain.User;
import com.example.culture_service.mapper.UserMapper;
import com.example.culture_service.service.UserService;
import com.example.culture_service.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping
public class LoginController {

    @Resource
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 处理用户登录请求的接口
     *
     * @param requestUser 请求体中的用户对象
     * @return JsonResult 包含登录结果的 JSON 对象
     */
    @PostMapping("/login")
    public JsonResult<User> login(@RequestBody User requestUser) {
        // 从请求中获取用户名和密码
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();

        // 构建查询条件
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username).eq(User::getPassword, password);

        // 从数据库中查询用户信息
        User userinfo = userMapper.selectOne(queryWrapper);
        Map<String, Object> user = userService.getMap(queryWrapper);

        JsonResult<User> jsonResult;

        // 如果用户存在，返回登录成功的信息；否则，返回登录失败的信息
        if (user != null) {
            System.out.println(user);
            System.out.println("登录成功");
            jsonResult = new JsonResult<>("200", "登录成功", userinfo);
        } else {
            System.out.println("登录失败");
            jsonResult = new JsonResult<>("404", "登录失败，用户不存在");
        }

        return jsonResult;
    }
}
