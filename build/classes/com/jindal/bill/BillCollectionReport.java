/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.bill;

import com.jindal.model.SalesOrderModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author RUBAL GARG
 */
public class BillCollectionReport {

    
static ArrayList<BillCollectionReportModel> reportMain1 = new ArrayList<BillCollectionReportModel>();
    public static ArrayList<BillCollectionReportModel> getBillBeanCollection() {
       ArrayList<BillCollectionReportModel> reportMain = new ArrayList<BillCollectionReportModel>();
       reportMain=reportMain1;
       return reportMain;
    }

 
    
    public static void generateBill(BillCollectionReportModel billmodel)
    {
        
     InputStream inputStream = null;
        try
        {
        // load jrxml file to stream
            String workingDir = System.getProperty("user.dir");
            workingDir=workingDir+"/src/com/jindal/bill/report2.jrxml";
            System.out.println(workingDir);
            inputStream = new FileInputStream(new File(workingDir));
            // compile jrxml file
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            net.sf.jasperreports.engine.JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
           inputStream.close();
           //fill the report
      reportMain1.clear();
           reportMain1.add(billmodel);
           ArrayList<BillCollectionReportModel> billReport = getBillBeanCollection();
           JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(billReport);
           
           JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, beanColDataSource);
           //JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null);
           // exporting the report
           String fileName = null;
           fileName = "C:/Bills/Bill_" + billmodel.getInvoiceNumber()+ ".pdf";
                
           File fileReportName = new File(fileName);
           OutputStream outputStream = new FileOutputStream(fileReportName);
           JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
           outputStream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
