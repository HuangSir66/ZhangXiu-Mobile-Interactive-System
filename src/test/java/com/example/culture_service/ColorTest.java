package com.example.culture_service;

import com.example.culture_service.domain.SysColor;
import com.example.culture_service.domain.UserSilkwormNumber;
import com.example.culture_service.mapper.SysColorMapper;
import com.example.culture_service.mapper.UserSilkwormNumberMapper;
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
        List<String> SizeList = Arrays.asList("大只", "中只", "小只");
        List<String> StatuList = Arrays.asList("幼蚕", "青年蚕", "老蚕");
        List<SysColor> list = sysColorMapper.selectList(null);
        for (SysColor sysColor : list) {
            for (String size : SizeList) {
                for (String statu : StatuList) {
                    String color = sysColor.getColor();
                    System.out.println(color);
                    System.out.println(size);
                    System.out.println(statu);
                }

            }


        }
    }

    @Autowired
    private UserSilkwormNumberMapper userSilkwormNumberMapper;
//    @Test
//    public void getSilk(){
//        user userSilkwormNumber =



}
