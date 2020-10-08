package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    int addProduct(Product product);
    List<Product> getProductList();
    Product queryProductById(int id);
}
