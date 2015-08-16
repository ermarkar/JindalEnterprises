/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.ui;

import com.jindal.ui.CustomLabel;
import com.jindal.forms.HomePage;
import com.jindal.reports.JasperReport;
import com.jindal.service.Validator;
import com.jindal.stockReport.StockReport;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import jindalenterprises.PrintFileToPrinter;
import jxl.format.Border;

/**
 *
 * @author RUBAL GARG
 */
public class ReportMenuPanel extends JPanel  implements ActionListener, KeyListener
{
    String fileName = null;
    private javax.swing.JLabel lblReports;
    private javax.swing.JPanel panelPackingList;
    private javax.swing.JPanel panelStockStatement;
    private javax.swing.JLabel lblPackingList;
    private javax.swing.JLabel lblStockStatement;
    private javax.swing.JLabel lblInvoiceNumber;
    private javax.swing.JTextField fldInvoiceNumber;
    private javax.swing.JButton btnGetDetails;
    private javax.swing.JButton btnGenerateStockReport;
    private javax.swing.JDialog dialogPackingList;
    private javax.swing.JDialog dialogStockReport;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel lblPackingListDialog1;
    private javax.swing.JLabel lblPackingListDialog2;
    private javax.swing.JLabel lblPackingListDialog3;

    public ReportMenuPanel() 
    {
        lblReports = new CustomLabel("Reports", new java.awt.Font("Calibri", 1, 36), java.awt.Color.orange);
        panelPackingList = new javax.swing.JPanel();
        panelStockStatement = new javax.swing.JPanel();
        lblPackingList = new CustomLabel("Packing List", new java.awt.Font("Calibri", 1, 36), java.awt.Color.orange);
        lblStockStatement = new CustomLabel("Stock Report", new java.awt.Font("Calibri", 1, 36), java.awt.Color.orange);
        lblInvoiceNumber = new CustomLabel("Invoice Number",  new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblPackingListDialog1 = new CustomLabel("Your Report has been saved at",  new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblPackingListDialog2 = new CustomLabel("",  new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblPackingListDialog3 = new CustomLabel("Do you want to print the report ?",  new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        
        fldInvoiceNumber = new JTextField();
        
        btnGetDetails = new com.jindal.ui.CustomButton("Get Details", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnGenerateStockReport = new com.jindal.ui.CustomButton("Generate Stock Report", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnCancel = new com.jindal.ui.CustomButton("Cancel", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnPrint = new com.jindal.ui.CustomButton("Print", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));

        
        dialogPackingList = new javax.swing.JDialog();
        dialogStockReport = new javax.swing.JDialog();

        /**
         * ******************** layout and background ******************
         */
        javax.swing.GroupLayout PackingListDialogLayout = new javax.swing.GroupLayout(dialogPackingList.getContentPane());
        dialogPackingList.getContentPane().setLayout(PackingListDialogLayout);
        dialogPackingList.getContentPane().setBackground(new java.awt.Color(255, 255, 255));
        dialogPackingList.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        PackingListDialogLayout.setHorizontalGroup(
            PackingListDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PackingListDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(btnPrint)
                .addGap(130, 130, 130))
            .addGroup(PackingListDialogLayout.createSequentialGroup()
                .addGroup(PackingListDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PackingListDialogLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(lblPackingListDialog3))
                    .addGroup(PackingListDialogLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblPackingListDialog2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PackingListDialogLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(lblPackingListDialog1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        PackingListDialogLayout.setVerticalGroup(
            PackingListDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PackingListDialogLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblPackingListDialog1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPackingListDialog2)
                .addGap(6, 6, 6)
                .addComponent(lblPackingListDialog3)
                .addGap(18, 18, 18)
                .addGroup(PackingListDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint)
                    .addComponent(btnCancel))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        
        
        panelPackingList.setLayout(null);
        panelPackingList.setBackground(new java.awt.Color(255, 255, 255));
        
        panelStockStatement.setLayout(null);
        panelStockStatement.setBackground(new java.awt.Color(255, 255, 255));
        /**
         * ************************ Set bounds of components
         * *********************************
         */
        javax.swing.border.Border border = BorderFactory.createLineBorder(Color.RED, 1);
        lblReports.setBounds(580, 46, 125, 31);
        panelPackingList.setBounds(28, 108, 1266, 150);
        panelStockStatement.setBounds(28, 288, 1266, 150);
        lblPackingList.setBounds(0, 0, 200, 150);
        lblPackingList.setBorder(border);
        lblStockStatement.setBounds(0, 0, 200, 150);
        lblStockStatement.setBorder(border);
        lblInvoiceNumber.setBounds(311,66,144,24);
        panelPackingList.setBorder(border);
        panelStockStatement.setBorder(border);
        
        fldInvoiceNumber.setBounds(527,66,174,28);
        btnGetDetails.setBounds(817,60,115,37);
        btnGenerateStockReport.setBounds(505,54,219,37);
        
        dialogPackingList.setMinimumSize(new java.awt.Dimension(600, 200));

        /**
         * ************************ Add Components on Frame
         * *********************************
         */
        add(lblReports);
        add(panelPackingList);
        add(panelStockStatement);
        /**
         * ************ add components to panel *********
         */
        
        panelPackingList.add(lblPackingList);
        panelStockStatement.add(lblStockStatement);
        panelPackingList.add(lblInvoiceNumber);
        panelPackingList.add(fldInvoiceNumber);
        panelPackingList.add(btnGetDetails);
        panelStockStatement.add(btnGenerateStockReport);
        /**
         * ***************** Register listener *****************
         */
        
        btnGetDetails.addActionListener(this);
        btnGenerateStockReport.addActionListener(this);
        btnGetDetails.addKeyListener(this);
        btnGenerateStockReport.addKeyListener(this);
        fldInvoiceNumber.addKeyListener(this);
        btnPrint.addActionListener(this);
        btnCancel.addActionListener(this);
        btnPrint.addKeyListener(this);
        btnCancel.addKeyListener(this);
    }
    
                @Override
            public void keyTyped(KeyEvent e) {
                    if(e.getSource() == fldInvoiceNumber)
                        Validator.integerValidation(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getSource() == btnGetDetails){
                    if (e.getKeyCode()==KeyEvent.VK_ENTER){
                        btnGetDetailsclick();
                    }
                }
                else if(e.getSource() == btnGenerateStockReport){
                    if (e.getKeyCode()==KeyEvent.VK_ENTER){
                        btnGenerateStockReportclick();
                    }
                }
                else if(e.getSource() == btnPrint){
                    if (e.getKeyCode()==KeyEvent.VK_ENTER){
                        btnPrintclick();
                    }
                }
                else if(e.getSource() == btnCancel){
                    if (e.getKeyCode()==KeyEvent.VK_ENTER){
                        btnCancelclick();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == btnGetDetails)
        {
            btnGetDetailsActionPerformed(e);
        }
        else if(e.getSource() == btnGenerateStockReport)
        {
            btnStockReportActionPerformed(e);
        }
        else if(e.getSource() == btnPrint)
        {
             btnPrintclick();
        }
        else if(e.getSource() == btnCancel)
        {
             btnCancelclick();
        }

    }
    
    private void btnStockReportActionPerformed(java.awt.event.ActionEvent evt) {                                               
        btnGenerateStockReportclick();
    }                                              

    private void btnGetDetailsActionPerformed(java.awt.event.ActionEvent evt) {                                              
        btnGetDetailsclick();
    }                                         
            private void btnGetDetailsclick()
            {
               if (fldInvoiceNumber.getText() != null && !fldInvoiceNumber.getText().equals("")) 
        {
            try
            {
                int invoiceNumber = Integer.parseInt(fldInvoiceNumber.getText());
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("dd_MM_yy_hh_mm");
                File theDir = new File("C:/PackingListReport");
                if(!theDir.exists())
                {
                    theDir.mkdir();
                }
                fileName = "C:/PackingListReport/PackingList_" + invoiceNumber + "_" + format.format(date) + ".pdf";
                lblPackingListDialog2.setText(fileName);
                JasperReport jasperReport = new JasperReport();
                jasperReport.generateReport(invoiceNumber, fileName);
                dialogPackingList.setVisible(true);
                dialogPackingList.setLocationRelativeTo(null);
//                lblPackingListDialog1.setText("Your report has been saved at");
//                lblPackingListDialog2.setText(fileName);
//                PackingListDialog.setVisible(true);
//                PackingListDialog.setLocationRelativeTo(null);
            }
            catch (Exception ex) 
            {
                Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
            }
            
            private void btnGenerateStockReportclick()
            {
                Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd_MM_yy_hh_mm");
        File theDir = new File("C:/StockStatementReport");
                if(!theDir.exists())
                {
                    theDir.mkdir();
                }
        fileName = "C:/StockStatementReport/StockStatement_" + format.format(date) + ".pdf";
         lblPackingListDialog2.setText(fileName);
        StockReport stockReport = new StockReport();
        stockReport.generateStockReport(fileName);
        dialogPackingList.setVisible(true);
        dialogPackingList.setLocationRelativeTo(null);
//        lblPackingListDialog1.setText("Your report has been saved at");
//        lblPackingListDialog2.setText(fileName);
//        PackingListDialog.setVisible(true);
            }
            private void btnPrintclick()
            {
                 PrintFileToPrinter.dataToPrint(fileName);
                 dialogPackingList.dispose();
            }
            
            private void btnCancelclick()
            {
                 //PrintFileToPrinter.dataToPrint(fileName);
                 dialogPackingList.dispose();
            }
}
