package com.example.culture_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.culture_service.domain.SysColorCount;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SysColorCountService extends IService<SysColorCount> {

    public List<SysColorCount> getColorCountByUserId(Long userId);
}
