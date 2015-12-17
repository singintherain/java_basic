package com.lvsong;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lvsong on 7/23/15.
 */
public class CarFactoryTest {
    @Test
    public void createTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CarFactory carFactory = (CarFactory) context.getBean("carFactory");

        System.out.println(carFactory);
        carFactory.getCar().run();
        System.out.println(carFactory.getCar());
        System.out.println(carFactory.getCar());

        CarFactory carFactory2 = (CarFactory) context.getBean("carFactory");

        System.out.println(carFactory2);
        carFactory2.getCar().run();
        System.out.println(carFactory2.getCar());
        System.out.println(carFactory2.getCar());
    }
}
