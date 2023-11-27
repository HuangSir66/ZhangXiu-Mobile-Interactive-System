package com.example.culture_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.culture_service.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper extends BaseMapper<User> {
    User selectUserWithAssetById(@Param("userId") Long userId);


}
