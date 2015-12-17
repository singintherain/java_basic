package action;

import org.openqa.selenium.WebDriver;

/**
 * 打开某个链接
 * Created by lvsong on 6/18/15.
 */
public class Visit implements IAction{
    private String url;
    private WebDriver driver;

    public Visit(String url){
        this.url = url;
    }

    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void start() {
        driver.get(url);
    }
}
