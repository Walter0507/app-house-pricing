package com.hbhs.house.pricing.repository;

import com.hbhs.common.tools.io.PropertiesLoader;
import com.hbhs.house.pricing.config.DatabaseConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

// SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringJUnit4ClassRunner.class)
//@EnableElasticsearchRepositories(basePackages = {"com.hbhs.house.pricing.repository.es"})
@Import({DatabaseConfig.class})
@Slf4j
public class BaseEsTest {

    static {
        try {
            PropertiesLoader.folderPath = "/opt/configs/house-pricing/";
            PropertiesLoader.loadFile("house-pricing.properties");
        }catch (Exception e){
            log.error("Failed to load properties file", e);
        }
    }
}
