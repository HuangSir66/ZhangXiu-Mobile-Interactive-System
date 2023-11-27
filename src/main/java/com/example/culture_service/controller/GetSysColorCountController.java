package com.example.culture_service.controller;

import com.example.culture_service.domain.SysColorCount;
import com.example.culture_service.service.impl.SysColorCountServiceImpl;
import com.example.culture_service.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class GetSysColorCountController {
    @Autowired
    private SysColorCountServiceImpl sysColorCountService;
    /*
        获取用户颜料数量
         */
    @GetMapping("/color_count/{userid}")
    public JsonResult<List<SysColorCount>> getColorCount(@PathVariable Long userid){
        try{
            List<SysColorCount> sysColorCounts = sysColorCountService.getColorCountByUserId(userid);
            if(sysColorCounts!=null){
                return new JsonResult<>("200", "获取成功", sysColorCounts);
            }else{
                return new JsonResult<>("404", "未找到颜料");
            }
        }catch (Exception e) {
            return new JsonResult<>("500", "获取失败");
        }
    }
}
