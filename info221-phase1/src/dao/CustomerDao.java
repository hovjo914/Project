/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author John
 */
public interface CustomerDao {

    public void delete(Customer customer);

    public void save(Customer customer);

    Collection<Customer> getAll();

    Customer getByUserName(String username, String pw);
    
    
}
