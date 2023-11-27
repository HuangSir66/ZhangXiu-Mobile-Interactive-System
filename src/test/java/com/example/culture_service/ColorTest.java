package com.example.culture_service;

import com.example.culture_service.domain.*;
import com.example.culture_service.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ColorTest {

    @Autowired
    private SysColorMapper sysColorMapper;

    @Test
    public void getColor() {
        List<SysColor> list = sysColorMapper.selectList(null);
        for(SysColor sysColor:list){
            String color = sysColor.getColor();
            SysColorCount sysColorCount = new SysColorCount();
            sysColorCount.setColor(color);
            sysColorCount.setUserId(1728978849233956865L);
            sysColorCountMapper.insert(sysColorCount);
        }
    }

    @Autowired
    private SysColorCountMapper sysColorCountMapper;


    @Autowired
    private SysCostumeMapper sysFacialMakeupMapper;
    @Test
    public void getPattern(){
        sysFacialMakeupMapper.selectList(null);
    }




}
