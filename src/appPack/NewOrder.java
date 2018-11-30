package appPack;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class NewOrder extends javax.swing.JFrame {
    Date d = new Date();
    SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
    
    public NewOrder() {
        initComponents();
        lblName.setText(DashBoard.name);
        lblSurname.setText(DashBoard.surname);
        lblAddress.setText(DashBoard.address);
        
    }
    public void newOrderFunc(){
        String name = lblName.getText();
        String surname = lblSurname.getText();
        String address = lblAddress.getText();
        String date = s.format(d);
        int price = Integer.parseInt(txtPrice.getText().trim());
        String sprice = txtPrice.getText().trim();
        if(sprice.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please enter price.");
            txtPrice.requestFocus();
        }else{
            try {
                DB db = new DB();
                int add = db.baglan().executeUpdate("INSERT INTO `orders` (`oid`, `oname`, `osurname`, `ostatus`, `oaddress`, `oprice`, `odate`) "
                    + "VALUES (NULL, '"+name+"', '"+surname+"', 'Preparing', '"+address+"', '"+price+"', '"+date+"');");
                if(add > 0){
                
                JOptionPane.showMessageDialog(rootPane, "New Order Added.");
                }else{
                JOptionPane.showMessageDialog(rootPane, "New Order could not be added.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Add Failed!");
            }
            DashBoard.id = "";
            dispose();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(415, 390));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("New Order");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 13, 389, 48);

        lblName.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.disabledShadow"));
        lblName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        getContentPane().add(lblName);
        lblName.setBounds(146, 74, 255, 34);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(12, 74, 116, 34);

        lblSurname.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        getContentPane().add(lblSurname);
        lblSurname.setBounds(146, 126, 255, 34);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Surname");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(12, 126, 116, 34);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Price");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(12, 241, 116, 34);

        lblAddress.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        getContentPane().add(lblAddress);
        lblAddress.setBounds(146, 189, 255, 34);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Address");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(12, 189, 116, 34);

        txtPrice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPriceKeyPressed(evt);
            }
        });
        getContentPane().add(txtPrice);
        txtPrice.setBounds(146, 241, 255, 34);

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("ADD");
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
        jButton1.setBounds(283, 307, 118, 42);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/water.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 410, 360);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        newOrderFunc();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            newOrderFunc();
        }
    }//GEN-LAST:event_txtPriceKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            newOrderFunc();
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
            java.util.logging.Logger.getLogger(NewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
