/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posa;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kimani kogi
 */
public class methods {
   String tt;
  String path;
  
//public Connection getConnectiondb()
//  {
//    Connection con = null;
//    try
//    {
//      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libclient", "root", "123ERYcog.");
//    }
//    catch (Exception ex)
//    {
//      System.out.println(ex.getMessage());
//    }
//    return con;
//  }
//  
//  public void getPath(){
//    // Connection con = null;
//    try
//    {
//      Connection con = getConnectiondb();
//    Statement st2 = con.createStatement();
//    
//    ResultSet res7 = st2.executeQuery("SELECT path FROM dbpath  ");
//    while (res7.next()) {
//      path=(res7.getString("path"));
//    
//     // SHOW.setText(path);
//    }
//     con.close();
//     // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "123ERYcog.");
//    }
//    catch (Exception ex)
//    {
//      System.out.println(ex.getMessage());
//    }
//}
//public void updatePath(String h){
//    
//    // Connection con = null;
//    try
//    {
//        //String url="jdbc:derby://myDB;create=true;user=me;password=mine";
//        // selectdbpath();
//      // Connection con = getConnectiondb();
//   // Statement st2 = con.createStatement();
//      // PreparedStatement st2 = con.prepareStatement
//    String query = "UPDATE `dbpath` SET `path`='" + h +"'";
//      
//      executeSQlQueryb(query, "Updated");
//       //st2.setString(1, h);
//       //st2.executeUpdate();
//       //executeSQlQueryb(r,message);
//    
//     // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "123ERYcog.");
//    }
//    catch (Exception ex)
//    {
//      System.out.println(ex.getMessage());
//      JOptionPane.showMessageDialog(null, "Data Not " );
//    }
//}

     public Connection getConnection()
  {
   // getPath();
    Connection con = null;
    try
    {
    
   String db=":3306/users";
   String jdbc="jdbc:mysql://";
   String user="root";
   String pass="123ERYcog.";
   path="localhost";
   String dbp=(jdbc+path+db);
        
      con = DriverManager.getConnection(dbp,user,pass);
     // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "123ERYcog.");
    }
    catch (Exception ex)
    {
      System.out.println(ex.getMessage());
    }
    return con;
  }
//           public void executeSQlQueryb(String query, String message)
//  {
//    Connection con = getConnectiondb();
//     try
//    {
//      Statement st = con.createStatement();
//      if (st.executeUpdate(query) == 1) {
//        JOptionPane.showMessageDialog(null, "Data " + message + " Succefully  !!SYSTEM WILL CLOSE TO EFFECT CHANGES");
//        System.exit(1);
//      } else {
//        JOptionPane.showMessageDialog(null, "Data Not " + message);
//      }
//      st.close();
//      con.close();
//    }
//    catch (Exception ex)
//    {
//      ex.printStackTrace();
//    }
//  }
//      public void executeSQlQuery(String query, String message)
//  {
//    Connection con = getConnection();
//    try
//    {
//      Statement st = con.createStatement();
//      if (st.executeUpdate(query) == 1)
//      {
//        //DefaultTableModel model = (DefaultTableModel)this.table.getModel();
//        
//        //model.setRowCount(0);
//        LOAN N=new LOAN();
//        N.findUsers();
//        
//        JOptionPane.showMessageDialog(null, "Book " + message + " Succefully");
//      }
//      else
//      {
//        JOptionPane.showMessageDialog(null, "Book Not " + message);
//        JOptionPane.showMessageDialog(null, "MAKE SURE THE BOOK ID IS NOT ALREADY BEING USED \nCHECK THE BOOK DETAILS ENTERED FOR ERRORS ie ID SHOULD BE NUMBERS ONLY");
//      }
//      st.close();
//      con.close();
//    }
//    catch (Exception ex)
//    {
//      ex.printStackTrace();
//    }
//  }
//
  public String setIconImage() {
      String image="sell.png";
      return image;
   }
//
  public String setTitle() {
       String title;
       try {
           methods m=new methods();
           Connection con = m.getConnection();
           Statement st2 = con.createStatement();
           
           ResultSet res7 = st2.executeQuery("SELECT name FROM reciept  ");
           while (res7.next()) {
               tt=(res7.getString("name"));
           }
           st2.close();
          res7.close();
           con.close();
           // setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("academic.png")));
          
          
//            //  setTitle(title);
//            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       } catch (SQLException ex) {
           Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
       }
       title=tt;
       return title;
  }
// public String selectnamei()
// {
//      String title;
//       String  tti = null;
//        try {
//           
//            
//            methods m=new methods();
//            Connection con = m.getConnection();
//            Statement st2 = con.createStatement();
//            
//            ResultSet res7 = st2.executeQuery("SELECT name FROM libprefrence  ");
//            while (res7.next()) {
//                tti=(res7.getString("name"));
//                //schoolname.setText(tt);
//                // return tti;
//                title=tti;
//            }
//            st2.close();
//            res7.close();
//            con.close();
//            // title=tti;
//           // return title;
//        } catch (SQLException ex) {
//            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       // tti="jina";
//         title=tti;
//        return title;
//  }
    public void selectname()
    throws Exception
  {
    methods m=new methods();
        Connection con = m.getConnection();
    Statement st2 = con.createStatement();
    
    ResultSet res7 = st2.executeQuery("SELECT name FROM reciept  ");
    while (res7.next()) {
       tt=(res7.getString("name"));
    }
    st2.close();
    res7.close();
    con.close();
  }

}
