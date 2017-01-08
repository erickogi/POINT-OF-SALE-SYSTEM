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
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class sellform extends javax.swing.JFrame {
   DefaultTableModel model = new DefaultTableModel();
  double h;
  double b;
   double a;
   int nr;
   static String on="on";
 static String ondb;
 int yes;
String tt;
 
String admin;
   String name,contact,tag,user_name;
   


    public sellform() {
    
       
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
             methods n=new methods();
   String t= n.setTitle();
   this.setTitle(t);
    String i=n.setIconImage();
    this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(i)));
    
       try {
           selecton();
       } catch (Exception ex) {
           Logger.getLogger(sellform.class.getName()).log(Level.SEVERE, null, ex);
       }
findUsers();
ran1();

        quantity1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent a) {
             
        
            final String newline="\n";
            final String tab="\t";
            double pric;
            double qua;

            pric=Double.valueOf(price.getText());
            qua=Double.valueOf(quantity1.getText());
            String tp=totalpurchase.getText();
            double tps=Double.valueOf(tp);
            final String LF = "\n";
final String SPACE = "          ";//10 spaces
    final String SPACES = "         ";//9
            double top=(pric*qua);
            tp=Double.toString(top+tps);
        

            totalprice.setText(Double.toString(top));

            totalpurchase.setText(tp);

        final String p=price.getText();   
       final String ab=quantity1.getText();
        final String ta=productname.getText();
         final String tb=totalprice.getText();
    
           // jcartarea.append( ab+ "      " +ta +"         "+tb +newline );
          jcartarea.append( ta +""+newline );
        jcartarea.append("     "+ ab+ "    *    "+p+"   = "+tb +newline );
   
    jcartarea.setEditable(false);
            
 

            try
            {
                Connection con = getConnection();
               
double y,c;

c=Double.valueOf(quantity1.getText());
y=b*c;
                String sql = "INSERT INTO `trans`(`bp`, `fname`, `lname`,`updated_at`, `age`) VALUES ("+y+",'"+productname.getText()+"','"+quantity1.getText()+"',now(),"+totalprice.getText()+")";
                  //String sql = "INSERT INTO `trans`( `fname`, `lname`,`updated_at`, `age`) VALUES ('"+productname.getText()+"','"+quantity1.getText()+"',now(),"+totalprice.getText()+")";
                PreparedStatement pst=con.prepareStatement(sql);
                pst.executeUpdate(sql);
                pst.close();
                con.close();
            }
            catch (Exception e) {
                System.err.println(e);
                System.exit(1);
            }
            try
            {
              
Connection con = getConnection();
                String sql = "UPDATE users SET lname = lname-'"+quantity1.getText()+"'  WHERE id='"+productid.getText()+"'";

                PreparedStatement pst=con.prepareStatement(sql);
                pst.executeUpdate(sql);
                pst.close();
                con.close();
                
            }
            catch (Exception e) {
                System.err.println(e);
                System.exit(1);
            }
            }
        });
       try {
           Show_Users_In_JTable4();
           editable();
       } catch (ParseException ex) {
           Logger.getLogger(sellform.class.getName()).log(Level.SEVERE, null, ex);
       }
