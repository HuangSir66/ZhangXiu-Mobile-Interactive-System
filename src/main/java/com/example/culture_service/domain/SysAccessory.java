package com.example.culture_service.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_accessory")
public class SysAccessory {

    private Long id;

    private String accessory;

    private String accessoryName;

}
