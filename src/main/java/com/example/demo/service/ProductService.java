package com.example.demo.service;

import com.example.demo.entity.Product;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {
    int addProduct(Product product);
    List<Product> getProductList();
    Product queryProductById(int id);
    PageInfo <Product> findAllProductByPageS(int pageNum,int pageSize);
}
