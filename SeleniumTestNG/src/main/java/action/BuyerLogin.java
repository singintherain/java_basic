package action;

import engine.StaticUrlConfig;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装买家登入
 * Created by lvsong on 6/18/15.
 */
public class BuyerLogin implements IAction {
    private WebDriver driver;
    private String username;
    private String password;

    public BuyerLogin(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public List<IAction> loginAction(){
        List<IAction> actions = new ArrayList<IAction>();

        IAction visitLoginUrl = new Visit(StaticUrlConfig.url("buyerLogin"));
        IAction insertUserName = new SendKeys("//input[@id='ddusername']", this.username);
        IAction insertPwd = new SendKeys("//input[@id='ddpw1']", this.password);
        IAction submitLogin = new Click("//input[@id='login_submit']");

        actions.add(visitLoginUrl);
        actions.add(insertUserName);
        actions.add(insertPwd);
        actions.add(submitLogin);

        return actions;
    }

    public void start() {
        for(IAction action : loginAction()){
            action.setWebDriver(this.driver);
            action.start();
        }
    }
}
