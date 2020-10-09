package com.example.demo.controller;

import com.example.demo.annotation.UserLoginToken;
import com.example.demo.entity.Response;
import com.example.demo.entity.Restaurant;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;
    @UserLoginToken
    @RequestMapping(value = "/addRestaurant",method = RequestMethod.POST)
    public Response addRestaurant(@RequestBody Restaurant restaurant){
        if(restaurant.getRestaurant_name()!=null &&restaurant.getRestaurant_price()!=0&&restaurant.getRestaurant_description()!=null){
            int count=restaurantService.addRestaurant(restaurant);
            System.out.println("count"+count);
            if(count>0){
                return new Response("添加成功",1,true);

            }else{
                return new Response("添加失败",-1,false);
            }
        }else{
            return new Response("餐厅名称/餐厅价格/餐厅简介不能为空",-1,false);
        }
    }
    @UserLoginToken
    @RequestMapping(value = "/getRestaurantList",method = RequestMethod.GET)
    public Response getRestaurantList(@RequestBody(required = false) Restaurant restaurant){
        Response response=new Response();
        List<Restaurant> restaurantList=restaurantService.getRestaurantList();
        response.setResponse("查询成功",1,true,restaurantList);
        return response;

    }
}
