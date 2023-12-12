package com.example.culture_service.controller;

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

    /**
     * 获取所有商品信息
     *
     * @return JsonResult 包含商品信息的 JSON 对象
     */
    @GetMapping("/store/list")
    public JsonResult<List<SysStoreList>> getSysStoreList() {
        try {
            // 查询所有商品信息
            List<SysStoreList> sysStoreLists = sysStoreListMapper.selectList(null);

            if (sysStoreLists != null && !sysStoreLists.isEmpty()) {
                return new JsonResult<>("200", "获取成功", sysStoreLists);
            } else {
                return new JsonResult<>("404", "未找到商品信息");
            }
        } catch (Exception e) {
            // 处理异常，返回获取失败的信息
            return new JsonResult<>("500", "获取失败");
        }
    }
}
