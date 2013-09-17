package dao;

import domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ProductJdbcDao implements ProductDao {

    @Override
    public void save(Product product) {
        try (
                // get connection to database
                Connection connection = JdbcConnection.getConnection();
                // create the SQL statement
                PreparedStatement stmt = connection.prepareStatement(
                "merge into products (productid, productname, description, category, price, quantity) values (?,?,?,?,?,?)");) {
// copy the data from the student domain object into the statement
            stmt.setString(1, product.getProductID());
            stmt.setString(2, product.getName());
            stmt.setString(3, product.getDescription());
            stmt.setString(4, product.getCategory());
            stmt.setDouble(5, product.getPrice());
            stmt.setInt(6, product.getQuantity());
// execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Collection<Product> getAll() {
        try (
                Connection connection = JdbcConnection.getConnection();
                PreparedStatement stmt =
                connection.prepareStatement("select * from products order by productID");
                ResultSet rs = stmt.executeQuery();) {

            Collection<Product> products = new ArrayList<>();

            while (rs.next()) {

                String productId = rs.getString("productid");
                String name = rs.getString("productname");
                String description = rs.getString("description");
                String category = rs.getString("category");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");

                Product s = new Product(productId, name, description, category, price, quantity);

                products.add(s);
            }
            return products;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public Collection<String> getCategories() {
        try (
                Connection connection = JdbcConnection.getConnection();
                PreparedStatement stmt =
                connection.prepareStatement("select distinct Category from products order by Category");
                ResultSet rs = stmt.executeQuery();) {

            Collection<String> categories = new ArrayList<>();

            while (rs.next()) {

                String category = rs.getString("category");
                //String s = new String(category);

                categories.add(category);
            }
            return categories;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


    }

    @Override
    public Product getById(String id) {
        Product products;

        try (
                Connection connection = JdbcConnection.getConnection();
                PreparedStatement stmt =
                connection.prepareStatement("select * from products where productId = ?");) { // I felt like I was really close..
            stmt.setString(1, id);

            ResultSet rs;
            rs = stmt.executeQuery();
            {

                products = new Product();

                while (rs.next()) {

                    String productId = rs.getString("productid");
                    String productname = rs.getString("productname");
                    String description = rs.getString("description");
                    String category = rs.getString("category");
                    Double price = rs.getDouble("price");
                    Integer quantity = rs.getInt("quantity");

                    products = new Product(productId, productname, description, category, price, quantity);

                }
                return products;

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Product product) {

        try (
                // get connection to database
                Connection connection = JdbcConnection.getConnection();
                // create the SQL statement
                PreparedStatement stmt = connection.prepareStatement("delete from products where productid=?");) {
// copy the data from the student domain object into the statement
            stmt.setString(1, product.getProductID());
            stmt.executeUpdate();

            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    @SuppressWarnings("empty-statement")
    public Collection<Product> getByCategory(String categories) {

        try (
                Connection connection = JdbcConnection.getConnection();
                PreparedStatement stmt =
                connection.prepareStatement("select * from products where Category =?");) { // I felt like I was really close..
            stmt.setString(1, categories);

            ResultSet rs;
            rs = stmt.executeQuery();
            {

                Collection<Product> products = new ArrayList<>();;

                while (rs.next()) {

                    String productId = rs.getString("productid");
                    String productname = rs.getString("productname");
                    String description = rs.getString("description");
                    String category = rs.getString("category");
                    Double price = rs.getDouble("price");
                    Integer quantity = rs.getInt("quantity");


                    Product s = new Product(productId, productname, description, category, price, quantity);


                    products.add(s);
                }
                return products;

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}