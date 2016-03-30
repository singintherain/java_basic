package lvsong.club;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lvsong on 3/5/16.
 */
public class Server {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springContext.xml");
        System.out.print("wait for request...");
    }
}
