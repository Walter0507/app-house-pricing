package com.hbhs.house.pricing;

import com.hbhs.common.tools.io.PropertiesLoader;
import com.hbhs.house.pricing.config.DatabaseConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(value = {"com.hbhs.house.pricing"})
@MapperScan(value = {"com.hbhs.house.pricing.repository.dao.mapper"})
@Import({DatabaseConfig.class})
@Slf4j
public class BaseTest {
    static {
        try {
            PropertiesLoader.folderPath = "/opt/configs/house-pricing/";
            PropertiesLoader.loadFile("house-pricing.properties");
        }catch (Exception e){
            log.error("Failed to load properties file", e);
        }
    }
}
