package com.example.culture_service;

import com.example.culture_service.domain.UserAsset;
import com.example.culture_service.mapper.UserAssetMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
