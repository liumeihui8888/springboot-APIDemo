package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.entity.table.TableOrder;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    int addOrder(TableOrder order);
    List<TableOrder> queryOrderList();


}
