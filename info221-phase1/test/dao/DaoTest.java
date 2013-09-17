/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author johnl_000
 */
public class DaoTest {

    private ProductDao dao = new ProductJdbcDao();
    private String keyboardId = "111111";
    private Product keyboard;
    private String mouseId = "222222";
    private Product mouse;

    public DaoTest() {
    }

    @BeforeClass
    public static void setUpClass() { //productID,productName,description,category,price, quantity
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        mouse = new Product(mouseId, "Mouse", "Hardware", "Hardware", 124.23, 7);
        keyboard = new Product(keyboardId, "Keyboard", "Hardware", "Hardware", 362.23, 3);
        dao.save(mouse);
        dao.save(keyboard);
    }

    @After
    public void tearDown() {
        dao.delete(mouse);
        dao.delete(keyboard);
    }

    @Test
    public void testDaoSaveAndDelete() {
        Product win = new Product("33333", "Windows 7", "Operating System", "Software", 300.00, 20);
        dao.save(win);
        Product retrieved = dao.getById("33333");
        assertEquals("Retrieved product should be the same as the saved one", win, retrieved);
        dao.delete(win);
        System.out.println(win.getName());
        assertNull("Product should no longer exist", win.getProductID());
    }

    @Test
    public void testDaoGetAll() {
        Collection<Product> products = dao.getAll();
        assertTrue("Mouse should exist in the result", products.contains(mouse));
        assertTrue("Keyboard should exist in the result", products.contains(keyboard));

        for (Product p : products) {
            if (p.equals(mouse)) {
                assertEquals(mouse.getProductID(), p.getProductID());
                assertEquals(mouse.getName(), p.getName());
                assertEquals(mouse.getDescription(), p.getDescription());
                assertEquals(mouse.getCategory(), p.getCategory());
                assertEquals(mouse.getPrice(), p.getPrice());
                assertEquals(mouse.getQuantity(), p.getQuantity());
            }
        }
    }

    @Test
    public void testDaoGetById() {
        Product products = dao.getById(mouse.getProductID());

        assertTrue("Mouse should exist in  the result", products.equals(mouse));

        assertEquals(mouse.getProductID(), products.getProductID());
        assertEquals(mouse.getName(), products.getName());
        assertEquals(mouse.getCategory(), products.getCategory());
    }
    
    @Test
    public void saveProduct(){
        this.mouse.setName("Bumper");
        dao.save(mouse);
        Product product = dao.getById(mouseId);
        assertEquals("Name should be Bumper", product.getName(),"Bumper");
        assertEquals("Name should be Bumper", mouse.getName(),"Bumper");
 
        
    }
    }
    
    
    

