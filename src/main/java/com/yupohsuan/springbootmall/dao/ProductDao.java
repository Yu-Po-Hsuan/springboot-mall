package com.yupohsuan.springbootmall.dao;

import com.yupohsuan.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
}
