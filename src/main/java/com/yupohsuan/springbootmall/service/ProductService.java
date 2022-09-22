package com.yupohsuan.springbootmall.service;

import com.yupohsuan.springbootmall.dto.ProductRequest;
import com.yupohsuan.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
