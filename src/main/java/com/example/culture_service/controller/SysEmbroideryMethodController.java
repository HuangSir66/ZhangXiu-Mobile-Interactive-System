package com.example.culture_service.controller;

import com.example.culture_service.domain.SysEmbroideryMethod;
import com.example.culture_service.mapper.SysEmbroideryMethodMapper;
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
public class SysEmbroideryMethodController {

    @Autowired
    private SysEmbroideryMethodMapper sysEmbroideryMethodMapper;

    /**
     * 获取所有针绣方法信息
     *
     * @return JsonResult 包含针绣方法信息的 JSON 对象
     */
    @GetMapping("/embroiderymethod")
    public JsonResult<List<SysEmbroideryMethod>> getSysEmbroideryMethod() {
        try {
            // 查询所有针绣方法信息
            List<SysEmbroideryMethod> sysEmbroideryMethod = sysEmbroideryMethodMapper.selectList(null);

            if (sysEmbroideryMethod != null && !sysEmbroideryMethod.isEmpty()) {
                return new JsonResult<>("200", "获取成功", sysEmbroideryMethod);
            } else {
                return new JsonResult<>("404", "未找到针绣方法");
            }
        } catch (Exception e) {
            // 处理异常，返回获取失败的信息
            return new JsonResult<>("500", "获取失败");
        }
    }
}
