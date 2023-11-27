package com.example.culture_service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.culture_service.domain.UserSilkwormNumber;
import com.example.culture_service.mapper.UserSilkwormNumberMapper;
import com.example.culture_service.service.UserSilkwormNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  UserSilkwormNumberServiceImpl extends ServiceImpl<UserSilkwormNumberMapper, UserSilkwormNumber> implements UserSilkwormNumberService {


    @Autowired
    private UserSilkwormNumberMapper userSilkwormNumberMapper;
    /*
    根据UserId获取信息
     */
    public List<UserSilkwormNumber> getSilkwormNumberByUserId(Long userId){
        QueryWrapper<UserSilkwormNumber> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        return userSilkwormNumberMapper.selectList(queryWrapper);
    }
}
