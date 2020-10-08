package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {
    int addOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> queryOrderDetailList();
    int insertRelationWithOrderDetail(@Param("product_id")int product_id, @Param("order_id")int order_id, @Param("count") int count);
}
