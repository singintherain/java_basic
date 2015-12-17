package com.lvsong;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by lvsong on 7/9/15.
 */
public class Engine {
    private WebDriver webDriver;

    public String visit(String url) {
//        System.out.println("visit: " + url);
        webDriver.get(url);
        return webDriver.getCurrentUrl();
    }

    public void sleep(int sec) {
        try {
            Thread.currentThread().sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
