package com.example.culture_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.culture_service.domain.User;
import com.example.culture_service.domain.UserSilkwormNumber;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSilkwormNumberMapper extends BaseMapper<UserSilkwormNumber> {
//    UserSilkwormNumber getSilkwormNumberListByUserId(@Param("userId") Long userId);
}
