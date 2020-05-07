package com.hbhs.house.pricing.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ComponentScan(value = {"com.hbhs.house.pricing.api"})
//@EnableFeignClients
@Slf4j
public class BaseClientTest {
    static {
        System.getProperties().put("feign.client.house-pricing.url","http://localhost:8201");
    }
}
