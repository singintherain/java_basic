import com.lvsong.customer.dao.CustomerDAO;
import com.lvsong.customer.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.activation.DataSource;
import javax.xml.crypto.Data;

/**
 * Created by lvsong on 7/20/15.
 */
public class CustomerDAOTest {
    CustomerDAO customerDAO;

    @Before
    public void init() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WEB-INF/web.xml");
//        DataSource ds = applicationContext.getId();
        customerDAO = (CustomerDAO) applicationContext.getBean("customerDao");
        customerDAO.findByCustomerId(2);
    }

    @Test
    public void insert() {
        Customer customer = new Customer();
        customer.setName("lvsong");
        customer.setAge(20);
        customerDAO.insert(customer);
    }
}
