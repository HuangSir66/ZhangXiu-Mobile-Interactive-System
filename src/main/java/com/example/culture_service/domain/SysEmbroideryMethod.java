package com.example.culture_service.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_embroidery_method")
public class SysEmbroideryMethod {

    private Long id;

    private String method;

    private String methodName;


}
