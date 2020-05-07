package com.hbhs.house.pricing;

import com.hbhs.common.tools.io.PropertiesLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableAspectJAutoProxy
//@EnableFeignClients(basePackages = {"com.hbhs.house.pricing"})
//@EnableEurekaClient
@ComponentScan(basePackages = {"com.hbhs.house.pricing"})
@MapperScan(basePackages = {"com.hbhs.house.pricing.repository.dao.mapper"})
@Slf4j
public class HousePricingApplicationBoot {

    public static void main(String[] args) {
        try {
            PropertiesLoader.folderPath = "/opt/configs/house-pricing/";
            PropertiesLoader.loadFile("house-pricing.properties");
        }catch (Exception e){
            log.error("Failed to load config file", e);
        }
        SpringApplication.run(HousePricingApplicationBoot.class);
    }
}
