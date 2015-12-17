package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 点击页面元素
 * Created by lvsong on 6/18/15.
 */
public class Click implements IAction {
    private WebDriver driver;
    private String elementPath;

    public Click(){}
    public Click(String elementPath){
        this.elementPath = elementPath;
    }

    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void start() {
        this.driver.findElement(By.xpath(this.getElementPath())).click();
    }

    public String getElementPath() {
        return elementPath;
    }

    public void setElementPath(String elementPath) {
        this.elementPath = elementPath;
    }
}
