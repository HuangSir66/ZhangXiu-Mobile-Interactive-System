package com.example.culture_service.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_silkworm_number")
public class UserSilkwormNumber {

    private Long id;

    private Long userId;

    private Integer silkwormNumber;

    private String silkwormColor;

    private String silkwormStatu;

    private String silkwormSize;

}
