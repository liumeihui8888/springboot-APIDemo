package com.example.demo.service.impl;

import com.example.demo.entity.OrderDetail;
import com.example.demo.mapper.OrderDetailMapper;
import com.example.demo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailServiceImpl  implements OrderDetailService {
    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Override
    public int addOrderDetail(OrderDetail orderDetail) {
        int count=orderDetailMapper.addOrderDetail(orderDetail);
        return count;
    }

    @Override
    public List<OrderDetail> queryOrderDetailList() {
        List<OrderDetail> orderDetailList=orderDetailMapper.queryOrderDetailList();
        return orderDetailList;
    }

    @Override
    public int insertRelationWithOrderDetail(int product_id, int order_id, int count) {
        System.out.println("1111111111111111:"+order_id);
        int count1=orderDetailMapper.insertRelationWithOrderDetail(product_id,order_id,count);
        return count1;
    }
}
