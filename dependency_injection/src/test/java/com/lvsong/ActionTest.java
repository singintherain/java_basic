package com.lvsong;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.plugin2.util.SystemUtil;

import java.io.File;

/**
 * Created by lvsong on 7/10/15.
 */
public class ActionTest {
    @Test
    public void actionTest() {
//        File file = new File("src/resources/spring-bean.xml");
//        System.out.println(file.isFile());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(System.getProperty("java.class.path"));
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "spring-bean.xml"
//        );
//        Client client = (Client)context.getBean("client");
//        client.run();
    }

    @Test
    public void springAopTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-aop.xml"
        );
//        IAction action = (IAction) context.getBean("createOrderProxy");
//        System.out.println(action);
//        action.run();

        CreateOrder createOrder = (CreateOrder) context.getBean("createOrderProxy");
        createOrder.run();
    }
}
