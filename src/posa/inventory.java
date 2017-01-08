/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posa;

import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

/**
 *
 * @author kimani kogi
 */
public class inventory extends javax.swing.JFrame {
DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form inventory
     */
    public inventory() {

        //initComponents();
        //Show_Users_In_JTable();

       this.jTable = new JTable(model);
        this.jtFilter= new JTextField();
         final TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(jTable.getModel());
       jTable.setRowSorter(rowSorter);
          jtFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
           @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
            initComponents();
             methods n=new methods();
   String t= n.setTitle();
   this.setTitle(t);
    String i=n.setIconImage();
    this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(i)));
            findUsers();
    try {
        sum();
    } catch (Exception ex) {
        Logger.getLogger(inventory.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
//    public void print () {
//		Connection connection = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root", "123ERYcog.");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return;
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			return;
//		}
//
//		JasperReportBuilder report = DynamicReports.report();//a new report
//		report
//		  .columns(
//		  	Columns.column(" Id", "id", DataTypes.integerType())
//		  		.setHorizontalAlignment(HorizontalAlignment.LEFT),
//		  	Columns.column("product Name", "fname", DataTypes.stringType()),
//		  	Columns.column("Quantity Name", "lname", DataTypes.stringType()),
//		  	Columns.column("Price", "age", DataTypes.stringType())
//		  		.setHorizontalAlignment(HorizontalAlignment.LEFT)
//		  	)
//		  .title(//title of the report
//		  	Components.text("INVENTORY  REPORT")
//		  		.setHorizontalAlignment(HorizontalAlignment.CENTER))
//		  .pageFooter(Components.pageXofY())//show page number on the page footer
//		  .setDataSource("SELECT id, fname, lname, bp,age FROM users", connection);
//
//		try {
//			report.show();//show the report
//			report.toPdf(new FileOutputStream("C:\\Users\\kimani kogi\\OneDrive\\Pictures\report.pdf"));//export the report to a pdf file
//		} catch (DRException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
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
  public  void sum() throws Exception {
    double sum = 0;
    double sum1 = 0;
    double diff = 0;
    //Class.forName("com.mysql.jdbc.Driver");
    //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
       // "root", "123ERYcog.");
     Connection connection = getConnection();
    Statement st = connection.createStatement();
    Statement st1 = connection.createStatement();
    ResultSet res = st.executeQuery("SELECT SUM(age*lname) FROM users");
    ResultSet res1 = st1.executeQuery("SELECT SUM(bp*lname) FROM users");
    while (res.next()&&res1.next()) {
      double c = res.getDouble(1);
      double c1 = res1.getDouble(1);
      sum1=c1;
      sum = c;
diff=c-c1;
    }
                  
    onpurchase.setText(Double.toString(sum1));
   aftersale.setText(Double.toString(sum));
   profit.setText(Double.toString(diff));
   
    st.close();
                st1.close();
              res.close();
              res1.close();
               connection.close();
  }
     public ArrayList<User_1> ListUsers(String ValToSearch)
    {
        ArrayList<User_1> usersList = new ArrayList<User_1>();

        Statement st;
        ResultSet rs;

        try{
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `users` WHERE CONCAT(`id`, `fname`, `lname`, `age`) LIKE '%"+ValToSearch+"%'";
            rs = st.executeQuery(searchQuery);

            User_1 user;

            while(rs.next())
            {
                user = new User_1(
                                 rs.getInt("id"),
                                 rs.getString("fname"),
                                 rs.getString("lname"),
                                 rs.getString("age"),
                        rs.getString("bp"),
                        rs.getString("from")
                                );
                usersList.add(user);
            }
              st.close();
              rs.close();
            
               con.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return usersList;
    }
       public void findUsers()
    {

        ArrayList<User_1> users = ListUsers(jtFilter.getText());
        DefaultTableModel model = new DefaultTableModel();


        model.setColumnIdentifiers(new Object[]{"ID","name","quantity","sell price","buy price","from"});
        Object[] row = new Object[6];

     for(int i = 0; i < users.size(); i++)
        {
            row[0] = users.get(i).getId();
            row[1] = users.get(i).getFname();
            row[2] = users.get(i).getLname();
            row[3] = users.get(i).getAge();
            row[4] = users.get(i).getBp();
            row[5]=users.get(i).getFrom();
            
            model.addRow(row);
        }
       jTable.setModel(model);

    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jtFilter = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        onpurchase = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        aftersale = new javax.swing.JTextField();
        profit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 255));
        jPanel1.setFocusable(false);
        jPanel1.setNextFocusableComponent(jtFilter);

        jTable.setBackground(new java.awt.Color(51, 204, 255));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name", "quantity", "price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setRowHeight(40);
        jScrollPane1.setViewportView(jTable);

        jtFilter.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jtFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtFilterActionPerformed(evt);
            }
        });
        jtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtFilterKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("inventory records");

        jLabel2.setText("worth on purchase");

        jLabel3.setText("after sale worth");

        jLabel4.setText("expected earnings");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(profit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(onpurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(aftersale, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(371, 371, 371)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(94, 94, 94))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(profit)
                                    .addComponent(onpurchase)
                                    .addComponent(aftersale)))
                            .addComponent(jtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFilterKeyReleased
        // TODO add your handling code here:
        findUsers();
    }//GEN-LAST:event_jtFilterKeyReleased

    private void jtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtFilterActionPerformed

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
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aftersale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jtFilter;
    private javax.swing.JTextField onpurchase;
    private javax.swing.JTextField profit;
    // End of variables declaration//GEN-END:variables
}
