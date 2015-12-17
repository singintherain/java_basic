package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 输入数据
 * Created by lvsong on 6/18/15.
 */
public class SendKeys implements IAction{
    private String elementPath;
    private String value;
    private WebDriver driver;

    public SendKeys(String elementPath, String value){
        this.elementPath = elementPath;
        this.value = value;
    }

    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void start() {
        this.driver.findElement(By.xpath(this.elementPath)).sendKeys(this.value);
    }
}
