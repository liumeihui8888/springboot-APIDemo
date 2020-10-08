package com.example.demo.service.impl;

import com.example.demo.entity.Restaurant;
import com.example.demo.mapper.RestaurantMapper;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantMapper restaurantMapper;
    @Override
    public int addRestaurant(Restaurant restaurant) {
        int count=restaurantMapper.addRestaurant(restaurant);
        return count;
    }

    @Override
    public List<Restaurant> getRestaurantList() {
        List<Restaurant> restaurantList=restaurantMapper.getRestaurantList();
        return restaurantList;
    }
}
