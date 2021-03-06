/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ProductDao;

/**
 *
 * @author John
 */
public class MainMenu extends javax.swing.JFrame {

    private static ProductDao dao;

    /**
     * Creates new form MainMenu
     */
    public MainMenu(ProductDao dao) {
        this.dao = dao;
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(true);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      btnNewProduct = new javax.swing.JButton();
      btnViewProduct = new javax.swing.JButton();
      btnExit = new javax.swing.JButton();
      jLabel1 = new javax.swing.JLabel();
      btnNewProduct1 = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      btnNewProduct.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
      btnNewProduct.setForeground(new java.awt.Color(0, 102, 102));
      btnNewProduct.setText("Add a New Customer");
      btnNewProduct.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnNewProductActionPerformed(evt);
         }
      });

      btnViewProduct.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
      btnViewProduct.setForeground(new java.awt.Color(0, 102, 102));
      btnViewProduct.setText("View Products");
      btnViewProduct.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnViewProductActionPerformed(evt);
         }
      });

      btnExit.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
      btnExit.setForeground(new java.awt.Color(0, 102, 102));
      btnExit.setText("Exit");
      btnExit.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnExitActionPerformed(evt);
         }
      });

      jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(0, 102, 102));
      jLabel1.setText("    Product Administration");

      btnNewProduct1.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
      btnNewProduct1.setForeground(new java.awt.Color(0, 102, 102));
      btnNewProduct1.setText("Add a New Product");
      btnNewProduct1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnNewProduct1ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
               .addComponent(btnExit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(btnViewProduct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(btnNewProduct1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btnNewProduct))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnNewProduct1)
               .addComponent(btnNewProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnViewProduct)
            .addGap(1, 1, 1)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void btnNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProductActionPerformed
        ProductEditorDialog frame = new ProductEditorDialog(this, true, dao);
        frame.setLocationRelativeTo(this);
        frame.setVisible(true);

    }//GEN-LAST:event_btnNewProductActionPerformed

    private void btnViewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProductActionPerformed
        ViewProductsDialog frame = new ViewProductsDialog(this, true, dao);
        frame.setLocationRelativeTo(this);
        frame.setVisible(true);

    }//GEN-LAST:event_btnViewProductActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

   private void btnNewProduct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProduct1ActionPerformed
       // TODO add your handling code here:
   }//GEN-LAST:event_btnNewProduct1ActionPerformed
    /**
     * @param args the command line arguments
     */
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnExit;
   private javax.swing.JButton btnNewProduct;
   private javax.swing.JButton btnNewProduct1;
   private javax.swing.JButton btnViewProduct;
   private javax.swing.JLabel jLabel1;
   // End of variables declaration//GEN-END:variables
}
