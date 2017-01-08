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

import java.awt.Toolkit;
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

/**
 *
 * @author kimani kogi
 */
public class reports extends javax.swing.JFrame {

    /**
     * Creates new form reports
     */
    public reports() {
        initComponents();
         methods n=new methods();
   String t= n.setTitle();
   this.setTitle(t);
    String i=n.setIconImage();
    this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(i)));
    }
// public  void printweekS() {
//		Connection connection = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root", "123ERYcog.");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return;
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			return;
//		}
//
//		JasperReportBuilder report = DynamicReports.report();//a new report
//		report
//		  .columns(
//		  	Columns.column(" Id", "id", DataTypes.integerType())
//		  		.setHorizontalAlignment(HorizontalAlignment.LEFT),
//		  	Columns.column("product Name", "fname", DataTypes.stringType()),
//		  	Columns.column("Quantity Name", "lname", DataTypes.stringType()),
//		  	Columns.column("Date", "updated_at", DataTypes.dateType())
//		  		.setHorizontalAlignment(HorizontalAlignment.LEFT)
//		  	)
//		  .title(//title of the report
//		  	Components.text("TRANSACTION REPORT")
//		  		.setHorizontalAlignment(HorizontalAlignment.CENTER))
//		  .pageFooter(Components.pageXofY())//show page number on the page footer
//		  .setDataSource("SELECT id, fname, lname, updated_at FROM trans WHERE DAY(updated_at)="+jTextField3.getText()+" AND YEAR(updated_at)="+jTextField1.getText()+" AND MONTH(updated_at)="+jTextField2.getText()+"", connection);
//
//		try {
//		report.show();//show the report
//			report.toPdf(new FileOutputStream("C:\\Users\\kimani kogi\\Documents\\POS\\"));//export the report to a pdf file
//		} catch (DRException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//
//	}
    public  void printweek() {
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
		  .setDataSource("SELECT id, fname, lname, updated_at FROM trans WHERE WEEK(updated_at)=WEEK(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())", connection);

		try {
		report.show(false);//show the report
			report.toPdf(new FileOutputStream("C:\\Users\\kimani kogi\\Documents\\POS\\weekreport.pdf"));//export the report to a pdf file
		} catch (DRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
     public  void printdebts() {
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
		  	Columns.column(" Name", "fname", DataTypes.stringType()),
		  	Columns.column("Amount", "lname", DataTypes.stringType()),
		  	Columns.column("status", "updated_at", DataTypes.stringType())
		  		.setHorizontalAlignment(HorizontalAlignment.LEFT)
		  	)
		  .title(//title of the report
		  	Components.text("DEBTS REPORT")
		  		.setHorizontalAlignment(HorizontalAlignment.CENTER))
		  .pageFooter(Components.pageXofY())//show page number on the page footer
		  .setDataSource("SELECT id, fname, lname, updated_at FROM debts ", connection);

		try {
		report.show(false);//show the report
			report.toPdf(new FileOutputStream("C:\\Users\\kimani kogi\\Documents\\POS\\debtsreport.pdf"));//export the report to a pdf file
		} catch (DRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
      public  void printcredits() {
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
		  	Columns.column(" Name", "fname", DataTypes.stringType()),
		  	Columns.column(" Amount", "lname", DataTypes.stringType()),
		  	Columns.column("status", "updated_at", DataTypes.dateType())
		  		.setHorizontalAlignment(HorizontalAlignment.LEFT)
		  	)
		  .title(//title of the report
		  	Components.text("creidts REPORT")
		  		.setHorizontalAlignment(HorizontalAlignment.CENTER))
		  .pageFooter(Components.pageXofY())//show page number on the page footer
		  .setDataSource("SELECT id, fname, lname, status FROM credits ", connection);

		try {
		report.show(false);//show the report
			report.toPdf(new FileOutputStream("C:\\Users\\kimani kogi\\Documents\\POS\\weekreport.pdf"));//export the report to a pdf file
		} catch (DRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
     public  void printtoday() {
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
		  .setDataSource("SELECT id, fname, lname, updated_at FROM trans WHERE DATE(updated_at) = DATE(NOW())", connection);

		try {
			report.show(false);//show the report
			report.toPdf(new FileOutputStream("C:\\Users\\kimani kogi\\Documents\\POS\\todaysreport.pdf"));//export the report to a pdf file
		} catch (DRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
   public  void printall() {
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
		  .setDataSource("SELECT id, fname, lname, updated_at FROM trans ", connection);

		try {
			report.show(false);//show the report
			report.toPdf(new FileOutputStream("C:\\Users\\kimani kogi\\Documents\\POS\\transactionreport.pdf"));//export the report to a pdf file
		} catch (DRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
      public  void printallc() {
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
		  	Columns.column(" Name", "fname", DataTypes.stringType())
		  		.setHorizontalAlignment(HorizontalAlignment.LEFT),
		  	Columns.column("amount", "lname", DataTypes.integerType()),
		  	Columns.column("product", "product", DataTypes.stringType()),
		  	Columns.column("status", "age", DataTypes.stringType()),
                                Columns.column("on", "updated_at", DataTypes.dateType())
		  		.setHorizontalAlignment(HorizontalAlignment.LEFT)
		  	)
		  .title(//title of the report
		  	Components.text("creditors")
		  		.setHorizontalAlignment(HorizontalAlignment.CENTER))
		  .pageFooter(Components.pageXofY())//show page number on the page footer
		  .setDataSource("SELECT age, fname, lname,product, updated_at FROM credits ", connection);

		try {
			report.show(false);//show the report
			report.toPdf(new FileOutputStream("C:\\Users\\kimani kogi\\Documents\\POS\\transactionreport.pdf"));//export the report to a pdf file
		} catch (DRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
 public  void printmonth() {
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
		  .setDataSource("SELECT id, fname, lname, updated_at FROM trans WHERE MONTH(updated_at)=MONTH(CURDATE()) AND YEAR(updated_at)=YEAR(CURDATE())", connection);

		try {
			report.show(false);//show the report
			report.toPdf(new FileOutputStream("C:\\Users\\kimani kogi\\Documents\\POS\\monthsreport.pdf"));//export the report to a pdf file
		} catch (DRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jButton1.setText("TODAY");
        jButton1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/posa/New Folder/booked1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("TRANSACTIONS REPORT");

        jLabel2.setText("INVENTORY");

        jButton2.setText("THIS WEEK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("THIS MONTH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("ALL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("DEBTS/CREDITS");

        jButton5.setText("PRINT INEVTORY");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("DEBTS");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("CREDITS");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addComponent(jButton6)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(14, 14, 14)
                .addComponent(jButton2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton7)))
                .addGap(51, 51, 51)
                .addComponent(jButton4)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel4.setText("PRINT REPORTS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(363, 363, 363)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        printtoday();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        printweek();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        printmonth();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        printall();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
printallc();        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
