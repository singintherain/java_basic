package customer.dao;

import customer.model.Customer;

/**
 * Created by lvsong on 7/20/15.
 */
public interface CustomerDAO {
    public void insert(Customer customer);
    public int count();
}
