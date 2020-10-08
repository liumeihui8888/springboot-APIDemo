package com.example.demo.entity;

public class OrderDetail {
    int order_id;
    int product_id;
    int orderdeatil_id;
    int count;

    public OrderDetail(int order_id,int product_id,int orderdeatil_id,int count){
        this.order_id=order_id;
        this.product_id=product_id;
        this.orderdeatil_id=orderdeatil_id;
        this.count=count;

    }
    public OrderDetail(int order_id,int product_id,int count){
        this.order_id=order_id;
        this.product_id=product_id;
        this.count=count;

    }
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrderdeatil_id() {
        return orderdeatil_id;
    }

    public void setOrderdeatil_id(int orderdeatil_id) {
        this.orderdeatil_id = orderdeatil_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
