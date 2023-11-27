package com.example.culture_service.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_costume")
public class SysCostume {

    private Long id;

    private String costume;

    private String costumeName;

}