re();
shopname.setText(name);

    }
              public void re(){         
       SimpleDateFormat df = new SimpleDateFormat();
String receiptDetailLine;
              df.applyPattern("dd/MM/yyyy HH:mm:ss");
    String strText = null;
    final String LF = "\n";// text string to output
    int lineStart;           // start index of line in jcartarea
    int lineEnd;             // end index of line in jcartarea
    int lineNumber;
    int lineCount;
    final String SPACE = "          ";//10 spaces
    final String SPACES = "     ";//9
    final String uline = "________________________________________";
    final String dline = "----------------------------------------";
    String greetings = "THANKS FOR YOUR VISIT";
    receiptDetailLine = "";
    
    jcartarea.append("   " + SPACES + name + "\n");
    
    jcartarea.append("" + SPACES + tag + "\n");
jcartarea.append("  " + SPACES + contact + "\n"+ "\n");
    jcartarea.append(SPACES + "YOUR PUCHASES" + "\n");

    jcartarea.append(uline + "\n");
   
    jcartarea.append(dline + "\n");
    jcartarea.append("Description   Qty" + SPACES + "  Price" + LF);
          }
    public void a() {
    PageFormat format = new PageFormat();
    Paper paper = new Paper();

    double paperWidth = 3;//3.25
    double paperHeight = 3.69;//11.69
    double leftMargin = 0.12;
    double rightMargin = 0.10;
    double topMargin = 0;
    double Margin = 0;
    double bottomMargin = 0.01;

    paper.setSize(paperWidth * 200, paperHeight * 200);
    paper.setImageableArea(leftMargin * 200, topMargin * 200,
            (paperWidth - leftMargin - rightMargin) * 200,
            (paperHeight - topMargin - bottomMargin) * 200);

    format.setPaper(paper);

    PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
    aset.add(OrientationRequested.PORTRAIT);


    PrinterJob printerJob = PrinterJob.getPrinterJob();
    Printable printable = new ReceiptPrint();

    format = printerJob.validatePage(format);
    boolean don = printerJob.printDialog();
    printerJob.setPrintable(printable, format);
    try {
        printerJob.print(aset);
    } catch (Exception e) {
        e.printStackTrace();
    }
    shopname.setText(name);
}
     public void selecton()
    throws Exception
  {
   Connection con = getConnection();
       // Connection con = m.getConnection();
    Statement st2 = con.createStatement();
    
    ResultSet res7 = st2.executeQuery("SELECT user_name FROM lib_user  WHERE id=1 ");
    while (res7.next()) {
      ondb=(res7.getString("user_name"));
      
    }
    st2.close();
    res7.close();
    con.close();
  
  
  }
    public void admin(){
    try{
    if(on.equals(ondb)){
        yes=1;
         }
    else{
        JOptionPane.showMessageDialog(null, "ACCESS DENEID ");
    }
    }
     catch (Exception ex)
    {
      JOptionPane.showMessageDialog(null, "ACCESS DENEID ");
    }
}
    
    public void editable(){
        try{
        if(on.equals(ondb)){
            price.setEditable(true);
        }
        else{
            price.setEditable(false);
        }
        }
        catch(Exception o){
            price.setEditable(false);
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


        model.setColumnIdentifiers(new Object[]{"ID","name","quantity","price","buy price"});
        Object[] row = new Object[5];

     for(int i = 0; i < users.size(); i++)
        {
            row[0] = users.get(i).getId();
            row[1] = users.get(i).getFname();
            row[2] = users.get(i).getLname();
            row[3] = users.get(i).getAge();
            row[4] = users.get(i).getBp();
            model.addRow(row);
        }
       table.setModel(model);

    }
     
   public ArrayList<recptu> getUsersList4() throws ParseException

   {
      


       ArrayList<recptu> usersList4 = new ArrayList<recptu>();

        Connection con = getConnection();
   

       String query4 =  "SELECT * FROM `reciept` ";
       
       Statement st4;

       ResultSet rs4;



       try {

           st4 = con.createStatement();

           rs4 = st4.executeQuery(query4);

           recptu user;

           while(rs4.next())

           {

               user = new recptu(rs4.getString("name"),rs4.getString("contact"),rs4.getString("tag"),rs4.getString("bsemail"),rs4.getString("toemail"),rs4.getString("epassword"));

               usersList4.add(user);

           }
           st4.close();
                rs4.close();
              
                con.close();

       } catch (Exception e) {

           e.printStackTrace();

       }

       return usersList4;

   }
      public void Show_Users_In_JTable4() throws ParseException

   {
//String a;
       ArrayList<recptu> list4 = getUsersList4();

       

       for(int i = 0; i < list4.size(); i++)

       {

           

          name=list4.get(i).getName();

           contact=list4.get(i).getContact();

           tag=list4.get(i).getTag();



          

       }

    }
 public ArrayList<servedby> getUsersList5() throws ParseException

   {
       
       ArrayList<servedby> usersList5 = new ArrayList<servedby>();

        Connection con = getConnection();
        

       String query5 =  "SELECT * FROM `servedby` ";
       
       Statement st5;

       ResultSet rs5;



       try {

           st5 = con.createStatement();

           rs5 = st5.executeQuery(query5);

           servedby user;

           while(rs5.next())

           {

               user = new servedby(rs5.getString("user_name"));

               usersList5.add(user);

           }
           st5.close();
                rs5.close();
              
                con.close();

       } catch (Exception e) {
 //JOptionPane.showMessageDialog(null,"Enter Password");
           e.printStackTrace();

       }

       return usersList5;

   }
      public void Show_Users_In_JTable5() throws ParseException

   {
//String a;
       ArrayList<servedby> list5 = getUsersList5();

       

       for(int i = 0; i < list5.size(); i++)

       {

           

          user_name=list5.get(i).getUserName();

          



          

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
        shopname = new javax.swing.JLabel();
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
        recieptbtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jcartarea = new javax.swing.JTextArea();
        totalpurchase = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cashin = new javax.swing.JTextField();
        change = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        quantity1 = new javax.swing.JTextField();
        productname = new javax.swing.JTextField();
        productid = new javax.swing.JTextField();
        totalprice = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 204, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1350, 812));

        shopname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        shopname.setText("RETAIL SYSTEM ");

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
                "Title 1", "Title 2", "Title 3", "Title 4"
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

        productidlbl.setText("PRODUCT ID");

        quantitylbl.setText("QUANTITY");

        pricelbl.setText("PRICE");

        addtocartbtn.setText("ADD");
        addtocartbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtocartbtnActionPerformed(evt);
            }
        });

        resetbtn.setText("RESET");
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });

        recieptbtn.setText("RECIEPT");
        recieptbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recieptbtnActionPerformed(evt);
            }
        });

        jLabel7.setText("ITEMS IN CART");

        jcartarea.setEditable(false);
        jcartarea.setBackground(new java.awt.Color(255, 255, 153));
        jcartarea.setColumns(20);
        jcartarea.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jcartarea.setRows(5);
        jScrollPane8.setViewportView(jcartarea);

        totalpurchase.setEditable(false);
        totalpurchase.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        totalpurchase.setText("0");

        jLabel3.setText("sh");

        jLabel4.setText("cash in");

        jLabel5.setText("change");

        cashin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cashin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cashinKeyReleased(evt);
            }
        });

        change.setEditable(false);
        change.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });

        quantity1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantity1ActionPerformed(evt);
            }
        });
        quantity1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantity1KeyReleased(evt);
            }
        });

        productname.setEditable(false);

        productid.setEditable(false);

        totalprice.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(358, 358, 358)
                        .addComponent(shopname, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addGap(616, 616, 616))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtFilter)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(1, 1, 1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel4)
                                        .addGap(24, 24, 24)
                                        .addComponent(cashin, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(115, 115, 115)
                                        .addComponent(addtocartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(recieptbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pricelbl)
                                            .addComponent(productnamelbl)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(totalprice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                                .addComponent(price, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(quantity1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(productid, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(productname, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addComponent(productidlbl)
                                            .addComponent(quantitylbl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(totalpurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(2, 2, 2))))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalpurchase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productnamelbl))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productname, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productidlbl)
                        .addGap(18, 18, 18)
                        .addComponent(productid, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantitylbl)
                        .addGap(18, 18, 18)
                        .addComponent(quantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pricelbl)
                        .addGap(18, 18, 18)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(totalprice, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addtocartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recieptbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cashin, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4)))
                .addGap(165, 165, 165))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shopname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jMenuBar1.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jMenuBar1.setMinimumSize(new java.awt.Dimension(10, 10));

        jMenu1.setText("File");
        jMenu1.setMargin(new java.awt.Insets(6, 6, 6, 6));

        jMenuItem17.setText("Exit");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem17);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Inventory");
        jMenu3.setMargin(new java.awt.Insets(6, 6, 6, 6));

        jMenuItem1.setText("check inventory");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Add products");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Transaction");
        jMenu4.setMargin(new java.awt.Insets(6, 6, 6, 6));

        jMenuItem3.setText("Check transactions");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setText("Transactions update");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu6.setText("Invoices");
        jMenu6.setMargin(new java.awt.Insets(6, 6, 6, 6));

        jMenuItem8.setText("Customer Invoice");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenuItem9.setText("Supplier Invoice");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem9);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Reports");
        jMenu7.setMargin(new java.awt.Insets(6, 6, 6, 6));

        jMenuItem10.setText("Print");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem10);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Prefrences");
        jMenu8.setMargin(new java.awt.Insets(6, 6, 6, 6));

        jMenuItem11.setText("Change Admin password");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem11);

        jMenuItem12.setText("Change User password");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem12);

        jMenuBar1.add(jMenu8);

        jMenu9.setText("Send");
        jMenu9.setMargin(new java.awt.Insets(6, 6, 6, 6));

        jMenuItem7.setText("send todays");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem7);

        jMenuBar1.add(jMenu9);

        jMenu10.setText("Debtors/Creditors");
        jMenu10.setMargin(new java.awt.Insets(6, 6, 6, 6));

        jMenuItem13.setText("Debtors");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem13);

        jMenuItem14.setText("Creditors");
        jMenu10.add(jMenuItem14);

        jMenuBar1.add(jMenu10);

        jMenu11.setText("Tools");
        jMenu11.setMargin(new java.awt.Insets(6, 6, 6, 6));

        jMenuItem5.setText("calculator");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem5);

        jMenuItem6.setText("calender");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem6);

        jMenuBar1.add(jMenu11);

        jMenu2.setText("Backup/Restore");
        jMenu2.setMargin(new java.awt.Insets(6, 6, 6, 6));

        jMenuItem18.setText("Backup");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem18);

        jMenuItem19.setText("Restore");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem19);

        jMenuBar1.add(jMenu2);

        jMenu13.setText("About");

        jMenuItem15.setText("About");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem15);

        jMenuItem16.setText("Manual");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem16);

        jMenuBar1.add(jMenu13);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed
