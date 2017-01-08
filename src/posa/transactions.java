
package posa;

import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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
public class transactions extends javax.swing.JFrame {
  //JTextField jTextField1;
       //String dateString;
    //java.util.Date dater;


    /**
     * Creates new form transactions
     */
    public transactions() {


        initComponents();
         methods n=new methods();
   String t= n.setTitle();
   this.setTitle(t);
    String i=n.setIconImage();
    this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(i)));
          DefaultTableModel dm = (DefaultTableModel)jTable.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
        Show_Users_In_JTable();
        try {
            sum();
        } catch (Exception ex) {
            Logger.getLogger(transactions.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextField1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               jTextField2.requestFocus(); //To change body of generated methods, choose Tools | Templates.
            }
        });
          jTextField2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               jTextField3.requestFocus(); //To change body of generated methods, choose Tools | Templates.
            }
        });
           jTextField3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               //jTextField3.requestFocus(); //To change body of generated methods, choose Tools | Templates.
                  try {
            try {
                sum4();
            } catch (Exception ex) {
                Logger.getLogger(transactions.class.getName()).log(Level.SEVERE, null, ex);
            }
            // TODO add your handling code here:
            // Show_Users_In_JTable4();
//        DefaultTableModel dm = (DefaultTableModel)jTable.getModel();
//dm.getDataVector().removeAllElements();
//dm.fireTableDataChanged();
               DefaultTableModel dm = (DefaultTableModel)jTable.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
                               //sum4();
            Show_Users_In_JTable4();
        } catch (ParseException ex) {
            Logger.getLogger(transactions.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


        });
       // Show_Users_In_JTable();

    }
     public  void sum() throws Exception {
    double sum = 0;
    double sum1 = 0;
    //Class.forName("com.mysql.jdbc.Driver");
    //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
       // "root", "123ERYcog.");
     Connection connection = getConnection();
    Statement st = connection.createStatement();
    Statement st1 = connection.createStatement();
    ResultSet res = st.executeQuery("SELECT SUM(age) FROM trans");
    ResultSet res1 = st1.executeQuery("SELECT SUM(bp) FROM trans");
    while (res.next()&&res1.next()) {
      double c = res.getDouble(1);
      double c1 = res1.getDouble(1);
      sum1=c-c1;
      sum = sum + c;

    }
                  
    profit.setText(Double.toString(sum1));
   total.setText(Double.toString(sum));
    st.close();
                st1.close();
              res.close();
              res1.close();
               connection.close();
  }
