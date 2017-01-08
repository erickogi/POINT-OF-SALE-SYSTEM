package posa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kimani kogi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


public class SendMail {
static String bsemail,toemail,epassword;
//   static double total1;
//// public  void sum3() throws Exception {
//    double sum2 = 0;
//      double total;
//    //double total;
//    Class.forName("com.mysql.jdbc.Driver");
//    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
//        "root", "");
//    Statement st2 = con.createStatement();
//    ResultSet res2 = st2.executeQuery("SELECT SUM(age) FROM trans  WHERE DATE(updated_at) = DATE(NOW())");
//    while (res2.next()) {
//      double c2 = res2.getInt(1);
//      sum2 = sum2 + c2;
//      // total=sum2;
//    }
//  total=sum2;
  //}
//  public  void sum1() throws Exception {
//    double sum1 = 0;
//    Class.forName("com.mysql.jdbc.Driver");
//    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
//        "root", "");
//    Statement st1 = con.createStatement();
//    ResultSet res1 = st1.executeQuery("SELECT SUM(age) FROM trans  WHERE WEEK(updated_at)=WEEK(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())");
//    while (res1.next()) {
//      double c1 = res1.getInt(1);
//      sum1 = sum1 + c1;
//
//
//    }
//  // total1.setText(Double.toString(sum1));
//     total1=sum1;
//  }
    public static void main() throws ClassNotFoundException, SQLException {
         try {
           Show_Users_In_JTable4();
       } catch (ParseException ex) {
           Logger.getLogger(sellform.class.getName()).log(Level.SEVERE, null, ex);
       }
 double total1;
// public  void sum3() throws Exception {
    double sum2 = 0;
    double sum3 = 0;
      double total;
      //double total1;
    //double total;
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
        "root", "123ERYcog.");
    Statement st2 = con.createStatement();
    ResultSet res2 = st2.executeQuery("SELECT SUM(age) FROM trans  WHERE DATE(updated_at) = DATE(NOW())");
    while (res2.next()) {
      double c2 = res2.getInt(1);
      sum2 = sum2 + c2;
      total=sum2;
      Statement st3 = con.createStatement();
    ResultSet res3 = st3.executeQuery("SELECT SUM(age) FROM trans  WHERE DATE(updated_at) = DATE(NOW())");
    while (res3.next()) {
      double c3 = res3.getInt(1);
      sum3 = sum3 + c3;
      total1=sum3;
        final String username = bsemail;
        final String password = epassword;

//        Properties props = new Properties();
//       props.put("mail.smtp.starttls.enable", "false");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props,
//          new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
          Properties props = new Properties();
    props.setProperty("mail.transport.protocol", "smtp");
    props.setProperty("mail.host", "smtp.gmail.com");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");
    props.put("mail.debug", "true");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");
    Session session = Session.getDefaultInstance(props,
    new javax.mail.Authenticator() {
       protected PasswordAuthentication getPasswordAuthentication() {
       return new PasswordAuthentication(username,password);
   }
    });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(bsemail));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(toemail));
            message.setSubject("TRANSACTION REPORT");

             //message.setText("\n\ntoday"+ Double.toString(total));
              message.setText("week,"+ Double.toString(total1)+"\n\ntoday"+ Double.toString(total));

            Transport.send(message);
 JOptionPane.showMessageDialog(null, "Data sent Succefully");
           // System.out.println("Done");

        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Data not sent Succefully");
            throw new RuntimeException(e);
        }
    }

    }
    }
     public static Connection getConnection()
    {
        Connection con = null;


        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root","123ERYcog.");

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return con;
    }
       public  static ArrayList<recptu> getUsersList4() throws ParseException

   {
       //String dateString;
    //java.util.Date a = null;


       ArrayList<recptu> usersList4 = new ArrayList<recptu>();

       Connection connection = getConnection();
        //String from ="2016-07-07" ;
         //jTextField1.getText();

           // String from = jTextField1.getText();
//DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
       // java.util.Date date1 =  format.parse(from);

//dd/MM/yyyy

       String query4 =  "SELECT * FROM `reciept` ";
       //MONTH(updated_at)=MONTH(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())
               //DATE(updated_at)='%"+date1+"%'
//WHERE DATE(datetime) = '2009-10-20'
       Statement st4;

       ResultSet rs4;



       try {

           st4 = connection.createStatement();

           rs4 = st4.executeQuery(query4);

           recptu user;

           while(rs4.next())

           {

               user = new recptu(rs4.getString("name"),rs4.getString("contact"),rs4.getString("tag"),rs4.getString("bsemail"),rs4.getString("toemail"),rs4.getString("epassword"));

               usersList4.add(user);

           }

       } catch (Exception e) {

           e.printStackTrace();

       }

       return usersList4;

   }
      public  static void Show_Users_In_JTable4() throws ParseException

   {
//String a;
       ArrayList<recptu> list4 = getUsersList4();

       

       for(int i = 0; i < list4.size(); i++)

       {

           

           bsemail=list4.get(i).getBsemail();

           toemail=list4.get(i).getToemail();

           epassword=list4.get(i).getEpassword();



          

       }

    }
}
