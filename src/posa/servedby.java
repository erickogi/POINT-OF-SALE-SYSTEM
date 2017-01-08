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
public class servedby {

    static TableModel resultSetToTableModel(ResultSet result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    private String user_name;
    
    //private String updated_at;
    
    
    public servedby(String UserName)
    {
        
        this.user_name = UserName;
     
        
    }
    
   
    
    public String getUserName()
    {
        return user_name;
    }
    
  

}
