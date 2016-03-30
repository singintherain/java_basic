package lvsong.club;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lvsong on 3/5/16.
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springContext.xml");
        Calculation calculation = applicationContext.getBean("caculationProxy", Calculation.class);
        System.out.println(calculation.cube(2));
    }
}
