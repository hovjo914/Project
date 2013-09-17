/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John
 */
import dao.ProductDao;
import dao.ProductJdbcDao;
import gui.MainMenu;
import java.awt.EventQueue;

public class Main {

    private static ProductDao dao = new ProductJdbcDao();

    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu(dao).setVisible(true);
            }
        });
    }
}
