package com.example.culture_service.controller;

import com.example.culture_service.domain.SysAccessory;
import com.example.culture_service.mapper.SysAccessoryMapper;
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
public class SysAccessoryController {

    @Autowired
    private SysAccessoryMapper sysAccessoryMapper;

    /**
     * 获取所有系统配饰数量
     *
     * @return JsonResult 包含系统配饰信息的 JSON 对象
     */
    @GetMapping("/accessory")
    public JsonResult<List<SysAccessory>> GetSysAccessory() {
        try {
            // 查询所有系统配饰信息
            List<SysAccessory> sysAccessory = sysAccessoryMapper.selectList(null);

            if (sysAccessory != null && !sysAccessory.isEmpty()) {
                return new JsonResult<>("200", "获取成功", sysAccessory);
            } else {
                return new JsonResult<>("404", "未找到配饰");
            }
        } catch (Exception e) {
            // 处理异常，返回获取失败的信息
            return new JsonResult<>("500", "获取失败");
        }
    }
}
