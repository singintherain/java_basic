import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvsong on 6/16/15.
 */
public class Engine {
    public static void main(String[] args){
        System.out.println("engine");

        List<XmlSuite> suites = new ArrayList<XmlSuite>();

        XmlSuite suite = new XmlSuite();

        List<XmlClass> klasses = new ArrayList<XmlClass>();
        XmlClass klass = new XmlClass("CalculatorTest");
        klasses.add(klass);

        List<XmlTest> tests = new ArrayList<XmlTest>();

        XmlTest test = new XmlTest(suite);
        test.setName("addTest1");
        test.setClasses(klasses);
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("testCase", "my first custom test");
//        test.setParameters(params);
        XmlTest test2 = new XmlTest(suite);
        test2.setName("addTest2");
        test2.setClasses(klasses);
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("testCase", "my first custom test");
//        test.setParameters(params);

        tests.add(test);
        tests.add(test2);

        suite.setTests(tests);
        suite.setName("calculator test cases");
        suite.setParallel("methods");
        suite.setThreadCount(4);

        suites.add(suite);

        TestNG testng = new TestNG();
        testng.setXmlSuites(suites);

        testng.run();
    }
}
