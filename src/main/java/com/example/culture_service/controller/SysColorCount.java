package com.example.culture_service.controller;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_color_count")
public class SysColorCount {

    private Long id;

    private Long userId;

    private Long colorId;

    private Integer count;


}
