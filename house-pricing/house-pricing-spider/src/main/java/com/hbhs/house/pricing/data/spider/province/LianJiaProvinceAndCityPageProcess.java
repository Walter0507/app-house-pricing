package com.hbhs.house.pricing.data.spider.province;

import com.hbhs.house.pricing.data.dto.CrawlCity;
import com.hbhs.house.pricing.data.dto.CrawlProvince;
import com.hbhs.house.pricing.data.spider.UserAgent;
import com.hbhs.house.pricing.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * @author juqi
 * @date 2018/12/26 16:08
 **/
@Slf4j
public class LianJiaProvinceAndCityPageProcess implements PageProcessor{
    private static final Logger LOG = LoggerFactory.getLogger(LianJiaProvinceAndCityPageProcess.class);

    private static final String XPATH_PATTERN_PROVINCE = "//div[@class='city_province']";

    private LianJiaProvinceAndCityPageCrawler crawler = null;

    private Site site = null;
    public LianJiaProvinceAndCityPageProcess(LianJiaProvinceAndCityPageCrawler crawler){
        site = new Site();
        site.setDomain("www.lianjia.com");
//        site.getHeaders().put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
        site.getHeaders().put("User-Agent", UserAgent.nextRandomUserAgent());
        site.setRetryTimes(3);
        site.setSleepTime(1000);

        this.crawler = crawler;
    }

    @Override
    public void process(Page page) {
        try {
            List<Selectable> selectableList = page.getHtml().xpath(XPATH_PATTERN_PROVINCE).nodes();
            if (CollectionUtils.isEmpty(selectableList)){
                LOG.warn("No province/city found in pattern:{} found from page: {}, skip to do next step... ", XPATH_PATTERN_PROVINCE, page.getUrl());
                return ;
            }

            for (Selectable selectable : selectableList) {
                String provinceName = selectable.xpath("//div[@class='city_list_tit c_b']/text()").get();

                List<Selectable> cityInfoList = selectable.xpath("//ul/li/a").nodes();
                if (!CollectionUtils.isEmpty(cityInfoList)){
                    for (Selectable cityInfo : cityInfoList) {
                        String cityName = cityInfo.xpath("//a/text()").get();
                        String cityUrl = cityInfo.xpath("//a/@href").get();

                        CrawlCity city = new CrawlCity();
                        city.setCityName(cityName);
                        city.setProvinceName(provinceName);
                        city.setCrawlUrl(cityUrl.endsWith("/")?(cityUrl+"ershoufang/"):(cityUrl+"/ershoufang/"));
                        crawler.getCityList().add(city);
                    }
                }

                CrawlProvince province = new CrawlProvince();
                province.setProvinceName(provinceName);
                province.setCrawlUrl(null);
                crawler.getProvinceList().add(province);
            }
            log.info("Already found province-and-city-info data in page:{}", page.getUrl());


        }catch (Exception e){
            log.error("Error to load province-and-city", e);
        }
    }
    @Override
    public Site getSite() {
        return site;
    }
}
