package com.example.culture_service.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.culture_service.domain.User;
import com.example.culture_service.mapper.UserMapper;
import com.example.culture_service.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class RetrievePwdController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 处理找回密码请求的接口
     *
     * @param requestUser 请求体中的用户对象
     * @return JsonResult 包含找回密码结果的 JSON 对象
     */
    @PostMapping("/retrievepwd")
    public JsonResult<User> RetrievePwd(@RequestBody User requestUser) {
        // 从请求中获取用户名
        String username = requestUser.getUsername();

        // 构建查询条件
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);

        // 从数据库中查询用户信息
        User user = userMapper.selectOne(queryWrapper);

        // 如果用户存在，返回找回成功的信息和用户信息；否则，返回用户不存在的信息
        if (user != null) {
            return new JsonResult<>("200", "找回成功", user);
        } else {
            return new JsonResult<>("404", "用户不存在");
        }
    }
}
