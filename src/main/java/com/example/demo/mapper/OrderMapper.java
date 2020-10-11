package com.example.demo.mapper;

import com.example.demo.entity.Order;
import com.example.demo.entity.table.TableOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface OrderMapper {
    int addOrder(TableOrder order);
    List<TableOrder> queryOrderList();

}
