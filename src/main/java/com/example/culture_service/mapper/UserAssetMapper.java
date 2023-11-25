package com.example.culture_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.culture_service.domain.User;
import com.example.culture_service.domain.UserAsset;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAssetMapper extends BaseMapper<UserAsset> {
}
