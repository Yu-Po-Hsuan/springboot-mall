package com.yupohsuan.springbootmall.service;

import com.yupohsuan.springbootmall.dto.UserRegisterRequest;
import com.yupohsuan.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

}
