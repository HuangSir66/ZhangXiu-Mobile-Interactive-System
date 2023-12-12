package com.example.culture_service.controller;

import com.example.culture_service.domain.SysPattern;
import com.example.culture_service.mapper.SysPatternMapper;
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
public class SysPatternController {

    @Autowired
    private SysPatternMapper sysPatternMapper;

    /**
     * 获取所有图案信息
     *
     * @return JsonResult 包含图案信息的 JSON 对象
     */
    @GetMapping("/pattern")
    public JsonResult<List<SysPattern>> getSysPattern() {
        try {
            // 查询所有图案信息
            List<SysPattern> sysPattern = sysPatternMapper.selectList(null);

            if (sysPattern != null && !sysPattern.isEmpty()) {
                return new JsonResult<>("200", "获取成功", sysPattern);
            } else {
                return new JsonResult<>("404", "未找到图案信息");
            }
        } catch (Exception e) {
            // 处理异常，返回获取失败的信息
            return new JsonResult<>("500", "获取失败");
        }
    }
}
