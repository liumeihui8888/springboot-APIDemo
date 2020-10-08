package com.example.demo.mapper;

import com.example.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    int addProduct(Product product);
    List<Product> getProductList();
    Product queryProductById(int id);

}
