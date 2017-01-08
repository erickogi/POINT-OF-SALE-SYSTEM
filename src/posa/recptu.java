package posa;

import java.sql.ResultSet;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author kimani kogi
 */
public class recptu {

    static TableModel resultSetToTableModel(ResultSet result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    private String name;
    private String contact;
    private String tag;
    private String bsemail;
    private String toemail;
    private String epassword;
    //private String updated_at;
    
    
    public recptu(String Name,String Contact,String Tag,String Bsemail,String Toemail,String Epassword)
    {
        
        this.name = Name;
        this.contact = Contact;
        this.tag = Tag;
        this.bsemail = Bsemail;
        this.toemail = Toemail;
        this.epassword = Epassword;
        //this.updated_at=Updated_at;
    }
    
   
    
    public String getName()
    {
        return name;
    }
    
    public String getContact()
    {
        return contact;
        
    }
     public String getTag()
    {
        return tag;
        
    }
      public String getBsemail()
    {
        return bsemail;
        
    }
       public String getToemail()
    {
        return toemail;
        
    }
          public String getEpassword()
    {
        return epassword;
        
    }
//    public String getUpdated_at()
//    {
//        return updated_at;
//    }

}
