package com.hbhs.house.pricing.data.spider.distinct;

import com.hbhs.house.pricing.data.dto.CrawlDistinct;
import com.hbhs.house.pricing.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author juqi
 * @date 2018/12/26 16:08
 **/
@Slf4j
public class LianJiaDistinctPageProcess implements PageProcessor{

    private static final String XPATH_PATTERN_PROVINCE = "//div[@class='city_province']";

    private LianJiaDistinctPageCrawler crawler;

    private Site site = null;
    public LianJiaDistinctPageProcess(LianJiaDistinctPageCrawler crawler){
        site = new Site();
        site.setDomain("www.lianjia.com");
        site.getHeaders().put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
        site.setRetryTimes(3);
        site.setSleepTime(1000);

        this.crawler = crawler;
    }

    @Override
    public void process(Page page) {
        try {
            this.handlerDistinctData(page);
        }catch (Exception e){
            log.error("Failed to process distinct page: "+page.getUrl(), e);
        }
    }

    private void handlerDistinctData(Page page){
        Html html = page.getHtml();
        String totalErshoufangCountStr = html.xpath("//h2[@class='total']/span/text()").get();
        crawler.setTotalErshoufangCount(NumberUtil.parseInt(totalErshoufangCountStr, 0));
        List<Selectable> selectableList = html.xpath("//div[@data-role='ershoufang']/div/a").nodes();
        if (CollectionUtils.isEmpty(selectableList)){
            log.warn("No province/city found in pattern:{} found from page: {}, skip to do next step... ", XPATH_PATTERN_PROVINCE, page.getUrl());
            return ;
        }
        String host = getHost(page.getUrl().get());
        for (Selectable selectable : selectableList) {
            String distinctName = selectable.xpath("//a/text()").get();
            String url = selectable.xpath("//a/@href").get();

            CrawlDistinct distinct = new CrawlDistinct();
            distinct.setDistinctName(distinctName);
            distinct.setCrawlUrl(host+url);
            distinct.setCityId(crawler.getCity().getId());
            distinct.setCityName(crawler.getCity().getName());

            crawler.getDistinctList().add(distinct);
        }
        if (log.isDebugEnabled()){
            log.debug("Already found data distinct-data data in page:{}, totalSize:{}", page.getUrl(), crawler.getDistinctList().size());
        }
    }

    private String getHost(String url){
        if (StringUtils.isEmpty(url)){
            return "";
        }
        return url.substring(0, url.indexOf("/",8));
    }

    @Override
    public Site getSite() {
        return site;
    }
}
