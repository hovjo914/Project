/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author John
 */
public class CustomerListDao implements CustomerDao {

    private static Map<String, Customer> customers = new TreeMap<>();

    @Override
    public void delete(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getUserName(), customer);
    }

    @Override
    public Collection<Customer> getAll() {
        return customers.values();
    }

    @Override
    public Customer getByUserName(String username, String pw) {
       return customers.get(username);

    }

  
   }

