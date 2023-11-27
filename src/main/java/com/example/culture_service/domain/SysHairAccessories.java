package com.example.culture_service.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@TableName("sys_hair_accessories")
public class SysHairAccessories {

    private Long id;

    private String hairAccessories;

    private String hairName;


}
