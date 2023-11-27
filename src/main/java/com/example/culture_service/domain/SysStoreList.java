package com.example.culture_service.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_store_list")
public class SysStoreList {

    private Long id;

    private String label;

    private String picture;

    private Integer price;


}
