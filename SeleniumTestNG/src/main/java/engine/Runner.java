package engine;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvsong on 6/17/15.
 */
public class Runner {
    public static void main(String[] args){
        System.out.println("runner");

        List<XmlSuite> suites = new ArrayList<XmlSuite>();

        XmlSuite suite = new XmlSuite();

        List<XmlClass> klasses = new ArrayList<XmlClass>();
        XmlClass klass = new XmlClass("testcase.BaseTest");
        klasses.add(klass);

        List<XmlTest> tests = new ArrayList<XmlTest>();

        XmlTest test = new XmlTest(suite);
//        test.setName("addTest1");
        test.setClasses(klasses);
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("testCase", "my first custom test");
//        test.setParameters(params);

        tests.add(test);

        suite.setTests(tests);
        suite.setName("first selenium testng");
//        suite.setParallel("methods");
//        suite.setThreadCount(4);
        suite.setDataProviderThreadCount(2);

        suites.add(suite);

        TestNG testng = new TestNG();
        testng.setXmlSuites(suites);

        testng.run();
    }

}
