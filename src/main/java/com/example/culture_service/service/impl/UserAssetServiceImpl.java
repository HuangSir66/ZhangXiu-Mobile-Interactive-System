package com.example.culture_service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.culture_service.domain.SysColorCount;
import com.example.culture_service.domain.User;
import com.example.culture_service.domain.UserAsset;
import com.example.culture_service.mapper.UserAssetMapper;
import com.example.culture_service.mapper.UserMapper;
import com.example.culture_service.service.UserAssetService;
import com.example.culture_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Provider;
import java.util.List;

@Service
public class UserAssetServiceImpl extends ServiceImpl<UserAssetMapper, UserAsset> implements UserAssetService {
    @Autowired
    private UserAssetMapper userAssetMapper;


    public void addCoinNumber(Long userId, Integer addedCoins) {
        QueryWrapper<UserAsset> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        UserAsset userAsset = userAssetMapper.selectOne(queryWrapper);
        if (userAsset != null) {
            userAsset.setCoinNumber(userAsset.getCoinNumber() + addedCoins);
            userAssetMapper.updateById(userAsset);
        } else {
            // 处理用户不存在的情况
            throw new RuntimeException("用户不存在");
        }
    }


}
