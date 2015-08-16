/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.ui;

import com.jindal.bill.BillCollectionReport;
import com.jindal.bill.BillCollectionReportModel;
import com.jindal.bill.BillItemModel;
import com.jindal.forms.HomePage;
import com.jindal.model.CustomerServiceModel;
import com.jindal.model.ItemModel;
import com.jindal.model.SalesOrderModel;
import com.jindal.model.StockModel;
import com.jindal.service.SalesService;

import com.jindal.service.Validator;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import jindalenterprises.PrintFileToPrinter;

/**
 *
 * @author RUBAL GARG
 */
public class Panelbillconfirmation extends JPanel implements ActionListener {
    
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnYes;
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnUpDate;
    private javax.swing.JLabel lblSales;
    private javax.swing.JLabel lblDesignId;
    private javax.swing.JLabel lblFinish;
    //private javax.swing.JLabel lblQuantity;
    //private javax.swing.JLabel lblSize;
    //private javax.swing.JLabel lblThickness;
    private javax.swing.JLabel lblRate;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblTax;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameValue;
    private javax.swing.JLabel lblFirmName;
    private javax.swing.JTextField fldFirmNameValue;
    private javax.swing.JLabel lblTinNo;
    private javax.swing.JTextField fldTinNoValue;
    private javax.swing.JLabel lblInvoiceNumber;
    private javax.swing.JTextField fldInvoiceNumberValue;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblFrieght;
    private javax.swing.JLabel lblTax1;
    private javax.swing.JLabel lblTax1Value;
    private javax.swing.JLabel lblSurcharge;
    private javax.swing.JLabel lblSurchargeValue;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JLabel lblGrandTotalValue;
    private javax.swing.JLabel lblNetTotal;
    private javax.swing.JLabel lblNetTotalValue;
//    private javax.swing.JLabel lblQuantityHint;
    //   private javax.swing.JLabel lblQuantityError1;
    // private javax.swing.JLabel lblQuantityError2;
    private javax.swing.JLabel lblTaxError;
    private javax.swing.JLabel lblDialog;
    private javax.swing.JTextField fldDescription;
    private javax.swing.JTextField fldDate;
    private javax.swing.JTextField fldNoOfSheets;
    //private javax.swing.JTextField fldQuantity;
    //private javax.swing.JTextField fldSize;
    //private javax.swing.JComboBox fldThickness;
    private javax.swing.JTextField fldRate;
    private javax.swing.JTextField fldTax;
    private javax.swing.JTextField fldFright;
    private javax.swing.JTextField fldDiscount;
    private javax.swing.JPanel panelCustomerDetail;
    private javax.swing.JPanel panelAddItem;
    private javax.swing.JPanel panelAmount;
    private javax.swing.JTable table;
    private javax.swing.JDialog dialogOrder;
    String[][] array;
    SimpleDefaulTable mDefaultTableModel = null;
    int tableIndex = 0;
    double tax = 0;
    double freightCost = 0;
    double discountAmount = 0;
    double discountPer = 0;
    private int mRightQuantity = -1;
    CustomerServiceModel customerObj = null;
    private List<StockModel> mListStockModel;
    int currentInvoiceNumber = 0;
    double taxValue = 0;
    double surchargeValue = 0;
    Double Surchage = 0.0;
    BillCollectionReportModel billMain;
    private Double GrandTotal = 0.0;    
    SalesOrderModel msalesOrderModel;
    int selectedrow = -1;
    int NoOfSheets=0;
    
