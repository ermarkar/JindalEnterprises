/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.stockReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import com.jindal.model.ItemModel;
import com.jindal.service.ItemService;
import com.jindal.stockReport.KnownStockModel;
import com.jindal.stockReport.StockReportModel;
import com.jindal.stockReport.TotalStockModel;
import com.jindal.stockReport.UnknownStockModel;

/**
 *
 * @author RUBAL GARG
 */
public class StockReport
{
    //static ArrayList<UnkonownItemModel> unknownItemModelArray= new ArrayList<UnkonownItemModel>();
    
    public static List<StockReportModel> getStockBeanCollection()
    {
        int grandTotal = 0;
        HashMap map = new HashMap();
        HashMap<Integer,Integer> quantityPerFinish=new  HashMap<Integer,Integer>();
        //ArrayList<StockReportModel> stockReportFinal=new ArrayList<StockReportModel>();
        StockReportModel stockReport = new StockReportModel();
        ArrayList<UnknownStockModel> unKnownStockArray = new ArrayList<UnknownStockModel>();
        ArrayList<KnownStockModel> knownStockArray = new ArrayList<KnownStockModel>();
        ArrayList<TotalStockModel> totalStockArray = new ArrayList<TotalStockModel>();
        TotalStockModel totalModel = new TotalStockModel();
        
        ArrayList<String> allFinish=new ArrayList<String>();
        ArrayList<String> allThickness=new ArrayList<String>();
        
        allFinish.add("HGF");
        allFinish.add("MTF");
        allFinish.add("SDF");
        allThickness.add("0.54");
        allThickness.add("0.6");
        allThickness.add("0.7");
        allThickness.add("0.8");
        allThickness.add("1.0");
        allThickness.add("1.5");
        allThickness.add("0.60");
        allThickness.add("0.70");
        allThickness.add("0.80");
        allThickness.add("1.00");
        allThickness.add("1.50");
        
        map = ItemService.getStockStatement();
        
        HashMap<String, Integer> count = (HashMap<String, Integer>) map.get("count");
        ArrayList<ItemModel> items = (ArrayList<ItemModel>) map.get("items");
        Iterator<ItemModel> itemIterator=items.iterator();
        boolean unknown=false;
        while(itemIterator.hasNext())
        {
            unknown=false; 
            UnknownStockModel unKnownModel=null;
            ArrayList<Integer> presentQuantityIndex=new ArrayList<Integer>();
            HashMap<Integer,String> quantity=new  HashMap<Integer,String>();
            int totalQuantity=0;
            ItemModel item=itemIterator.next();
            String designId = item.getDesign_Id();
            KnownStockModel knownModel=new KnownStockModel();
            knownModel.setDesignId(designId);
            int countDesignId = count.get(designId);
             for(int i=0; i< countDesignId; i++)
            { 
                String thickness=item.getThickness();
                String finish=item.getFinish();
                if(!allFinish.contains(finish) || !allThickness.contains(thickness))
                {
                    unKnownModel=new UnknownStockModel();
                    unKnownModel.setUnKnownDesign_Id(designId);
                    unKnownModel.setUnKnownFinish(finish);
                    unKnownModel.setUnKnownThickness(thickness);
                    unKnownModel.setUnKnownQuantity(item.getQuantity());
                    unKnownStockArray.add(unKnownModel);
                    unknown=true;
                    grandTotal = grandTotal + item.getQuantity();
                    break;
                }
               int thicknessIndex=allThickness.indexOf(thickness);
               int finishIndex=allFinish.indexOf(finish);
               finishIndex=finishIndex+1;
               int quantityIndex=(thicknessIndex*3)+finishIndex;
               if(quantityPerFinish.containsKey(quantityIndex))
               {
                   int oldTotal=quantityPerFinish.get(quantityIndex);
                   quantityPerFinish.put(quantityIndex,oldTotal+item.getQuantity());
               }
               else
               {
                   quantityPerFinish.put(quantityIndex,item.getQuantity());
               }
               presentQuantityIndex.add(quantityIndex);
               quantity.put(quantityIndex,String.valueOf(item.getQuantity()));
               totalQuantity=totalQuantity+item.getQuantity();
               if(i<countDesignId-1)
               {
               item=itemIterator.next();
               }
            }
             if(!unknown)
             {
             for(int i=1;i<=18;i++)
             {
                if(!presentQuantityIndex.contains(i))
                {
                    quantity.put(i,"-"); 
                }
                if(!quantityPerFinish.containsKey(i))
                {
                    quantityPerFinish.put(i,0); 
                }
             }
             knownModel.setQuantity(quantity);
             knownModel.setTotalQuantity(totalQuantity);
             knownStockArray.add(knownModel);
             //stockReport.add(reportModel);
             }
             else
             {
                //stockReport.add(unknownItemModel);
                //unKnownStockArray.add(unknownItemModel);
               // reportModel.setUnKnownStock(unKnownStockArray);
             }
             //stockReport.add(reportModel);
             if(quantityPerFinish.containsKey(19))
             {
                 int oldTotal=quantityPerFinish.get(19);
                 quantityPerFinish.put(19,oldTotal+totalQuantity);
             }
             else
             {
                 quantityPerFinish.put(19,totalQuantity);
             }        
        }
        
        grandTotal = grandTotal + quantityPerFinish.get(19);
        totalModel.setTotalQuantityPerFinish(quantityPerFinish);
        totalStockArray.add(totalModel);
        stockReport.setKnownStock(knownStockArray);
        stockReport.setUnKnownStock(unKnownStockArray);
        stockReport.setTotalStock(totalStockArray);
        stockReport.setGrandTotal(grandTotal);
        return Arrays.asList(stockReport);
    }
    
    public void generateStockReport(String fileName)
    {
     InputStream inputStream = null;
        try
        {
        // load jrxml file to stream
            //String workingDir = System.getProperty("user.dir");
            //workingDir=workingDir+"/src/com/jindal/stockReport/mainStockReport.jrxml";
            //System.out.println(workingDir);
            inputStream = this.getClass().getResourceAsStream("mainStockReport.jrxml");
            //inputStream = new FileInputStream(new File(workingDir));
            // compile jrxml file
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            net.sf.jasperreports.engine.JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
           inputStream.close();
           //fill the report
          
           List<StockReportModel> stockReport = getStockBeanCollection();
           JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(stockReport);
           
           JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, beanColDataSource);
           
           // exporting the report
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
