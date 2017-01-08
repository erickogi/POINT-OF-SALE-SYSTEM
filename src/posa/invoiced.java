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
public class invoiced {

    static TableModel resultSetToTableModel(ResultSet result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    private int id;
    private String iname;
    private String product;
    private String price_product;
    private String total;
    private String quantity;
    private String updated_at;

    //To change body of generated methods, choose Tools | Templates.
    
    
    
    public invoiced(int Id,String Iname,String Product,String Price_product,String Total,String Quantity,String Updated_at)
    {
        this.id = Id;
        this.iname = Iname;
        this.product = Product;
         this.price_product = Price_product;
        this.total = Total;
        this.quantity = Quantity;
        this.updated_at=Updated_at;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getIname()
    {
        return iname;
    }
    
    public String getProduct()
    {
        return product;
    }
    
    public String getPrice_product()
    {
        return price_product;
        
    }
     public String getTotal()
    {
        return total;
    }
      public String getQuantity()
    {
        return quantity;
    }
    public String getUpdated_at()
    {
        return updated_at;
    }

}
