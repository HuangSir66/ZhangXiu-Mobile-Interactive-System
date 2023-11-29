package com.example.culture_service.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("user_info")
public class User {

    private Long id;

    private String name;

    private String username;

    private String password;

    @TableField(exist = false)
    private UserAsset userAsset;

//    @TableField(exist = false)
//    private List<UserSilkwormNumber> silkwormNumber;


}
