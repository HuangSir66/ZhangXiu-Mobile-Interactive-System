package com.example.culture_service;

import com.example.culture_service.domain.SysColorCount;
import com.example.culture_service.domain.UserSilkwormStatu;
import com.example.culture_service.mapper.SysColorCountMapper;
import com.example.culture_service.mapper.UserSilkwormStatuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CultureServiceApplicationTests {

    @Test
    void contextLoads() {
    }



    @Autowired
    private UserSilkwormStatuMapper sysColorCountMapper;

    @Test
    public void getColor(){
        List<UserSilkwormStatu> list=  sysColorCountMapper.selectList(null);
        for(UserSilkwormStatu silkwormStatu:list){
            System.out.println(silkwormStatu.getStatu());
        }

    }

}