//          public  void profit() throws Exception {
//    double sum1 = 0;
//    int a;
//    Class.forName("com.mysql.jdbc.Driver");
//    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
//        "root", "123ERYcog.");
//    Statement st1 = con.createStatement();
//    ResultSet res1 = st1.executeQuery("SELECT SUM(bp) FROM users  WHERE WEEK(updated_at)=WEEK(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())");
//    while (res1.next()) {
//      double c1 = res1.getInt(1);
//    a=Integer.valueOf(total.getText());
//      sum1 =c1-a;
//      
//
//    }
//   profit.setText(Double.toString(sum1));
//  }
        public  void sum1() throws Exception {
    double sum1 = 0;
    double sum2 = 0;
    //Class.forName("com.mysql.jdbc.Driver");
    //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
     //   "root", "123ERYcog.");
     Connection connection = getConnection();
    Statement st1 = connection.createStatement();
    Statement st2 = connection.createStatement();
    ResultSet res1 = st1.executeQuery("SELECT SUM(age) FROM trans  WHERE WEEK(updated_at)=WEEK(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())");
    ResultSet res2 = st2.executeQuery("SELECT SUM(bp) FROM trans  WHERE WEEK(updated_at)=WEEK(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())");
    while (res1.next()&&res2.next()) {
      double c1 = res1.getDouble(1);
       double c2 = res2.getDouble(1);
      
      sum2 =c1-c2;
      sum1 = sum1 + c1;

    }
    profit.setText(Double.toString(sum2));
   total.setText(Double.toString(sum1));
    st2.close();
                st1.close();
              res2.close();
              res1.close();
               connection.close();
  }
              public  void sum2() throws Exception {
    double sum2 = 0;
    double sum1 = 0;
    //Class.forName("com.mysql.jdbc.Driver");
    //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
     //   "root", "123ERYcog.");
     Connection connection = getConnection();
    Statement st3 = connection.createStatement();
      Statement st4 = connection.createStatement();
    ResultSet res3 = st3.executeQuery("SELECT SUM(age) FROM trans  WHERE MONTH(updated_at)=MONTH(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())");
     ResultSet res4 = st4.executeQuery("SELECT SUM(bp) FROM trans  WHERE MONTH(updated_at)=MONTH(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())");
    while (res3.next()&&res4.next()) {
      double c1 = res3.getDouble(1);
       double c2 = res4.getDouble(1);
      
      sum2 =c1-c2;
      sum1 = sum1 + c1;

    }
    profit.setText(Double.toString(sum2));
   total.setText(Double.toString(sum1));
    st3.close();
                st4.close();
              res3.close();
              res4.close();
               connection.close();
  }
    public  void sum3() throws Exception {
    double sum2 = 0;
    double sum3 = 0;
    //Class.forName("com.mysql.jdbc.Driver");
    //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
    //    "root", "123ERYcog.");
     Connection connection = getConnection();
    Statement st2 = connection.createStatement();
    Statement st5 = connection.createStatement();
    ResultSet res5 = st2.executeQuery("SELECT SUM(age) FROM trans  WHERE DATE(updated_at) = DATE(NOW())");
    ResultSet res6 = st5.executeQuery("SELECT SUM(bp) FROM trans  WHERE DATE(updated_at) = DATE(NOW())");
    while (res5.next()&&res6.next()) {
      double c2 = res5.getDouble(1);
      double c3 = res6.getDouble(1);
      sum3 =c2-c3;
      sum2 = sum2 + c2;
      

    }
    profit.setText(Double.toString(sum3));
   total.setText(Double.toString(sum2));
    st2.close();
                st5.close();
              res5.close();
              res6.close();
               connection.close();
  }
 public  void sum4() throws Exception {
    double sum2 = 0;
    double sum1 = 0;
    //Class.forName("com.mysql.jdbc.Driver");
    //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
    //    "root", "123ERYcog.");
     Connection connection = getConnection();
    Statement st2 = connection.createStatement();
    Statement st0 = connection.createStatement();
    ResultSet res7 = st2.executeQuery("SELECT SUM(age) FROM trans  WHERE DAY(updated_at)="+jTextField3.getText()+" AND YEAR(updated_at)="+jTextField1.getText()+" AND MONTH(updated_at)="+jTextField2.getText()+"");
    ResultSet res8 = st0.executeQuery("SELECT SUM(bp) FROM trans  WHERE DAY(updated_at)="+jTextField3.getText()+" AND YEAR(updated_at)="+jTextField1.getText()+" AND MONTH(updated_at)="+jTextField2.getText()+"");
    while (res7.next()&&res8.next()) {
      double c2 = res7.getDouble(1);
      double c3= res8.getDouble(1);
      sum2 = sum2 + c2;
      sum1 =c2-c3;

    }
     profit.setText(Double.toString(sum1));
   total.setText(Double.toString(sum2));
    st0.close();
                st2.close();
              res7.close();
              res8.close();
               connection.close();
  }
   public void printss(){
             // SimpleReportExample.print();

       SimpleReportExample m=  new SimpleReportExample();
     m.main();
   }
     public  void printweekS() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root", "123ERYcog.");
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}

		JasperReportBuilder report = DynamicReports.report();//a new report
		report
		  .columns(
		  	Columns.column(" Id", "id", DataTypes.integerType())
		  		.setHorizontalAlignment(HorizontalAlignment.LEFT),
		  	Columns.column("product Name", "fname", DataTypes.stringType()),
		  	Columns.column("Quantity Name", "lname", DataTypes.stringType()),
		  	Columns.column("Date", "updated_at", DataTypes.dateType())
		  		.setHorizontalAlignment(HorizontalAlignment.LEFT)
		  	)
		  .title(//title of the report
		  	Components.text("TRANSACTION REPORT")
		  		.setHorizontalAlignment(HorizontalAlignment.CENTER))
		  .pageFooter(Components.pageXofY())//show page number on the page footer
		  .setDataSource("SELECT id, fname, lname, updated_at FROM trans WHERE DAY(updated_at)="+jTextField3.getText()+" AND YEAR(updated_at)="+jTextField1.getText()+" AND MONTH(updated_at)="+jTextField2.getText()+"", connection);

		try {
		report.show();//show the report
			report.toPdf(new FileOutputStream("C:\\Users\\kimani kogi\\Documents\\POS\\"));//export the report to a pdf file
		} catch (DRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

                  //  dateAgentAdded(fieldDateAgentAdded.toString())
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
     *
     */








      public ArrayList<User_2> getUsersList()

   {

       ArrayList<User_2> usersList = new ArrayList<User_2>();

       Connection connection = getConnection();



       String query = "SELECT * FROM  `trans` ";


       Statement st;

       ResultSet rs;



       try {

           st = connection.createStatement();

           rs = st.executeQuery(query);

           User_2 user;

           while(rs.next())

           {

               user = new User_2(rs.getInt("id"),rs.getString("fname"),rs.getString("lname"),rs.getString("age"),rs.getString("updated_at"));

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

       ArrayList<User_2> list = getUsersList();

       DefaultTableModel model = (DefaultTableModel)jTable.getModel();

       Object[] row = new Object[4];

       for(int i = 0; i < list.size(); i++)

       {

           row[0] = list.get(i).getUpdated_at();

           row[1] = list.get(i).getFname();

           row[2] = list.get(i).getLname();

           row[3] = list.get(i).getAge();



           model.addRow(row);

       }

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

               user = new User_2(rs1.getInt("id"),rs1.getString("fname"),rs1.getString("lname"),rs1.getString("age"),rs1.getString("updated_at"));

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

       ArrayList<User_2> list1 = getUsersList1();

       DefaultTableModel model = (DefaultTableModel)jTable.getModel();

       Object[] row = new Object[4];

       for(int i = 0; i < list1.size(); i++)

       {

           row[0] = list1.get(i).getUpdated_at();

           row[1] = list1.get(i).getFname();

           row[2] = list1.get(i).getLname();

           row[3] = list1.get(i).getAge();



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

               user = new User_2(rs2.getInt("id"),rs2.getString("fname"),rs2.getString("lname"),rs2.getString("age"),rs2.getString("updated_at"));

               usersList2.add(user);

           }
 st2.close();
                rs2.close();
             
               connection.close();
       } catch (Exception e) {

           e.printStackTrace();

       }

       return usersList2;

   }
      public void Show_Users_In_JTable2()

   {

       ArrayList<User_2> list2 = getUsersList2();

       DefaultTableModel model = (DefaultTableModel)jTable.getModel();

       Object[] row = new Object[4];

       for(int i = 0; i < list2.size(); i++)

       {

           row[0] = list2.get(i).getUpdated_at();

           row[1] = list2.get(i).getFname();

           row[2] = list2.get(i).getLname();

           row[3] = list2.get(i).getAge();



           model.addRow(row);

       }

    }
             public ArrayList<User_2> getUsersList3()

   {

       ArrayList<User_2> usersList3 = new ArrayList<User_2>();

       Connection connection = getConnection();



       String query3 = "SELECT * FROM trans WHERE MONTH(updated_at)=MONTH(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())";
       //WHERE WEEK(date)=WEEK(CURDATE()) AND YEAR(date)=YEAR(CURDATE())

       Statement st3;


       ResultSet rs3;



       try {
           st3 = connection.createStatement();

           rs3 = st3.executeQuery(query3);

           User_2 user;

           while(rs3.next())

           {

               user = new User_2(rs3.getInt("id"),rs3.getString("fname"),rs3.getString("lname"),rs3.getString("age"),rs3.getString("updated_at"));

               usersList3.add(user);

           }
 st3.close();
                
              rs3.close();
             
               connection.close();
       } catch (Exception e) {

           e.printStackTrace();

       }

       return usersList3;

   }
      public void Show_Users_In_JTable3()

   {

       ArrayList<User_2> list3 = getUsersList3();

       DefaultTableModel model = (DefaultTableModel)jTable.getModel();

       Object[] row = new Object[4];

       for(int i = 0; i < list3.size(); i++)

       {

           row[0] = list3.get(i).getUpdated_at();

           row[1] = list3.get(i).getFname();

           row[2] = list3.get(i).getLname();

           row[3] = list3.get(i).getAge();



           model.addRow(row);

       }

    }

      public ArrayList<User_2> getUsersList4() throws ParseException

   {
       //String dateString;
    //java.util.Date a = null;


       ArrayList<User_2> usersList4 = new ArrayList<User_2>();

       Connection connection = getConnection();
        //String from ="2016-07-07" ;
         //jTextField1.getText();

           // String from = jTextField1.getText();
//DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
       // java.util.Date date1 =  format.parse(from);

//dd/MM/yyyy

       String query4 =  "SELECT * FROM trans WHERE DAY(updated_at)="+jTextField3.getText()+" AND YEAR(updated_at)="+jTextField1.getText()+" AND MONTH(updated_at)="+jTextField2.getText()+"";

       //MONTH(updated_at)=MONTH(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())
               //DATE(updated_at)='%"+date1+"%'
//WHERE DATE(datetime) = '2009-10-20'
       Statement st4;

       ResultSet rs4;



       try {

           st4 = connection.createStatement();

           rs4 = st4.executeQuery(query4);

           User_2 user;

           while(rs4.next())

           {

               user = new User_2(rs4.getInt("id"),rs4.getString("fname"),rs4.getString("lname"),rs4.getString("age"),rs4.getString("updated_at"));

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

       ArrayList<User_2> list4 = getUsersList4();

       DefaultTableModel model = (DefaultTableModel)jTable.getModel();

       Object[] row = new Object[4];

       for(int i = 0; i < list4.size(); i++)

       {

           row[0] = list4.get(i).getUpdated_at();

           row[1] = list4.get(i).getFname();

           row[2] = list4.get(i).getLname();

           row[3] = list4.get(i).getAge();



           model.addRow(row);

       }

    }

    /**
     *
     * @param tf
     */


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
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        setdate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        total = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        profit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        checkreciept = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 204));

        jLabel1.setText("TRANSACTION  REPORT TABLE");

        jTable.setBackground(new java.awt.Color(153, 153, 255));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "date", "name", "quantity", "price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setMaximumSize(null);
        jTable.setMinimumSize(null);
        jTable.setRowHeight(40);
        jScrollPane1.setViewportView(jTable);

        setdate.setText("SET DATE");
        setdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setdateActionPerformed(evt);
            }
        });

        jButton1.setText("check reciept");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton12.setText("PRINT");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel3.setText("year");

        jLabel4.setText("month");

        jLabel5.setText("day");

        jLabel2.setText("PROFIT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(profit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))))))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(setdate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkreciept, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(263, 263, 263))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkreciept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton12)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(profit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        jMenu1.setText("DATE");

        jMenuItem1.setText("TODAY");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("THIS WEEK");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("CURRENT MONT");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("ALL");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setdateActionPerformed

        try {
            try {
                sum4();
            } catch (Exception ex) {
                Logger.getLogger(transactions.class.getName()).log(Level.SEVERE, null, ex);
            }
            // TODO add your handling code here:
            // Show_Users_In_JTable4();
//        DefaultTableModel dm = (DefaultTableModel)jTable.getModel();
//dm.getDataVector().removeAllElements();
//dm.fireTableDataChanged();
               DefaultTableModel dm = (DefaultTableModel)jTable.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
                               //sum4();
            Show_Users_In_JTable4();
        } catch (ParseException ex) {
            Logger.getLogger(transactions.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_setdateActionPerformed
 public  void select() throws Exception {
    //String sum2 ;
    //String sum1;
    Connection con = getConnection();;
    Statement st2 = con.createStatement();
    Statement st0 = con.createStatement();
    Statement st3 = con.createStatement();
    ResultSet res7 = st2.executeQuery("SELECT invoiceno FROM recieptsale  WHERE invoiceno="+checkreciept.getText()+"");
    ResultSet res8 = st0.executeQuery("SELECT total FROM recieptsale   WHERE invoiceno="+checkreciept.getText()+" ");
    ResultSet res9 = st3.executeQuery("SELECT updated_at FROM recieptsale   WHERE invoiceno="+checkreciept.getText()+" ");
    if (res7.next()&&res8.next()&&res9.next()) {
        JOptionPane.showMessageDialog(null,""+res7.getString("invoiceno")+"'  reciept  "+"\n"+" with     "+res8.getString("total")+"  ksh products worth"+"\n"+"given on    "+res9.getString("updated_at") );
    st2.close();
    st0.close();
    st3.close();
    res7.close();
    res8.close();
    res9.close();
    //st2.close();
        st2.close();
    con.close();
    }
    
    else{

               JOptionPane.showMessageDialog(null, "NO DATA... \n "
                       + "RECIEPT NOT FOUND... \n"
                       + "RE-CHECK THE RECEIPT NO... ");

           }
    
  }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {        
            select();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "!!!error ..enter a valid reciept no");
            Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText(null);
        total.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        profit.setText(null);

        DefaultTableModel dm = (DefaultTableModel)jTable.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        printweekS();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         DefaultTableModel dm = (DefaultTableModel)jTable.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
        Show_Users_In_JTable2();
        try {
            sum1();
           // profit();
        } catch (Exception ex) {
            Logger.getLogger(transactions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
             DefaultTableModel dm = (DefaultTableModel)jTable.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
Show_Users_In_JTable3();
        try {
            sum2();
        } catch (Exception ex) {
            Logger.getLogger(transactions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       DefaultTableModel dm = (DefaultTableModel)jTable.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
        Show_Users_In_JTable1();
        try {
            sum3();
        } catch (Exception ex) {
            Logger.getLogger(transactions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       DefaultTableModel dm = (DefaultTableModel)jTable.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged();
        Show_Users_In_JTable();
        try {
            sum();
        } catch (Exception ex) {
            Logger.getLogger(transactions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transactions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField checkreciept;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField profit;
    private javax.swing.JButton setdate;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
