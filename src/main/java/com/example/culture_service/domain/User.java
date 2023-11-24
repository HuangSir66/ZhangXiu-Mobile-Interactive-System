package com.example.culture_service.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_info")
public class User {

    private Long id;

    private String name;

    private String username;

    private String password;
}
