package action;

import org.openqa.selenium.WebDriver;

/**
 * Created by lvsong on 6/18/15.
 */
public class Sleep implements IAction{
    private WebDriver driver;
    private int timeout;

    public Sleep(int timeout){
        this.timeout = timeout;
    }

    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void start() {
        try {
            Thread.currentThread().sleep(this.timeout * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new Error("sleep timeout error");
        }
    }
}
