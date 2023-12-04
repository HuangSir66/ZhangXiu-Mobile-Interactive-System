package com.example.culture_service.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_asset")
public class UserAsset {
    private Long id;

    private Long userId;

    private Integer coinNumber;

    private Integer silkwormLeaves;

    private Integer fabricNumber;
}
