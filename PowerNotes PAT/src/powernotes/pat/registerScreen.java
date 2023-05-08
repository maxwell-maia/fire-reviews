/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powernotes.pat;

import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author maim20
 */
public class registerScreen extends javax.swing.JFrame {
    
    /**
     * Creates new form registerScreen
     */
    public registerScreen() {
        initComponents();
    }
    
    //variables for information to registering user
    private String username, password, outputMessage;
    private boolean allValid; //boolean for validation.
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbgGender = new javax.swing.ButtonGroup();
        jSpinner1 = new javax.swing.JSpinner();
        lblRegister = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        psfPassword = new javax.swing.JPasswordField();
        txfUsername = new javax.swing.JTextField();
        lblPasswordError = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        lblHelp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(42, 161, 255));
        setMinimumSize(new java.awt.Dimension(608, 440));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegister.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        lblRegister.setText("Register a new account");
        getContentPane().add(lblRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 380, 69));

        btnRegister.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 200, 68));

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsername.setText("Username: ");
        getContentPane().add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 90, -1));

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPassword.setText("Password: ");
        getContentPane().add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 90, -1));
        getContentPane().add(psfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 243, -1));
        getContentPane().add(txfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 243, -1));

        lblPasswordError.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lblPasswordError, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 240, 24));

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogin.setText("Return to Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 150, 68));

        btnHelp.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        btnHelp.setText("?");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        getContentPane().add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 48, 48));

        lblHelp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHelp.setText("Help");
        getContentPane().add(lblHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 34, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        allValid = true; //initially true
        outputMessage = "";
        
        //Check that the length of the password is between 5 and 32 characters
        if(!psfPassword.getText().isEmpty())
        {
            lblPasswordError.setText("");
            
            if(psfPassword.getText().length() >= 5 && psfPassword.getText().length() <= 32)
            {
                password = psfPassword.getText();
                psfPassword.setBorder(new LineBorder(Color.gray,1));
                lblPasswordError.setText("");
            }
            else //password is too long or too short
            {
                lblPasswordError.setText("Password is too long or too short.");
                outputMessage += "\n\nError: Password is too long or too short.\nPlease enter a password with 5-32 characters.";
                allValid = false;
                psfPassword.setBorder(new LineBorder(Color.red,1)); //colour the border of the password field to red to show user where they inputted invalid data
            }
        }
        else //no password was entered
        {
            lblPasswordError.setText("Please enter a password.");
            outputMessage += "\n\nError: No password inputted.";
            allValid = false;
            psfPassword.setBorder(new LineBorder(Color.red,1)); //colour the border of the password field to red to show user where they inputted invalid data
        }
        
        //if the validation was successful
        if(allValid)
        {
            //collect data
            String u = txfUsername.getText();
            String p = psfPassword.getText();
            
            //Send variables to SQLSTatments class to add user to database
            SQLSTatements sq = new SQLSTatements();
            sq.ReadToLogin(u, p);
            this.dispose(); //close this screen
            new loginScreen().setVisible(true); //open the login screen
        }
        
       
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        this.dispose(); //close this screen
        new loginScreen().setVisible(true); //and open login screen
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        //Create help box (using message number 2)
        Help h = new Help(2);
    }//GEN-LAST:event_btnHelpActionPerformed

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
            java.util.logging.Logger.getLogger(registerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registerScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblHelp;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordError;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField psfPassword;
    private javax.swing.ButtonGroup rbgGender;
    private javax.swing.JTextField txfUsername;
    // End of variables declaration//GEN-END:variables
}
