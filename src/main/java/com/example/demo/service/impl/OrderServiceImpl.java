package com.example.demo.service.impl;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.table.TableOrder;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public int addOrder(TableOrder order) {
        System.out.println("44444444444444444444"+order.getProductsStr());
        int count=orderMapper.addOrder(order);
        int order_id=order.getOrder_id();

        return count;
    }

    @Override
    public List<TableOrder> queryOrderList() {
        List<TableOrder> orderList=orderMapper.queryOrderList();
        return orderList;
    }


}
