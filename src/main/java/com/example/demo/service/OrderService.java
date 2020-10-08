package com.example.demo.service;

import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    int addOrder(Order order);
    List<Order> queryOrderList();

}
