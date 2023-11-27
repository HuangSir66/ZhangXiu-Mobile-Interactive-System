package com.example.culture_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.culture_service.domain.SysAccessory;

import java.util.List;

public interface SysAccessoryService extends IService<SysAccessory> {
    public List<SysAccessory> getAccessoryListById(Long id);
}
