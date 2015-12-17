package customer;

import customer.dao.CustomerDAO;
import customer.model.Customer;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by lvsong on 7/20/15.
 */
public class DaoTest {
//    @Test
//    public void insertTest() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
//
//        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
//
//        int count = customerDAO.count();
//
//        Customer customer = new Customer();
//        customer.setAge(20);
//        customer.setName("lvsong");
//
//        customerDAO.insert(customer);
//
//        Assert.assertEquals((count + 1), customerDAO.count());
//    }

    @Test
    public void insertWebTest() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("webapp/WEB-INF/web.xml");
        ApplicationContext context = new FileSystemXmlApplicationContext("file:src/main/webapp/WEB-INF/config/dispatch-servlet.xml");
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");

        int count = customerDAO.count();

        Customer customer = new Customer();
        customer.setAge(20);
        customer.setName("lvsong");

        customerDAO.insert(customer);

        Assert.assertEquals((count + 1), customerDAO.count());
    }
}
