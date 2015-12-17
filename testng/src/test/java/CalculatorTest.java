import com.services.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by lvsong on 6/15/15.
 */
public class CalculatorTest {
    private int first = 1;
    private int second = 2;

    @Test
    public void addTest()
    {
        Calculator cal = new Calculator();
        Assert.assertEquals(cal.add(first, second), 3);
    }
}
