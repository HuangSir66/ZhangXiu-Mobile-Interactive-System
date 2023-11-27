package com.example.culture_service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.culture_service.domain.SysColorCount;
import com.example.culture_service.mapper.SysColorCountMapper;
import com.example.culture_service.service.SysColorCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysColorCountServiceImpl extends ServiceImpl<SysColorCountMapper, SysColorCount> implements SysColorCountService {

    @Autowired
    private SysColorCountMapper sysColorCountMapper;
    /*
    根据UserId获取信息
     */
    public List<SysColorCount> getColorCountByUserId(Long userId){
        QueryWrapper<SysColorCount> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        return sysColorCountMapper.selectList(queryWrapper);
    }
}
