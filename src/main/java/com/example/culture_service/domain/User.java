package com.example.culture_service.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

@Data
@TableName("user_info")
public class User {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String name;

    private String username;

    private String password;

    private String avator;

    private String sex;

    @TableField(exist = false)
    private UserAsset userAsset;

    @TableField(exist = false)
    private List<UserSilkwormNumber> silkwormNumber;

    @TableField(exist = false)
    private List<SysColorCount> sysColorCounts;
}
