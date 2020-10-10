package com.example.demo.controller;

import com.example.demo.annotation.UserLoginToken;
import com.example.demo.entity.Product;
import com.example.demo.entity.Response;
import com.example.demo.entity.Restaurant;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;
import com.example.demo.service.RestaurantService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @UserLoginToken
    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    public Response addProduct(@RequestBody Product product){

        System.out.println("--------------------------");
        if(product.getProduct_name()!=null &&product.getProduct_price()!=0 &&product.getRestaurant_id()!=0 &&product.getProduct_label()!=null&&product.getProduct_description()!=null){
            int count=productService.addProduct(product);
            System.out.println("count"+count);
            if(count>0){
                return new Response("添加成功",1,true);
            }else{
                return new Response("添加失败",-1,false);
            }
        }else{
            return new Response("商品名称/商品价格/商品的餐厅不能为空",-1,false);
        }
    }

    //@RequestMapping(value = "/getProductList",method = RequestMethod.GET)这种写法与下面那行写法是相等的
    @UserLoginToken
    @GetMapping("/getProductList")  //与上面的那行写法是相等的
    public Response getProductList(@RequestParam(required = false) Product product){
        Response response=new Response();
        List<Product> productList=productService.getProductList();
        response.setResponse("查询成功",1,true,productList);
        return response;

    }

    @UserLoginToken
    @GetMapping(value = "findAllProductByPageS") //商品列表分页查询
    public Response findAllProductByPageS( int pageNum, int pageSize){
        PageInfo<Product> lists=productService.findAllProductByPageS(pageNum,pageSize);
        return new Response("查询成功",1,true,lists);
    }
}
