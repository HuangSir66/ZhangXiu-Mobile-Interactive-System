package com.example.culture_service.controller;

import com.example.culture_service.domain.SysPattern;
import com.example.culture_service.domain.SysStoreList;
import com.example.culture_service.mapper.SysStoreListMapper;
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
public class SysStoreListController {

    @Autowired
    private SysStoreListMapper sysStoreListMapper;

    @GetMapping("/store/list")
    public JsonResult<List<SysStoreList>> GetSysStoreList(){
        try{
            List<SysStoreList> sysStoreLists = sysStoreListMapper.selectList(null);
            if(sysStoreLists!=null && !sysStoreLists.isEmpty()){
                return new JsonResult<>("200", "获取成功", sysStoreLists);
            }else{
                return new JsonResult<>("404", "未找到商品");
            }
        }catch (Exception e) {
            return new JsonResult<>("500", "获取失败");
        }
    }



}
