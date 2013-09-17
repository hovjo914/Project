/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ProductDao;
import domain.Product;
import java.util.Collection;
import java.util.TreeSet;
import org.fest.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.fest.swing.core.matcher.JButtonMatcher.withText;
import static org.fest.swing.core.matcher.DialogMatcher.withTitle;
import org.mockito.ArgumentCaptor;

/**
 *
 * @author johnl_000
 */
public class ProductsEditorTest {

    private ProductDao dao;
    private DialogFixture fest;

    public ProductsEditorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Collection<String> categories = new TreeSet<>();
        categories.add("Software");
        categories.add("Hardware");
        dao = mock(ProductDao.class);
        when(dao.getCategories()).thenReturn(categories);

    }

    @After
    public void tearDown() {
        fest.cleanUp();
    }

    @Test
    public void testSave() {
// create the dialog passing in the mocked DAO
        ProductEditorDialog dialog = new ProductEditorDialog(null, true, dao);
// use FEST to control the dialog
        fest = new DialogFixture(dialog);
        fest.show();
// slow down the FEST robot a bitdefault is 30 millis
        fest.robot.settings().delayBetweenEvents(75);
// TODO: enter some details into the UI components (use enterText and selectItem)
        fest.textBox("txtID").selectAll().enterText("MP124");
        fest.textBox("txtName").selectAll().enterText("MousePad");
        fest.comboBox("cmbCategory").enterText("Peripheal");
        fest.textBox("txtPrice").selectAll().enterText("1234.23");
        fest.textBox("txtQuantity").selectAll().enterText("3");

        // TODO: click the save button
        fest.button("btnSave").click();
// slow down the FEST robot a bit
        fest.robot.settings().delayBetweenEvents(75);
// create a Mockito argument captor to use to retrieve the passed student from the mocked DAO
        ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);
// TODO: verify that the DAO save method was called, and capture the passed student

        verify(dao).save(argument.capture());
// TODO: retrieve the passed student from the captor
        Product saved = argument.getValue();
// TODO: ensure that the student’s ID, name, and major were properly saved
        assertEquals("Student's Name was Properly Saved", "MousePad", saved.getName());
        assertEquals("Student's Id was Properly Saved", "MP124", saved.getProductID());
    }

    @Test
    public void testEdit() {
        Product monitor = new Product("Mon232", "Monitor", "LG1250", "Peripheal", 450.00, 10);
        ProductEditorDialog dialog = new ProductEditorDialog(null, true, monitor, dao);
        fest = new DialogFixture(dialog);
        fest.show();
        fest.robot.settings().delayBetweenEvents(75);


        fest.textBox("txtName").requireText("Monitor");
        fest.textBox("txtID").requireText("Mon232");
        fest.comboBox("cmbCategory").requireSelection("Peripheal");

        fest.textBox("txtName").selectAll().enterText("DressShirt");
        fest.comboBox("cmbCategory").selectItem("Hardware");
        fest.button("btnSave").click();

        ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);
        verify(dao).save(argument.capture());

        Product edited = argument.getValue();

        assertEquals("Ensure the name was Changed", "DressShirt", edited.getName());
        assertEquals("Ensure the category was Changed", "Hardware", edited.getCategory());

    }
}