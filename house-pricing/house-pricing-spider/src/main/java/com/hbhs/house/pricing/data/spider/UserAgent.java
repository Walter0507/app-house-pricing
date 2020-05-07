package com.hbhs.house.pricing.data.spider;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class UserAgent {
    private static List<String> userAgentList = new ArrayList<>();

    private static synchronized void init() {
        if (userAgentList.size() > 0) {
            return;
        }
        InputStream is = null;
        try {
            is = UserAgent.class.getClassLoader().getResourceAsStream("useragent.txt");
        } catch (Exception e) {
            is = UserAgent.class.getClassLoader().getResourceAsStream("/useragent.txt");
        }
        try {
            userAgentList = IOUtils.readLines(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        userAgentList.removeIf(str -> str == null || "".equals(str.trim()));
        if (userAgentList.size() == 0) {
            userAgentList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
        }
    }

    public static String nextRandomUserAgent() {
        if (userAgentList.size() == 0) {
            init();
        }
        return userAgentList.get(new Random().nextInt(userAgentList.size()));
    }

    public static void main(String[] args) {
        UserAgent ua = new UserAgent();
        ua.init();
        System.out.println(ua.userAgentList.size());
        for (int i = 0; i < 10; i++) {
            System.out.println(ua.nextRandomUserAgent());
        }
    }
}
