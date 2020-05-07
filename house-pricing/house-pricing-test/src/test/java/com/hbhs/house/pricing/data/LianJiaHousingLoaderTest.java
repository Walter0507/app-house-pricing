package com.hbhs.house.pricing.data;

import com.hbhs.house.pricing.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class LianJiaHousingLoaderTest extends BaseTest {

    @Autowired
    private LianJiaHousingLoader housingLoader;

    @Test
    public void crawlAndSaveProvinceAndCity() {
        housingLoader.crawlAndSaveProvinceAndCity("https://www.lianjia.com/city/");
    }

    @Test
    public void crawlAndSaveDistinct(){
        housingLoader.crawlAndSaveDistinct();
    }

    @Test
    public void crawlAndSaveDistinctPrice(){
        housingLoader.crawlAndSaveDistinctPrice();
    }

    @Test
    public void generateAndSaveCityPrice(){
        housingLoader.crawlAndSaveDistinctPrice();
        housingLoader.generateAndSaveCityPrice();
    }
}