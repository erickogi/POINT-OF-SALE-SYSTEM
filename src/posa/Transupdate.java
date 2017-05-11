package posa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Transupdate extends javax.swing.JFrame {
   DefaultTableModel model = new DefaultTableModel();
   methods method=new methods();
   public Color setTilteImage(){
        Color c=null;
        try {
            
            String t= method.setTitle();
            this.setTitle(t);
           // String i=n.setIconImage();
           // this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(i)));
            
            String col=method.selectcolor();
             c=new Color(Integer.parseInt(col));
           // jPanel1.setBackground(c);
            Container cont=this.getContentPane();
            cont.getWidth();
            cont.setBackground(c);
                        
            jPanel1.setBackground(c);
            
            
            
            
            this.setForeground(c);
        } catch (Exception ex) {
            Logger.getLogger(sellform.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
}
    public Transupdate() {
 
       this.table = new JTable(model);
        this.jtFilter= new JTextField();
         final TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
       table.setRowSorter(rowSorter);
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
            setTilteImage();
             methods n=new methods();
   
    String i=n.setIconImage();
    this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(i)));
            findUsers();
        }
    public ArrayList<User_2> getUsersList1()

   {

       ArrayList<User_2> usersList1 = new ArrayList<User_2>();

       Connection connection = getConnection();



       String query1 = "SELECT * FROM trans WHERE DATE(updated_at) = DATE(NOW())";
       //WHERE WEEK(date)=WEEK(CURDATE()) AND YEAR(date)=YEAR(CURDATE())

       Statement st1;


       ResultSet rs1;



       try {
           st1 = connection.createStatement();

           rs1 = st1.executeQuery(query1);

           User_2 user;

           while(rs1.next())

           {

               user = new User_2(rs1.getInt("id"),rs1.getString("fname"),rs1.getString("lname"),rs1.getString("age"),rs1.getString("updated_at"),rs1.getString("servedby"));

               usersList1.add(user);

           }
rs1.close();
st1.close();
connection.close();
       } catch (Exception e) {
       }

       return usersList1;

   }
      public void Show_Users_In_JTable1()

   {

       ArrayList<User_2> list1 = getUsersList1();

       DefaultTableModel model = (DefaultTableModel)table.getModel();
model.setColumnIdentifiers(new Object[]{"updated_at","name","quantity","price","id","served by"});
       Object[] row = new Object[6];

       for(int i = 0; i < list1.size(); i++)

       {

           row[0] = list1.get(i).getUpdated_at();

           row[1] = list1.get(i).getFname();

           row[2] = list1.get(i).getLname();

           row[3] = list1.get(i).getAge();
           row[4] = list1.get(i).getId();
           
           row[5] =list1.get(i).getServedby();



           model.addRow(row);

       }

    }
         public ArrayList<User_2> getUsersList2()

   {

       ArrayList<User_2> usersList2 = new ArrayList<User_2>();

       Connection connection = getConnection();



       String query2 = "SELECT * FROM trans WHERE WEEK(updated_at)=WEEK(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())";
       //WHERE WEEK(date)=WEEK(CURDATE()) AND YEAR(date)=YEAR(CURDATE())

       Statement st2;


       ResultSet rs2;



       try {
           st2 = connection.createStatement();

           rs2 = st2.executeQuery(query2);

           User_2 user;

           while(rs2.next())

           {

               user = new User_2(rs2.getInt("id"),rs2.getString("fname"),rs2.getString("lname"),rs2.getString("age"),rs2.getString("updated_at"),rs2.getString("servedby"));

               usersList2.add(user);

           }
st2.close();
rs2.close();
connection.close();
       } catch (Exception e) {
       }

       return usersList2;

   }
          public void Show_Users_In_JTable2()

   {

       ArrayList<User_2> list2 = getUsersList2();

       DefaultTableModel model = (DefaultTableModel)table.getModel();
model.setColumnIdentifiers(new Object[]{"updated_at","name","quantity","price","id","served by"});
       Object[] row = new Object[6];

       for(int i = 0; i < list2.size(); i++)

       {

           row[0] = list2.get(i).getUpdated_at();

           row[1] = list2.get(i).getFname();

           row[2] = list2.get(i).getLname();

           row[3] = list2.get(i).getAge();
           row[4] = list2.get(i).getId();

           row[5] =list2.get(i).getServedby();

           model.addRow(row);

       }

    }
  public Connection getConnection()
    {
        Connection con = null;


        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","123ERYcog.");

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return con;
    }
    public ArrayList<User_2> ListUsers(String ValToSearch)
    {
        ArrayList<User_2> usersList = new ArrayList<User_2>();

        Statement st;
        ResultSet rs;

        try{
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `trans` WHERE CONCAT(`id`, `fname`, `lname`, `age`,`updated_at`) LIKE '%"+ValToSearch+"%'";
            rs = st.executeQuery(searchQuery);

            User_2 user;

            while(rs.next())
            {
                user = new User_2(
                                 rs.getInt("id"),
                                 rs.getString("fname"),
                                 rs.getString("lname"),
                                 rs.getString("age"),
                        rs.getString ("updated_at"),rs.getString("servedby")
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

        ArrayList<User_2> users = ListUsers(jtFilter.getText());
        DefaultTableModel model = new DefaultTableModel();


        model.setColumnIdentifiers(new Object[]{"updated_at","name","quantity","price","id","served by"});
        Object[] row = new Object[6];

     for(int i = 0; i < users.size(); i++)
        {
             row[0] = users.get(i).getUpdated_at();

           row[1] = users.get(i).getFname();

           row[2] = users.get(i).getLname();

           row[3] = users.get(i).getAge();
           
           row[4] = users.get(i).getId();
           
           row[5]=users.get(1).getServedby();
           
           // row[1] = users.get(i).getFname();
           // row[2] = users.get(i).getLname();
            //row[3] = users.get(i).getAge();
            //row[3] = users.get(i).getUpdated_at();
            model.addRow(row);
        }
       table.setModel(model);

    }
      public void executeSQlQueryq(String queryq, String messageq)

   {

       Connection con = getConnection();

       Statement st;

       try{

           st = con.createStatement();

           if((st.executeUpdate(queryq)) == 1)

           {

               // refresh jtable data

               DefaultTableModel model = (DefaultTableModel)table.getModel();

               model.setRowCount(0);

               findUsers();



               //JOptionPane.showMessageDialog(null, "Data "+messageq+" Succefully");

           }else{

               //JOptionPane.showMessageDialog(null, "Data Not "+messageq);

           }
st.close();
con.close();
       }catch(Exception ex){

           ex.printStackTrace();

       }

   }
 public void executeSQlQuery(String query, String message)

   {

       Connection con = getConnection();

       Statement st;

       try{

           st = con.createStatement();

           if((st.executeUpdate(query)) == 1)

           {

               // refresh jtable data

               DefaultTableModel model = (DefaultTableModel)table.getModel();

               model.setRowCount(0);

               findUsers();



               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");

           }else{

               JOptionPane.showMessageDialog(null, "Data Not "+message);

           }
st.close();
con.close();
       }catch(Exception ex){

           ex.printStackTrace();

       }

   }
  public void executeSQlQuery1(String query1, String message1)

   {

       Connection con = getConnection();

       Statement st;

       try{

           st = con.createStatement();

           if((st.executeUpdate(query1)) == 1)

           {

               // refresh jtable data

               DefaultTableModel model = (DefaultTableModel)table.getModel();

               model.setRowCount(0);

               findUsers();



               JOptionPane.showMessageDialog(null, "Data "+message1+" Succefully");

           }else{

               JOptionPane.showMessageDialog(null, "Data Not "+message1);

           }
st.close();
con.close();
       }catch(Exception ex){

           ex.printStackTrace();

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtFilter = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        productnamelbl = new javax.swing.JLabel();
        productidlbl = new javax.swing.JLabel();
        quantitylbl = new javax.swing.JLabel();
        pricelbl = new javax.swing.JLabel();
        addtocartbtn = new javax.swing.JButton();
        resetbtn = new javax.swing.JButton();
        price = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        quantity = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        productname = new javax.swing.JTextField();
        productid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 204, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1350, 812));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSACTIONS");

        jtFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtFilterActionPerformed(evt);
            }
        });
        jtFilter.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jtFilterCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jtFilterInputMethodTextChanged(evt);
            }
        });
        jtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtFilterKeyReleased(evt);
            }
        });

        table.setBackground(new java.awt.Color(51, 153, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4","Title 5"
            }
        ));
        table.setRowHeight(40);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel2.setText("ENTER PRODUCT NAME,ID ");

        productnamelbl.setText("PRODUCT NAME");

        productidlbl.setText("DATE");

        quantitylbl.setText("QUANTITY");

        pricelbl.setText("PRICE");

        addtocartbtn.setText("DELETE");
        addtocartbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtocartbtnActionPerformed(evt);
            }
        });

        resetbtn.setText("UPDATE");
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });

        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("TODAY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("THIS WEEK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("CALCULATOR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });

        jButton5.setText("REVERT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posa/New Folder/booked1.png"))); // NOI18N
        jButton6.setText("delete all");
        jButton6.setToolTipText("deleting all transactions is a non-reversible action");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(386, 386, 386))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4))
                                    .addComponent(pricelbl)
                                    .addComponent(price, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(productnamelbl)
                                    .addComponent(productname, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3))
                                    .addComponent(productidlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantitylbl)
                                    .addComponent(productid)
                                    .addComponent(quantity))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addtocartbtn)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productnamelbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productname, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(productidlbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productid, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(quantitylbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pricelbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton4))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addtocartbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(238, 238, 238))
                    .addComponent(jScrollPane1)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //totalpurchase.setText("0");
        productname.setText(null);
        productid.setText(null);
        quantity.setText(null);
