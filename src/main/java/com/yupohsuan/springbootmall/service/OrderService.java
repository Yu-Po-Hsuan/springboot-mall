package com.yupohsuan.springbootmall.service;

import com.yupohsuan.springbootmall.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
