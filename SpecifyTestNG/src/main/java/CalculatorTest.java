import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by lvsong on 6/16/15.
 */
public class CalculatorTest {
    private int first = 1;
    private int second = 2;

    @Test
    public void addTest(){
//        System.out.println("add Test");
        System.out.println(Thread.currentThread().getName());
        Calculator cal = new Calculator();
        Assert.assertEquals(cal.add(first, second), 3);
    }

    @Test
    public void addTest2(){
        System.out.println(Thread.currentThread().getName());
//        System.out.println("add Test");
        Calculator cal = new Calculator();
        Assert.assertEquals(cal.add(first, second), 3);
    }
}