id.setText(null);
         price.setText(null);
       // totalprice.setText(null);
        //jcartarea.setText(null);

       // cashin.setText(null);
        //change.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 DefaultTableModel dm = (DefaultTableModel)table.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
        Show_Users_In_JTable1();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       DefaultTableModel dm = (DefaultTableModel)table.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
        Show_Users_In_JTable2();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void recieptbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recieptbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recieptbtnActionPerformed

    private void quantity1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantity1KeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_quantity1KeyReleased

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        String query = "UPDATE `trans` SET `fname`='"+productname.getText()+"',`lname`='"+quantity.getText()+"',`age`="+price.getText()+" WHERE `id` = "+id.getText();

       executeSQlQuery(query, "Updated");
        findUsers();
    }//GEN-LAST:event_resetbtnActionPerformed

    private void addtocartbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtocartbtnActionPerformed
         String query = "DELETE FROM `trans` WHERE id = "+id.getText();

         executeSQlQuery(query, "Deleted");
          findUsers();
    }//GEN-LAST:event_addtocartbtnActionPerformed

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        // TODO add your handling code here:
        //createKeybindings();
    }//GEN-LAST:event_tableKeyPressed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int i = table.getSelectedRow();

        TableModel model = table.getModel();

        // Display Slected Row In JTexteFields

        productid.setText(model.getValueAt(i,0).toString());

        productname.setText(model.getValueAt(i,1).toString());

        quantity.setText(model.getValueAt(i,2).toString());

        price.setText(model.getValueAt(i,3).toString());
        id.setText(model.getValueAt(i, 4).toString());

        // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

    private void jtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFilterKeyReleased
        // TODO add your handling code here:
        findUsers();
    }//GEN-LAST:event_jtFilterKeyReleased

    private void jtFilterInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtFilterInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jtFilterInputMethodTextChanged

    private void jtFilterCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtFilterCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jtFilterCaretPositionChanged

    private void jtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtFilterActionPerformed
        // TODO add your handling code here:
        findUsers();
    }//GEN-LAST:event_jtFilterActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Calc me=new Calc();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased

             
    }//GEN-LAST:event_quantityKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String query = "DELETE FROM `trans` WHERE id = "+id.getText();

         executeSQlQuery(query, "Deleted");
          String query1 = "UPDATE users SET lname = lname+'"+quantity.getText()+"'  WHERE fname='"+productname.getText()+"'";
//lname = lname-'"+quantity1.getText()+"'
       executeSQlQuery1(query1, "Updated");
       findUsers();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         String queryq = "DELETE FROM `trans` ";
          executeSQlQueryq(queryq, "Deleted");
         DefaultTableModel dm = (DefaultTableModel)table.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
       findUsers();
    }//GEN-LAST:event_jButton6ActionPerformed

      private void tableInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
        // TODO add your handling code here:
    }
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
            java.util.logging.Logger.getLogger(Transupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transupdate().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtocartbtn;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtFilter;
    private javax.swing.JTextField price;
    private javax.swing.JLabel pricelbl;
    private javax.swing.JTextField productid;
    private javax.swing.JLabel productidlbl;
    private javax.swing.JTextField productname;
    private javax.swing.JLabel productnamelbl;
    private javax.swing.JTextField quantity;
    private javax.swing.JLabel quantitylbl;
    private javax.swing.JButton resetbtn;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables


    /**
     *
     * @param query
     * @param message
     */





}
