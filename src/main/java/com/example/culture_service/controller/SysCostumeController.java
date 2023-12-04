package com.example.culture_service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.culture_service.domain.SysAccessory;
import com.example.culture_service.domain.SysCostume;
import com.example.culture_service.mapper.SysCostumeMapper;
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
@RequestMapping("/sys")
public class SysCostumeController {

    @Autowired
    private SysCostumeMapper sysCostumeMapper;


    /**
    获取用户服饰
     **/
    @GetMapping("/costume")
    public JsonResult<List<SysCostume>> GetSysCostume(){
        try{
            List<SysCostume> sysCostume = sysCostumeMapper.selectList(null);
            if(sysCostume!=null && !sysCostume.isEmpty()){
                return new JsonResult<>("200", "获取成功", sysCostume);
            }else{
                return new JsonResult<>("404", "未找到服装");
            }
        }catch (Exception e) {
            return new JsonResult<>("500", "获取失败");
        }
    }
}
