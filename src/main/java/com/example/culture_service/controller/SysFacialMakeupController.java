package com.example.culture_service.controller;

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

    /**
     * 获取所有脸谱化妆信息
     *
     * @return JsonResult 包含脸谱化妆信息的 JSON 对象
     */
    @GetMapping("/sysfacialmakeup")
    public JsonResult<List<SysFacialMakeup>> getSysFacialMakeup() {
        try {
            // 查询所有脸谱化妆信息
            List<SysFacialMakeup> sysFacialMakeup = sysFacialMakeupMapper.selectList(null);

            if (sysFacialMakeup != null && !sysFacialMakeup.isEmpty()) {
                return new JsonResult<>("200", "获取成功", sysFacialMakeup);
            } else {
                return new JsonResult<>("404", "未找到脸谱化妆信息");
            }
        } catch (Exception e) {
            // 处理异常，返回获取失败的信息
            return new JsonResult<>("500", "获取失败");
        }
    }
}
