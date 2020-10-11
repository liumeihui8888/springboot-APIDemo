package com.example.demo.entity.table;



import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class TableOrder {

    int order_id;
    int user_id;
    public User user;
    String productsStr;
    int status;
    public List<OrderDetail> orderDetailList;
    public List<Product> productList;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createtime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updatetime;
    public TableOrder(){}

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public TableOrder(int order_id, int user_id, String productsStr, int status, List<Product> productList,Date createtime, Date updatetime){
        this.order_id=order_id;
        this.user_id=user_id;
        this.productsStr=productsStr;
        this.status=status;
        this.createtime=createtime;
        this.updatetime=updatetime;
        this.productList=productList;
    }
    public TableOrder(int user_id,String productsStr){
        this.user_id=user_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getProductsStr() {
        return productsStr;
    }

    public void setProductsStr(String productsStr) {
        this.productsStr = productsStr;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}