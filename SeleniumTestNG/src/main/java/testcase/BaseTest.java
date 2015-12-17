package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import testConfig.FileSource;
import testConfig.XmlTestConvertor;

import java.util.List;

/**
 * Created by lvsong on 6/18/15.
 */
public class BaseTest {
//    private WebDriver driver;

//    @BeforeTest
//    public void init(){
//        System.out.println("init");
//        this.driver = new FirefoxDriver();
//    }
//
//    @AfterTest
//    public void clear(){
//        this.driver.close();
//        System.out.println("clear");
//    }

    @DataProvider(name = "testCases", parallel = true)
    public Object[][] testCases(){

        FileSource source = new FileSource();
        XmlTestConvertor convertor = new XmlTestConvertor(source.testSource());
        convertor.run();
        List<OneTestCase> testCaseList = convertor.getTestCases();
        int size = testCaseList.size();

        System.out.println("test size: " + size);

        Object[][] result = new Object[size][1];

        for(int i = 0; i < size; i++){
            result[i][0] = testCaseList.get(i);
        }

        return result;
    }

    @Test(dataProvider = "testCases")
    public void testCase(OneTestCase oneTestCase){
        WebDriver driver = new FirefoxDriver();
        System.out.println("one test case");
        System.out.println(driver.toString());
        System.out.println(Thread.currentThread().getName());
        oneTestCase.setWebDriver(driver);
        oneTestCase.execute();
        driver.close();
        System.out.println("driver close");
    }
}
