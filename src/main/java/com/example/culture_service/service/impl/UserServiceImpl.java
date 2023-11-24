package com.example.culture_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.culture_service.domain.User;
import com.example.culture_service.mapper.UserMapper;
import com.example.culture_service.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
