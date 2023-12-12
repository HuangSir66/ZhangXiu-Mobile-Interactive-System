package com.example.culture_service.controller;

import com.example.culture_service.domain.SysHairAccessories;
import com.example.culture_service.mapper.SysHairAccessoriesMapper;
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
public class SysHairAccessoriesController {

    @Autowired
    private SysHairAccessoriesMapper sysHairAccessoriesMapper;

    /**
     * 获取所有发饰信息
     *
     * @return JsonResult 包含发饰信息的 JSON 对象
     */
    @GetMapping("/sys_hair_accessories")
    public JsonResult<List<SysHairAccessories>> getSysHairAccessories() {
        try {
            // 查询所有发饰信息
            List<SysHairAccessories> sysHairAccessories = sysHairAccessoriesMapper.selectList(null);

            if (sysHairAccessories != null && !sysHairAccessories.isEmpty()) {
                return new JsonResult<>("200", "获取成功", sysHairAccessories);
            } else {
                return new JsonResult<>("404", "未找到发饰信息");
            }
        } catch (Exception e) {
            // 处理异常，返回获取失败的信息
            return new JsonResult<>("500", "获取失败");
        }
    }
}
