package com.example.demo.entity;

public class OrderDetail {
    int order_id;
    int product_id;
    public Product product;
    int id;
    int count;
    public OrderDetail(){}
    public OrderDetail(int order_id,int product_id,int id,int count){
        this.order_id=order_id;
        this.product_id=product_id;
        this.id=id;
        this.count=count;

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
