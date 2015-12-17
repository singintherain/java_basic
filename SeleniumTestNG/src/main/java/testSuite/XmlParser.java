package testSuite;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvsong on 6/17/15.
 */
public class XmlParser implements IParser{
//    private String xmlPath = "./src/main/resources/testcases.xml";
//    private SAXReader reader = new SAXReader();
//
//    public List<XmlSuite> xmlSuites() {
//        return null;
//    }
//
//    private List<XmlTest> xmlTests(){
//        List<XmlTest> xmlTests = new ArrayList<XmlTest>();
//
//        for(Element e : tests()){
//            xmlTests.add(xmlTest(e));
//        }
//
//        return xmlTests;
//    }
//
//    private XmlTest xmlTest(Element e){
//        XmlTest test = new XmlTest();
//
//        return test;
//    }
//
//    private List<Element> tests(){
////        List<Element> elements = new ArrayList<Element>();
//
//        return document().selectNodes("test");
//    }
//
//    private Document document(){
//        try {
//            return reader.read(new File(xmlPath));
//        } catch (DocumentException e) {
//            System.out.println(xmlPath + "read wrong");
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
}
