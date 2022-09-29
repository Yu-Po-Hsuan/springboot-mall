package com.yupohsuan.springbootmall.dao;

import com.yupohsuan.springbootmall.dto.UserRegisterRequest;
import com.yupohsuan.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    Integer createUser(UserRegisterRequest userRegisterRequest);


}
