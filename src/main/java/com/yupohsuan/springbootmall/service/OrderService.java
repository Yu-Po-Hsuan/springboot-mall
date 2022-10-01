package com.yupohsuan.springbootmall.service;

import com.yupohsuan.springbootmall.dto.CreateOrderRequest;
import com.yupohsuan.springbootmall.dto.OrderQueryParams;
import com.yupohsuan.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrders(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
