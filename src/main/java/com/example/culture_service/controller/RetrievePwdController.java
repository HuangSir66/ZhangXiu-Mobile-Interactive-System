package com.example.culture_service.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.culture_service.domain.User;
import com.example.culture_service.mapper.UserMapper;
import com.example.culture_service.service.UserService;
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

    /*
    修改密码
     */
    @PostMapping("/retrievepwd")
    public JsonResult<User> RetrievePwd(@RequestBody User requestUser){
        String username = requestUser.getUsername();

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);

        User user = userMapper.selectOne(queryWrapper);

        if(user!=null){
            return new JsonResult<>("200","找回成功",user);
        }else{
            return new JsonResult<>("404","用户不存在");
        }
    }
}
