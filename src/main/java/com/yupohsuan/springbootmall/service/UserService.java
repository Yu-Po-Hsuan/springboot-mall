package com.yupohsuan.springbootmall.service;

import com.yupohsuan.springbootmall.dto.UserRegisterRequest;
import com.yupohsuan.springbootmall.model.User;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
