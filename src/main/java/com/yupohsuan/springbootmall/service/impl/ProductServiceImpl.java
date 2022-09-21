package com.yupohsuan.springbootmall.service.impl;

import com.yupohsuan.springbootmall.dao.ProductDao;
import com.yupohsuan.springbootmall.dto.ProductRequest;
import com.yupohsuan.springbootmall.model.Product;
import com.yupohsuan.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }
}
