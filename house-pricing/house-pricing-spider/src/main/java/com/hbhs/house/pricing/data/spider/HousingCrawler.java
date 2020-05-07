package com.hbhs.house.pricing.data.spider;

import java.util.List;

/**
 *
 * @author juqi
 * @date 2018/12/24 21:07
 **/
public interface HousingCrawler {

    void init();

    void crawlPage(List<String> urlList);

    void close();
}
