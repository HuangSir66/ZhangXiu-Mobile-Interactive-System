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
public class SysColorCountController {

    @Autowired
    private SysColorCountServiceImpl sysColorCountService;

    /**
     * 获取用户颜料数量
     *
     * @param userid 用户ID
     * @return JsonResult 包含用户颜料数量信息的 JSON 对象
     */
    @GetMapping("/color_count/{userid}")
    public JsonResult<List<SysColorCount>> getColorCount(@PathVariable Long userid) {
        try {
            // 查询用户颜料数量信息
            List<SysColorCount> sysColorCounts = sysColorCountService.getColorCountByUserId(userid);

            if (sysColorCounts != null && !sysColorCounts.isEmpty()) {
                return new JsonResult<>("200", "获取成功", sysColorCounts);
            } else {
                return new JsonResult<>("404", "未找到颜料");
            }
        } catch (Exception e) {
            // 处理异常，返回获取失败的信息
            return new JsonResult<>("500", "获取失败");
        }
    }
}
