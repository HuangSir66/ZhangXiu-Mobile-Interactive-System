package com.example.culture_service;

import com.example.culture_service.domain.SysColorCount;
import com.example.culture_service.mapper.SysColorCountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CultureServiceApplicationTests {

    @Test
    void contextLoads() {
    }



    @Autowired
    private SysColorCountMapper sysColorCountMapper;

    @Test
    public void getColor(){
        sysColorCountMapper.selectList(null);

    }

}
