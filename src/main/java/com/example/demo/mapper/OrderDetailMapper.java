package com.example.demo.mapper;

import com.example.demo.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface OrderDetailMapper {
    int addOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> queryOrderDetailList();
    int insertRelationWithOrderDetail(@Param("product_id")int product_id, @Param("order_id")int order_id, @Param("count") int count);
}
