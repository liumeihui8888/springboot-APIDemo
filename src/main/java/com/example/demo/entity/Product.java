package com.example.demo.entity;


public class Product{
    String product_name;
    String product_label;
    String product_description;
    String product_icon;
    double product_price;
    Restaurant restaurant;
    int restaurant_id;
    int id;
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product(){

    }
    public Product(String product_name,String product_label,String product_description,String product_icon,double product_price,int restaurant_id){
          this.product_name=product_name;
          this.product_label=product_label;
          this.product_description=product_description;
          this.product_icon=product_icon;
          this.product_price=product_price;
          this.restaurant_id=restaurant_id;
    }
    public Product(String product_name,String product_label,double product_price){
        this.product_name=product_name;
        this.product_label=product_label;
        this.product_price=product_price;

    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_label() {
        return product_label;
    }

    public void setProduct_label(String product_label) {
        this.product_label = product_label;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_icon() {
        return product_icon;
    }

    public void setProduct_icon(String product_icon) {
        this.product_icon = product_icon;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
