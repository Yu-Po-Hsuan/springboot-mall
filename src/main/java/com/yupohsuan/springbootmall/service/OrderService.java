package com.yupohsuan.springbootmall.service;

import com.yupohsuan.springbootmall.dto.CreateOrderRequest;
import com.yupohsuan.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
