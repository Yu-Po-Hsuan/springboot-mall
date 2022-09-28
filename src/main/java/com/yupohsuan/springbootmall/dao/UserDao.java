package com.yupohsuan.springbootmall.dao;

import com.yupohsuan.springbootmall.dto.UserRegisterRequest;
import com.yupohsuan.springbootmall.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
