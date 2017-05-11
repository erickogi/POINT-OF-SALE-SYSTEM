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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

/**
 *
 * @author kimani kogi
 */
public class debtors extends javax.swing.JFrame {
   int bu = 0;
  static String on;
  int bo = 0;
  int yu = 0;
  DefaultTableModel model = new DefaultTableModel();
  double tt = 0.0D;
  DefaultTableModel model1 = new DefaultTableModel();
  String value;
  String name;
  String contact;
  String tag;
  String user_name;
  String b;
  double c;
  double g;
  double h;
  String l;
  double x;
  int n;
  int nr;
  int nr1;
  int wq;
  
 /**

     * Creates new form debtors
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
    public debtors() {
 this.jTable_Display_Users = new JTable(this.model);
    this.jTextField2 = new JTextField();
    final TableRowSorter<TableModel> rowSorter = new TableRowSorter(this.jTable_Display_Users.getModel());
    this.jTable_Display_Users.setRowSorter(rowSorter);
    this.jTextField2.getDocument().addDocumentListener(new DocumentListener()
    {
      public void insertUpdate(DocumentEvent e)
      {
        String text = debtors.this.jTextField2.getText();
        if (text.trim().length() == 0) {
          rowSorter.setRowFilter(null);
        } else {
          rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, new int[0]));
        }
      }
      
      public void removeUpdate(DocumentEvent e)
      {
        String text = debtors.this.jTextField2.getText();
        if (text.trim().length() == 0) {
          rowSorter.setRowFilter(null);
        } else {
          rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, new int[0]));
        }
      }
      
      public void changedUpdate(DocumentEvent e)
      {
        throw new UnsupportedOperationException("Not supported yet.");
      }
    });
    initComponents();
     methods n=new methods();
     setTilteImage();
    String i=n.setIconImage();
    this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(i)));
    try
    {
      Show_Users_In_JTable4();
    }
    catch (ParseException ex)
    {
      Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
    }
    ran1();
    Show_Users_In_JTable();
    
    inr();
    try
    {
      sum1();
    }
    catch (Exception ex)
    {
      Logger.getLogger(debtscredits.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void rani()
  {
    Random rand = new Random();
    this.nr1 = (rand.nextInt(50000) + 1);
    
    inr();
  }
  
  public void inr()
  {
    try
    {
      int stru = this.nr1;
      
      Connection con = getConnection();
      String str = "";
      
      str = "select * from cinvoiced where  invoiceno =?";
      
      PreparedStatement pst = con.prepareStatement(str);
      
      pst.setInt(1, stru);
      
      ResultSet rs = pst.executeQuery();
      if (rs.next())
      {
        rani();
      }
      else
      {
        SimpleDateFormat df = new SimpleDateFormat();
        
        df.applyPattern("dd/MM/yyyy HH:mm:ss");
        String strText = null;
        String LF = "\n";
        
        String SPACE = "          ";
        String SPACES = "     ";
        String uline = "_____________________________________________________________________________________________________________________";
        String dline = "---------------------------------------------------------------------------------------------------------------------";
        String greetings = "THANKS FOR YOUR VISIT";
        String receiptDetailLine = "";
        
        this.jcartarea.append("   customer invoice                               NO  " + this.nr1 + "                                 " + df.format(new Date()) + "\n");
        this.jcartarea.append("_____________________________________________________________________________________________________________________\n");
        this.jcartarea.append("    " + this.name + "\n");
        
        this.jcartarea.append("    " + this.tag + "\n");
        this.jcartarea.append("    " + this.contact + "\n" + "\n");
        this.jcartarea.append("                                            DETAILS\n");
        
        this.jcartarea.append("_____________________________________________________________________________________________________________________\n");
        
        this.jcartarea.append("---------------------------------------------------------------------------------------------------------------------\n");
        this.jcartarea.append("   product                     quantity                      Price per                          total     id\n");
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
  
  public void a()
  {
    PageFormat format = new PageFormat();
    Paper paper = new Paper();
    
    double paperWidth = 8.3D;
    double paperHeight = 11.7D;
    double leftMargin = 0.12D;
    double rightMargin = 0.1D;
    double topMargin = 0.0D;
    double Margin = 0.0D;
    double bottomMargin = 0.01D;
    
    paper.setSize(paperWidth * 200.0D, paperHeight * 200.0D);
    paper.setImageableArea(leftMargin * 200.0D, topMargin * 200.0D, (paperWidth - leftMargin - rightMargin) * 200.0D, (paperHeight - topMargin - bottomMargin) * 200.0D);
    
    format.setPaper(paper);
    
    PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
    aset.add(OrientationRequested.PORTRAIT);
    
    PrinterJob printerJob = PrinterJob.getPrinterJob();
    Printable printable = new ReceiptPrint();
    
    format = printerJob.validatePage(format);
    boolean don = printerJob.printDialog();
    printerJob.setPrintable(printable, format);
    try
    {
      printerJob.print(aset);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public Connection getConnection()
  {
    Connection con = null;
    try
    {
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "123ERYcog.");
    }
    catch (Exception ex)
    {
      System.out.println(ex.getMessage());
    }
    return con;
  }
  
  public ArrayList<recptu> getUsersList4()
    throws ParseException
  {
    ArrayList<recptu> usersList4 = new ArrayList();
    
    Connection con = getConnection();
    
    String query4 = "SELECT * FROM `reciept` ";
    try
    {
      Statement st4 = con.createStatement();
      
      ResultSet rs4 = st4.executeQuery(query4);
      while (rs4.next())
      {
        recptu user = new recptu(rs4.getString("name"), rs4.getString("contact"), rs4.getString("tag"), rs4.getString("bsemail"), rs4.getString("toemail"), rs4.getString("epassword"));
        
        usersList4.add(user);
      }
      st4.close();
      rs4.close();
      
      con.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return usersList4;
  }
  
  public void Show_Users_In_JTable4()
    throws ParseException
  {
    ArrayList<recptu> list4 = getUsersList4();
    for (int i = 0; i < list4.size(); i++)
    {
      this.name = ((recptu)list4.get(i)).getName();
      
      this.contact = ((recptu)list4.get(i)).getContact();
      
      this.tag = ((recptu)list4.get(i)).getTag();
    }
  }
  
  public ArrayList<invoiced> getUsersList(String ValToSearch)
  {
    ArrayList<invoiced> usersList = new ArrayList();
    
    Connection connection = getConnection();
    
    String query = "SELECT * FROM `invoiced` WHERE CONCAT(`id`, `iname`, `product`, `updated_at`) LIKE '%" + ValToSearch + "%'";
    try
    {
      Statement st = connection.createStatement();
      
      ResultSet rs = st.executeQuery(query);
      while (rs.next())
      {
        invoiced user = new invoiced(rs.getInt("id"), rs.getString("iname"), rs.getString("product"), rs.getString("price product"), rs.getString("total"), rs.getString("quantity"), rs.getString("updated_at"));
        
        usersList.add(user);
      }
      st.close();
      rs.close();
      
      connection.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return usersList;
  }
  
  public ArrayList<invoiced> getUsersList1()
  {
    ArrayList<invoiced> usersList1 = new ArrayList();
    
    Connection connection = getConnection();
    
    String query1 = "SELECT * FROM invoiced WHERE DATE(updated_at) = DATE(NOW())";
    try
    {
      Statement st1 = connection.createStatement();
      
      ResultSet rs1 = st1.executeQuery(query1);
      while (rs1.next())
      {
        invoiced user = new invoiced(rs1.getInt("id"), rs1.getString("iname"), rs1.getString("product"), rs1.getString("price product"), rs1.getString("total"), rs1.getString("quantity"), rs1.getString("updated_at"));
        
        usersList1.add(user);
      }
      st1.close();
      
      rs1.close();
      connection.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return usersList1;
  }
  
  public void Show_Users_In_JTable1()
  {
    ArrayList<invoiced> list1 = getUsersList1();
    
    DefaultTableModel model = (DefaultTableModel)this.jTable_Display_Users.getModel();
    model.setColumnIdentifiers(new Object[] { "ID", "name", "product", "per", "quantity", "total", "date" });
    Object[] row = new Object[7];
    for (int i = 0; i < list1.size(); i++)
    {
      row[0] = Integer.valueOf(((invoiced)list1.get(i)).getId());
      
      row[1] = ((invoiced)list1.get(i)).getIname();
      row[2] = ((invoiced)list1.get(i)).getProduct();
      
      row[3] = ((invoiced)list1.get(i)).getPrice_product();
      
      row[4] = ((invoiced)list1.get(i)).getQuantity();
      row[5] = ((invoiced)list1.get(i)).getTotal();
      row[6] = ((invoiced)list1.get(i)).getUpdated_at();
      
      model.addRow(row);
    }
  }
  
  public void Show_Users_In_JTable()
  {
    ArrayList<invoiced> list = getUsersList(this.jTextField2.getText());
    DefaultTableModel model = new DefaultTableModel();
    
    model.setColumnIdentifiers(new Object[] { "ID", "name", "product", "per", "quantity", "total", "date" });
    Object[] row = new Object[7];
    for (int i = 0; i < list.size(); i++)
    {
      row[0] = Integer.valueOf(((invoiced)list.get(i)).getId());
      
      row[1] = ((invoiced)list.get(i)).getIname();
      row[2] = ((invoiced)list.get(i)).getProduct();
      
      row[3] = ((invoiced)list.get(i)).getPrice_product();
      
      row[4] = ((invoiced)list.get(i)).getQuantity();
      row[5] = ((invoiced)list.get(i)).getTotal();
      row[6] = ((invoiced)list.get(i)).getUpdated_at();
      
      model.addRow(row);
    }
    this.jTable_Display_Users.setModel(model);
  }
  
  public void executeSQlQuery(String query, String message)
  {
    Connection con = getConnection();
    try
    {
      Statement st = con.createStatement();
      if (st.executeUpdate(query) == 1)
      {
        DefaultTableModel model = (DefaultTableModel)this.jTable_Display_Users.getModel();
        
        model.setRowCount(0);
        
        Show_Users_In_JTable();
        
        JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
      }
      else
      {
        JOptionPane.showMessageDialog(null, "Data Not " + message);
      }
      st.close();
      
      con.close();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  public void executeSQlQueryu(String queryu, String messageu)
  {
    Connection con = getConnection();
    try
    {
      Statement st = con.createStatement();
      if (st.executeUpdate(queryu) == 1)
      {
        ii();
        JOptionPane.showMessageDialog(null, "Data " + messageu + " Succefully");
      }
      else
      {
        JOptionPane.showMessageDialog(null, "Data Not " + messageu + "\n no such product on your inventory check the name");
      }
      st.close();
      
      con.close();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  public void select()
    throws Exception
  {
    Connection con = getConnection();
    Statement st2 = con.createStatement();
    Statement st0 = con.createStatement();
    Statement st3 = con.createStatement();
    ResultSet res7 = st2.executeQuery("SELECT name FROM cinvoiced  WHERE invoiceno=" + this.checkinvoiceno.getText() + "");
    ResultSet res8 = st0.executeQuery("SELECT total FROM cinvoiced  WHERE invoiceno=" + this.checkinvoiceno.getText() + " ");
    ResultSet res9 = st3.executeQuery("SELECT updated_at FROM cinvoiced  WHERE invoiceno=" + this.checkinvoiceno.getText() + " ");
    if ((res7.next()) && (res8.next()) && (res9.next()))
    {
      JOptionPane.showMessageDialog(null, "" + res7.getString("name") + "'s  invoice  " + "\n" + " with     " + res8.getString("total") + "  shillings" + "\n" + "given on    " + res9.getString("updated_at"));
      st2.close();
      st0.close();
      st3.close();
      res7.close();
      res8.close();
      res9.close();
      
      st2.close();
      con.close();
    }
    else
    {
      JOptionPane.showMessageDialog(null, "NO DATA ");
    }
  }
  
  public void sum1()
    throws Exception
  {
    double sum = 0.0D;
    
    Connection con = getConnection();
    Statement st = con.createStatement();
    
    ResultSet res = st.executeQuery("SELECT SUM(total) FROM invoiced");
    while (res.next())
    {
      double c = res.getInt(1);
      
      sum += c;
    }
    this.sum1.setText(Double.toString(sum));
    st.close();
    
    res.close();
    con.close();
  }
  
  public void sum2()
    throws Exception
  {
    double sum = 0.0D;
    try
    {
      Connection con = getConnection();
      Statement st = con.createStatement();
      
      ResultSet res = st.executeQuery("SELECT SUM(total) FROM invoiced  WHERE iname='" + this.searchname.getText() + "' ");
      while (res.next())
      {
        double c = res.getInt(1);
        
        sum += c;
      }
      JOptionPane.showMessageDialog(null, "TOTAL FOR " + this.searchname.getText() + " is " + sum + " ");
      st.close();
      
      res.close();
      con.close();
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null, "no data");
      e.printStackTrace();
    }
  }
  
  public void sum3(String query, String message)
  {
    Connection connection = getConnection();
    try
    {
      Statement st = connection.createStatement();
      
      ResultSet res = st.executeQuery(query);
      while (res.next())
      {
        double c = res.getInt(1);
        double e = 0.0D;
        double sum = e + c;
        this.sum1.setText(Double.toString(sum));
      }
      st.close();
      res.close();
      connection.close();
    }
    catch (Exception ex)
    {
      JOptionPane.showMessageDialog(null, " error");
      ex.printStackTrace();
    }
  }
  
  public ArrayList<User_1> ListUsers(String ValToSearch)
  {
    ArrayList<User_1> usersList = new ArrayList();
    try
    {
      Connection con = getConnection();
      Statement st = con.createStatement();
      String searchQuery = "SELECT * FROM `users` WHERE CONCAT(`id`, `fname`, `lname`, `age`) LIKE '%" + ValToSearch + "%'";
      ResultSet rs = st.executeQuery(searchQuery);
      while (rs.next())
      {
        User_1 user = new User_1(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("age"), rs.getString("bp"), rs.getString("from"));
        
        usersList.add(user);
      }
      st.close();
      rs.close();
      
      con.close();
    }
    catch (Exception ex)
    {
      System.out.println(ex.getMessage());
    }
    return usersList;
  }
  
  public void findUsers()
  {
    ArrayList<User_1> users = ListUsers(this.jTextField2.getText());
    
    this.model1.setColumnIdentifiers(new Object[] { "ID", "name", "quantity", "price", "buy price" });
    Object[] row = new Object[5];
    for (int i = 0; i < users.size(); i++)
    {
      row[0] = Integer.valueOf(((User_1)users.get(i)).getId());
      row[1] = ((User_1)users.get(i)).getFname();
      row[2] = ((User_1)users.get(i)).getLname();
      row[3] = ((User_1)users.get(i)).getAge();
      row[4] = ((User_1)users.get(i)).getBp();
      this.model1.addRow(row);
    }
    this.jTable_Display_Users.setModel(this.model1);
  }
  
  public void b()
  {
    PageFormat format = new PageFormat();
    Paper paper = new Paper();
    
    double paperWidth = 3.0D;
    double paperHeight = 3.69D;
    double leftMargin = 0.22D;
    double rightMargin = 0.1D;
    double topMargin = 0.0D;
    double Margin = 0.0D;
    double bottomMargin = 0.01D;
    
    paper.setSize(paperWidth * 200.0D, paperHeight * 200.0D);
    paper.setImageableArea(leftMargin * 200.0D, topMargin * 200.0D, (paperWidth - leftMargin - rightMargin) * 200.0D, (paperHeight - topMargin - bottomMargin) * 200.0D);
    
    format.setPaper(paper);
    
    PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
    aset.add(OrientationRequested.PORTRAIT);
    
    PrinterJob printerJob = PrinterJob.getPrinterJob();
    Printable printable = new ReceiptPrintb();
    
    format = printerJob.validatePage(format);
    boolean don = printerJob.printDialog();
    printerJob.setPrintable(printable, format);
    try
    {
      printerJob.print(aset);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
 private class ReceiptPrintb
    implements Printable
  {
    SimpleDateFormat df = new SimpleDateFormat();
    String receiptDetailLine;
    public static final String pspace = "               ";
    
    private ReceiptPrintb() {}
    
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
      throws PrinterException
    {
      this.df.applyPattern("dd/MM/yyyy HH:mm:ss");
      String strText = null;
      String LF = "\n";
      
      String SPACE = "          ";
      String SPACES = "         ";
      String uline = "________________________________________";
      String dline = "----------------------------------------";
      String greetings = "KARIBU TENA";
      this.receiptDetailLine = "asdasdasda";
      
      Graphics2D g2d = (Graphics2D)graphics;
      Font font = new Font("MONOSPACED", 1, 9);
      if ((pageIndex < 0) || (pageIndex >= 1)) {
        return 1;
      }
      g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
      
      g2d.setFont(font);
      int lineNumber = 0;
      int lineCount = debtors.this.jcartarea.getLineCount();
      strText = debtors.this.jcartarea.getText();
      while (lineCount != 0)
      {
        try
        {
          int lineStart = debtors.this.jcartarea.getLineStartOffset(lineNumber);
          int lineEnd = debtors.this.jcartarea.getLineEndOffset(lineNumber);
          strText = debtors.this.jcartarea.getText(lineStart, lineEnd - lineStart);
        }
        catch (Exception exception)
        {
          System.out.println("Printing error:" + exception);
        }
        g2d.drawString(strText, 1, (lineNumber + 1) * 18);
        
        lineNumber += 1;
        lineCount--;
      }
      return 0;
    }
  }
  public ArrayList<servedby> getUsersList5()
    throws ParseException
  {
    ArrayList<servedby> usersList5 = new ArrayList();
    
    Connection con = getConnection();
    
    String query5 = "SELECT * FROM `servedby` ";
    try
    {
      Statement st5 = con.createStatement();
      
      ResultSet rs5 = st5.executeQuery(query5);
      while (rs5.next())
      {
        servedby user = new servedby(rs5.getString("user_name"));
        
        usersList5.add(user);
      }
      st5.close();
      rs5.close();
      
      con.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return usersList5;
  }
  
  public ArrayList<invoiced> getUsersListw()
  {
    ArrayList<invoiced> usersList1 = new ArrayList();
    
    Connection connection = getConnection();
    
    String query1 = "SELECT * FROM invoiced WHERE WEEK(updated_at)=WEEK(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())";
    try
    {
      Statement st1 = connection.createStatement();
      
      ResultSet rs1 = st1.executeQuery(query1);
      while (rs1.next())
      {
        invoiced user = new invoiced(rs1.getInt("id"), rs1.getString("iname"), rs1.getString("product"), rs1.getString("price product"), rs1.getString("total"), rs1.getString("quantity"), rs1.getString("updated_at"));
        
        usersList1.add(user);
      }
      st1.close();
      
      rs1.close();
      connection.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return usersList1;
  }
  
  public void Show_Users_In_JTablew()
  {
    ArrayList<invoiced> list1 = getUsersListw();
    
    DefaultTableModel model = (DefaultTableModel)this.jTable_Display_Users.getModel();
    model.setColumnIdentifiers(new Object[] { "ID", "name", "product", "per", "quantity", "total", "date" });
    Object[] row = new Object[7];
    for (int i = 0; i < list1.size(); i++)
    {
      row[0] = Integer.valueOf(((invoiced)list1.get(i)).getId());
      
      row[1] = ((invoiced)list1.get(i)).getIname();
      row[2] = ((invoiced)list1.get(i)).getProduct();
      
      row[3] = ((invoiced)list1.get(i)).getPrice_product();
      
      row[4] = ((invoiced)list1.get(i)).getQuantity();
      row[5] = ((invoiced)list1.get(i)).getTotal();
      row[6] = ((invoiced)list1.get(i)).getUpdated_at();
      
      model.addRow(row);
    }
  }
  
  public ArrayList<invoiced> getUsersListm()
  {
    ArrayList<invoiced> usersList1 = new ArrayList();
    
    Connection connection = getConnection();
    
    String query1 = "SELECT * FROM invoiced WHERE MONTH(updated_at)=MONTH(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())";
    try
    {
      Statement st1 = connection.createStatement();
      
      ResultSet rs1 = st1.executeQuery(query1);
      while (rs1.next())
      {
        invoiced user = new invoiced(rs1.getInt("id"), rs1.getString("iname"), rs1.getString("product"), rs1.getString("price product"), rs1.getString("total"), rs1.getString("quantity"), rs1.getString("updated_at"));
        
        usersList1.add(user);
      }
      st1.close();
      
      rs1.close();
      connection.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return usersList1;
  }
  
  public void Show_Users_In_JTablem()
  {
    ArrayList<invoiced> list1 = getUsersListm();
    
    DefaultTableModel model = (DefaultTableModel)this.jTable_Display_Users.getModel();
    model.setColumnIdentifiers(new Object[] { "ID", "name", "product", "per", "quantity", "total", "date" });
    Object[] row = new Object[7];
    for (int i = 0; i < list1.size(); i++)
    {
      row[0] = Integer.valueOf(((invoiced)list1.get(i)).getId());
      
      row[1] = ((invoiced)list1.get(i)).getIname();
      row[2] = ((invoiced)list1.get(i)).getProduct();
      
      row[3] = ((invoiced)list1.get(i)).getPrice_product();
      
      row[4] = ((invoiced)list1.get(i)).getQuantity();
      row[5] = ((invoiced)list1.get(i)).getTotal();
      row[6] = ((invoiced)list1.get(i)).getUpdated_at();
      
      model.addRow(row);
    }
  }
  
  public ArrayList<invoiced> getUsersListd()
    throws ParseException
  {
    ArrayList<invoiced> usersList4 = new ArrayList();
    
    Connection connection = getConnection();
    try
    {
      String query4 = "SELECT * FROM invoiced WHERE DAY(updated_at)=" + this.day.getText() + " AND YEAR(updated_at)=" + this.year.getText() + " AND MONTH(updated_at)=" + this.month.getText() + "";
      
      Statement st4 = connection.createStatement();
      ResultSet rs4 = st4.executeQuery(query4);
      while (rs4.next())
      {
        invoiced user = new invoiced(rs4.getInt("id"), rs4.getString("iname"), rs4.getString("product"), rs4.getString("price product"), rs4.getString("total"), rs4.getString("quantity"), rs4.getString("updated_at"));
        
        usersList4.add(user);
      }
      st4.close();
      rs4.close();
      
      connection.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return usersList4;
  }
  
  public void Show_Users_In_JTabled()
    throws ParseException
  {
    ArrayList<invoiced> list4 = getUsersListd();
    
    DefaultTableModel model = (DefaultTableModel)this.jTable_Display_Users.getModel();
    model.setColumnIdentifiers(new Object[] { "ID", "name", "product", "per", "quantity", "total", "date" });
    Object[] row = new Object[7];
    for (int i = 0; i < list4.size(); i++)
    {
      row[0] = Integer.valueOf(((invoiced)list4.get(i)).getId());
      
      row[1] = ((invoiced)list4.get(i)).getIname();
      row[2] = ((invoiced)list4.get(i)).getProduct();
      
      row[3] = ((invoiced)list4.get(i)).getPrice_product();
      
      row[4] = ((invoiced)list4.get(i)).getQuantity();
      row[5] = ((invoiced)list4.get(i)).getTotal();
      row[6] = ((invoiced)list4.get(i)).getUpdated_at();
      
      model.addRow(row);
    }
  }
  
  public void Show_Users_In_JTable5()
    throws ParseException
  {
    ArrayList<servedby> list5 = getUsersList5();
    for (int i = 0; i < list5.size(); i++) {
      this.user_name = ((servedby)list5.get(i)).getUserName();
    }
  }
  
  public void ii()
  {
    String query = "INSERT INTO `invoiced`(`iname`, `product`, `price product`,`total`,`quantity`,`updated_at`) VALUES ('" + this.iname.getText() + "','" + this.product.getText() + "','" + this.perproduct.getText() + "','" + this.tamount.getText() + "','" + this.quantity.getText() + "',now())";
    executeSQlQuery(query, "Inserted");
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
        jTextField2 = new javax.swing.JTextField();
        product = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tamount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        perproduct = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jcartarea = new javax.swing.JTextArea();
        namei = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        iname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        totalp = new javax.swing.JTextField();
        checkinvoiceno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sum1 = new javax.swing.JTextField();
        searchname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        year = new javax.swing.JTextField();
        month = new javax.swing.JTextField();
        day = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 204));

        jPanel1.setBackground(new java.awt.Color(255, 153, 204));

        jTable_Display_Users.setBackground(new java.awt.Color(51, 255, 204));
        jTable_Display_Users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_Display_Users.setRowHeight(40);
        jTable_Display_Users.setRowMargin(7);
        jTable_Display_Users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_UsersMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable_Display_UsersMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_Users);

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

        product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productActionPerformed(evt);
            }
        });

        jLabel4.setText("NAME");

        jLabel5.setText("PIECIES");

        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });

        jLabel6.setText("AMOUNT");

        jLabel7.setText("PER PIECE");

        jcartarea.setColumns(20);
        jcartarea.setRows(5);
        jScrollPane3.setViewportView(jcartarea);

        namei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameiActionPerformed(evt);
            }
        });

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("PRINT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("PRODUCT");

        jButton4.setBackground(new java.awt.Color(204, 255, 204));
        jButton4.setText("ADD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("UPDATE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 0, 0));
        jButton6.setText("REMOVE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton3.setText("CLEAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        totalp.setText("0");

        jLabel2.setText("invoice no");

        jButton7.setText("check");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel3.setText("Total");

        jLabel11.setText("name");

        jButton8.setText("check");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("view inventory");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 102, 102));
        jButton9.setText("PAID");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("reciept");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayActionPerformed(evt);
            }
        });

        jButton12.setText("check date");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("today");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("week");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("month");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("all");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel8.setText("yyyy-mm-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iname)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(searchname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(checkinvoiceno, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7)
                            .addComponent(jButton8)))
                    .addComponent(product)
                    .addComponent(quantity)
                    .addComponent(tamount)
                    .addComponent(perproduct, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton12)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sum1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(namei, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalp, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namei, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(totalp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(sum1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(jToggleButton1))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(iname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(14, 14, 14)
                                .addComponent(product, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tamount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(perproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton4)
                                    .addComponent(jButton5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton9)
                                    .addComponent(jButton6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(checkinvoiceno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(searchname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton13)
                                    .addComponent(jButton14))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton15)
                                    .addComponent(jButton16))
                                .addGap(16, 16, 16)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addComponent(jButton12)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        yu=0;
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void nameiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameiActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
    if (this.bo == 2) {
      recieptbtn();
    } else {
      printi();
    }
    }//GEN-LAST:event_jButton2ActionPerformed
  public void printi()
  {
    this.bu = 1;
    
    String t = this.namei.getText();
    this.jcartarea.append("\n                customer         " + t + "            \n");
    this.jcartarea.append("\n                Total           " + this.totalp.getText() + "            \n");
    String query = "INSERT INTO `cinvoiced`(`name`, `total`, `invoiceno`, `updated_at`) VALUES ('" + t + "','" + this.totalp.getText() + "','" + this.nr1 + "',now())";
    
    executeSQlQuery(query, "printing");
    a();
  }
    private void productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
          
           String g = this.product.getText();
    String queryu = "UPDATE users SET lname = lname-'" + this.quantity.getText() + "'  WHERE fname='" + g + "'";
    executeSQlQueryu(queryu, "updated");
    
    this.iname.setText(null);
    this.id.setText(null);
    this.quantity.setText(null);
    this.perproduct.setText(null);
    this.product.setText(null);
    this.tamount.setText(null);
    this.yu = 0;
    try
    {
      sum1();
    }
    catch (Exception ex)
    {
      Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable_Display_UsersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_UsersMousePressed
    //     int i = jTable_Display_Users.getSelectedRow();
     //   TableModel model1 = jTable_Display_Users.getModel();
 //iname.setText(model1.getValueAt(i, 1).toString());
    }//GEN-LAST:event_jTable_Display_UsersMousePressed

    private void jTable_Display_UsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_UsersMouseClicked

    int i = this.jTable_Display_Users.getSelectedRow();
    if (this.yu == 0)
    {
      TableModel model = this.jTable_Display_Users.getModel();
      this.namei.setText(model.getValueAt(i, 1).toString());
      String k = model.getValueAt(i, 2).toString();
      this.b = k;
      String a = model.getValueAt(i, 3).toString();
      this.c = Double.valueOf(a).doubleValue();
      String z = model.getValueAt(i, 0).toString();
      this.n = Integer.valueOf(z).intValue();
      String d = model.getValueAt(i, 4).toString();
      this.g = Double.valueOf(d).doubleValue();
      String e = model.getValueAt(i, 5).toString();
      this.h = Double.valueOf(e).doubleValue();
      String f = model.getValueAt(i, 6).toString();
      this.l = f;
      this.id.setText(model.getValueAt(i, 0).toString());
      this.iname.setText(model.getValueAt(i, 1).toString());
      this.product.setText(model.getValueAt(i, 2).toString());
      this.quantity.setText(model.getValueAt(i, 4).toString());
      this.tamount.setText(model.getValueAt(i, 5).toString());
      this.perproduct.setText(model.getValueAt(i, 3).toString());
    }
    else
    {
      TableModel model1 = this.jTable_Display_Users.getModel();
      this.iname.setText(null);
      this.product.setText(null);
      this.quantity.setText(null);
      this.tamount.setText(null);
      this.perproduct.setText(null);
      this.product.setText(model1.getValueAt(i, 1).toString());
      this.perproduct.setText(model1.getValueAt(i, 3).toString());
    }
    }//GEN-LAST:event_jTable_Display_UsersMouseClicked
    private void jTable_Display_UsersMouseClicked1(java.awt.event.MouseEvent evt) {                                                  
//int i = jTable_Display_Users.getSelectedRow();
 //TableModel model1 = jTable_Display_Users.getModel();
 //namei.setText(model1.getValueAt(i, 1).toString());
    }   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (this.bo == 0)
    {
      if ((this.bu == 0) || (this.bu == 2))
      {
        String tiup = this.totalp.getText();
        double tps = Double.valueOf(tiup).doubleValue();
        
        double top = tps + this.h;
        String tp = Double.toString(top);
        this.totalp.setText(tp);
        String newline = "\n";
        this.jcartarea.append("    " + this.b + "                          " + this.g + "                    " + this.c + "                      " + this.h + "          " + this.n + "\n");
        
        this.jcartarea.setEditable(false);
        this.bu = 2;
      }
      else
      {
        JOptionPane.showMessageDialog(null, "!!!PRESS CLEAR BUTTON ABOVE RECIEPT PREVIEW FIRST");
      }
    }
    else {
      JOptionPane.showMessageDialog(null, "!!!PRESS CLEAR BUTTON ABOVE RECIEPT PREVIEW FIRST");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         this.bu = 0;
    this.bo = 0;
    double uo = 0.0D;
    String tp = Double.toString(uo);
    this.jcartarea.setText(null);
    this.totalp.setText(tp);
    this.namei.setText(null);
    inr();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        Show_Users_In_JTable();
    try
    {
      sum1();
    }
    catch (Exception ex)
    {
      Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       try
    {
      select();
    }
    catch (Exception ex)
    {
      JOptionPane.showMessageDialog(null, "!!!error ..enter a valid name");
      Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         String query = "UPDATE `invoiced` SET `iname`='" + this.iname.getText() + "',`product`='" + this.product.getText() + "',`total`='" + this.tamount.getText() + "',`quantity`=" + this.quantity.getText() + " WHERE `id` = " + this.id.getText();
    
    executeSQlQuery(query, "Updated");
    try
    {
      sum1();
    }
    catch (Exception ex)
    {
      Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
    }
    this.iname.setText(null);
    this.id.setText(null);
    this.quantity.setText(null);
    this.perproduct.setText(null);
    this.product.setText(null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
String query = "DELETE FROM `invoiced` WHERE id = " + this.id.getText();
    
    executeSQlQuery(query, "Deleted");
    try
    {
      sum1();
    }
    catch (Exception ex)
    {
      Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
    }
    this.iname.setText(null);
    this.id.setText(null);
    this.quantity.setText(null);
    this.perproduct.setText(null);
    this.product.setText(null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       try
    {
      sum2();
    }
    catch (Exception ex)
    {
      JOptionPane.showMessageDialog(null, "!!!error ..enter a valid invoice ..MUST BE A NO");
      Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
 this.yu += 1;
    DefaultTableModel dm = (DefaultTableModel)this.jTable_Display_Users.getModel();
    dm.getDataVector().removeAllElements();
    dm.fireTableDataChanged();
    findUsers();       
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
String newline = "\n";
    if ((this.bu == 0) && (this.bo == 0))
    {
      this.jcartarea.setText(null);
      SimpleDateFormat df = new SimpleDateFormat();
      
      df.applyPattern("dd/MM/yyyy HH:mm:ss");
      String strText = null;
      String LF = "\n";
      
      String SPACE = "          ";
      String SPACES = "     ";
      String uline = "________________________________________";
      String dline = "----------------------------------------";
      String greetings = "THANKS FOR YOUR VISIT";
      String receiptDetailLine = "";
      
      this.jcartarea.append("        " + this.name + "\n");
      
      this.jcartarea.append("     " + this.tag + "\n");
      this.jcartarea.append("       " + this.contact + "\n" + "\n");
      this.jcartarea.append("     YOUR PUCHASES\n");
      
      this.jcartarea.append("________________________________________\n");
      
      this.jcartarea.append("----------------------------------------\n");
      this.jcartarea.append("Description     Qty       Price\n");
      this.bo = 2;
    }
    if (this.bu == 0)
    {
      String ab = this.quantity.getText();
      String ta = this.product.getText();
      String tb = this.tamount.getText();
      
      String tiup = this.totalp.getText();
      double tps = Double.valueOf(tiup).doubleValue();
      
      double tpsi = Double.valueOf(tb).doubleValue();
      double a = tps + tpsi;
      this.totalp.setText(Double.toString(a));
      
      String p = this.perproduct.getText();
      this.jcartarea.append(ta + "" + "\n");
      this.jcartarea.append("     " + ab + "    *    " + p + "   = " + tb + "\n");
      String query = "DELETE FROM `invoiced` WHERE id = " + this.id.getText();
      
      executeSQlQuery(query, "Deleted");
      try
      {
        sum1();
      }
      catch (Exception ex)
      {
        Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
      }
      try
      {
        Connection con = getConnection();
        
        String sql = "SELECT bp FROM users  WHERE fname='" + this.product.getText() + "'";
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
          this.value = rs.getString("bp");
        }
        stmt.close();
        rs.close();
        
        con.close();
      }
      catch (Exception ex)
      {
        Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
      }
      try
      {
        double y = Double.valueOf(this.value).doubleValue();
        double c = Double.parseDouble(this.quantity.getText());
        double k = y * c;
        Connection con = getConnection();
        String sql = "INSERT INTO `trans`(`bp`, `fname`, `lname`,`updated_at`, `age`) VALUES (" + k + ",'" + this.product.getText() + "','" + this.quantity.getText() + "',now()," + this.tamount.getText() + ")";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.executeUpdate(sql);
        pst.close();
        
        con.close();
      }
      catch (Exception e)
      {
        System.err.println(e);
      }
      this.iname.setText(null);
      this.id.setText(null);
      this.quantity.setText(null);
      this.perproduct.setText(null);
      this.product.setText(null);
    }
    else
    {
      JOptionPane.showMessageDialog(null, "!!!PRESS CLEAR BUTTON ABOVE RECIEPT PREVIEW FIRST");
    }
    }//GEN-LAST:event_jButton9ActionPerformed
 public void ran(){
    Random rand = new Random();
    this.nr1 = (rand.nextInt(50000) + 1);
    
    recieptbtn();
}
public void ran1(){
   
    Random rand = new Random();
    this.nr1 = (rand.nextInt(50000) + 1);
}
    public void recieptbtn(){
 try
    {
      int stru = this.nr1;
      
      Connection con = getConnection();
      String str = "";
      
      str = "select * from recieptsale where  invoiceno =?";
      
      PreparedStatement pst = con.prepareStatement(str);
      
      pst.setInt(1, stru);
      
      ResultSet rs = pst.executeQuery();
      if (rs.next())
      {
        ran();
      }
      else
      {
       // try
       // {
       //   Show_Users_In_JTable5();
       // }
       // catch (ParseException ex)
       // {
       //   Logger.getLogger(sellform.class.getName()).log(Level.SEVERE, null, ex);
       // }
        SimpleDateFormat df = new SimpleDateFormat();
        
        String pspace = "               ";
        
        df.applyPattern("dd/MM/yyyy HH:mm:ss");
        String strText = null;
        String LF = "\n";
        
        String SPACE = "          ";
        String SPACES = "         ";
        String uline = "_________________________________";
        String dline = "---------------------------------";
        String greetings = "KARIBU TENA";
        String receiptDetailLine = "asdasdasda";
        
        Connection con1 = getConnection();
        String sql = "INSERT INTO `recieptsale`( `total`, `invoiceno`, `updated_at`) VALUES ('" + this.totalp.getText() + "','" + this.nr1 + "',now())";
        PreparedStatement pst1 = con1.prepareStatement(sql);
        pst1.executeUpdate(sql);
        pst1.close();
        
        con1.close();
        String printedLine = "       Service Charge Complimentary";
        
        this.jcartarea.append("\n               total " + this.totalp.getText() + "\n");
        this.jcartarea.append("_________________________________\n");
        
        this.jcartarea.append("---------------------------------\n");
        this.jcartarea.append("\nserverd by    " + this.on);
        this.jcartarea.append("\n         " + this.name + "\n" + "          " + greetings + "\n");
        this.jcartarea.append("\nRECIEPT NO    " + this.nr1 + "\n");
        this.jcartarea.append(df.format(new Date()) + "\n");
        b();
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
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

    if (this.bo == 2) {
      recieptbtn();
    } else {
      printi();
    }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
        double ch = Double.parseDouble(this.quantity.getText());
    double nh = Double.parseDouble(this.perproduct.getText());
    double mh = ch * nh;
    this.tamount.setText(Double.toString(mh));
    }//GEN-LAST:event_quantityKeyReleased

    private void dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        DefaultTableModel dm = (DefaultTableModel)this.jTable_Display_Users.getModel();
    dm.getDataVector().removeAllElements();
    dm.fireTableDataChanged();
    Show_Users_In_JTable1();
    
    String query = "SELECT SUM(total) FROM invoiced  WHERE DATE(updated_at) = DATE(NOW())";
    sum3(query, "Inserted");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
      DefaultTableModel dm = (DefaultTableModel)this.jTable_Display_Users.getModel();
    dm.getDataVector().removeAllElements();
    dm.fireTableDataChanged();
    Show_Users_In_JTablew();
    String query = "SELECT SUM(total) FROM invoiced  WHERE WEEK(updated_at)=WEEK(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())";
    sum3(query, "Inserted");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
         DefaultTableModel dm = (DefaultTableModel)this.jTable_Display_Users.getModel();
    dm.getDataVector().removeAllElements();
    dm.fireTableDataChanged();
    Show_Users_In_JTablem();
    String query = "SELECT SUM(total) FROM invoiced";
    sum3(query, "Inserted");
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        DefaultTableModel dm = (DefaultTableModel)this.jTable_Display_Users.getModel();
    dm.getDataVector().removeAllElements();
    dm.fireTableDataChanged();
    Show_Users_In_JTable();
    String query = "SELECT SUM(total) FROM invoiced";
    sum3(query, "Inserted");
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
         try
    {
      String query = "SELECT SUM(total) FROM invoiced  WHERE DAY(updated_at)=" + this.day.getText() + " AND YEAR(updated_at)=" + this.year.getText() + " AND MONTH(updated_at)=" + this.month.getText() + "";
      
      sum3(query, "Inserted");
      DefaultTableModel dm = (DefaultTableModel)this.jTable_Display_Users.getModel();
      dm.getDataVector().removeAllElements();
      dm.fireTableDataChanged();
      
      Show_Users_In_JTabled();
    }
    catch (ParseException ex)
    {
      Logger.getLogger(transactions.class.getName()).log(Level.SEVERE, null, ex);
    }

    }//GEN-LAST:event_jButton12ActionPerformed

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
            java.util.logging.Logger.getLogger(debtors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(debtors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(debtors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(debtors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new debtors().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField checkinvoiceno;
    private javax.swing.JTextField day;
    private javax.swing.JTextField id;
    private javax.swing.JTextField iname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_Display_Users;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextArea jcartarea;
    private javax.swing.JTextField month;
    private javax.swing.JTextField namei;
    private javax.swing.JTextField perproduct;
    private javax.swing.JTextField product;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField searchname;
    private javax.swing.JTextField sum1;
    private javax.swing.JTextField tamount;
    private javax.swing.JTextField totalp;
    private javax.swing.JTextField year;
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
  //String printedLine = "       Service Charge Complimentary";
    //jcartarea.append(printedLine + LF);
//totalprice.getText();
//jcartarea.append( "\n" +"total "+totalpurchase.getText());
//jcartarea.append( "\n" +"serverd by    "+user_name);
    //jcartarea.append(LF + SPACES + name + "\n" + SPACE + greetings + LF);
    //jcartarea.append(df.format(new Date()) + LF);
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
 }
}
