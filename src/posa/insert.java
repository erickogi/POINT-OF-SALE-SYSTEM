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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Color;
import java.awt.Container;
/**
 *
 * @author kimani kogi
 */
public class insert extends javax.swing.JFrame {
DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form insert
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
           // Logger.getLogger(sellform.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
}











    public insert() {
        this.jTable_Display_Users = new JTable(model);
        this. jTextField2= new JTextField();
         final TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(jTable_Display_Users.getModel());
       jTable_Display_Users.setRowSorter(rowSorter);
          jTextField2.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jTextField2.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
           @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jTextField2.getText();

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
        //findUsers();
        
        Show_Users_In_JTable();
         jTextField_name.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               jTextField_quantity.requestFocus(); //To change body of generated methods, choose Tools | Templates.
            }
        });
          jTextField_quantity.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               jTextField_price.requestFocus(); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    /**
     *
     */
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

        ArrayList<User_1> users = ListUsers(jTextField2.getText());
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
       jTable_Display_Users.setModel(model);

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
    public ArrayList<User_1> getUsersList()

   {

       ArrayList<User_1> usersList = new ArrayList<User_1>();

       Connection connection = getConnection();



       String query = "SELECT * FROM  `users` ";

       Statement st;

       ResultSet rs;



       try {

           st = connection.createStatement();

           rs = st.executeQuery(query);

           User_1 user;

           while(rs.next())

           {

               user = new User_1(rs.getInt("id"),rs.getString("fname"),rs.getString("lname"),rs.getString("age"),rs.getString("bp"),rs.getString("from"));

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

       ArrayList<User_1> list = getUsersList();

       DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
 model.setColumnIdentifiers(new Object[]{"ID","name","quantity","sell price","buy price","from"});
       Object[] row = new Object[6];

       for(int i = 0; i < list.size(); i++)

       {

           row[0] = list.get(i).getId();

           row[1] = list.get(i).getFname();

           row[2] = list.get(i).getLname();

           row[3] = list.get(i).getAge();
row[4] = list.get(i).getBp();
row[5] = list.get(i).getFrom();


           model.addRow(row);

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

               DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();

               model.setRowCount(0);

               Show_Users_In_JTable();



               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");

           }else{

               JOptionPane.showMessageDialog(null, "Data Not "+message);

           }
             st.close();
             
               con.close();
       }
       catch(Exception ex){

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Users = new javax.swing.JTable();
        jLabelid = new javax.swing.JLabel();
        jLabelname = new javax.swing.JLabel();
        jLabelquantity = new javax.swing.JLabel();
        jLabelprice = new javax.swing.JLabel();
        jTextField_Id = new javax.swing.JTextField();
        jTextField_name = new javax.swing.JTextField();
        jTextField_quantity = new javax.swing.JTextField();
        jTextField_price = new javax.swing.JTextField();
        jButton_Insert = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        bpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        from = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ttol = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 153));

        jTable_Display_Users.setAutoCreateRowSorter(true);
        jTable_Display_Users.setBackground(new java.awt.Color(51, 153, 255));
        jTable_Display_Users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "quantity", "Price", "buyprice"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Display_Users.setIntercellSpacing(new java.awt.Dimension(4, 4));
        jTable_Display_Users.setRowHeight(40);
        jTable_Display_Users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_UsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_Users);

        jLabelid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelid.setText("product id");

        jLabelname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelname.setText("product name");

        jLabelquantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelquantity.setText("product quantity");

        jLabelprice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelprice.setText("sell price");

        jTextField_Id.setEditable(false);
        jTextField_Id.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        jTextField_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_IdActionPerformed(evt);
            }
        });

        jTextField_name.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nameActionPerformed(evt);
            }
        });

        jTextField_quantity.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jTextField_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_quantityActionPerformed(evt);
            }
        });

        jTextField_price.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_priceActionPerformed(evt);
            }
        });

        jButton_Insert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_Insert.setText("INSERT");
        jButton_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InsertActionPerformed(evt);
            }
        });

        jButton_update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_update.setText("UPDATE");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jButton_delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_delete.setText("DELETE");
        jButton_delete.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/posa/New Folder/booked1.png"))); // NOI18N
        jButton_delete.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/posa/New Folder/booked1.png"))); // NOI18N
        jButton_delete.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/posa/New Folder/booked1.png"))); // NOI18N
        jButton_delete.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/posa/New Folder/booked1.png"))); // NOI18N
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });

        jLabel1.setText("PRODUCT LIST");

        jLabel2.setText("RETAIL SYSTEM");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("REDUCE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("buy price @product");

        bpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpfActionPerformed(evt);
            }
        });
        bpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bpfKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("from(optional)");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("change quantity");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("total");

        ttol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttolActionPerformed(evt);
            }
        });
        ttol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ttolKeyReleased(evt);
            }
        });

        jLabel7.setText("0r");

        jLabel8.setText("only fill one");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(403, 403, 403))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(jButton_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_update, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelquantity, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(jLabelid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabelprice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(from)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ttol, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField_quantity)
                            .addComponent(jTextField_price)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_Id, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bpf))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 363, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                        .addGap(69, 69, 69))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelid, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelname, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addComponent(bpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(ttol))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelprice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(from))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_IdActionPerformed

    private void jTextField_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nameActionPerformed

    private void jTextField_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_quantityActionPerformed

    private void jTextField_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_priceActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        // TODO add your handling code here:
          String query = "DELETE FROM `users` WHERE id = "+jTextField_Id.getText();

         executeSQlQuery(query, "Deleted");
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        // TODO add your handling code here:
        String query = "UPDATE `users` SET `fname`='"+jTextField_name.getText()+"',`lname`='"+jTextField_quantity.getText()+"',`bp`='"+bpf.getText()+"',`age`="+jTextField_price.getText()+" WHERE `id` = "+jTextField_Id.getText();

       executeSQlQuery(query, "Updated");
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jButton_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InsertActionPerformed
        // TODO add your handling code here:
       // now(),
                try
        {
            //get database connection details
           
            String stru=jTextField_name.getText();
             //open connection
          Connection con = getConnection();
            String str="";
            
            str="select * from users where  fname =?";
            
           PreparedStatement pst=con.prepareStatement(str);
         
           pst.setString(1, stru);
          
           ResultSet rs;
          // ResultSet rs1;
           rs=pst.executeQuery();
          
           if (rs.next())
               
           {
          JOptionPane.showMessageDialog(null,"A PRODUCT WITH SUCH NAME  ("+jTextField_name.getText()+")  ALREADY EXIST \n "
                  + " USE ANOTHER NAME OR UPDATE THE PRODUCTS IN QUESTION");
               
           }
           else
           {
                 String query = "INSERT INTO `users`(`fname`, `lname`, `age`,`bp`,`from`) VALUES ('"+jTextField_name.getText()+"','"+jTextField_quantity.getText()+"','"+jTextField_price.getText()+"','"+bpf.getText()+"','"+from.getText()+"')";



        executeSQlQuery(query, "Inserted");
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
    }//GEN-LAST:event_jButton_InsertActionPerformed

    private void jTable_Display_UsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_UsersMouseClicked
        // TODO add your handling code here:
          int i = jTable_Display_Users.getSelectedRow();




        TableModel model = jTable_Display_Users.getModel();



         // Display Slected Row In JTexteFields

        jTextField_Id.setText(model.getValueAt(i,0).toString());




        jTextField_name.setText(model.getValueAt(i,1).toString());




        jTextField_quantity.setText(model.getValueAt(i,2).toString());




        jTextField_price.setText(model.getValueAt(i,3).toString());


bpf.setText(model.getValueAt(i, 4).toString());

from.setText(model.getValueAt(i, 5).toString());
    }//GEN-LAST:event_jTable_Display_UsersMouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
