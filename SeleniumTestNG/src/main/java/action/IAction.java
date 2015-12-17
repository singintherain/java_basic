package action;

import org.openqa.selenium.WebDriver;

/**
 * 页面动作接口，对外有个统一的执行操作
 * Created by lvsong on 6/18/15.
 */
public interface IAction {
    /**
     * 设置操作执行的driver
     */
    public void setWebDriver(WebDriver driver);

    /**
     * 动作开始执行
     */
    public void start();
}
