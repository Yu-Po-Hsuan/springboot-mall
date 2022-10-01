package com.yupohsuan.springbootmall.dao;

import com.yupohsuan.springbootmall.dto.OrderQueryParams;
import com.yupohsuan.springbootmall.model.Order;
import com.yupohsuan.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer countOrders(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