//       int pric;
//        int qua;
//        jTextField_quantity.getText();
//        pric=Integer.parseInt(jTextField_quantity.getText());
//        qua=Integer.parseInt(jTextField1.getText());
//        int top=(pric+qua);
//
//        jTextField_quantity.setText(Integer.toString(top));
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        double pric;
        double qua;
        jTextField_quantity.getText();
       // qua=Double.valueOf(quantity1.getText());
        pric=Double.valueOf(jTextField_quantity.getText());
        qua=Double.valueOf(jTextField1.getText());
        double top=(pric+qua);

        jTextField_quantity.setText(Double.toString(top));
        jTextField1.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         double pric;
        double qua;
        jTextField_quantity.getText();
        pric=Double.valueOf(jTextField_quantity.getText());
        qua=Double.valueOf(jTextField1.getText());
        double top=(pric-qua);

        jTextField_quantity.setText(Double.toString(top));
        jTextField1.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bpfActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTextField_name.setText(null);
        jTextField_quantity.setText(null);
        jTextField_price.setText(null);
        from.setText(null);
        bpf.setText(null);
        jTextField_Id.setText(null);
        jTextField1.setText(null);
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ttolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttolActionPerformed

    private void ttolKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttolKeyReleased
        // TODO add your handling code here:
        double c,x,m;
        jTextField_quantity.getText();
        c=Double.parseDouble(jTextField_quantity.getText());
        x=Double.parseDouble(ttol.getText());
        m=x/c;
        bpf.setText(Double.toString(m));
    }//GEN-LAST:event_ttolKeyReleased

    private void bpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bpfKeyReleased
        // TODO add your handling code here:
          double c,x,m;
        jTextField_quantity.getText();
        c=Double.parseDouble(jTextField_quantity.getText());
        x=Double.parseDouble(bpf.getText());
        m=x*c;
       ttol.setText(Double.toString(m));
    }//GEN-LAST:event_bpfKeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        findUsers();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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
            java.util.logging.Logger.getLogger(insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new insert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bpf;
    private javax.swing.JTextField from;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_Insert;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelid;
    private javax.swing.JLabel jLabelname;
    private javax.swing.JLabel jLabelprice;
    private javax.swing.JLabel jLabelquantity;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Users;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField_Id;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_price;
    private javax.swing.JTextField jTextField_quantity;
    private javax.swing.JTextField ttol;
    // End of variables declaration//GEN-END:variables
}
