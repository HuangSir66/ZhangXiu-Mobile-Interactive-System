package com.example.culture_service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.culture_service.domain.SysAccessory;
import com.example.culture_service.domain.SysColorCount;
import com.example.culture_service.mapper.SysAccessoryMapper;
import com.example.culture_service.service.SysAccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysAccessoryServiceImpl extends ServiceImpl<SysAccessoryMapper, SysAccessory>implements SysAccessoryService {


    @Autowired
    private SysAccessoryMapper sysAccessoryMapper;
    public List<SysAccessory> getAccessoryListById(Long id){
        QueryWrapper<SysAccessory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return sysAccessoryMapper.selectList(queryWrapper);
    }
}
