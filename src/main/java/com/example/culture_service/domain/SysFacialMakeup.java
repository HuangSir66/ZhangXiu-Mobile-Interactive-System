package com.example.culture_service.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_facial_makeup")
public class SysFacialMakeup {

    private Long id;

    private String facialMakeup;

    private String facialName;

}
