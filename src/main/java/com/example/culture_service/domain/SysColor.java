package com.example.culture_service.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_color")
public class SysColor {

    private Long id;

    private String colorUrl;

    private String color;


}
