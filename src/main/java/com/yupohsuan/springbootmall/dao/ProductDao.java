package com.yupohsuan.springbootmall.dao;

import com.yupohsuan.springbootmall.dto.ProductRequest;
import com.yupohsuan.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts();

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
