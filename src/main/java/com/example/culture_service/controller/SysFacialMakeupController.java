package com.example.culture_service.controller;

import com.example.culture_service.domain.SysEmbroideryMethod;
import com.example.culture_service.domain.SysFacialMakeup;
import com.example.culture_service.mapper.SysFacialMakeupMapper;
import com.example.culture_service.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sys")
public class SysFacialMakeupController {
    @Autowired
    private SysFacialMakeupMapper sysFacialMakeupMapper;

    @GetMapping("/sysfacialmakeup")
    public JsonResult<List<SysFacialMakeup>> GetSysEmbroideryMethod(){
        try{
            List<SysFacialMakeup> sysFacialMakeup = sysFacialMakeupMapper.selectList(null);
            if(sysFacialMakeup!=null && !sysFacialMakeup.isEmpty()){
                return new JsonResult<>("200", "获取成功", sysFacialMakeup);
            }else{
                return new JsonResult<>("404", "未找到针秀");
            }
        }catch (Exception e) {
            return new JsonResult<>("500", "获取失败");
        }
    }
}
