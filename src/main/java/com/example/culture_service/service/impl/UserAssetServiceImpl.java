package com.example.culture_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.culture_service.domain.User;
import com.example.culture_service.domain.UserAsset;
import com.example.culture_service.mapper.UserAssetMapper;
import com.example.culture_service.mapper.UserMapper;
import com.example.culture_service.service.UserAssetService;
import com.example.culture_service.service.UserService;
import org.springframework.stereotype.Service;

import java.security.Provider;
@Service
public class UserAssetServiceImpl extends ServiceImpl<UserAssetMapper, UserAsset> implements UserAssetService {
}
