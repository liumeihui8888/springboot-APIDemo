package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public int addProduct(Product product) {
        int count=productMapper.addProduct(product);
        return count;
    }

    @Override
    public List<Product> getProductList() {
        List<Product> productList=productMapper.getProductList();
        return productList;
    }

    @Override
    public Product queryProductById(int id) {
        Product product=productMapper.queryProductById(id);
        return product;
    }

    @Override
    public PageInfo<Product> findAllProductByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> lists=productMapper.getProductList();
        PageInfo pageInfo=new PageInfo<Product>(lists);
        return pageInfo;
    }
}
