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
public class user_dcc {

    static TableModel resultSetToTableModel(ResultSet result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    private int id;
    private String fname;
    private String lname;
    private String age;
    private String product;
    //private String updated_at;
    
    
    public user_dcc(int Id,String Fname,String Lname,String Age,String Product)
    {
        this.id = Id;
        this.fname = Fname;
        this.lname = Lname;
        this.age = Age;
        this.product = Product;
        //this.updated_at=Updated_at;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getFname()
    {
        return fname;
    }
    
    public String getLname()
    {
        return lname;
    }
    
    public String getAge()
    {
        return age;
        
    }
     public String getProduct()
    {
        return product;
        
    }
//    public String getUpdated_at()
//    {
//        return updated_at;
//    }

}
