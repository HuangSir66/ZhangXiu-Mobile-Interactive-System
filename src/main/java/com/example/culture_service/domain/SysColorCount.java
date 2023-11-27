package com.example.culture_service.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_color_count")
public class SysColorCount {

    private Long id;

    private Long userId;

    private String color;

    private Integer count;

}
