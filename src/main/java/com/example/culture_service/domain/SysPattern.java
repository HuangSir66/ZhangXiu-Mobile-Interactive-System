package com.example.culture_service.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_pattern")
public class SysPattern {

    private Long id;

    private String pattern;

    private String patternName;

}
