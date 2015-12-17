package com.lvsong;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

/**
 * Created by lvsong on 7/9/15.
 */
public class EngineTest {
    private Engine engine;

//    private WebDriver webdriver() {
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//
//        try {
//            WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//            return driver;
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    @Before
    public void setup() {
//        engine = new Engine();
//        engine.setWebDriver(webdriver());
//        engine.setWebDriver(new FirefoxDriver());
    }

    @After
    public void clearDown() {
//        engine.getWebDriver().quit();
    }

//    @Test
//    public void getTest() {
//        String url = "http://www.baidu.com";
//        for(int i = 0; i < 20; i++) {
//            engine.visit(url);
//        }
//    }

    @Test
    public void runManyTimesTest() {
        for(int i = 0; i < 2; i++) {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();

            try {
                WebDriver driver = new RemoteWebDriver(new URL("http://192.168.2.176:4444/wd/hub"), capabilities);
                Engine engine = new Engine();
                engine.setWebDriver(driver);

                String url = "http://www.baidu.com";
                engine.visit(url);
                driver.quit();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    class InnerThread implements Runnable {

        public void run() {
            System.out.println("inner thread");

            DesiredCapabilities capabilities = DesiredCapabilities.firefox();

            try {
                System.out.println(capabilities);
                System.out.println(Thread.currentThread().getName());
                System.out.println("before driver init");
//                WebDriver driver = new RemoteWebDriver(new URL("http://192.168.2.176:4444/wd/hub"), capabilities);
                System.out.println("after driver init");
//                Engine engine = new Engine();
//                engine.setWebDriver(driver);
//
//                System.out.println("driver");
//                String url = "http://www.baidu.com";
//                engine.visit(url);
//                driver.quit();
//            } catch (MalformedURLException e) {
//                System.out.println("MalformedURLException: " + e.getMessage());
//                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }

    @Test
    public void runMultiThreadTest() {
//        ExecutorService pool = Executors.newFixedThreadPool(2);
//
//        for(int i = 0; i < 2; i++) {
//            pool.submit(new InnerThread());
//        }
//
//        pool.shutdown();
    }
}
