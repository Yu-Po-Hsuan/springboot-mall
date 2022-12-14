package com.yupohsuan.springbootmall.service.impl;

import com.yupohsuan.springbootmall.dao.OrderDao;
import com.yupohsuan.springbootmall.dao.ProductDao;
import com.yupohsuan.springbootmall.dao.UserDao;
import com.yupohsuan.springbootmall.dto.BuyItem;
import com.yupohsuan.springbootmall.dto.CreateOrderRequest;
import com.yupohsuan.springbootmall.dto.OrderQueryParams;
import com.yupohsuan.springbootmall.model.Order;
import com.yupohsuan.springbootmall.model.OrderItem;
import com.yupohsuan.springbootmall.model.Product;
import com.yupohsuan.springbootmall.model.User;
import com.yupohsuan.springbootmall.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    private final static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Integer countOrders(OrderQueryParams orderQueryParams) {
        return orderDao.countOrders(orderQueryParams);
    }

    @Override
    public List<Order> getOrders(OrderQueryParams orderQueryParams) {
        List<Order> orderList =  orderDao.getOrders(orderQueryParams);

        for (Order order : orderList) {
            List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(order.getOrderId());

            order.setOrderItemList(orderItemList);
        }

        return orderList;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;
    }

    @Transactional //???????????? table ???????????? @Transactional, ?????????????????????????????????????????????
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        //?????? user ????????????
        User user = userDao.getUserById(userId);
        if (user == null) {
            log.warn("??? userId {} ?????????", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            //????????????????????????, ??????????????????
            if (product == null) {
                log.warn("?????? {} ?????????", buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

            }else if (product.getStock() < buyItem.getQuantity()) {
                log.warn("?????? {} ??????????????????, ???????????? ???????????? {} , ???????????? {}",
                        product.getProductName(),product.getStock(), buyItem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            //??????????????????
            productDao.updateStock(product.getProductId(), product.getStock() - buyItem.getQuantity());

            //???????????????
            int amount = product.getPrice() * buyItem.getQuantity();
            totalAmount = totalAmount + amount;

            //?????? BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        //????????????
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }
}
