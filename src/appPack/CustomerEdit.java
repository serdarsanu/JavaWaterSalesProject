package appPack;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class CustomerEdit extends javax.swing.JFrame {

    public CustomerEdit() {
        initComponents();
        txtName.setText(DashBoard.name);
        txtSurname.setText(DashBoard.surname);
        txtTelephone.setText(DashBoard.telephone);
        txtAddress.setText(DashBoard.address);
    }
    public void customerEditFunc(){
        String name = txtName.getText().trim();
        String surname = txtSurname.getText().trim();
        String telephone = txtTelephone.getText().trim();
        String address = txtAddress.getText().trim();
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please enter name!");
            txtName.requestFocus();
        }else if(surname.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please enter surname!");
            txtSurname.requestFocus();
        }else if(telephone.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please enter telephone!");
            txtTelephone.requestFocus();
        }else if(address.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please enter address!");
            txtAddress.requestFocus();
        }else{
            try {
            DB db = new DB();
            String query = "UPDATE `customers` SET `cname` = '"+name+"', `csurname` = '"+surname+"', "
                    + "`ctelephone` = '"+telephone+"', `caddress` = '"+address+"' "
                    + "WHERE `customers`.`cid` = '"+DashBoard.id+"'";
            int add = db.baglan().executeUpdate(query);
            if(add > 0){
                JOptionPane.showMessageDialog(rootPane, "Customer Edited.");
                dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Customer could not be edited.");
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Edited Failed : ");
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTelephone = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 570));
        setResizable(false);
        getContentPane().setLayout(null);

        txtTelephone.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtTelephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelephoneKeyPressed(evt);
            }
        });
        getContentPane().add(txtTelephone);
        txtTelephone.setBounds(12, 313, 374, 38);

        txtSurname.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtSurname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSurnameKeyPressed(evt);
            }
        });
        getContentPane().add(txtSurname);
        txtSurname.setBounds(12, 213, 374, 38);

        txtAddress.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddressKeyPressed(evt);
            }
        });
        getContentPane().add(txtAddress);
        txtAddress.setBounds(12, 413, 374, 38);

        txtName.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
        });
        getContentPane().add(txtName);
        txtName.setBounds(12, 112, 374, 38);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Address");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 369, 374, 37);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 68, 374, 37);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Surname");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(12, 168, 374, 37);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Telephone");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(12, 269, 374, 37);

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("EDIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(219, 464, 167, 52);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Customer Edit");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 0, 374, 42);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/glass1.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 400, 540);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        customerEditFunc();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            customerEditFunc();
        }
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtSurnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSurnameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            customerEditFunc();
        }
    }//GEN-LAST:event_txtSurnameKeyPressed

    private void txtTelephoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelephoneKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            customerEditFunc();
        }
    }//GEN-LAST:event_txtTelephoneKeyPressed

    private void txtAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            customerEditFunc();
        }
    }//GEN-LAST:event_txtAddressKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            customerEditFunc();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
}
