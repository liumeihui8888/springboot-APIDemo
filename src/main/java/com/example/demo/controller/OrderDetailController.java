package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Response;
import com.example.demo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;
    @RequestMapping(value = "/queryOrderDetailList",method = RequestMethod.POST)
    public Response queryOrderDetailList(@RequestBody(required = false) Order order){
        Response response=new Response();
        List<OrderDetail> orderDetailList=orderDetailService.queryOrderDetailList();
        response.setResponse("查询成功",1,true,orderDetailList);
        return response;

    }
}
