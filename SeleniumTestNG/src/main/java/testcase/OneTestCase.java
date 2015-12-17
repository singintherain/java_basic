package testcase;

import action.IAction;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * 完整的一个测试用例
 * 使用时，请先设置webDriver，然后再actions列表中增加各种动作
 * Created by lvsong on 6/18/15.
 */
public class OneTestCase {
    /**
     * 测试步骤
     */
    private List<IAction> actions = new ArrayList<IAction>();
    private WebDriver driver;
    private String name = "默认测试用例";

    public OneTestCase(){}

    public OneTestCase(List<IAction> actions){
        this.actions = actions;
    }

    public void execute(){
        for(IAction action : actions){
            action.setWebDriver(driver);
            action.start();
        }
    }

    public void setWebDriver(WebDriver driver){
        this.driver = driver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IAction> getActions() {
        return actions;
    }

    public void setActions(List<IAction> actions) {
        this.actions = actions;
    }
}
