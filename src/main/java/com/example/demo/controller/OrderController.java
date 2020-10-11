package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.UserLoginToken;
import com.example.demo.entity.*;
import com.example.demo.entity.table.TableOrder;
import com.example.demo.mapper.OrderDetailMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.OrderDetailService;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    OrderDetailMapper orderDetailMapper;
    @UserLoginToken
    @Transactional //此方法开启事务管理
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public Response addOrder(@RequestBody TableOrder order){
        JSONObject jsonObject=new JSONObject();
        //System.out.println("==============="+order.getProductList());
        try {
            if(order.productList!=null &&order.productList.size()>=1 &&order.getProductsStr()!=null) {

                int ordercount = orderService.addOrder(order);
                int order_id=order.getOrder_id();

                for(Product product1:order.getProductList()){

                    orderDetailService.insertRelationWithOrderDetail(product1.getId(),order.getOrder_id(),product1.getCount());
                    Product product=productService.queryProductById(product1.getId());
                    product1.setProduct_name(product.getProduct_name());
                    product1.setProduct_label(product.getProduct_label());
                    product1.setProduct_description(product.getProduct_description());
                    product1.setProduct_price(product.getProduct_price());
                    product1.setProduct_icon(product.getProduct_icon());
                    product1.setRestaurant_id(product.getRestaurant_id());
                    product1.setRestaurant(product.getRestaurant());

                }
                if (ordercount > 0) {
                    jsonObject.put("ps",order.getProductList());
                    jsonObject.put("order_id",order.getOrder_id());

                    return new Response("添加成功", 1, true,jsonObject);
                } else {
                    return new Response("添加失败", -1, false);
                }

            }else {
                return new Response("商品信息不能为空",-1,false);
            }
        }catch (Exception e){
           logger.error(e.getMessage());
           return new Response("添加失败",-1,false);
        }



    }
    @UserLoginToken
    @RequestMapping(value = "/queryOrderList",method = RequestMethod.GET)
    public Response queryOrderList(@RequestParam(required = false) TableOrder order){
        Response response=new Response();
        List<TableOrder> orderList=orderService.queryOrderList();
        List<Order> orders = new ArrayList<Order>();
        for(TableOrder tableOrder:orderList){
            Order order1=new Order();
            order1.setId(tableOrder.getOrder_id());
            order1.setUser(tableOrder.getUser());
            order1.setDate(tableOrder.getCreatetime());
            order1.setProductsStr(tableOrder.getProductsStr());
            List<OrderDetail> orderDetailList=tableOrder.getOrderDetailList();
            int count=0;
            double price=0.0;
            List<Product> products=new ArrayList<Product>();
            for(OrderDetail orderDetail:orderDetailList){
                count+=orderDetail.getCount();
                price+=orderDetail.getProduct().getProduct_price()*orderDetail.getCount();
                Product product = orderDetail.getProduct();
                product.setCount(orderDetail.getCount());
                products.add(product);
            }
            order1.setCount(count);
            order1.setPrice(price);
            order1.setProducts(products);
            orders.add(order1);

        }



        response.setResponse("查询成功",1,true,orders);
        return response;

    }
}
