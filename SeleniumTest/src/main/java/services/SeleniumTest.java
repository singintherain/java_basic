package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by lvsong on 6/16/15.
 */
public class SeleniumTest {
    public static void main(String[] args){
//        System.out.print("main");

//        System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
//        System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = new FirefoxDriver();
        String url = "http://www.baidu.com";

        driver.get(url);
        driver.quit();
    }
}
