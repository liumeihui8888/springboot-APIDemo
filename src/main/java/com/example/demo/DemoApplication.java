package com.example.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

//exclude= {DataSourceAutoConfiguration.class},如果不连数据库，则需要加上这个字段
@EnableTransactionManagement  //启动时添加事务
@Configuration
@MapperScan("com.example.demo.mapper")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("============项目启动开始===========");

		SpringApplication.run(DemoApplication.class, args);
		System.out.println("============项目启动结束===========");
	}

}
