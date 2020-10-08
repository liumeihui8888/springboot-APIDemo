package com.example.demo.entity;

public class Restaurant {
    int Restaurant_id;
    String Restaurant_icon;
    String Restaurant_name;
    String Restaurant_description;
    double Restaurant_price;
    public Restaurant(){

    }
    public Restaurant(int Restaurant_id,String Restaurant_icon,String Restaurant_name,String Restaurant_description,double Restaurant_price){
        this.Restaurant_id=Restaurant_id;
        this.Restaurant_icon=Restaurant_icon;
        this.Restaurant_name=Restaurant_name;
        this.Restaurant_description=Restaurant_description;
        this.Restaurant_price=Restaurant_price;
    }

    public int getRestaurant_id() {
        return Restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        Restaurant_id = restaurant_id;
    }

    public String getRestaurant_icon() {
        return Restaurant_icon;
    }

    public void setRestaurant_icon(String restaurant_icon) {
        Restaurant_icon = restaurant_icon;
    }

    public String getRestaurant_name() {
        return Restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        Restaurant_name = restaurant_name;
    }

    public String getRestaurant_description() {
        return Restaurant_description;
    }

    public void setRestaurant_description(String restaurant_description) {
        Restaurant_description = restaurant_description;
    }

    public double getRestaurant_price() {
        return Restaurant_price;
    }

    public void setRestaurant_price(double restaurant_price) {
        Restaurant_price = restaurant_price;
    }
}
