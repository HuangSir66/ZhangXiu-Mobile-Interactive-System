package com.example.culture_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.culture_service.domain.UserSilkwormNumber;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserSilkwormNumberService extends IService<UserSilkwormNumber> {

    public List<UserSilkwormNumber> getSilkwormNumberByUserId(Long userId);
}
