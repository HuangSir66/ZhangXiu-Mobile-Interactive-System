package com.example.culture_service;

import com.example.culture_service.domain.SysColor;
import com.example.culture_service.mapper.SysColorMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ColorTest {

    @Autowired
    private SysColorMapper sysColorMapper;

    @Test
    public void getColor(){
        List<SysColor> list = sysColorMapper.selectList(null);
        System.out.println(list);


    }


}
