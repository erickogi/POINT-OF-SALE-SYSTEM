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


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.view.JasperViewer;



//CREATE TABLE `customers` (
//  `id` int(11) NOT NULL AUTO_INCREMENT,
//  `first_name` varchar(50) DEFAULT NULL,
//  `last_name` varchar(50) DEFAULT NULL,
//  `date` date DEFAULT NULL,
//  PRIMARY KEY (`id`)
//) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1$$
// 
// 	INSERT INTO `test`.`customers` (`first_name`, `last_name`, `date`) VALUES ('Ricardo', 'Mariaca', CURRENT_DATE);
//	INSERT INTO `test`.`customers` (`first_name`, `last_name`, `date`) VALUES ('YONG', 'MOOK KIM', CURRENT_DATE);

 
public class SimpleReportExample {

	

    void main() {
         {
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
		  .setDataSource("SELECT id, fname, lname, updated_at FROM trans", connection);

		try {
                    //JasperViewer.viewReport(report, false);
			report.show();//show the report
			report.toPdf(new FileOutputStream("C:\\Users\\kimani kogi\\OneDrive\\Pictures\\yreport.pdf"));//export the report to a pdf file
		} catch (DRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
