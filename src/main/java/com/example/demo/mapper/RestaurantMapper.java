package com.example.demo.mapper;

import com.example.demo.entity.Restaurant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    int addRestaurant(Restaurant restaurant);
    List<Restaurant> getRestaurantList();
}