public void reset(){
            // TODO add your handling code here:
        totalpurchase.setText("0");
        productname.setText(null);
        productid.setText(null);
        quantity1.setText(null);

         price.setText(null);
        totalprice.setText(null);
        jcartarea.setText(null);

        cashin.setText(null);
        change.setText(null);
        re();
//                   SimpleDateFormat df = new SimpleDateFormat();
//String receiptDetailLine;
//              df.applyPattern("dd/MM/yyyy HH:mm:ss");
//    String strText = null;
//    final String LF = "\n";// text string to output
//    int lineStart;           // start index of line in jcartarea
//    int lineEnd;             // end index of line in jcartarea
//    int lineNumber;
//    int lineCount;
//    final String SPACE = "          ";//10 spaces
//    final String SPACES = "     ";//9
//    final String uline = "________________________________________";
//    final String dline = "----------------------------------------";
//    String greetings = "THANKS FOR YOUR VISIT";
//    receiptDetailLine = "";
//     // jcartarea.append(SPACES + "*************" + "\n");
//
//   // jcartarea.append(" " + SPACES + "***********" + "\n");
//
//   // jcartarea.append(SPACES + "************" + "\n");
////String a;
//    jcartarea.append("   " + SPACES + name + "\n");
//    
//    jcartarea.append("" + SPACES + tag + "\n");
//jcartarea.append("  " + SPACES + contact + "\n"+ "\n");
//    jcartarea.append(SPACES + "YOUR PUCHASES" + "\n");
//
//    jcartarea.append(uline + "\n");
//   // jcartarea.append("Order Ref:" + "   " + receiptDetailLine + "\n");
//    jcartarea.append(dline + "\n");
//    jcartarea.append(" Qty  Description" + SPACES + "  Price" + LF);
}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       reset();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void quantity1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantity1KeyReleased
        double pric;
        double qua;
        pric=Double.parseDouble(price.getText());
        qua=Double.parseDouble(quantity1.getText());
        double top=(pric*qua);

        totalprice.setText(Double.toString(top));

    }//GEN-LAST:event_quantity1KeyReleased

    private void cashinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashinKeyReleased
        // TODO add your handling code here:
        double pric;
        double qua;
        String tp;

        pric=Integer.valueOf(cashin.getText());
        qua=Double.valueOf(totalpurchase.getText());

        double top=(pric-qua);
        tp=Double.toString(top);

        change.setText(tp);
    }//GEN-LAST:event_cashinKeyReleased

    private void recieptbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recieptbtnActionPerformed
        recieptbtn();

    }//GEN-LAST:event_recieptbtnActionPerformed

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        reset();
    }//GEN-LAST:event_resetbtnActionPerformed

    private void addtocartbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtocartbtnActionPerformed

        final String newline="\n";
        final String tab="\t";
        double pric;
        double qua;

        pric=Double.valueOf(price.getText());
        qua=Double.valueOf(quantity1.getText());
        String tp=totalpurchase.getText();
        double tps=Double.valueOf(tp);
        final String LF = "\n";
        final String SPACE = "          ";//10 spaces
        final String SPACES = "         ";//9
        double top=(pric*qua);
        tp=Double.toString(top+tps);

        totalprice.setText(Double.toString(top));

        totalpurchase.setText(tp);
        final String p=price.getText();
        final String ab=quantity1.getText();
        final String ta=productname.getText();
        final String tb=totalprice.getText();

        //jcartarea.append( ab+ "      " +ta +"         "+tb +newline );
        jcartarea.append( ta +""+newline );
        jcartarea.append("     "+ ab+ "    *    "+p+"   = "+tb +newline );
        //jcartarea.append( ab+ "      " +ta +"         "+tb +newline );

        jcartarea.setEditable(false);

        try
        {

            double y,c;
            c=Double.parseDouble(quantity1.getText());
            y=b*c;
            Connection con = getConnection();
            String sql = "INSERT INTO `trans`(`bp`, `fname`, `lname`,`updated_at`, `age`) VALUES ("+y+",'"+productname.getText()+"','"+quantity1.getText()+"',now(),"+totalprice.getText()+")";
            //String sql = "INSERT INTO `trans`( `fname`, `lname`,`updated_at`, `age`) VALUES ('"+productname.getText()+"','"+quantity1.getText()+"',now(),"+totalprice.getText()+")";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.executeUpdate(sql);
            pst.close();
            // rs4.close();

            con.close();

        }
        catch (Exception e) {
            System.err.println(e);
            // System.exit(1);
        }
        try
        {
            //Connection connection;
            //connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","123ERYcog.");
            Connection con = getConnection();
            String sql = "UPDATE users SET lname = lname-'"+quantity1.getText()+"'  WHERE id='"+productid.getText()+"'";

            PreparedStatement pst=con.prepareStatement(sql);
            pst.executeUpdate(sql);
            pst.close();
            //rs4.close();

            con.close();

        }
        catch (Exception e) {
            System.err.println(e);
            //System.exit(1);
        }
    }//GEN-LAST:event_addtocartbtnActionPerformed

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed

    }//GEN-LAST:event_tableKeyPressed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int i = table.getSelectedRow();
        //int bp,Interger;
        TableModel model = table.getModel();

        // Display Slected Row In JTexteFields

        productid.setText(model.getValueAt(i,0).toString());

        productname.setText(model.getValueAt(i,1).toString());
        //bp.(model.getValueAt(i, 4).toString());
        quantity1.setText("");

        price.setText(model.getValueAt(i,3).toString());

        totalprice.setText(Double.toString(0));

        String k=model.getValueAt(i, 4).toString();
        b=Double.valueOf(k);

    }//GEN-LAST:event_tableMouseClicked

    private void jtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFilterKeyReleased

        findUsers();
    }//GEN-LAST:event_jtFilterKeyReleased

    private void jtFilterInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtFilterInputMethodTextChanged

    }//GEN-LAST:event_jtFilterInputMethodTextChanged

    private void jtFilterCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtFilterCaretPositionChanged

    }//GEN-LAST:event_jtFilterCaretPositionChanged

    private void jtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtFilterActionPerformed
   findUsers();
    }//GEN-LAST:event_jtFilterActionPerformed

    private void quantity1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantity1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantity1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        admin();
        if(yes==1){
      inventory m=new inventory();
        // this.setVisible(true);
         m.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
           admin();
        if(yes==1){      
        insert m=new insert();
                   // this.setVisible(true);
                    m.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
             admin();
        if(yes==1){   
        transactions m=new transactions();
                    //this.setVisible(true);
                    m.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       Calc me=new Calc();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        CalendarProgram m = new CalendarProgram();
        m.main();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
                     admin();
        if(yes==1){ 
        SendMail m=new SendMail();
        try {
            SendMail.main();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sellform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(sellform.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
                      admin();
        if(yes==1){ 
        Transupdate m=new Transupdate();
        // this.setVisible(true);
               m.setVisible(true);
                       }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       admin();
        if(yes==1){ 
        debtors m=new debtors();
      
               m.setVisible(true); 
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
       admin();
        if(yes==1){
        credits m=new credits();
        m.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        admin();
        if(yes==1){
         reports m=new reports();
          m.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        admin();
        if(yes==1){
        changepassuser m=new changepassuser();
             
               m.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        admin();
        if(yes==1){
        changepass m=new changepass();
       
               m.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
         admin();
        if(yes==1){
       debtscredits m=new debtscredits();
       m.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        about b=new about();
       b.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        try
    {
      String url = "help.html";
      Desktop.getDesktop().browse(URI.create(url));
    }
    catch (IOException e1)
    {
       JOptionPane.showMessageDialog(null, "NOT AVAILABLE");
    }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
       System.exit(1);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
         admin();
        if(yes==1){
       importexport m=new importexport();
       m.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
       admin();
        if(yes==1){
       restore m=new restore();
       m.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem19ActionPerformed

public void ran(){

           Random rand= new Random();
          nr = rand.nextInt(50000)+1;
          
          recieptbtn();
}
public void ran1(){

           Random rand= new Random();
          nr = rand.nextInt(50000)+1;

}
public void recieptbtn(){
     
    try
        {

            int stru=nr;

          Connection con = getConnection();
            String str="";
            
            str="select * from recieptsale where  invoiceno =?";
            
           PreparedStatement pst=con.prepareStatement(str);
         
           pst.setInt(1, stru);
          
           ResultSet rs;
          
           rs=pst.executeQuery();
          
           if (rs.next())
               
           {
              
               ran();
               
           }
           else
           {
           //  try {
           //Show_Users_In_JTable5();
      // } catch (ParseException ex) {
      //     Logger.getLogger(sellform.class.getName()).log(Level.SEVERE, null, ex);
      // }
        
        SimpleDateFormat df = new SimpleDateFormat();
String receiptDetailLine;
 String pspace = "               ";//15-spaces



df.applyPattern("dd/MM/yyyy HH:mm:ss");
    String strText = null;
    final String LF = "\n";// text string to output
    int lineStart;           // start index of line in jcartarea
    int lineEnd;             // end index of line in jcartarea
    int lineNumber;
    int lineCount;
    final String SPACE = "          ";//10 spaces
    final String SPACES = "         ";//9
    final String uline = "________________________________________";
    final String dline = "----------------------------------------";
    String greetings = "KARIBU TENA";
    receiptDetailLine = "asdasdasda";
Connection con1 = getConnection();
 String sql = "INSERT INTO `recieptsale`( `total`, `invoiceno`, `updated_at`) VALUES ('"+totalpurchase.getText()+"','"+nr+"',now())";
 PreparedStatement pst1=con1.prepareStatement(sql);
                pst1.executeUpdate(sql);
                  pst1.close();
               // rs4.close();
              
                con1.close();


       
 String printedLine = "       Service Charge Complimentary";
    //jcartarea.append(printedLine + LF);
//totalprice.getText();
 
jcartarea.append( "\n                   " +"total "+totalpurchase.getText()+ "\n");
jcartarea.append(uline + "\n");
   // jcartarea.append("Order Ref:" + "   " + receiptDetailLine + "\n");
    jcartarea.append(dline + "\n");
jcartarea.append( "\n" +"serverd by    "+on);
    jcartarea.append(LF + SPACES + name + "\n" + SPACE + greetings + LF);
    jcartarea.append( "\n" +"RECIEPT NO    "+nr+"\n");
    jcartarea.append(df.format(new Date()) + LF);

        a();   
        reset();

            }
           con.close();
           rs.close();
           pst.close();

        }
        catch (Exception a)
        {
            System.err.println(a);

        }  
}
      private void tableInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
 
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
            java.util.logging.Logger.getLogger(sellform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sellform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sellform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sellform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new sellform().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtocartbtn;
    private javax.swing.JTextField cashin;
    private javax.swing.JTextField change;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextArea jcartarea;
    private javax.swing.JTextField jtFilter;
    private javax.swing.JTextField price;
    private javax.swing.JLabel pricelbl;
    private javax.swing.JTextField productid;
    private javax.swing.JLabel productidlbl;
    private javax.swing.JTextField productname;
    private javax.swing.JLabel productnamelbl;
    private javax.swing.JTextField quantity1;
    private javax.swing.JLabel quantitylbl;
    private javax.swing.JButton recieptbtn;
    private javax.swing.JButton resetbtn;
    private javax.swing.JLabel shopname;
    public javax.swing.JTable table;
    private javax.swing.JTextField totalprice;
    private javax.swing.JTextField totalpurchase;
    // End of variables declaration//GEN-END:variables


    private  class ReceiptPrint implements Printable {
SimpleDateFormat df = new SimpleDateFormat();
String receiptDetailLine;
public static final String pspace = "               ";//15-spaces
        
public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
        throws PrinterException {
 
    df.applyPattern("dd/MM/yyyy HH:mm:ss");
    String strText = null;
    final String LF = "\n";// text string to output
    int lineStart;           // start index of line in jcartarea
    int lineEnd;             // end index of line in jcartarea
    int lineNumber;
    int lineCount;
    final String SPACE = "          ";//10 spaces
    final String SPACES = "         ";//9
    final String uline = "________________________________________";
    final String dline = "----------------------------------------";
    String greetings = "KARIBU TENA";
    receiptDetailLine = "asdasdasda";

    Graphics2D g2d = (Graphics2D) graphics;
    Font font = new Font("MONOSPACED", Font.BOLD, 9);

    if (pageIndex < 0 || pageIndex >= 1) {
        return Printable.NO_SUCH_PAGE;
    }

    g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

    g2d.setFont(font);
    lineNumber = 0;
    lineCount = jcartarea.getLineCount();
    strText = jcartarea.getText();
    while (lineCount != 0) {
        try {

            lineStart = jcartarea.getLineStartOffset(lineNumber);
            lineEnd = jcartarea.getLineEndOffset(lineNumber);
            strText = jcartarea.getText(lineStart, lineEnd - lineStart);
        } catch (Exception exception) {
            System.out.println("Printing error:" + exception);                  // have to catch BadLocationException
        }

        g2d.drawString(strText, 1, (lineNumber + 1) * 18);
        //spacing    between lines
        lineNumber = lineNumber + 1;
        lineCount--;
    }
    return Printable.PAGE_EXISTS;
    }

    /**
     *
     * @param query
     * @param message
     */



}
}
