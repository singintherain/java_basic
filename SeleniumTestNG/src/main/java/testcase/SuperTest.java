package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by lvsong on 6/17/15.
 */
public class SuperTest {
    private final String usernameInput = "//input[@id='ddusername']";
    private final String passwordInput = "//input[@id='ddpw1']";
    private final String submitButton = "//input[@id='login_submit']";
    private WebDriver driver;

    @DataProvider(name = "actions")
    public Object[][] actions(){
        return new Object[][]{
                {"get", "www.zhe800.com/login"}
        };
    }

    @Test
    public void browser(){
        System.out.println("browser");
        String loginUrl = "http://www.zhe800.com/login";
        String mainUrl = "http://www.zhe800.com";

        driver.get(loginUrl);
        driver.findElement(By.xpath(submitButton)).click();
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get(mainUrl);
    }

    @BeforeClass
    public void driver(){
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void clear(){
        driver.close();
    }

}
