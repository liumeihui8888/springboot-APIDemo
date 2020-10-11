package com.example.demo.entity;

import com.example.demo.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Order {
    @Autowired
    public User user;
    public int id;
    public Date date;
    public String productsStr;
    public Restaurant restaurant;
    public int count;
    public double price;
    public List<ProductPS> ps;
    public List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProductsStr() {
        return productsStr;
    }

    public void setProductsStr(String productsStr) {
        this.productsStr = productsStr;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ProductPS> getPs() {
        return ps;
    }

    public void setPs(List<ProductPS> ps) {
        this.ps = ps;
    }

    //    int order_id;
//    int user_id;
//    String productsStr;
//    int status;
//    public List<Product> productList;
//   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    Date createtime;
//   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    Date updatetime;
    public Order(){}

}