    public Panelbillconfirmation() {
        
        panelCustomerDetail = new javax.swing.JPanel();
        panelAddItem = new javax.swing.JPanel();
        panelAmount = new javax.swing.JPanel();
        
        panelAddItem.setLayout(null);
        panelAddItem.setBackground(new java.awt.Color(255, 255, 255));
        
        panelCustomerDetail.setLayout(null);
        panelCustomerDetail.setBackground(new java.awt.Color(255, 255, 255));
        
        panelAmount.setLayout(null);
        panelAmount.setBackground(new java.awt.Color(255, 255, 255));
        
        lblSales = new com.jindal.ui.CustomLabel("Bill Details", new java.awt.Font("Calibri", 1, 36), java.awt.Color.orange);
        lblDesignId = new com.jindal.ui.CustomLabel("Description", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblFinish = new com.jindal.ui.CustomLabel("No. of Sheets", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblRate = new com.jindal.ui.CustomLabel("Rate", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblTax = new com.jindal.ui.CustomLabel("Tax", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        
        lblName = new com.jindal.ui.CustomLabel("Customer Name", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblNameValue = new com.jindal.ui.CustomLabel("kzxjbkdjfbhjbgj", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblFirmName = new com.jindal.ui.CustomLabel("Firm Name", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblTinNo = new com.jindal.ui.CustomLabel("Tin No.", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblInvoiceNumber = new com.jindal.ui.CustomLabel("Invoice Number", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblDiscount = new com.jindal.ui.CustomLabel("Discount", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblFrieght = new com.jindal.ui.CustomLabel("Frieght", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblTax1 = new com.jindal.ui.CustomLabel("Tax", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblTax1Value = new com.jindal.ui.CustomLabel("0.0", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblSurcharge = new com.jindal.ui.CustomLabel("Surcharge", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblSurchargeValue = new com.jindal.ui.CustomLabel("0.0", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblGrandTotal = new com.jindal.ui.CustomLabel("Grand Total", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblGrandTotalValue = new com.jindal.ui.CustomLabel("0.0", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblNetTotal = new com.jindal.ui.CustomLabel("Net Total", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblNetTotalValue = new com.jindal.ui.CustomLabel("0.0", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        
        
        lblTaxError = new com.jindal.ui.CustomLabel("", new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(204, 51, 0));
        
        lblDialog = new com.jindal.ui.CustomLabel("Do you want to generate the bill?", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        
        dialogOrder = new javax.swing.JDialog();
        // design id

        
        fldDescription = new JTextField();



        // Finish
        fldNoOfSheets = new JTextField();
        
        
        
        
        fldFirmNameValue = new JTextField();
        fldTinNoValue = new JTextField();
        fldDate = new JTextField();
        
        fldInvoiceNumberValue = new JTextField();

        // Thickness
        fldRate = new JTextField();
        fldTax = new JTextField();
        fldFright = new JTextField();
        fldDiscount = new JTextField();
        
        btnUpDate = new com.jindal.ui.CustomButton("Update", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnAddItem = new com.jindal.ui.CustomButton("Save", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnNext = new com.jindal.ui.CustomButton("Print", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnBack = new com.jindal.ui.CustomButton("Back", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnDelete = new com.jindal.ui.CustomButton("Delete", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnYes = new com.jindal.ui.CustomButton("Yes", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnNo = new com.jindal.ui.CustomButton("No", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        
        
        final Object[] columnNames = {"Description",
            "No. of Sheets",
            "Rate Per Sheet", "Total Amount",};
        
        array = new String[0][0];
        
        mDefaultTableModel = new SimpleDefaulTable(array, columnNames);
        
        
        table = new JTable();
        table.setModel(mDefaultTableModel);
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(30);
        table.setFont(new Font("Tahoma", 0, 18));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = JTable.createScrollPaneForTable(table);


        /**
         * ******************** layout and background ******************
         */
        javax.swing.border.Border border = BorderFactory.createLineBorder(Color.RED, 1);
        panelAmount.setBorder(border);
        dialogOrder.getContentPane().setBackground(new java.awt.Color(255, 255, 255));
        javax.swing.GroupLayout dialogOrderLayout = new javax.swing.GroupLayout(dialogOrder.getContentPane());
        dialogOrder.getContentPane().setLayout(dialogOrderLayout);
        dialogOrderLayout.setHorizontalGroup(
                dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dialogOrderLayout.createSequentialGroup()
                .addGroup(dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dialogOrderLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblDialog))
                .addGroup(dialogOrderLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnNo)
                .addGap(85, 85, 85)
                .addComponent(btnYes)))
                .addContainerGap(89, Short.MAX_VALUE)));
        dialogOrderLayout.setVerticalGroup(
                dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogOrderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDialog)
                .addGap(55, 55, 55)
                .addGroup(dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnNo)
                .addComponent(btnYes))
                .addGap(40, 40, 40)));




        /**
         * ************ add components to panel *********
         */
        panelCustomerDetail.add(lblSales);
        panelCustomerDetail.add(btnBack);
        
        add(panelCustomerDetail);
        add(panelAddItem);
        
        panelAddItem.add(lblDesignId);
        panelAddItem.add(lblFinish);
        panelAddItem.add(lblRate);
        panelAddItem.add(panelAmount);

        // panelCustomerDetail.add(lblName);
        //panelCustomerDetail.add(lblNameValue);
        panelCustomerDetail.add(lblFirmName);
        panelCustomerDetail.add(fldFirmNameValue);
        panelCustomerDetail.add(lblTinNo);
        panelCustomerDetail.add(fldTinNoValue);
        panelCustomerDetail.add(lblInvoiceNumber);
        panelCustomerDetail.add(fldInvoiceNumberValue);
        panelCustomerDetail.add(lblTax);
        panelCustomerDetail.add(fldTax);
        panelCustomerDetail.add(lblTaxError);
        
        panelAddItem.add(fldDescription);
        panelAddItem.add(fldNoOfSheets);
        panelAddItem.add(fldRate);
        
        panelAddItem.add(btnUpDate);
        panelAddItem.add(btnAddItem);
        panelAddItem.add(btnDelete);
        panelAddItem.add(btnNext);
        panelAddItem.add(scrollPane);
        
        panelAmount.add(lblDiscount);
        panelAmount.add(lblFrieght);
        panelAmount.add(lblTax1);
        panelAmount.add(lblSurcharge);
        panelAmount.add(lblGrandTotal);
        panelAmount.add(lblNetTotal);
        panelAmount.add(lblTax1Value);
        panelAmount.add(lblSurchargeValue);
        panelAmount.add(lblGrandTotalValue);
        panelAmount.add(lblNetTotalValue);
        panelAmount.add(fldFright);
        panelAmount.add(fldDiscount);

        /**
         * ************************ Set bounds of components
         * *********************************
         */
        panelCustomerDetail.setBounds(16, 0, 1297, 89);
        panelAddItem.setBounds(16, 95, 1297, 369);
        panelAmount.setBounds(20, 224, 539, 142);
        lblSales.setBounds(522, 0, 250, 55);
        lblDesignId.setBounds(32, 24, 120, 25);
        lblFinish.setBounds(32, 77, 120, 24);
        lblRate.setBounds(32, 133, 120, 26);
        lblInvoiceNumber.setBounds(32, 70, 160, 13);
        fldInvoiceNumberValue.setBounds(188, 62, 120, 28);
        
        lblFirmName.setBounds(320, 70, 100, 13);
        fldFirmNameValue.setBounds(414, 62, 180, 28);
        lblTinNo.setBounds(650, 70, 100, 13);
        fldTinNoValue.setBounds(750, 62, 160, 28);
        lblTax.setBounds(1000, 70, 70, 13);
        
        lblTaxError.setBounds(1160, 62, 150, 13);
        
        fldDescription.setBounds(154, 21, 200, 28);
        fldNoOfSheets.setBounds(154, 74, 200, 28);
        fldRate.setBounds(154, 130, 200, 28);
        fldTax.setBounds(1050, 59, 100, 28);

//        fldQuantity.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//
//                       
//                        if(mRightQuantity > 0)
//                        {
//                            lblQuantityHint.setText("[Hint] Quantity for this design id is "+mRightQuantity);
//                        }
//                        fldQuantity.setText("");
//                        lblQuantityError1.setText("");
//                        lblQuantityError2.setText("");
//                             
//
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                if (!fldDescription.getSelectedItem().toString().equals("") && !fldThickness.getSelectedItem().toString().equals("")
//                        && !fldNoOfSheets.getSelectedItem().toString().equals("") && !fldQuantity.getText().equalsIgnoreCase("")) {
//                    if (mRightQuantity == -1) {
//                        fldQuantity.setForeground(Color.red);
//                        lblQuantityError1.setText("The Item you entered is not in stock");
//                        lblQuantityError1.setForeground(Color.red);
//                    } else if (mRightQuantity < Integer.parseInt(
//                            fldQuantity.getText().toString())) {
//                        lblQuantityError1.setText("Quantity you entered for this design id");
//                        lblQuantityError2.setText(" is not in stock. Right Quantity is " + mRightQuantity);
//                        lblQuantityError1.setForeground(Color.red);
//                        lblQuantityError2.setForeground(Color.red);
//                    }
//                }
//            }
//        });
        dialogOrder.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        fldRate.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Validator.doubleValidation(e, fldRate);
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        
        fldTax.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Validator.doubleValidation(e, fldTax);
                
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        
        
        
        fldTax.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //        btnAddItem.setEnabled(true);
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (fldTax.getText() != null && !fldTax.getText().equals("")) {
                    if (mDefaultTableModel != null && mDefaultTableModel.getRowCount() > 0) {
                        setValues();
                        lblTaxError.setText("");
                        btnAddItem.setEnabled(true);
                        btnNext.setEnabled(true);
                    }
                    lblTaxError.setText("");
                } else {
                    lblTaxError.setText("can't be empty.");
                    lblTaxError.setForeground(Color.red);
                    btnNext.setEnabled(false);
                    btnAddItem.setEnabled(false);
                    btnNext.setEnabled(false);
                }
            }
        });
        
        fldFright.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                String freight = fldFright.getText();
                if (freight != null) {
                    setValues();
                }
            }
        });
        fldDiscount.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                setValues();
            }
        });
        btnAddItem.setBounds(422, 184, 112, 30);
        btnNext.setBounds(1111, 336, 112, 30);
        btnDelete.setBounds(819, 336, 112, 30);
        btnBack.setBounds(48, 5, 112, 30);
        btnUpDate.setBounds(619, 336, 112, 30);
        scrollPane.setBounds(565, 21, 718, 302);
        
        lblDiscount.setBounds(19, 17, 100, 13);
        lblFrieght.setBounds(19, 111, 100, 25);
        lblTax1.setBounds(160, 12, 350, 15);
        lblTax1Value.setBounds(460, 12,120, 13);
        lblSurcharge.setBounds(329, 47, 100, 20);
        lblSurchargeValue.setBounds(460, 47, 130, 25);
        lblGrandTotal.setBounds(329, 88, 100, 13);
        lblGrandTotalValue.setBounds(460, 88, 130, 13);
        lblNetTotal.setBounds(329, 122, 100, 13);
        lblNetTotalValue.setBounds(460, 122, 130, 13);
        
        fldFright.setBounds(120, 111, 130, 25);
        fldDiscount.setBounds(120, 12, 70, 25);
        
        dialogOrder.setMinimumSize(new java.awt.Dimension(400, 175));

        /**
         * ***************** Register listener *****************
         */
        btnAddItem.addActionListener(this);
        btnBack.addActionListener(this);
        btnDelete.addActionListener(this);
        btnNext.addActionListener(this);
        btnYes.addActionListener(this);
        btnNo.addActionListener(this);
        btnUpDate.addActionListener(this);
        
        if (mListStockModel == null) {
            mListStockModel = new ArrayList<StockModel>();
        }
        
        
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                
                
                
            }
        });
        
    }
    
    public void setData(SalesOrderModel salesOrderModel) {
        
        
        msalesOrderModel = salesOrderModel;
        HashMap<Double, Integer> mHashMap = new HashMap<>();
        
        for (int i = 0; i < salesOrderModel.getItems().size(); i++) {
            if (mHashMap.containsKey(salesOrderModel.getItems().get(i).getRate())) {
                int value = mHashMap.get(salesOrderModel.getItems().get(i).getRate());
                mHashMap.put(salesOrderModel.getItems().get(i).getRate(), value + salesOrderModel.getItems().get(i).getQuantity());
            } else {
                mHashMap.put(salesOrderModel.getItems().get(i).getRate(), salesOrderModel.getItems().get(i).getQuantity());
            }
        }
        
        ArrayList<BillItemModel> itemMain = new ArrayList<BillItemModel>();
        int i = 1;
        for (Map.Entry<Double, Integer> entry : mHashMap.entrySet()) {
            Double key = entry.getKey();
            int value = entry.getValue();
            NoOfSheets = NoOfSheets + value;
            BillItemModel mBillItemModel = new BillItemModel();
            
            mBillItemModel.setItemName("Laminate Liner");
            mBillItemModel.setSerailNumber("" + i);
            i++;
            mBillItemModel.setNoOfSheets("" + value);
            mBillItemModel.setRatePerSheet("" + key);
            mBillItemModel.setTotalAmount("" + (value * key));
            
            
            itemMain.add(mBillItemModel);
        }
        
        billMain = new BillCollectionReportModel();
        
        billMain.setFirstName(salesOrderModel.getCustomerObj().getFirst_name());
        billMain.setLastName(salesOrderModel.getCustomerObj().getLast_name());
        billMain.setFirmName(salesOrderModel.getCustomerObj().getFirm_name());
        billMain.setAddress(salesOrderModel.getCustomerObj().getAddress());
        billMain.setCity(salesOrderModel.getCustomerObj().getCity());
        billMain.setTinNo(salesOrderModel.getCustomerObj().getTinNo());
        billMain.setModeOfTransport(salesOrderModel.getTransportMode());
        billMain.setVehicleNumber(salesOrderModel.getVehicle());
        billMain.setInvoiceNumber("" + salesOrderModel.getInvoiceNumber());
        billMain.setDate("" + (new Date(System.currentTimeMillis())));
        billMain.setmItemList(itemMain);
        billMain.setTotalNoOfSheets("" + NoOfSheets);
        billMain.setGrandTotal("" + salesOrderModel.getGrandTotal());
        billMain.setModeOfTransport(salesOrderModel.getTransportMode());
        billMain.setVehicleNumber(salesOrderModel.getVehicle());
        
        if (salesOrderModel.getTax() == 12.5) {
            if (salesOrderModel.isVatSelected()) {
                billMain.setTaxLabel(" Vat @ " + salesOrderModel.getTax() + "% ");
            } else {
                billMain.setTaxLabel(" FULL C.S.T @ " + salesOrderModel.getTax() + "% ");
            }
        } else if (salesOrderModel.getTax() == 2.0) {
            billMain.setTaxLabel(" Aganist 'C' form C.S.T @ " + salesOrderModel.getTax() + "% ");
        } else if (salesOrderModel.getTax() == 4.0) {
            billMain.setTaxLabel(" Aganist 'D1' form V.A.T @ " + salesOrderModel.getTax() + "% ");
        } else {
            billMain.setTaxLabel(" Tax @ " + salesOrderModel.getTax() + "% ");
        }
        
        
        
        
        
        if (salesOrderModel.getSurcharge() != 0.0) {
            billMain.setSurchareLabel("Surchage");
            billMain.setSurchageAmount("" + salesOrderModel.getSurchargeValue());
        } else {
            billMain.setSurchareLabel("");
            billMain.setSurchageAmount("");
        }
        if (salesOrderModel.getDiscount() != 0.0) {
            billMain.setDiscountLabel("Discount ");
            billMain.setDiscountTotal("" + salesOrderModel.getDiscountValue());
        } else {
            billMain.setDiscountLabel("");
            billMain.setDiscountTotal("");
        }
        
        billMain.setNetTotal("" + salesOrderModel.getNetTotal());
        billMain.setRoundOffValue(Math.round(salesOrderModel.getNetTotal())+"");
        /*String[] Round=(salesOrderModel.getNetTotal()+"").split(".");
         if(Integer.parseInt(Round[1])==0)
         {
         billMain.setRoundOffValue("");
         billMain.setMainTotal(salesOrderModel.getNetTotal()+".00");
         }
         else if(Integer.parseInt(Round[1])<50)
         {
         billMain.setRoundOffValue("-"+Round[1]);
         billMain.setMainTotal(""+((long)salesOrderModel.getNetTotal())+".00");
         }
         else
         {
         billMain.setRoundOffValue("+"+Round[1]);
         billMain.setMainTotal(""+((long)salesOrderModel.getNetTotal()+1)+".00");
         }*/
        
        
        fldInvoiceNumberValue.setText("" + billMain.getInvoiceNumber());
        fldFirmNameValue.setText("" + billMain.getFirmName());
        fldTinNoValue.setText("" + billMain.getTinNo());
        fldTax.setText("" + salesOrderModel.getTax());
        fldFright.setText(""+salesOrderModel.getFreight());
        fldDescription.setText("");
        fldDiscount.setText("" + billMain.getDiscountTotal());
        fldDate.setText("" + billMain.getDate());
        if (billMain.getFright() != null) {
            fldFright.setText("" + billMain.getFright());
        }
        //lblGrandTotalValue.setText(""+billMain.getGrandTotal());
        //lblNetTotalValue.setText(""+billMain.getNetTotal());
        
        GrandTotal = 0.0;
        array = new String[itemMain.size()][4];
        for (int k = 0; k < itemMain.size(); k++) {
            BillItemModel mItemModel = itemMain.get(k);
            array[k][0] = mItemModel.getItemName();
            array[k][1] = mItemModel.getNoOfSheets();
            array[k][2] = mItemModel.getRatePerSheet();
            array[k][3] = (Integer.parseInt(mItemModel.getNoOfSheets()) * Double.parseDouble(mItemModel.getRatePerSheet())) + "";
            GrandTotal = GrandTotal + Integer.parseInt(mItemModel.getNoOfSheets()) * Double.parseDouble(mItemModel.getRatePerSheet());
        }
        
        final Object[] columnNames = {"Description",
            "No. of Sheets",
            "Rate Per Sheet", "Total Amount",};
        
        
        mDefaultTableModel = new SimpleDefaulTable(array, columnNames);
        table.setModel(mDefaultTableModel);
        setValues();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnYes)
        {
            
            SalesService.saveTransaction(msalesOrderModel);
                billMain.setFirmName(fldFirmNameValue.getText());
                
        billMain.setTinNo(fldTinNoValue.getText());
        billMain.setInvoiceNumber("" + fldInvoiceNumberValue.getText());

        
        billMain.setTotalNoOfSheets("" + NoOfSheets);
        billMain.setGrandTotal("" + lblGrandTotalValue.getText());
        
        
        if (Double.parseDouble(
            fldTax.getText()) == 12.5) {
            if (msalesOrderModel.isVatSelected()) {
                billMain.setTaxLabel(" Vat @ " + Double.parseDouble(
            fldTax.getText()) + "% ");
            } else {
                billMain.setTaxLabel(" FULL C.S.T @ " + Double.parseDouble(
            fldTax.getText()) + "% ");
            }
        } else if (Double.parseDouble(
            fldTax.getText()) == 2.0) {
            billMain.setTaxLabel(" Aganist 'C' form C.S.T @ " + Double.parseDouble(
            fldTax.getText()) + "% ");
        } else if (Double.parseDouble(
            fldTax.getText()) == 4.0) {
            billMain.setTaxLabel(" Aganist 'D1' form V.A.T @ " + Double.parseDouble(
            fldTax.getText()) + "% ");
        } else {
            billMain.setTaxLabel(" Tax @ " + Double.parseDouble(
            fldTax.getText()) + "% ");
        }
        billMain.setTaxAmount(""+lblTax1Value.getText());
        billMain.setFright(""+fldFright.getText());
        
        
        
        if (Double.parseDouble(
            lblSurchargeValue.getText()) != 0.0) {
            billMain.setSurchareLabel("Surchage");
            billMain.setSurchageAmount("" + Double.parseDouble(
            lblSurchargeValue.getText()));
        } else {
            billMain.setSurchareLabel("");
            billMain.setSurchageAmount("");
        }
        if (!fldDiscount.getText().isEmpty()&&Double.parseDouble(
            fldDiscount.getText()) != 0.0) {
            billMain.setDiscountLabel("Discount ");
            billMain.setDiscountTotal("" + Double.parseDouble(
            fldDiscount.getText()));
        } else {
            billMain.setDiscountLabel("");
            billMain.setDiscountTotal("");
        }
        
        billMain.setNetTotal("" + Double.parseDouble(
            lblNetTotalValue.getText()));
        BillCollectionReport.generateBill(billMain);
        
        String fileName = null;
           fileName = "C:/Bills/Bill_" + fldInvoiceNumberValue.getText()+ ".pdf";
                PrintFileToPrinter.dataToPrint(fileName);
                 dialogOrder.dispose();
           
                 JRootPane mJRootPane = this.getRootPane();
            final int WIDTH = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;    //This is maximum width of the windows
            final int HEIGHT = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;	//This is maximum height of the windows

            mJRootPane.getContentPane().revalidate();
            mJRootPane.getContentPane().repaint();
            mJRootPane.getContentPane().remove(this);
            HomePage.sLoadedPanel = new PanelCustomer(false);
            HomePage.sLoadedPanel.setLayout(null);
            HomePage.sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
            HomePage.sLoadedPanel.setBackground(new java.awt.Color(255, 255, 255));

            mJRootPane.getContentPane().add(HomePage.sLoadedPanel);

            HomePage.sLoadedPanel.setVisible(true);
    
                 
    }
        else if(e.getSource() == btnNo)
        {
            dialogOrder.setVisible(false);
            dialogOrder.dispose();
        }
        else if(e.getSource()==btnBack)
        {
            btnBackActionPerformed(e);
        }
        else if(e.getSource()==btnNext)
        {
            dialogOrder.setVisible(true);
            dialogOrder.setLocationRelativeTo(null);
        }
        else if (e.getSource() == btnAddItem) {
            if (!fldDescription.getText().equalsIgnoreCase("") && !fldNoOfSheets.getText().equalsIgnoreCase("") && !fldRate.getText().equalsIgnoreCase("")) {
                billMain.getmItemList().get(selectedrow).setItemName(fldDescription.getText());
                billMain.getmItemList().get(selectedrow).setNoOfSheets(fldNoOfSheets.getText());
                billMain.getmItemList().get(selectedrow).setRatePerSheet(fldRate.getText());
                
               
                
                
                billMain.getmItemList().get(selectedrow).setTotalAmount(Double.parseDouble(fldRate.getText()) * Integer.parseInt(fldNoOfSheets.getText()) + "");
                
                
                 fldDescription.setText("");
                fldRate.setText("");
                fldNoOfSheets.setText("");
                GrandTotal = 0.0;
                array = new String[billMain.getmItemList().size()][4];
                NoOfSheets=0;
                for (int k = 0; k < billMain.getmItemList().size(); k++) {
                    BillItemModel mItemModel = billMain.getmItemList().get(k);
                    array[k][0] = mItemModel.getItemName();
                    array[k][1] = mItemModel.getNoOfSheets();
                    NoOfSheets=NoOfSheets+Integer.parseInt(mItemModel.getNoOfSheets());
                    array[k][2] = mItemModel.getRatePerSheet();
                    array[k][3] = (Integer.parseInt(mItemModel.getNoOfSheets()) * Double.parseDouble(mItemModel.getRatePerSheet())) + "";
                    GrandTotal = GrandTotal + Integer.parseInt(mItemModel.getNoOfSheets()) * Double.parseDouble(mItemModel.getRatePerSheet());
                }
                
                final Object[] columnNames = {"Description",
                    "No. of Sheets",
                    "Rate Per Sheet", "Total Amount",};
                
                
                mDefaultTableModel = new SimpleDefaulTable(array, columnNames);
                table.setModel(mDefaultTableModel);
                setValues();
                
                
            }
        } else if (e.getSource() == btnDelete) {
            
            
                
            billMain.getmItemList().remove(selectedrow);
            
            GrandTotal = 0.0;
            array = new String[billMain.getmItemList().size()][4];
            NoOfSheets=0;
            for (int k = 0; k < billMain.getmItemList().size(); k++) {
                BillItemModel mItemModel = billMain.getmItemList().get(k);
                array[k][0] = mItemModel.getItemName();
                array[k][1] = mItemModel.getNoOfSheets();

                                    NoOfSheets=NoOfSheets+Integer.parseInt(mItemModel.getNoOfSheets());

                array[k][2] = mItemModel.getRatePerSheet();
                array[k][3] = (Integer.parseInt(mItemModel.getNoOfSheets()) * Double.parseDouble(mItemModel.getRatePerSheet())) + "";
                GrandTotal = GrandTotal + Integer.parseInt(mItemModel.getNoOfSheets()) * Double.parseDouble(mItemModel.getRatePerSheet());
            }
            
            
            fldDescription.setText("");
                fldRate.setText("");
                fldNoOfSheets.setText("");
            
            final Object[] columnNames = {"Description",
                "No. of Sheets",
                "Rate Per Sheet", "Total Amount",};
            
            
            mDefaultTableModel = new SimpleDefaulTable(array, columnNames);
            table.setModel(mDefaultTableModel);
            setValues();
            
            
        } else if (e.getSource() == btnUpDate) {
            
            selectedrow = table.getSelectedRow();
            
            if (selectedrow != -1) {
                fldDescription.setText("" + billMain.getmItemList().get(selectedrow).getItemName());
                fldNoOfSheets.setText("" + billMain.getmItemList().get(selectedrow).getNoOfSheets());
                fldRate.setText("" + billMain.getmItemList().get(selectedrow).getRatePerSheet());
                
            }
        }
    }
    
    private void setValues() {
        Double Discount = 0.0, Fright = 0.0;
        Double taxPercntage = 0.0;
        Double Tax = 0.0;
        
        Surchage = 0.0;
        if (fldDiscount.getText() != null && !fldDiscount.getText().equalsIgnoreCase("")) {
            Discount = Double.parseDouble("" + fldDiscount.getText().toString());
        }
        
        if (!fldFright.getText().equalsIgnoreCase("")) {
            Fright = Double.parseDouble(fldFright.getText());
        }
        
        if (!fldTax.getText().equalsIgnoreCase("")) {
            
            taxPercntage = Double.parseDouble(fldTax.getText());
            
            String applicableTaxes = SalesService.getApplicableTaxes();
            if (applicableTaxes != null) {
                String taxes[] = applicableTaxes.split(",");
                String CustomerTax = Double.toString(taxPercntage);
                for (String taxOne : taxes) {
                    if (!taxOne.contains(".")) {
                        taxOne = taxOne + ".0";
                    }
                    if (taxOne.equals(CustomerTax)) {
                        Surchage = SalesService.getSurcharge();
                    }
                }
            }
        }
        Double GrandTotal = this.GrandTotal - Discount;
        if (taxPercntage != 0.0) {
            Tax = (GrandTotal * taxPercntage) / 100;
            if (Surchage != 0.0) {
                Surchage = (Tax * Surchage) / 100;
            }
        }
        Double NetTotal=0.0;
        if(this.GrandTotal==0)
        {
           GrandTotal=0.0; 
        }
        else
        {
        GrandTotal = this.GrandTotal + Fright;
        NetTotal = this.GrandTotal - Discount + Tax + Fright + Surchage;
        }
         
        
        lblGrandTotalValue.setText("" + GrandTotal);
        lblSurchargeValue.setText(Surchage + "");
        lblTax1Value.setText(Tax + "");
        lblNetTotalValue.setText("" + NetTotal);
        
        if (fldTax.getText() != null) {
            Double tax = Double.parseDouble(fldTax.getText());
            if (tax == 12.5) {
                if (msalesOrderModel.isVatSelected()) {
                    billMain.setTaxLabel(" Vat @ " + msalesOrderModel.getTaxValue() + "% ");
                } else {
                    billMain.setTaxLabel(" FULL C.S.T @ " + msalesOrderModel.getTaxValue() + "% ");
                }
            } else if (msalesOrderModel.getTax() == 2.0) {
                billMain.setTaxLabel(" Aganist 'C' form C.S.T @ " + msalesOrderModel.getTaxValue() + "% ");
            } else if (msalesOrderModel.getTax() == 4.0) {
                billMain.setTaxLabel(" Aganist 'D1' form V.A.T @ " + msalesOrderModel.getTaxValue() + "% ");
            } else {
                billMain.setTaxLabel(" Tax @ " + msalesOrderModel.getTaxValue() + "% ");
            }
        }        
        
        lblTax1.setText(billMain.getTaxLabel());
        
        
    }
    
    
    
    
       private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JRootPane mJRootPane = this.getRootPane();
            final int WIDTH = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;    //This is maximum width of the windows
            final int HEIGHT = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;	//This is maximum height of the windows

            mJRootPane.getContentPane().revalidate();
            mJRootPane.getContentPane().repaint();
            mJRootPane.getContentPane().remove(this);
            HomePage.sLoadedPanel = new PanelTranspotation(msalesOrderModel);
            HomePage.sLoadedPanel.setLayout(null);
            HomePage.sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
            HomePage.sLoadedPanel.setBackground(new java.awt.Color(255, 255, 255));

            mJRootPane.getContentPane().add(HomePage.sLoadedPanel);
          
            HomePage.sLoadedPanel.setVisible(true);
    }                                        

}


