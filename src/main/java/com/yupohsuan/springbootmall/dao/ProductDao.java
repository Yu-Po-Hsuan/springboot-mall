package com.yupohsuan.springbootmall.dao;

import com.yupohsuan.springbootmall.dto.ProductRequest;
import com.yupohsuan.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
