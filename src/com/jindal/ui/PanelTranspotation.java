/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.ui;


import com.jindal.bill.BillCollectionReport;
import com.jindal.forms.HomePage;
import com.jindal.model.SalesOrderModel;
import com.jindal.service.S16MaximumMatch;
import com.jindal.service.SalesService;
import com.jindal.service.Validator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author RUBAL GARG
 */
public class PanelTranspotation extends JPanel  implements ActionListener
{
    
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnCancel;

    
    private javax.swing.JTextField fldTransportMode;
    private javax.swing.JTextField fldVehicleNumber;
   
    private javax.swing.JLabel lblTransPort;
    private javax.swing.JLabel lblTransportMode;
    private javax.swing.JLabel lblVehicleNumber;
    private javax.swing.JLabel lblDialog;
    private javax.swing.ButtonGroup buttonGroup;

    private javax.swing.JRadioButton rdVat,rdFullCst;     
            private javax.swing.JDialog dialogOrder;
    
    SalesOrderModel salesOrderModel;
    
    
    public PanelTranspotation(SalesOrderModel salesModel)
    {
        this.salesOrderModel = salesModel;
        System.out.println(this.salesOrderModel);
        lblTransPort = new com.jindal.ui.CustomLabel("Transport Detail", new java.awt.Font("Calibri", 1, 36), java.awt.Color.orange);
        lblTransportMode = new com.jindal.ui.CustomLabel("Transport Mode", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblVehicleNumber = new com.jindal.ui.CustomLabel("Vehicle Number", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        
        lblDialog = new com.jindal.ui.CustomLabel("Do you want to generate bill?", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        
        //fldTransportMode = new JTextField();
        // Transport
        fldTransportMode = new JTextField();
        fldTransportMode.setText("By Road");
        fldVehicleNumber = new JTextField();

        btnBack = new com.jindal.ui.CustomButton("Back", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnOrder = new com.jindal.ui.CustomButton("Order", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnGenerate = new com.jindal.ui.CustomButton("Generate", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnCancel = new com.jindal.ui.CustomButton("Cancel", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        
        
        rdFullCst = new javax.swing.JRadioButton();
        rdVat = new javax.swing.JRadioButton();
        buttonGroup = new javax.swing.ButtonGroup();
        dialogOrder = new javax.swing.JDialog();
        
        buttonGroup.add(rdFullCst);
        rdFullCst.setSelected(true);
        rdFullCst.setText("Full Cst ");

        buttonGroup.add(rdVat);
        rdVat.setText("Vat");

        
        /**
         * ******************** layout and background ******************
         */
        javax.swing.GroupLayout dialogOrderLayout = new javax.swing.GroupLayout(dialogOrder.getContentPane());
        dialogOrder.getContentPane().setLayout(dialogOrderLayout);
        dialogOrder.getContentPane().setBackground(new java.awt.Color(255, 255, 255));
        dialogOrder.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialogOrderLayout.setHorizontalGroup(
            dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogOrderLayout.createSequentialGroup()
                .addGroup(dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogOrderLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(lblDialog))
                    .addGroup(dialogOrderLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnCancel)
                        .addGap(85, 85, 85)
                        .addComponent(btnGenerate)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        dialogOrderLayout.setVerticalGroup(
            dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogOrderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDialog)
                .addGap(55, 55, 55)
                .addGroup(dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerate)
                    .addComponent(btnCancel))
                .addGap(40, 40, 40))
        );

        
        /**
         * ************ add components to panel *********
         */
        if(salesOrderModel!=null&&salesOrderModel.getTax()==12.5)
        {
            add(rdFullCst);
            add(rdVat);
        }
        
        
        
        add(lblTransPort);
        add(lblTransportMode);
        add(lblVehicleNumber);
        add(fldTransportMode);
        add(fldVehicleNumber);
        add(btnBack);
        add(btnOrder);
        /*
         * ************************ Set bounds of components
         * *********************************
         */
        lblTransPort.setBounds(580, 46, 400, 31);
        lblTransportMode.setBounds(480, 138, 150, 24);
        lblVehicleNumber.setBounds(480, 228, 150, 24);

        fldTransportMode.setBounds(750, 138, 174, 28);
        
        fldVehicleNumber.setBounds(750, 228, 174, 28);

        
        rdFullCst.setBounds(750,318,80, 28);
        
        rdVat.setBounds(840, 318,80, 28);
        
        btnBack.setBounds(480, 400, 120, 37);
        btnOrder.setBounds(750, 400, 120, 37);
        
        dialogOrder.setMinimumSize(new java.awt.Dimension(400, 175));
        dialogOrder.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        /**
         * ***************** Register listener *****************
         */
        btnBack.addActionListener(this);
        btnOrder.addActionListener(this);
        btnGenerate.addActionListener(this);
        btnCancel.addActionListener(this);
        
        fldVehicleNumber.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Validator.alphanumericIntegerValidation(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        if(salesOrderModel.getTransportMode()!=null)
        fldTransportMode.setText(salesOrderModel.getTransportMode());
        if(salesOrderModel.getVehicle()!=null)
        fldVehicleNumber.setText(salesOrderModel.getVehicle());
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == btnOrder)
//        {
//            btnOrderActionPerformed(e);
//        }
         if(e.getSource() == btnBack)
        {
            btnBackActionPerformed(e);
        }
        else if(e.getSource() == btnOrder)
        {
            if(rdFullCst.isSelected())
            {
                salesOrderModel.setVatSelected(false);
            }
            else
            {
                salesOrderModel.setVatSelected(true);             
            }
    
            JRootPane mJRootPane = this.getRootPane();
            final int WIDTH = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;    //This is maximum width of the windows
            final int HEIGHT = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;	//This is maximum height of the windows

            mJRootPane.getContentPane().revalidate();
            mJRootPane.getContentPane().repaint();
            mJRootPane.getContentPane().remove(this);
            HomePage.sLoadedPanel = new Panelbillconfirmation();
            HomePage.sLoadedPanel.setLayout(null);
            HomePage.sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
            HomePage.sLoadedPanel.setBackground(new java.awt.Color(255, 255, 255));

            mJRootPane.getContentPane().add(HomePage.sLoadedPanel);
            if(HomePage.sLoadedPanel instanceof Panelbillconfirmation)
            {
                ((Panelbillconfirmation)HomePage.sLoadedPanel).setData(salesOrderModel);
            }
            HomePage.sLoadedPanel.setVisible(true);
    
            
            
            
            
            //SalesService.saveTransaction(salesOrderModel);
                      
            //BillCollectionReport.generateBill(salesOrderModel);
        }
        else if(e.getSource() == btnCancel)
        {
            dialogOrder.setVisible(false);
        }
    }
    
    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {                                         
        salesOrderModel.setTransportMode(fldTransportMode.getText().toString());
        salesOrderModel.setVehicle(fldVehicleNumber.getText());
        dialogOrder.setVisible(true);
        dialogOrder.setLocationRelativeTo(null);
    }                                        
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JRootPane mJRootPane = this.getRootPane();
            final int WIDTH = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;    //This is maximum width of the windows
            final int HEIGHT = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;	//This is maximum height of the windows

            mJRootPane.getContentPane().revalidate();
            mJRootPane.getContentPane().repaint();
            mJRootPane.getContentPane().remove(this);
            HomePage.sLoadedPanel = new PanelSales();
            HomePage.sLoadedPanel.setLayout(null);
            HomePage.sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
            HomePage.sLoadedPanel.setBackground(new java.awt.Color(255, 255, 255));

            mJRootPane.getContentPane().add(HomePage.sLoadedPanel);
            if(HomePage.sLoadedPanel instanceof PanelSales)
            {
                ((PanelSales)HomePage.sLoadedPanel).setReloadData(salesOrderModel);
            }
            HomePage.sLoadedPanel.setVisible(true);
    }            
    
    
    
    
    
}
