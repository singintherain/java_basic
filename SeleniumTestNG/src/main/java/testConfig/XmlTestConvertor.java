package testConfig;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import testcase.ActionTranslation;
import testcase.OneTestCase;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 将输入的xml配置测试用例转换为单独的测试用例
 * 使用时将testSource传入，执行run方法，使用getTestCases获取解析后的所有的测试用例
 * Created by lvsong on 6/18/15.
 */
public class XmlTestConvertor {
    private SAXReader reader = new SAXReader();
    private InputStream testSource;
    private List<OneTestCase> testCases = new ArrayList<OneTestCase>();

    public XmlTestConvertor(InputStream testSource){
        this.testSource = testSource;
    }

    public void run(){
        try {
            Document document = reader.read(this.testSource);
            Element root = document.getRootElement();

            List<Element> tests = root.elements("test");

            for(Element test : tests){
                parseAllTestCase(test);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void parseAllTestCase(Element test){
        OneTestCase testCase = new OneTestCase();

        List<Element> actions = new ArrayList<Element>();
        actions = test.elements("action");

        for(Element element : actions){
            ActionTranslation trans = new ActionTranslation(element);
            trans.start();
            testCase.getActions().add(trans.getAction());
        }

        this.getTestCases().add(testCase);
    }

    public List<OneTestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<OneTestCase> testCases) {
        this.testCases = testCases;
    }
}
