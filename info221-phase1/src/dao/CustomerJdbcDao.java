/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author hovjo914
 */
public class CustomerJdbcDao implements CustomerDao {

    @Override
    public void delete(Customer customer) {
        try (
                // get connection to database
                Connection connection = JdbcConnection.getConnection();
                // create the SQL statement
                PreparedStatement stmt = connection.prepareStatement(
                "remove from customers (customername, address, creditcard,password ) values (?,?,?,?)");) {
// copy the data from the student domain object into the statement
            stmt.setString(1, customer.getUserName());
            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getCreditCard());
            stmt.setString(4, customer.getPassWord());

// execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void save(Customer customer) {

        try (
                // get connection to database
                Connection connection = JdbcConnection.getConnection();
                // create the SQL statement
                PreparedStatement stmt = connection.prepareStatement(
                "merge into customers (customername, address, creditcard, password) values (?,?,?,?)");) {
// copy the data from the student domain object into the statement
            stmt.setString(1, customer.getUserName());
            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getCreditCard());
            stmt.setString(4, customer.getPassWord());

// execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Collection<Customer> getAll() {
        try (
                Connection connection = JdbcConnection.getConnection();
                PreparedStatement stmt =
                connection.prepareStatement("select * from customers order by customername");
                ResultSet rs = stmt.executeQuery();) {

            Collection<Customer> customers = new ArrayList<>();

            while (rs.next()) {

                String customername = rs.getString("customername");
                String address = rs.getString("address");
                String password = rs.getString("password");
                String creditcard = rs.getString("creditCard");


                Customer s = new Customer(customername, address, creditcard, password);

                customers.add(s);
            }
            return customers;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public Customer getByUserName(String name, String pw) {
        Customer customers;

        try (
                Connection connection = JdbcConnection.getConnection();
                PreparedStatement stmt =
                connection.prepareStatement("select * from customers where customername = ?");) {
            stmt.setString(1, name);


            ResultSet rs = stmt.executeQuery();
            {

                customers = new Customer();

                while (rs.next()) {

                    String customername = rs.getString("customername");
                    String address = rs.getString("address");
                    String creditcard = rs.getString("creditcard");
                    String password = rs.getString("password");

                    customers = new Customer(customername, address, creditcard, password);

                }
                return customers;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Customer login(String username, String pw) {
        Customer customers = null;
        try (
                Connection connection = JdbcConnection.getConnection();
                PreparedStatement stmt =
                connection.prepareStatement("select * from customers where customername = ? and password = ?");) {
            stmt.setString(1, username);
            stmt.setString(2, pw);

            ResultSet rs = stmt.executeQuery();
            {

                while (rs.next()) {

                    String customername = rs.getString("customername");
                    String address = rs.getString("address");
                    String creditcard = rs.getString("creditcard");
                    String password = rs.getString("password");

                    customers = new Customer(customername, address, creditcard, password);
                }
                return customers;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
