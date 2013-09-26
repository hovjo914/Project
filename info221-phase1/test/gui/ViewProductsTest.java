/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ProductDao;
import domain.Product;
import gui.helpers.ProductListModel;
import java.util.Collection;
import java.util.TreeSet;
import static org.fest.swing.core.matcher.DialogMatcher.withTitle;
import static org.fest.swing.core.matcher.JButtonMatcher.withText;
import org.fest.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;

/**
 *
 * @author johnl_000
 */
public class ViewProductsTest {

    private Collection<Product> products;
    private Product monitor;
    private Product keyboard;
    private ProductDao dao;
    private ViewProductsDialog dialog;
    private DialogFixture fest;

    public ViewProductsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // create some students for testing with
        monitor = new Product("Mon232", "Monitor", "LG1250", "Peripheal", 450.00, 10);
        keyboard = new Product("Har352", "Keyboard", "MS450", "Peripheal", 150.00, 6);
// add the students to collection for testing with
        products = new TreeSet<>();
        products.add(monitor);
        products.add(keyboard);
// create a mock for the DAO
        dao = mock(ProductDao.class);
// stub the getAll method to return the test students collection
        when(dao.getAll()).thenReturn(products);
// stub the getById method to return the appropriate test student based on the passed ID
        when(dao.getById("Mon232")).thenReturn(monitor);
        when(dao.getById("Har352")).thenReturn(keyboard);
// create dialog passing mocked DAO
        dialog = new ViewProductsDialog(null, true, dao);
    }

    @After
    public void tearDown() {
        if (fest != null) {
            fest.cleanUp();
        }
    }

    @Test
    public void testReportView() {
// use FEST to control the dialog
        fest = new DialogFixture(dialog);
        fest.show();
// Slow down the FEST Robot a bit - default is 30 millis
        fest.robot.settings().delayBetweenEvents(75);
//ensure getAll was called
        verify(dao).getAll();
//get the JList's model
        ProductListModel model = (ProductListModel) fest.list().component().getModel();
// check that the model actually contains the students
        assertTrue("Ensure list contains Monitor", model.contains(monitor));
        assertTrue("Ensure list contains Keyboard", model.contains(keyboard));
        assertTrue("Ensure list contains the correct number of students", model.getSize() == products.size());

    }

    @Test
    public void testReportDelete() {
// use FEST to control the dialog
        fest = new DialogFixture(dialog);
        fest.show();
// slow down the FEST robot a bit default is 30 millis
        fest.robot.settings().delayBetweenEvents(75);
// select Jill in the list
        fest.list().selectItem(monitor.toString());
// click the delete button
        fest.button("btnDelete").click();
// ensure a confirmation dialog is displayed
        DialogFixture confirmDialog;
        confirmDialog = fest.dialog(withTitle("Select an Option").andShowing()).requireVisible();
// click the No button on the confirmation dialog
        confirmDialog.button(withText("No")).click();
// verify that the delete method did NOT get called on the mock DAO
        verify(dao, never()).delete(null);
// select Jill again
        fest.list().selectItem(monitor.toString());
// click the delete button again
        fest.button("btnDelete").click();
// ensure a confirmation dialog is displayed again
        confirmDialog = fest.dialog(withTitle("Select an Option")
                .andShowing()).requireVisible();
// click the Yes button on the confirmation dialog
        confirmDialog.button(withText("Yes")).click();
// create a Mockito argument captor to use to retrieve the passed student from the mocked DAO
        ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);
// verify that the DAO.save method was called, and capture the passed student
        verify(dao).delete(argument.capture());
// retrieve the passed student from the captor
        Product deletedStudent = argument.getValue();
// ensure that the correct student was deleted
        assertEquals("Deleted student should be Monitor", monitor, deletedStudent);



//       public void testReportDelete() {
//// use FEST to control the dialog
//      fest = new DialogFixture(dialog);
//      fest.show();
//// slow down the FEST robot a bit default is 30 millis
//      fest.robot.settings().delayBetweenEvents(75);
//// select Jill in the list
//      fest.list().selectItem(jill.toString());
//// click the delete button
//      fest.button("btnDelete").click();
//// ensure a confirmation dialog is displayed
//      DialogFixture confirmDialog;
//      confirmDialog = fest.dialog(withTitle("Select an Option").andShowing()).requireVisible();
//// click the No button on the confirmation dialog
//      confirmDialog.button(withText("No")).click();
//// verify that the delete method did NOT get called on the mock DAO
//      verify(dao, never()).delete(null);
//// select Jill again
//      fest.list().selectItem(jill.toString());
//// click the delete button again
//      fest.button("btnDelete").click();
//// ensure a confirmation dialog is displayed again
//      confirmDialog = fest.dialog(withTitle("Select an Option")
//              .andShowing()).requireVisible();
//// click the Yes button on the confirmation dialog
//      confirmDialog.button(withText("Yes")).click();
//// create a Mockito argument captor to use to retrieve the passed student from the mocked DAO
//      ArgumentCaptor<Student> argument = ArgumentCaptor.forClass(Student.class);
//// verify that the DAO.save method was called, and capture the passed student
//      verify(dao).delete(argument.capture());
//// retrieve the passed student from the captor
//      Student deletedStudent = argument.getValue();
//// ensure that the correct student was deleted
//      assertEquals("Deleted student should be Jill", jill, deletedStudent);
//
//   }



    }

    @Test
    public void testReportSearch() {
// use FEST to control the dialog
        fest = new DialogFixture(dialog);
        fest.show();
// slow down the FEST robot a bitdefault is 30 millis
        fest.robot.settings().delayBetweenEvents(75);
// TODO: enter Jack’s ID into the search box
        fest.textBox("txtSearch").selectAll().enterText(String.valueOf(keyboard.getProductID()));
// TODO: click the search button
        fest.button("btnSearch").click();
// ensure that getById was called and was passed Jack’s ID
        verify(dao).getById(keyboard.getProductID());
// TODO: get the JList’s model 
        ProductListModel model = (ProductListModel) fest.list().component().getModel();
        // ensure that the list is displaying ONLY Jack
        assertTrue("Student selected should have been Keyboard", model.contains(keyboard));
        assertFalse("Student selected should not have been Monitor", model.contains(monitor));
    }

    @Test
    public void testReportEdit() {
// use FEST to control the dialog
        fest = new DialogFixture(dialog);
        fest.show();
// slow down the FEST robot a bit default is 30 millis
        fest.robot.settings().delayBetweenEvents(75);
// TODO: select Jill in the list
        fest.list().selectItem(monitor.toString());
// TODO: click the edit button
        fest.button("btnEdit").click();
// ensure that the StudentDialog appears

        DialogFixture editDialog = fest.dialog("ProductEditorDialog").requireVisible();

// TODO: ensure the StudentDialog contains the correct student
//      assertEquals("Student selected should have been Jill", editDialog.robot.equals(jill)  ,jill  );
// (make sure the ID text field has Jill’s ID in it)
        editDialog.textBox("txtID").requireText(monitor.getProductID().toString());
    }
}
