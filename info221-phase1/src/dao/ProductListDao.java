/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author John
 */
public class ProductListDao implements ProductDao {

    private static Map<String, Product> products = new TreeMap<>();
    private static Collection<String> categories = new HashSet<>();

    @Override
    public void delete(Product product) {
        products.remove(product);
    }

    @Override
    public void save(Product product) {
        products.put(product.getProductID(), product);
        categories.add(product.getCategory());
    }
    
    @Override
    public Collection<Product> getAll() {
        return products.values();
    }

    @Override
    public Collection<String> getCategories() {
        return categories;
    }

    @Override
    public Product getById(String id) {
        return products.get(id);
    }

    @Override
    public Collection<Product> getByCategory(String category) {
        return products.values();
    }
}