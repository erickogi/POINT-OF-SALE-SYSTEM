/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posa;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author kimani kogi
 */
public class changepass extends javax.swing.JFrame {


    /**
     * Creates new form changepass
     */
    public changepass() {
        initComponents();
         methods n=new methods();
   String t= n.setTitle();
   this.setTitle(t);
    String i=n.setIconImage();
    this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(i)));
        newusername.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               newpassword.requestFocus(); //To change body of generated methods, choose Tools | Templates.
            }
        });
       
         newpassword.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               //changeActionPerformed(); //To change body of generated methods, choose Tools | Templates.
                 String stru="";
        stru=newusername.getText();
        
        
        
         String strc="";
        strc=newpassword.getText();
        if (stru.isEmpty()==true)
        {
         JOptionPane.showMessageDialog(null,"Enter username");
         return;
        }
        
      
        if (strc.isEmpty()==true)
        {
         JOptionPane.showMessageDialog(null,"Enter Password");
         return;
        }
        
               try
        {
        //Connection connection;
           
 Connection connection = getConnection();
            String sql = "UPDATE adminuser SET user_password ='"+newpassword.getText()+"'  ";
            String sql1 = "UPDATE lib_user SET user_password='"+newpassword.getText()+"'WHERE id='1 ' ";
            String sql2 = "UPDATE adminuser SET user_name ='"+newusername.getText()+"'  ";
            String sql3 = "UPDATE lib_user SET user_name='"+newusername.getText()+"'WHERE id='1 ' ";
            PreparedStatement pst=connection.prepareStatement(sql);
            PreparedStatement pst1=connection.prepareStatement(sql1);
             PreparedStatement pst2=connection.prepareStatement(sql2);
            PreparedStatement pst3=connection.prepareStatement(sql3);
            pst.executeUpdate(sql);
            pst1.executeUpdate(sql1);
             pst2.executeUpdate(sql2);
            pst3.executeUpdate(sql3);
            pst.close();
           pst1.close();
           pst2.close();
           pst3.close();
           connection.close();
           
        }
               
            catch (Exception a) {
                JOptionPane.showMessageDialog(null," not successful.");
            System.err.println(a);
            //System.exit(1);
        }
    
            
              // MainClass.StrUser=TxtUserName.getText();
                JOptionPane.showMessageDialog(null,"successful.");
               //this.setVisible(false);
               
           
          
           

         }
        });
    }
public Connection getConnection()

   {

       Connection con;

       try {

           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","123ERYcog.");

           return con;

       } catch (Exception e) {

           e.printStackTrace();

           return null;

       }

   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        newusername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        newpassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        change = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 51, 255));

        jLabel1.setText("new username");

        newusername.setNextFocusableComponent(newusername);

        jLabel3.setText("new password");

        change.setText("change");
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });
        change.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                changeKeyTyped(evt);
            }
        });

        jLabel5.setText("change admin password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(change))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(129, 129, 129)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(newusername)
                                    .addComponent(newpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newusername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addComponent(newpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(change)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        // TODO add your handling code here:
         String stru="";
        stru=newusername.getText();
        
        
        
         String strc="";
        strc=newpassword.getText();
        if (stru.isEmpty()==true)
        {
         JOptionPane.showMessageDialog(null,"Enter username");
         return;
        }
        
      
        if (strc.isEmpty()==true)
        {
         JOptionPane.showMessageDialog(null,"Enter Password");
         return;
        }
        
               try
        {
        //Connection connection;
           
 Connection connection = getConnection();
            String sql = "UPDATE adminuser SET user_password ='"+newpassword.getText()+"'  ";
            String sql1 = "UPDATE lib_user SET user_password='"+newpassword.getText()+"'WHERE id='1 ' ";
            String sql2 = "UPDATE adminuser SET user_name ='"+newusername.getText()+"'  ";
            String sql3 = "UPDATE lib_user SET user_name='"+newusername.getText()+"'WHERE id='1 ' ";
            PreparedStatement pst=connection.prepareStatement(sql);
            PreparedStatement pst1=connection.prepareStatement(sql1);
             PreparedStatement pst2=connection.prepareStatement(sql2);
            PreparedStatement pst3=connection.prepareStatement(sql3);
            pst.executeUpdate(sql);
            pst1.executeUpdate(sql1);
             pst2.executeUpdate(sql2);
            pst3.executeUpdate(sql3);
            pst.close();
           pst1.close();
           pst2.close();
           pst3.close();
           connection.close();
           
        }
               
            catch (Exception a) {
                JOptionPane.showMessageDialog(null," not successful.");
            System.err.println(a);
           // System.exit(1);
        }
    
            
              // MainClass.StrUser=TxtUserName.getText();
                JOptionPane.showMessageDialog(null,"successful.");
               //this.setVisible(false);
               
           
          
           

        
        
                          
    }//GEN-LAST:event_changeActionPerformed

    private void changeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_changeKeyTyped
        // TODO add your handling code here:
//        changepassuser m=new changepassuser();
//               m.setVisible(true);
//               this.setVisible(false);
    }//GEN-LAST:event_changeKeyTyped

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
            java.util.logging.Logger.getLogger(changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changepass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton change;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField newpassword;
    private javax.swing.JTextField newusername;
    // End of variables declaration//GEN-END:variables
}
