import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * Created by lvsong on 6/12/15.
 */
public class Dom4jTest {
    public static void main(String[] args){
        System.out.println("Happy Maven!");
        SAXReader reader = new SAXReader();

        Document document;
        try {
            System.out.println(System.getProperty("user.dir"));
            File file = new File(".");
            System.out.println(file.getAbsolutePath());
            document = reader.read(new File("src/main/resources/students.xml"));

            Element root = document.getRootElement();
            System.out.println("root: " + root.getName());
//
//            List<Node> nodes = root.selectNodes("Student");
//            System.out.println(nodes.size());
//            for(Node node : nodes){
//                System.out.println(node.getName());
//            }

            //获取所有子元素
            List<Element> childList = root.elements();
            System.out.println("子元素个数 " + childList.size());

            Element firstStudent = root.element("student");
            System.out.println("attr: "
                    + firstStudent.attribute(0).getName()
                    + " = "
                    + firstStudent.attributeValue("name")
            );
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
