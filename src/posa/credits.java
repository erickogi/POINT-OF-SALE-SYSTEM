/*
 * Copyright 2016 kimani kogi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package posa;

import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
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

/**
 *
 * @author kimani kogi
 */
public class credits extends javax.swing.JFrame {
DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form credits
     */
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





    public credits() {
             this.table2 = new JTable(model);
        this.jtFilter2= new JTextField();
         final TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table2.getModel());
       table2.setRowSorter(rowSorter); 
          jtFilter2.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtFilter2.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
           @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtFilter2.getText();

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
   setTilteImage();
    String i=n.setIconImage();
    this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(i)));
         Show_Users_In_JTable();
         try {
         sum1();
     } catch (Exception ex) {
         Logger.getLogger(debtscredits.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

        public  void sum1()  {
    String   query = "SELECT SUM(total) FROM credited";

      sum3(query, "Updated");  
        }
    public  void sum2() throws Exception {
    double sum = 0;
    //double sum1 = 0;
    try
    {
     Connection con = getConnection();
    Statement st = con.createStatement();
    //Statement st1 = con.createStatement();
    ResultSet res = st.executeQuery("SELECT SUM(total) FROM credited  WHERE iname='"+checkbyname.getText()+"' ");
  
    while (res.next()) {
      double c = res.getInt(1);
     sum = sum + c;
}
    JOptionPane.showMessageDialog(null, "TOTAL FOR " +checkbyname.getText()+ " is " +sum+" ");
              st.close();
              
             res.close();
             con.close();
  }
    catch (Exception e) {
        JOptionPane.showMessageDialog(null, "no data" );
        e.printStackTrace();
    }
           }
                public  void sum3(String query, String message)  {
     Connection connection = getConnection();
   Statement st;
   try{
st = connection.createStatement();
ResultSet res;
res=st.executeQuery(query);
 while (res.next()) {
      double c = res.getInt(1);
 double e=0;
     double sum = e+ c;
      total.setText(Double.toString(sum));
          }
;
st.close();
 connection.close();
       }catch(Exception ex){
JOptionPane.showMessageDialog(null," error");
           ex.printStackTrace();
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
 public ArrayList<invoiced> getUsersList(String ValToSearch)

   {

       ArrayList<invoiced> usersList = new ArrayList<invoiced>();

       Connection connection = getConnection();


String query = "SELECT * FROM `credited` WHERE CONCAT(`id`, `iname`, `product`, `updated_at`) LIKE '%"+ValToSearch+"%'";
      // String query = "SELECT * FROM  `invoiced` ";

       Statement st;

       ResultSet rs;



       try {

           st = connection.createStatement();

           rs = st.executeQuery(query);

           invoiced user;

           while(rs.next())

           {

               user = new invoiced(rs.getInt("id"),rs.getString("iname"),rs.getString("product"),rs.getString("price product"),rs.getString("total"),rs.getString("quantity"),rs.getString("updated_at"));

               usersList.add(user);

           }
             st.close();
              rs.close();
              
               connection.close();
       } catch (Exception e) {

           e.printStackTrace();

       }

       return usersList;

   }
      public void Show_Users_In_JTable()

   {

       ArrayList<invoiced> list = getUsersList(jtFilter2.getText());
 DefaultTableModel model = new DefaultTableModel();
      // DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
 model.setColumnIdentifiers(new Object[]{"ID","name","product","per","quantity","total","date"});
       Object[] row = new Object[7];

       for(int i = 0; i < list.size(); i++)

       {

           row[0] = list.get(i).getId();

           row[1] = list.get(i).getIname();
           row[2] = list.get(i).getProduct();

           row[3] = list.get(i).getPrice_product();

           
          row[4] = list.get(i).getQuantity();
          row[5] = list.get(i).getTotal();
                  row[6] = list.get(i).getUpdated_at();


           model.addRow(row);

       }
 table2.setModel(model);
    }
    public void executeSQlQueryu(String queryu, String messageu)

   {

       Connection con = getConnection();

       Statement st;

       try{

           st = con.createStatement();

           if((st.executeUpdate(queryu))== 1)

           {

               // refresh jtable data

               //DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();

               //model1.setRowCount(0);
                               //   findUsers(); 
               //Show_Users_In_JTable();

                                                  ic();

               JOptionPane.showMessageDialog(null, "Data "+messageu+" Succefully");

           }else{

               JOptionPane.showMessageDialog(null, "Data Not "+messageu+"\n no such product on your inventory check the name");

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

               DefaultTableModel model = (DefaultTableModel)table2.getModel();

               model.setRowCount(0);

               Show_Users_In_JTable();



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
       public ArrayList<invoiced> getUsersList4() throws ParseException

   {
       //String dateString;
    //java.util.Date a = null;


       ArrayList<invoiced> usersList4 = new ArrayList<invoiced>();

       Connection connection = getConnection();
String query4 =  "SELECT * FROM credited WHERE DAY(updated_at)="+day.getText()+" AND YEAR(updated_at)="+year.getText()+" AND MONTH(updated_at)="+month.getText()+"";
Statement st4;
ResultSet rs4;
 try {
 st4 = connection.createStatement();
 rs4 = st4.executeQuery(query4);
invoiced user;

           while(rs4.next())

           {

               user = new invoiced(rs4.getInt("id"),rs4.getString("iname"),rs4.getString("product"),rs4.getString("price product"),rs4.getString("total"),rs4.getString("quantity"),rs4.getString("updated_at"));

               usersList4.add(user);

           }
 st4.close();
                rs4.close();
              
               connection.close();
       } catch (Exception e) {

           e.printStackTrace();

       }

       return usersList4;

   }
      public void Show_Users_In_JTable4() throws ParseException

   {

       ArrayList<invoiced> list4 = getUsersList4();

       DefaultTableModel model = (DefaultTableModel)table2.getModel();
 model.setColumnIdentifiers(new Object[]{"ID","name","product","per","quantity","total","date"});
       Object[] row = new Object[7];

       for(int i = 0; i < list4.size(); i++)

       {

           row[0] = list4.get(i).getId();

           row[1] = list4.get(i).getIname();
           row[2] = list4.get(i).getProduct();

           row[3] = list4.get(i).getPrice_product();

           
          row[4] = list4.get(i).getQuantity();
          row[5] = list4.get(i).getTotal();
                  row[6] = list4.get(i).getUpdated_at();


           model.addRow(row);

       }

    }
      public ArrayList<invoiced> getUsersList1()

   {

       ArrayList<invoiced> usersList1 = new ArrayList<invoiced>();

       Connection connection = getConnection();



       String query1 = "SELECT * FROM credited WHERE DATE(updated_at) = DATE(NOW())";
       //WHERE WEEK(date)=WEEK(CURDATE()) AND YEAR(date)=YEAR(CURDATE())

       Statement st1;


       ResultSet rs1;



       try {
           st1 = connection.createStatement();

           rs1 = st1.executeQuery(query1);

           invoiced user;

           while(rs1.next())

           {

               user = new invoiced(rs1.getInt("id"),rs1.getString("iname"),rs1.getString("product"),rs1.getString("price product"),rs1.getString("total"),rs1.getString("quantity"),rs1.getString("updated_at"));

               usersList1.add(user);

           }
 
                st1.close();
              
              rs1.close();
               connection.close();
       } catch (Exception e) {

           e.printStackTrace();

       }

       return usersList1;

   }
      public void Show_Users_In_JTable1()

   {

       ArrayList<invoiced> list1 = getUsersList1();

       DefaultTableModel model = (DefaultTableModel)table2.getModel();
 model.setColumnIdentifiers(new Object[]{"ID","name","product","per","quantity","total","date"});
       Object[] row = new Object[7];

       for(int i = 0; i < list1.size(); i++)

       {

          row[0] = list1.get(i).getId();

           row[1] = list1.get(i).getIname();
           row[2] = list1.get(i).getProduct();

           row[3] = list1.get(i).getPrice_product();

           
          row[4] = list1.get(i).getQuantity();
          row[5] = list1.get(i).getTotal();
                  row[6] = list1.get(i).getUpdated_at();




           model.addRow(row);

       }

    }
  public ArrayList<invoiced> getUsersListm()

   {

       ArrayList<invoiced> usersList1 = new ArrayList<invoiced>();

       Connection connection = getConnection();



       String query1 = "SELECT * FROM credited WHERE MONTH(updated_at)=MONTH(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())";
       //WHERE WEEK(date)=WEEK(CURDATE()) AND YEAR(date)=YEAR(CURDATE())

       Statement st1;


       ResultSet rs1;



       try {
           st1 = connection.createStatement();

           rs1 = st1.executeQuery(query1);

           invoiced user;

           while(rs1.next())

           {

               user = new invoiced(rs1.getInt("id"),rs1.getString("iname"),rs1.getString("product"),rs1.getString("price product"),rs1.getString("total"),rs1.getString("quantity"),rs1.getString("updated_at"));

               usersList1.add(user);

           }
 
                st1.close();
              
              rs1.close();
               connection.close();
       } catch (Exception e) {

           e.printStackTrace();

       }

       return usersList1;

   }
      public void Show_Users_In_JTablem()

   {

       ArrayList<invoiced> list1 = getUsersListm();

       DefaultTableModel model = (DefaultTableModel)table2.getModel();
 model.setColumnIdentifiers(new Object[]{"ID","name","product","per","quantity","total","date"});
       Object[] row = new Object[7];

       for(int i = 0; i < list1.size(); i++)

       {

          row[0] = list1.get(i).getId();

           row[1] = list1.get(i).getIname();
           row[2] = list1.get(i).getProduct();

           row[3] = list1.get(i).getPrice_product();

           
          row[4] = list1.get(i).getQuantity();
          row[5] = list1.get(i).getTotal();
                  row[6] = list1.get(i).getUpdated_at();




           model.addRow(row);

       }

    }
       public ArrayList<invoiced> getUsersListw()

   {

       ArrayList<invoiced> usersList1 = new ArrayList<invoiced>();

       Connection connection = getConnection();



       String query1 = "SELECT * FROM credited WHERE WEEK(updated_at)=WEEK(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())";
       //WHERE WEEK(date)=WEEK(CURDATE()) AND YEAR(date)=YEAR(CURDATE())

       Statement st1;


       ResultSet rs1;



       try {
           st1 = connection.createStatement();

           rs1 = st1.executeQuery(query1);

           invoiced user;

           while(rs1.next())

           {

               user = new invoiced(rs1.getInt("id"),rs1.getString("iname"),rs1.getString("product"),rs1.getString("price product"),rs1.getString("total"),rs1.getString("quantity"),rs1.getString("updated_at"));

               usersList1.add(user);

           }
 
                st1.close();
              
              rs1.close();
               connection.close();
       } catch (Exception e) {

           e.printStackTrace();

       }

       return usersList1;

   }
      public void Show_Users_In_JTablew()

   {

       ArrayList<invoiced> list1 = getUsersListw();

       DefaultTableModel model = (DefaultTableModel)table2.getModel();
 model.setColumnIdentifiers(new Object[]{"ID","name","product","per","quantity","total","date"});
       Object[] row = new Object[7];

       for(int i = 0; i < list1.size(); i++)

       {

          row[0] = list1.get(i).getId();

           row[1] = list1.get(i).getIname();
           row[2] = list1.get(i).getProduct();

           row[3] = list1.get(i).getPrice_product();

           
          row[4] = list1.get(i).getQuantity();
          row[5] = list1.get(i).getTotal();
                  row[6] = list1.get(i).getUpdated_at();




           model.addRow(row);

       }

    }
      public void ic(){
        String query = "INSERT INTO `credited`(`iname`, `product`, `price product`,`total`,`quantity`,`updated_at`) VALUES ('"+name.getText()+"','"+product.getText()+"','"+perproduct.getText()+"','"+tamount.getText()+"','"+quantity.getText()+"',now())";
           executeSQlQuery(query, "Inserted");
    }
      public void match(){
      try {
            Connection con = getConnection();
            String value;
                String sql = "SELECT fname FROM users  WHERE fname='"+product.getText()+"'";
                  
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
                     value=rs.getString("bp");
                stmt.close();
                rs.close();
              
                con.close();
           } catch (Exception ex) {
               Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jtFilter2 = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        product = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        perproduct = new javax.swing.JTextField();
        tamount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        checkbyname = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        year = new javax.swing.JTextField();
        month = new javax.swing.JTextField();
        day = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        on = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        bp = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        table2.setBackground(new java.awt.Color(51, 204, 255));
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table2.setRowHeight(40);
        table2.setRowMargin(4);
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table2);

        jtFilter2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtFilter2KeyReleased(evt);
            }
        });

        jLabel1.setText("CREDITORS TABLE");

        jLabel2.setText("ID");

        jLabel3.setText("NAME");

        jLabel4.setText("PRODUCT");

        jLabel5.setText("QUANTITY");

        jLabel6.setText("PER PIECE");

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("CLEAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("CHECK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setText("CHECK BY NAME");

        jLabel8.setText("CHECK BY DATE");

        jButton6.setText("TODAY");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("WEEK");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("MONTH");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("CHECK");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("VIEW ALL");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        on.setEditable(false);

        jLabel9.setText("TOTAL");

        jLabel10.setText("ON");

        total.setEditable(false);
        total.setText("0");

        jLabel11.setText("TOTAL");

        jButton11.setText("NEW PRODUCT");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        bp.setText("0");

        jLabel12.setText("buying price");

        jLabel13.setText("yyyy-mm-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkbyname, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jButton10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(on, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(id)
                            .addComponent(name)
                            .addComponent(product)
                            .addComponent(quantity)
                            .addComponent(perproduct)
                            .addComponent(tamount)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8)
                            .addComponent(jButton9)
                            .addComponent(jButton5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2))
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(bp))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(767, 767, 767))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtFilter2)
                                .addGap(178, 178, 178)
                                .addComponent(jLabel11)
                                .addGap(29, 29, 29)
                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtFilter2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(product, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(perproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tamount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(on, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton11))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkbyname, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jButton7)
                            .addComponent(jButton6))
                        .addGap(3, 3, 3)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jButton10)
                        .addGap(47, 47, 47))))
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
   // "SELECT SUM(total) FROM credited  WHERE DAY(updated_at)="+day.getText()+" AND YEAR(updated_at)="+year.getText()+" AND MONTH(updated_at)="+month.getText()+""
        try {
        sum2();
    } catch (Exception ex) {
        Logger.getLogger(credits.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
          String query = "SELECT SUM(total) FROM credited";
          //executeSQlQuery(query, "Inserted");
          String queryu = "UPDATE users SET lname = lname+'"+quantity.getText()+"'  WHERE fname='"+product.getText()+"'";
           executeSQlQueryu(queryu, "updated");
       sum3(query, "Updated");
       name.setText(null);
           id.setText(null);
           quantity.setText(null);
           perproduct.setText(null);
           product.setText(null);
           tamount.setText(null);
           on.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String query = "UPDATE `credited` SET `iname`='"+name.getText()+"',`product`='"+product.getText()+"',`total`='"+tamount.getText()+"',`quantity`="+quantity.getText()+" WHERE `id` = "+id.getText();

       executeSQlQuery(query, "Updated");
         query = "SELECT SUM(total) FROM credited";

       sum3(query, "Updated");
      
        name.setText(null);
           id.setText(null);
           quantity.setText(null);
           perproduct.setText(null);
           product.setText(null);
             tamount.setText(null);
             on.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String query = "DELETE FROM `credited` WHERE id = "+id.getText();

         executeSQlQuery(query, "Deleted");
        query = "SELECT SUM(total) FROM credited";

       sum3(query, "Updated");
       name.setText(null);
           id.setText(null);
           quantity.setText(null);
           perproduct.setText(null);
           product.setText(null);
           tamount.setText(null);
           on.setText(null);
           //total.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         name.setText(null);
         tamount.setText(null);
           id.setText(null);
           quantity.setText(null);
           perproduct.setText(null);
           product.setText(null);
           total.setText(null);
           checkbyname.setText(null);
           day.setText(null);
           month.setText(null);
           year.setText(null);
           on.setText(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       try {
           String query = "SELECT SUM(total) FROM credited  WHERE DAY(updated_at)="+day.getText()+" AND YEAR(updated_at)="+year.getText()+
            " AND MONTH(updated_at)="+month.getText()+"";
            sum3(query, "Inserted");
               DefaultTableModel dm = (DefaultTableModel)table2.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
                               
            Show_Users_In_JTable4();
        } catch (ParseException ex) {
            Logger.getLogger(transactions.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DefaultTableModel dm = (DefaultTableModel)table2.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
        Show_Users_In_JTable1();
        //try {
           // sum3();
       // } catch (Exception ex) {
        //    Logger.getLogger(transactions.class.getName()).log(Level.SEVERE, null, ex);
        //}
         String query = "SELECT SUM(total) FROM credited  WHERE DATE(updated_at) = DATE(NOW())";
           sum3(query, "Inserted");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DefaultTableModel dm = (DefaultTableModel)table2.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
        Show_Users_In_JTablew();    
                String query = "SELECT SUM(total) FROM credited  WHERE WEEK(updated_at)=WEEK(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())";
           sum3(query, "Inserted");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
 DefaultTableModel dm = (DefaultTableModel)table2.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
        Show_Users_In_JTable();    
                String query = "SELECT SUM(total) FROM credited";
           sum3(query, "Inserted");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       DefaultTableModel dm = (DefaultTableModel)table2.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
        Show_Users_In_JTablem();    
                String query = "SELECT SUM(total) FROM credited";
           sum3(query, "Inserted");
     
    }//GEN-LAST:event_jButton8ActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
         int i = table2.getSelectedRow();
 


 TableModel model = table2.getModel();
 id.setText(model.getValueAt(i,0).toString());
 name.setText(model.getValueAt(i,1).toString());
 product.setText(model.getValueAt(i,2).toString());
 perproduct.setText(model.getValueAt(i,3).toString());
 quantity.setText(model.getValueAt(i,4).toString());
 tamount.setText(model.getValueAt(i,5).toString());
 on.setText(model.getValueAt(i,6).toString());
    }//GEN-LAST:event_table2MouseClicked

    private void jtFilter2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFilter2KeyReleased
        Show_Users_In_JTable();
        String query = "SELECT SUM(total) FROM credited";
           sum3(query, "Inserted");
    }//GEN-LAST:event_jtFilter2KeyReleased

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
                 try
        {
            //get database connection details
           
            String stru=product.getText();
             //open connection
          Connection con = getConnection();
            String str="";
            
            str="select * from users where  fname =?";
            
           PreparedStatement pst=con.prepareStatement(str);
         
           pst.setString(1, stru);
          
           ResultSet rs;
           //ResultSet rs1;
           rs=pst.executeQuery();
          
           if (rs.next())
               
           {
          JOptionPane.showMessageDialog(null,"A PRODUCT WITH SUCH NAME  ("+product.getText()+")  ALREADY EXIST \n "
                  + " USE ANOTHER NAME OR UPDATE THE PRODUCTS IN QUESTION");
               
           }
           else
           {
String f=bp.getText();
        double p=Double.valueOf(bp.getText());
        if(f!=null&&p>0){
        String query = "INSERT INTO `credited`(`iname`, `product`, `price product`,`total`,`quantity`,`updated_at`) VALUES ('"+name.getText()+"','"+product.getText()+"','"+perproduct.getText()+"','"+tamount.getText()+"','"+quantity.getText()+"',now())";
           executeSQlQuery(query, "Inserted INTO CREDITORS TABLE");
           //String f=product.getText();
          // if(+bp.getText()+)
           query = "INSERT INTO `users`(`fname`, `lname`,`age` ,`bp`,`from`) VALUES ('"+product.getText()+"','"+quantity.getText()+"','"+perproduct.getText()+"','"+bp.getText()+"','"+name.getText()+"')";
           executeSQlQuery(query, " INTO INENTORY Inserted");
           query = "SELECT SUM(total) FROM credited";
            sum3(query, "Updated");
       name.setText(null);
           id.setText(null);
           quantity.setText(null);
           perproduct.setText(null);
           product.setText(null);
           tamount.setText(null);
           on.setText(null);
        }
        else{
             JOptionPane.showMessageDialog(null, "!!PROVIDE THE BUYING PRICE FOR THE NEW PRODUCT!!");
        }
            }
           
          con.close();
           rs.close();
           pst.close();   
        }
        catch (Exception a)
        {
            System.err.println(a);
           // System.exit(1);
        } 
        
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(credits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(credits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(credits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(credits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new credits().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bp;
    private javax.swing.JTextField checkbyname;
    private javax.swing.JTextField day;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtFilter2;
    private javax.swing.JTextField month;
    private javax.swing.JTextField name;
    private javax.swing.JTextField on;
    private javax.swing.JTextField perproduct;
    private javax.swing.JTextField product;
    private javax.swing.JTextField quantity;
    private javax.swing.JTable table2;
    private javax.swing.JTextField tamount;
    private javax.swing.JTextField total;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}
