package com.example.demo.entity;

import com.example.demo.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Order {
    @Autowired
    OrderDetailMapper orderDetailMapper;
    int order_id;
    int user_id;
    String productsStr;
    int status;
    public List<Product> productList;
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createtime;
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updatetime;
    public Order(){}
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Order(int order_id, int user_id, String productsStr, int status, List<Product> productList,Date createtime, Date updatetime){
        this.order_id=order_id;
        this.user_id=user_id;
        this.productsStr=productsStr;
        this.status=status;
        this.createtime=createtime;
        this.updatetime=updatetime;
        this.productList=productList;
    }
    public Order(int user_id,String productsStr){
        this.user_id=user_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getProductsStr() {
        return productsStr;
    }

    public void setProductsStr(String productsStr) {
        this.productsStr = productsStr;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
