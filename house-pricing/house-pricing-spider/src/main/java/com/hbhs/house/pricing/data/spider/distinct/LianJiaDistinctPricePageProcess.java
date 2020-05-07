package com.hbhs.house.pricing.data.spider.distinct;

import com.hbhs.house.pricing.data.spider.UserAgent;
import com.hbhs.house.pricing.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * @author juqi
 * @date 2018/12/26 16:08
 **/
@Slf4j
public class LianJiaDistinctPricePageProcess implements PageProcessor {
    private int pageSize = 30;
    private int maxPage = 20;

    private LianJiaDistinctPricePageCrawler crawler;

    private Site site = null;

    public LianJiaDistinctPricePageProcess(LianJiaDistinctPricePageCrawler crawler) {
        site = new Site();
        site.setDomain("www.lianjia.com");
        site.getHeaders().put("User-Agent", UserAgent.nextRandomUserAgent());
        site.setRetryTimes(3);
        site.setSleepTime(1000);
        site.setDisableCookieManagement(true);
        site.setUseGzip(true);

        this.crawler = crawler;
    }

    @Override
    public void process(Page page) {
        try {
            this.handlerDistinctData(page);
        } catch (Exception e) {
            log.error("Error to parse page.", e);
        }
    }

    private void handlerDistinctData(Page page) {
        Html html = page.getHtml();
        String totalErshoufangCountStr = html.xpath("//h2[@class='total']/span/text()").get();
        crawler.setTotalErshoufangCount(NumberUtil.parseInt(totalErshoufangCountStr, 0));
        List<Selectable> priceList = html.xpath("//div[@class='unitPrice']/@data-price").nodes();
        if (priceList != null && priceList.size() > 0) {
            for (Selectable price : priceList) {
                Integer priceInt = NumberUtil.parseInt(price.get(), null);
                if (priceInt != null) {
                    crawler.getPriceList().add(priceInt);
                }
            }
        }
        if (priceList != null && priceList.size() >= pageSize) {
            addNextPage(page, crawler.getTotalErshoufangCount());
        }
    }

    private void addNextPage(Page page, int maxCount) {
        String url = page.getUrl().get();
        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }
        String urlExcludePage = url;
        String pageNumInfo = url.substring(url.lastIndexOf("/") + 1);
        int pageNum = 1;
        if (pageNumInfo.contains("pg")) {
            pageNum = NumberUtil.parseInt(pageNumInfo.substring(2), 0);
            urlExcludePage = urlExcludePage.substring(0, urlExcludePage.lastIndexOf("/"));
        }
        if (pageNum == 0) {
            return;
        }
        int maxPageNum = (maxCount-1)/pageSize+1;
        maxPageNum = Math.min(maxPageNum, maxPage);
        while(pageNum < maxPageNum){
            String nextUrl =  urlExcludePage + "/pg" + (pageNum + 1) + "/";
            if (!crawler.getCrawlUrlList().contains(nextUrl)){
                page.addTargetRequest(nextUrl);
                crawler.getCrawlUrlList().add(nextUrl);
                log.debug("Adding next url: {}", nextUrl);
            }
            pageNum++;
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
