package com.scaler.productservice.service;

import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id);
    List<Product> getAllProducts();
    void addNewProduct(Product product);
    void updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    void replaceProduct(Long id, Product product);
}

