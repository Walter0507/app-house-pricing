package com.hbhs.house.pricing.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;

/**
 * @Author: juqi
 * @Date: 2018/7/17
 **/
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, SessionAutoConfiguration.class,
        DataSourceAutoConfiguration.class})
//@EnableEurekaClient
public class TestBoot {
    public static void main(String[] args){
        SpringApplication.run(TestBoot.class, args);
    }
}
