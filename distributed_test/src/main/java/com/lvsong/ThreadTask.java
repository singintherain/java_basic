package com.lvsong;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lvsong on 7/9/15.
 */
public class ThreadTask implements Runnable {
    public void run() {
//            System.out.println("inner thread");

            DesiredCapabilities capabilities = DesiredCapabilities.firefox();

            try {
//                System.out.println(capabilities);
                System.out.println(Thread.currentThread().getName());
//                System.out.println("before driver init");
                WebDriver driver = new RemoteWebDriver(new URL("http://192.168.2.176:4444/wd/hub"), capabilities);
//                System.out.println("after driver init");
                Engine engine = new Engine();
                engine.setWebDriver(driver);

//                System.out.println("driver");
                String url = "http://www.baidu.com";
                engine.visit(url);
                engine.sleep(5);
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
                FileUtils.copyFile(scrFile, new File("/Users/lvsong/Pictures/" + Thread.currentThread().getName() + "screenshot.png"));
                driver.quit();
            } catch (MalformedURLException e) {
                System.out.println("MalformedURLException: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
     }
}
