package com.example.culture_service;

import com.example.culture_service.domain.SysColorCount;
import com.example.culture_service.domain.User;
import com.example.culture_service.domain.UserAsset;
import com.example.culture_service.mapper.SysColorCountMapper;
import com.example.culture_service.mapper.UserAssetMapper;
import com.example.culture_service.service.UserAssetService;
import com.example.culture_service.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusRegisterTest {

    @Autowired
    UserAssetMapper userAssetMapper;

    @Test
    public void add(){
        UserAsset userAsset = new UserAsset();
        userAsset.setUserId(1727986098187034626L);
        userAssetMapper.insert(userAsset);
    }

    @Autowired
    private UserService userService;

    @Test
    public void ColorCount(){

        User userWithAsset = userService.getUserWithAssetById(1731608340498239490L);

    }

}
