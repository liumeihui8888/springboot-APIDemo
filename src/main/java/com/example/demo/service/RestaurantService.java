package com.example.demo.service;


import com.example.demo.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    int addRestaurant(Restaurant restaurant);
    List<Restaurant> getRestaurantList();
}
