/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;

/**
 *
 * @author John
 */
public interface ProductDao {

    public void save(Product product);

    public void delete(Product product);

    Collection<Product> getByCategory(String category);

    Collection<Product> getAll();

    Collection<String> getCategories();

    Product getById(String id);
}
