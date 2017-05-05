/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.view; 
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.util.ArrayList; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.swing.JButton; 
import javax.swing.JComboBox; 
import javax.swing.JOptionPane; 
import javax.swing.JTable; 
import javax.swing.JTextField; 
import javax.swing.table.DefaultTableModel; 
import pack.control.c_koneksi; 
import pack.control.controllerToko; 
import pack.control.login_koneksi;
import pack.model.m_toko;
/**
 *
 * @author MALBUF
 */
public class login extends javax.swing.JFrame {
  public static String user;
    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtuname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        signup = new javax.swing.JButton();
        signIn = new javax.swing.JButton();
        exit1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtuname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtuname);
        txtuname.setBounds(60, 50, 150, 35);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 30, 90, 15);

        txtpass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtpass);
        txtpass.setBounds(60, 110, 150, 35);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 90, 90, 15);

        signup.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        signup.setText("Sign Up");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        getContentPane().add(signup);
        signup.setBounds(30, 240, 90, 30);

        signIn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        signIn.setText("Sign In");
        signIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInActionPerformed(evt);
            }
        });
        getContentPane().add(signIn);
        signIn.setBounds(30, 200, 200, 30);

        exit1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exit1.setText("Exit");
        exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit1ActionPerformed(evt);
            }
        });
        getContentPane().add(exit1);
        exit1.setBounds(140, 240, 90, 30);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 250, 170);

        setBounds(0, 0, 289, 323);
    }// </editor-fold>//GEN-END:initComponents

    private void signInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInActionPerformed
        Connection connection; 
        PreparedStatement ps; 
        try { 
            connection = DriverManager.getConnection("jdbc:mysql://localhost/toko?zeroDateTimeBehavior=convertToNull", "root", ""); 
            ps = connection.prepareStatement("SELECT * FROM `tb_akun` WHERE `username` = ? AND `password` = ?"); 
            ps.setString(1, txtuname.getText()); 
            ps.setString(2, txtpass.getText()); 
            ResultSet result =ps.executeQuery(); 
            if(result.next()){ 
                new home().show(); 
                user  = txtuname.getText();//perlu deklarasi user diclass utama. 
                this.dispose(); 
            } 
            else{ 
                JOptionPane.showMessageDialog(rootPane, "Salah!"); 
                txtpass.setText(""); 
                txtuname.requestFocus(); 
            } 
             }catch (SQLException ex){ 
            JOptionPane.showMessageDialog(rootPane,"Gagal!"); 
    }//GEN-LAST:event_signInActionPerformed
    }
    private void exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit1ActionPerformed
        dispose();
    }//GEN-LAST:event_exit1ActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        String username = txtuname.getText();
        String password = txtpass.getText();

        try{
            try(Statement statement = (Statement) login_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("insert into tb_akun(username, password) VALUES ('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null, "Selamat! Anda berhasil sign up!");
        }
        catch(Exception t){
            JOptionPane.showMessageDialog(null, "Maaf! Username atau password Anda salah.");
        }
    }//GEN-LAST:event_signupActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton signIn;
    private javax.swing.JButton signup;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}
