package com.jindal.reports;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jindal.database.ConnectDB;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
/**
 *
 * @author RUBAL GARG
 */
public class JasperReport {
    
    
    public void generateReport(int invoiceNumber, String fileName) {
        Connection connection = null;
        try
        {
            connection = ConnectDB.openConnection();
            // load jrxml file to stream
            //String workingDir = System.getProperty("user.dir");
            //workingDir=workingDir+"/src/com/jindal/reports/report1_1.jrxml";
            
           InputStream inputStream = this.getClass().getResourceAsStream("report1_1.jrxml");
            System.out.println("Hello "+JasperReport.class.getResource("report1_1.jrxml").getFile().toString());
            
            //System.out.println(workingDir);
            
           // inputStream = new FileInputStream();
            // compile jrxml file
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            net.sf.jasperreports.engine.JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
           inputStream.close();
           //fill the report
           System.out.println("Hello");
           Map<String, Object> map = new HashMap<String, Object>();
           map.put("invoiceNumber", invoiceNumber);
           JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, connection);
           
           // exporting the report
           File fileReportName = new File(fileName);
           OutputStream outputStream = new FileOutputStream(fileReportName);
           JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
           outputStream.close();
           
        }
        catch (Exception ex)
        {
            Logger.getLogger(JasperReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
            {
                ConnectDB.closeConnection();
            }
        
    }
    
        public static void generateStockReport(String fileName) {
        try
        {
            String userName = "root";
	    String password = "pass";
	    String url = "jdbc:mysql://127.0.0.1:3306/JindalEnterprises";
	    Class.forName ("com.mysql.jdbc.Driver").newInstance ();
	    Connection connection = (Connection) DriverManager.getConnection ( url, userName , password );
            
            // load jrxml file to stream
            String workingDir = System.getProperty("user.dir");
            workingDir=workingDir+"/src/com/jindal/reports/report1_1.jrxml";
           // JasperReport report=new JasperReport();
           //String classPath=report.getClass().getResource("JasperReport.class").getPath();
            System.out.println(workingDir);
            InputStream inputStream = new FileInputStream(new File(workingDir));
            // compile jrxml file
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            net.sf.jasperreports.engine.JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            inputStream.close();
           //fill the report
//           Map<String, Object> map = new HashMap<String, Object>();
//           map.put("invoiceNumber", invoiceNumber);
           JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);
           
           // exporting the report
           File fileReportName = new File(fileName);
           OutputStream outputStream = new FileOutputStream(fileReportName);
           JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
           outputStream.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(JasperReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
