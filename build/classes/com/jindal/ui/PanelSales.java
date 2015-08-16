/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.ui;

import com.jindal.forms.HomePage;
import com.jindal.forms.Trasportation;
import com.jindal.model.CustomerServiceModel;
import com.jindal.model.ItemModel;
import com.jindal.model.SalesOrderModel;
import com.jindal.model.StockModel;
import com.jindal.service.ItemService;
import com.jindal.service.S16MaximumMatch;
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
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RUBAL GARG
 */
public class PanelSales extends JPanel implements ActionListener {

    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnYes;
    private javax.swing.JButton btnNo;
    private javax.swing.JLabel lblSales;
    private javax.swing.JLabel lblDesignId;
    private javax.swing.JLabel lblFinish;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel lblThickness;
    private javax.swing.JLabel lblRate;
    private javax.swing.JLabel lblTax;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameValue;
    private javax.swing.JLabel lblFirmName;
    private javax.swing.JLabel lblFirmNameValue;
    private javax.swing.JLabel lblTinNo;
    private javax.swing.JLabel lblTinNoValue;
    private javax.swing.JLabel lblInvoiceNumber;
    private javax.swing.JLabel lblInvoiceNumberValue;
    private javax.swing.JLabel lblDiscountValue;
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
    private javax.swing.JLabel lblQuantityHint;
    private javax.swing.JLabel lblQuantityError1;
    private javax.swing.JLabel lblQuantityError2;
    private javax.swing.JLabel lblTaxError;
    private javax.swing.JLabel lblDialog;
    private javax.swing.JComboBox fldDesignId;
    private javax.swing.JComboBox fldFinish;
    private javax.swing.JTextField fldPrice;
    private javax.swing.JTextField fldQuantity;
    private javax.swing.JTextField fldSize;
    private javax.swing.JComboBox fldThickness;
    private javax.swing.JTextField fldRate;
    private javax.swing.JTextField fldTax;
    private javax.swing.JTextField fldFright;
    private javax.swing.JTextField fldDiscount;
    private javax.swing.JPanel panelCustomerDetail;
    private javax.swing.JPanel panelAddItem;
    private javax.swing.JPanel panelAmount;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JRadioButton rdAmount;
    private javax.swing.JRadioButton rdPercantage;
    private javax.swing.JTable table;
    private javax.swing.JDialog dialogOrder;

    String[][] array;
    SimpleDefaulTable mDefaultTableModel = null;
    double grandTotalMajor = 0;
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

    public PanelSales() {
        panelCustomerDetail = new javax.swing.JPanel();
        panelAddItem = new javax.swing.JPanel();
        panelAmount = new javax.swing.JPanel();

        panelAddItem.setLayout(null);
        panelAddItem.setBackground(new java.awt.Color(255, 255, 255));

        panelCustomerDetail.setLayout(null);
        panelCustomerDetail.setBackground(new java.awt.Color(255, 255, 255));

        panelAmount.setLayout(null);
        panelAmount.setBackground(new java.awt.Color(255, 255, 255));

        lblSales = new com.jindal.ui.CustomLabel("Stock Inventory", new java.awt.Font("Calibri", 1, 36), java.awt.Color.orange);
        lblDesignId = new com.jindal.ui.CustomLabel("Design Id", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblThickness = new com.jindal.ui.CustomLabel("Thickness", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblFinish = new com.jindal.ui.CustomLabel("Finish", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblQuantity = new com.jindal.ui.CustomLabel("Quantity", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblRate = new com.jindal.ui.CustomLabel("Rate", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblSize = new com.jindal.ui.CustomLabel("Size", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblTax = new com.jindal.ui.CustomLabel("Tax", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));

        lblName = new com.jindal.ui.CustomLabel("Customer Name", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblNameValue = new com.jindal.ui.CustomLabel("kzxjbkdjfbhjbgj", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblFirmName = new com.jindal.ui.CustomLabel("Firm Name", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblFirmNameValue = new com.jindal.ui.CustomLabel("rrrrrrrrrrrrrrrrrrrrr", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblTinNo = new com.jindal.ui.CustomLabel("Tin No.", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblTinNoValue = new com.jindal.ui.CustomLabel("1234679000", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblInvoiceNumber = new com.jindal.ui.CustomLabel("Invoice Number", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblInvoiceNumberValue = new com.jindal.ui.CustomLabel("125125", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));

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

        lblDiscountValue = new com.jindal.ui.CustomLabel("0.0", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));

        lblQuantityError1 = new com.jindal.ui.CustomLabel("", new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(204, 51, 0));
        lblQuantityError2 = new com.jindal.ui.CustomLabel("", new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(204, 51, 0));
        lblTaxError = new com.jindal.ui.CustomLabel("", new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(204, 51, 0));
        
        lblQuantityHint = new com.jindal.ui.CustomLabel("", new java.awt.Font("Tahoma", 0, 12), java.awt.Color.orange);
        lblDialog = new com.jindal.ui.CustomLabel("Do you want to Cancel the Order?", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        buttonGroup = new javax.swing.ButtonGroup();
        rdAmount = new javax.swing.JRadioButton();
        rdPercantage = new javax.swing.JRadioButton();
        
        dialogOrder = new javax.swing.JDialog();
        // design id


        fldDesignId = new JComboBox();
        fldDesignId.setEditable(true);
        fldDesignId.setAutoscrolls(true);
        fldDesignId.setFocusCycleRoot(true);

        ArrayList<String> finishArrayList1 = HomePage.designIdArray;
        fldDesignId.setModel(new javax.swing.DefaultComboBoxModel(finishArrayList1.toArray()));
        new S16MaximumMatch(fldDesignId);

        // Finish
        fldFinish = new JComboBox();
        ArrayList<String> finishArrayList2 = SalesService.getFinish();
        fldFinish.setModel(new javax.swing.DefaultComboBoxModel(finishArrayList2.toArray()));
        fldFinish.setEditable(true);
        fldFinish.setAutoscrolls(true);
        fldFinish.setFocusCycleRoot(true);
        new S16MaximumMatch(fldFinish);

        // Thickness
        fldThickness = new JComboBox();
        ArrayList<String> finishArrayList3 = SalesService.getThickness();
        fldThickness.setModel(new javax.swing.DefaultComboBoxModel(finishArrayList3.toArray()));
        fldThickness.setEditable(true);
        fldThickness.setAutoscrolls(true);
        fldThickness.setFocusCycleRoot(true);


        new S16MaximumMatch(fldThickness);

        fldQuantity = new JTextField();
        fldRate = new JTextField();
        fldSize = new JTextField();
        fldTax = new JTextField();
        fldFright = new JTextField();
        fldDiscount = new JTextField();
        
        btnAddItem = new com.jindal.ui.CustomButton("Add Item", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnNext = new com.jindal.ui.CustomButton("Next", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnBack = new com.jindal.ui.CustomButton("Back", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnDelete = new com.jindal.ui.CustomButton("Delete", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnYes = new com.jindal.ui.CustomButton("Yes", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnNo = new com.jindal.ui.CustomButton("No", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));


        final Object[] columnNames = {"Design Id",
            "Thickness",
            "Finish", "Quantity",
            "Rate", "Size", "Price"};

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
        fldSize.setText("8*4");
        
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
                .addContainerGap(89, Short.MAX_VALUE))
        );
        dialogOrderLayout.setVerticalGroup(
            dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogOrderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDialog)
                .addGap(55, 55, 55)
                .addGroup(dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNo)
                    .addComponent(btnYes))
                .addGap(40, 40, 40))
        );
        
        
        
        
        /**
         * ************ add components to panel *********
         */
        panelCustomerDetail.add(lblSales);
        panelCustomerDetail.add(btnBack);

        add(panelCustomerDetail);
        add(panelAddItem);
        panelAddItem.add(lblDesignId);
        panelAddItem.add(lblThickness);
        panelAddItem.add(lblFinish);
        panelAddItem.add(lblQuantity);
        panelAddItem.add(lblRate);
        panelAddItem.add(lblSize);
        panelAddItem.add(panelAmount);

        panelAddItem.add(lblQuantityError1);
        panelAddItem.add(lblQuantityError2);
        panelAddItem.add(lblQuantityHint);
        // panelCustomerDetail.add(lblName);
        //panelCustomerDetail.add(lblNameValue);
        panelCustomerDetail.add(lblFirmName);
        panelCustomerDetail.add(lblFirmNameValue);
        panelCustomerDetail.add(lblTinNo);
        panelCustomerDetail.add(lblTinNoValue);
        panelCustomerDetail.add(lblInvoiceNumber);
        panelCustomerDetail.add(lblInvoiceNumberValue);
        panelCustomerDetail.add(lblTax);
        panelCustomerDetail.add(fldTax);
        panelCustomerDetail.add(lblTaxError);

        panelAddItem.add(fldDesignId);
        panelAddItem.add(fldThickness);
        panelAddItem.add(fldFinish);
        panelAddItem.add(fldQuantity);
        panelAddItem.add(fldRate);
        panelAddItem.add(fldSize);


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
        panelAmount.add(rdAmount);
        panelAmount.add(rdPercantage);
        panelAmount.add(lblDiscountValue);

        /**
         * ************************ Set bounds of components
         * *********************************
         */
        panelCustomerDetail.setBounds(16, 0, 1297, 89);
        panelAddItem.setBounds(16, 95, 1297, 369);
        panelAmount.setBounds(20, 224, 539, 142);
        lblSales.setBounds(522, 0, 250, 55);
        lblDesignId.setBounds(32, 24, 82, 25);
        lblThickness.setBounds(303, 24, 89, 24);
        lblFinish.setBounds(32, 77, 89, 24);
        lblQuantity.setBounds(303, 77, 89, 24);
        lblRate.setBounds(32, 133, 358, 26);
        lblSize.setBounds(303, 133, 358, 26);
        lblInvoiceNumber.setBounds(32, 62, 160, 13);
        lblInvoiceNumberValue.setBounds(188, 62, 120, 13);

        lblFirmName.setBounds(303, 62, 100, 13);
        lblFirmNameValue.setBounds(414, 62, 180, 13);
        lblTinNo.setBounds(650, 62, 100, 13);
        lblTinNoValue.setBounds(750, 62, 160, 13);
        lblTax.setBounds(1000, 62, 70, 13);

        lblTaxError.setBounds(1160, 62, 150, 13);

        lblQuantityError1.setBounds(350, 100, 230, 13);
        lblQuantityError2.setBounds(350, 115, 230, 13);
        lblQuantityHint.setBounds(350, 55, 230, 13);
        
        fldDesignId.setBounds(154, 21, 100, 28);
        fldThickness.setBounds(422, 21, 100, 28);
        fldFinish.setBounds(154, 74, 100, 28);
        fldQuantity.setBounds(422, 74, 100, 28);
        fldRate.setBounds(154, 130, 100, 28);
        fldSize.setBounds(422, 130, 100, 28);
        fldTax.setBounds(1050, 59, 100, 28);

        fldQuantity.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                        getRightQuantity();
                        if(mRightQuantity > 0)
                        {
                            lblQuantityHint.setText("[Hint] Quantity for this design id is "+mRightQuantity);
                        }
                        fldQuantity.setText("");
                        lblQuantityError1.setText("");
                        lblQuantityError2.setText("");
                             

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!fldDesignId.getSelectedItem().toString().equals("") && !fldThickness.getSelectedItem().toString().equals("")
                        && !fldFinish.getSelectedItem().toString().equals("") && !fldQuantity.getText().equalsIgnoreCase("")) {
                    if (mRightQuantity == -1) {
                        fldQuantity.setForeground(Color.red);
                        lblQuantityError1.setText("The Item you entered is not in stock");
                        lblQuantityError1.setForeground(Color.red);
                    } else if (mRightQuantity < Integer.parseInt(
                            fldQuantity.getText().toString())) {
                        lblQuantityError1.setText("Quantity you entered for this design id");
                        lblQuantityError2.setText(" is not in stock. Right Quantity is " + mRightQuantity);
                        lblQuantityError1.setForeground(Color.red);
                        lblQuantityError2.setForeground(Color.red);
                    }
                }
            }
        });


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
        fldQuantity.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Validator.integerValidation(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        fldFinish.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if (lblQuantityError1.getText() != null || lblQuantityError1.getText().equals("")) {
                    lblQuantityError1.setText("");
                    lblQuantityError2.setText("");
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                getRightQuantity();

            }
        });


        fldTax.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                btnAddItem.setEnabled(true);

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

        scrollPane.setBounds(565, 21, 718, 302);

        lblDiscount.setBounds(19, 17, 100, 13);
        lblFrieght.setBounds(19, 111, 100, 25);
        lblTax1.setBounds(329, 12, 100, 13);
        lblTax1Value.setBounds(439, 12, 130, 13);
        lblSurcharge.setBounds(329, 47, 100, 20);
        lblSurchargeValue.setBounds(439, 47, 130, 25);
        lblGrandTotal.setBounds(329, 88, 100, 13);
        lblGrandTotalValue.setBounds(439, 88, 130, 13);
        lblNetTotal.setBounds(329, 122, 100, 13);
        lblNetTotalValue.setBounds(439, 122, 130, 13);

        buttonGroup.add(rdAmount);
        rdAmount.setSelected(true);
        rdAmount.setText("Amount");

        buttonGroup.add(rdPercantage);
        rdPercantage.setText("% Percantage");

        rdAmount.setBounds(120, 17, 70, 13);
        rdPercantage.setBounds(120, 37, 70, 13);

        fldFright.setBounds(150, 111, 130, 25);
        fldDiscount.setBounds(200, 30, 70, 25);
        lblDiscountValue.setBounds(120, 60, 130, 25);
        
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

        
        if (mListStockModel == null) {
            mListStockModel = new ArrayList<StockModel>();
        }

        rdAmount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setValues();
            }
        });

        rdPercantage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setValues();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddItem) {
            lblQuantityHint.setText("");
            btnAddItemActionPerformed(e);
        } else if (e.getSource() == btnDelete) {
            if (table.getSelectedRow() >= 0) {
                int row = table.getSelectedRow();
                mDefaultTableModel = (SimpleDefaulTable) table.getModel();
                double price = Double.parseDouble(mDefaultTableModel.getValueAt(row, 6).toString());

                grandTotalMajor = grandTotalMajor - price;

                setValues();
                tableIndex--;

                for (StockModel stockModel : mListStockModel) {
                    if (stockModel.getDesign_Id().equalsIgnoreCase(fldDesignId.getSelectedItem().toString())
                            && stockModel.getThickness().equalsIgnoreCase(fldThickness.getSelectedItem().toString())
                            && stockModel.getFinish().equalsIgnoreCase(fldFinish.getSelectedItem().toString())) {

                        stockModel.setQuantity(Integer.parseInt(mDefaultTableModel.getValueAt(row, 3).toString()));
                        System.out.println("" + Integer.parseInt(mDefaultTableModel.getValueAt(row, 3).toString()));
                        tableIndex--;
                        break;
                    }
                }
                mDefaultTableModel.removeRow(row);
            }
            if (table.getRowCount() == 0) {
                lblGrandTotalValue.setText("0.00");
                lblNetTotalValue.setText("0.00");
                fldFright.setText("0.00");
                fldDiscount.setText("");
                lblDiscountValue.setText("0.00");
                fldTax.setText("0.00");
                lblSurchargeValue.setText("0.00");

                // disable frieght and discount field and Next button..
                fldDiscount.setEnabled(false);
                tableIndex = 0;
            }
        } else if (btnNext == e.getSource()) {
            btnNextSalesActionPerformed(e);
        }
        else if(e.getSource() == btnBack)
        {
            if (table.getRowCount() > 0)
            {
                dialogOrder.setVisible(true);
                dialogOrder.setLocationRelativeTo(null);
            }
            else
            {
                btnYesActionPerformed(e);
            }
        }
        else if(e.getSource() == btnYes)
        {
            btnYesActionPerformed(e);
            dialogOrder.setVisible(false);
        }
        else if(e.getSource() == btnNo)
        {
            dialogOrder.setVisible(false);
        }
    }

    private void btnNextSalesActionPerformed(java.awt.event.ActionEvent evt) {
        if (table.getRowCount() > 0) {
            ArrayList<ItemModel> items = new ArrayList<ItemModel>();
            SalesOrderModel salesModel = new SalesOrderModel();
            mDefaultTableModel = (SimpleDefaulTable) table.getModel();
            int rows = mDefaultTableModel.getRowCount();
            for (int row = 0; row < rows; row++) {
                ItemModel item = new ItemModel();
                item.setDesign_Id(mDefaultTableModel.getValueAt(row, 0).toString());
                item.setThickness(mDefaultTableModel.getValueAt(row, 1).toString());
                item.setFinish(mDefaultTableModel.getValueAt(row, 2).toString());
                item.setQuantity(Integer.parseInt(mDefaultTableModel.getValueAt(row, 3).toString()));
                item.setRate(Double.parseDouble(mDefaultTableModel.getValueAt(row, 4).toString()));
                item.setSize(mDefaultTableModel.getValueAt(row, 5).toString());
                item.setPrice(Double.parseDouble(mDefaultTableModel.getValueAt(row, 6).toString()));

                items.add(item);
            }
            salesModel.setInvoiceNumber(Integer.parseInt(lblInvoiceNumberValue.getText()));
            salesModel.setItems(items);
            double discountValue = 0.0, discount = 0.0, Fright = 0.0, TAXPERCENTAGE = 0.0, TAX = 0.0;

            if (fldDiscount.getText() != null && !fldDiscount.getText().equals("")) {
                discountValue = Double.parseDouble("" + fldDiscount.getText());
            }

            if (rdAmount.isSelected()) {
                salesModel.setIsAmountselected(true);
            } else {
                salesModel.setIsAmountselected(false);
            }

            if (lblDiscountValue.getText() != null && !lblDiscountValue.getText().toString().equals("")) {
                discount = Double.parseDouble(lblDiscountValue.getText());
            }


            if (fldFright.getText() != null && !fldFright.getText().toString().equals("")) {
                Fright = Double.parseDouble(fldFright.getText());
            }

            if (fldTax.getText() != null && !fldTax.getText().toString().equalsIgnoreCase("")) {
                TAXPERCENTAGE = Double.parseDouble(fldTax.getText());
            }

            if (lblTax1Value.getText() != null && !lblTax1Value.getText().toString().equalsIgnoreCase("")) {
                TAX = Double.parseDouble(lblTax1Value.getText());
            }
salesModel.setDiscountValue(discountValue);
            salesModel.setDiscount(discount);
            salesModel.setFreight(Fright);
            salesModel.setTax(TAXPERCENTAGE);
            salesModel.setTaxValue(TAX);
            salesModel.setSurcharge(Surchage);

            salesModel.setSurchargeValue(Double.parseDouble(lblSurchargeValue.getText()));
            salesModel.setGrandTotal(Double.parseDouble(lblGrandTotalValue.getText()));
            salesModel.setNetTotal(Double.parseDouble(lblNetTotalValue.getText()));

            salesModel.setCustomerObj(customerObj);


            //loading Transpotation panel
            JRootPane mJRootPane = this.getRootPane();
            final int WIDTH = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;    //This is maximum width of the windows
            final int HEIGHT = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;	//This is maximum height of the windows

            mJRootPane.getContentPane().revalidate();
            mJRootPane.getContentPane().repaint();
            mJRootPane.getContentPane().remove(this);
            HomePage.sLoadedPanel = new PanelTranspotation(salesModel);
            HomePage.sLoadedPanel.setLayout(null);
            HomePage.sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
            HomePage.sLoadedPanel.setBackground(new java.awt.Color(255, 255, 255));

            mJRootPane.getContentPane().add(HomePage.sLoadedPanel);

            HomePage.sLoadedPanel.setVisible(true);
        }
    }

    public void setData(CustomerServiceModel mcustomerServiceModel) {
        this.customerObj = mcustomerServiceModel;
        lblInvoiceNumberValue.setText("" + SalesService.getCurrentInvoiceNumber());
        lblFirmNameValue.setText(mcustomerServiceModel.getFirm_name());
        lblTinNoValue.setText(mcustomerServiceModel.getTinNo());
        fldTax.setText("" + mcustomerServiceModel.getTax());
    }

    private void getRightQuantity() {

        boolean isDataBaseHitRequired = true;

        if (!fldDesignId.getSelectedItem().toString().toString().equalsIgnoreCase("")
                && !fldThickness.getSelectedItem().toString().equalsIgnoreCase("")
                && !fldFinish.getSelectedItem().toString().equalsIgnoreCase("")) {
            for (StockModel stockModel : mListStockModel) {
                if (stockModel.getDesign_Id().equalsIgnoreCase(fldDesignId.getSelectedItem().toString())
                        && stockModel.getThickness().equalsIgnoreCase(fldThickness.getSelectedItem().toString())
                        && stockModel.getFinish().equalsIgnoreCase(fldFinish.getSelectedItem().toString())) {
                    isDataBaseHitRequired = false;
                    mRightQuantity = stockModel.getQuantity();
                }
            }

            if (isDataBaseHitRequired) {
                ItemModel itemModel = new ItemModel();
                itemModel.setDesign_Id(fldDesignId.getSelectedItem().toString());
                itemModel.setThickness(fldThickness.getSelectedItem().toString());
                itemModel.setFinish(fldFinish.getSelectedItem().toString());

                mRightQuantity = ItemService.checkItemQuantity(itemModel);
                if (mRightQuantity != -1) {
                    StockModel mStockModel = new StockModel();
                    mStockModel.setDesign_Id(fldDesignId.getSelectedItem().toString());
                    mStockModel.setThickness(fldThickness.getSelectedItem().toString());
                    mStockModel.setFinish(fldFinish.getSelectedItem().toString());
                    mStockModel.setQuantity(mRightQuantity);
                    mListStockModel.add(mStockModel);
                }
            }
        }
    }

    public void getTax() {
        if (fldTax.getText() != null && !fldTax.getText().equals("")) {
            String taxString = fldTax.getText();
            if (taxString.startsWith(".")) {

                taxString = "0" + taxString;
                tax = Double.parseDouble(taxString);
            } else if (taxString.endsWith(".")) {
                taxString = taxString + "0";
                tax = Double.parseDouble(taxString);
            } else {
                tax = Double.parseDouble(taxString);
            }
            String applicableTaxes = SalesService.getApplicableTaxes();
            if (applicableTaxes != null) {
                String taxes[] = applicableTaxes.split(",");
                String CustomerTax = Double.toString(tax);
                for (String taxOne : taxes) {
                    if (taxOne.equals(CustomerTax)) {
                        Surchage = SalesService.getSurcharge();
                    }
                }
            }
        }
    }

    private void fldQuantitySalesFocusGained(java.awt.event.FocusEvent evt) {
        getRightQuantity();

        if (!fldQuantity.getText().toString().equalsIgnoreCase("")) {
            if (mRightQuantity < Integer.parseInt(
                    fldQuantity.getText().toString()) && mRightQuantity != -1) {
                fldQuantity.setText("");
                lblQuantityError1.setText("");
                lblQuantityError2.setText("");
            }
        }
    }

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {
        ItemModel itemModel = new ItemModel();
        fldQuantity.setForeground(Color.blue);
        itemModel.setDesign_Id(fldDesignId.getSelectedItem().toString());
        itemModel.setThickness(fldThickness.getSelectedItem().toString());
        itemModel.setFinish(fldFinish.getSelectedItem().toString());
        //itemModel.setQuantity(Integer.parseInt(fldQuantitySales.getText()));

        if (lblQuantityError1.getText().equals("") && !fldDesignId.getSelectedItem().toString().equals("") && !fldThickness.getSelectedItem().toString().equals("")
                && !fldFinish.getSelectedItem().toString().equals("")
                && !fldQuantity.getText().equals("") && !fldRate.getText().equals("")
                && !fldSize.getText().equals("")
                && Integer.parseInt(fldQuantity.getText().toString()) > 0) {
            //mDefaultTableModel = (DefaultTableModel) table.getModel();
            //mDefaultTableModel.setRowCount(tableIndex);
            int quantity = Integer.parseInt(fldQuantity.getText());
            double rate = Double.parseDouble(fldRate.getText());
            String price = (quantity * rate) + "";

            mDefaultTableModel.insertRow(tableIndex++, new Object[]{new String(fldDesignId.getSelectedItem().toString()), new String(fldThickness.getSelectedItem().toString()),
                        new String(fldFinish.getSelectedItem().toString()), new String(fldQuantity.getText()), new String(fldRate.getText()), new String(fldSize.getText()), new String(price)});

            for (StockModel stockModel : mListStockModel) {
                if (stockModel.getDesign_Id().equalsIgnoreCase(fldDesignId.getSelectedItem().toString())
                        && stockModel.getThickness().equalsIgnoreCase(fldThickness.getSelectedItem().toString())
                        && stockModel.getFinish().equalsIgnoreCase(fldFinish.getSelectedItem().toString())) {
                    stockModel.setQuantity(stockModel.getQuantity() - quantity);
                    break;
                }
            }
            //Now empty the upper fields.
            fldDesignId.setSelectedIndex(0);
            fldThickness.setSelectedIndex(0);
            fldFinish.setSelectedIndex(0);
            fldQuantity.setText("");
            fldRate.setText("");
            fldSize.setText("8*4");
            grandTotalMajor = grandTotalMajor + (quantity * rate);
            setValues();
            //enabling discount , freight field , Next button
//            fldDiscount.setEnabled(true);
            //          fldFreight.setEnabled(true);
            //btnNextSales.setEnabled(true);
        }
    }

    private void setValues() {
        Double Discount = 0.0;
        Double TaxOnDiscount = 0.0;
        Double Fright = 0.0;
        Double Tax = 0.0;

        Double taxPercntage = 0.0;
        Surchage = 0.0;


        if (fldDiscount.getText() != null && !fldDiscount.getText().equalsIgnoreCase("")) {
            Discount = Double.parseDouble("" + fldDiscount.getText().toString());
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

        /* if(taxPercntage!=0.0)
         {
         Tax=(grandTotalMajor*taxPercntage)/100;
         if(Surchage!=0.0)
         {
         Surchage=(Tax*Surchage)/100;
             
         }
         }*/
        if (!fldFright.getText().equalsIgnoreCase("")) {
            Fright = Double.parseDouble(fldFright.getText());
        }

        if (rdAmount.isSelected()) {
            //  Discount=Double.parseDouble(fldDiscount.getText());      
            TaxOnDiscount = (Discount * taxPercntage) / 100;

        } else {
            Discount = (grandTotalMajor * Discount) / 100;
            TaxOnDiscount = (Discount * taxPercntage) / 100;
        }

        Double GrandTotal = grandTotalMajor - Discount;
        if (taxPercntage != 0.0) {
            Tax = (GrandTotal * taxPercntage) / 100;
            if (Surchage != 0.0) {
                Surchage = (Tax * Surchage) / 100;
            }
        }
        GrandTotal = GrandTotal + Fright;
        Double NetTotal = grandTotalMajor - Discount + Tax + Fright + Surchage;
        lblGrandTotalValue.setText("" + GrandTotal);
        lblSurchargeValue.setText(Surchage + "");
        lblTax1Value.setText(Tax + "");
        lblNetTotalValue.setText("" + NetTotal);
        lblDiscountValue.setText(Discount + "");
    }

    public void setReloadData(SalesOrderModel mSalesOrderModel) {
        this.customerObj = mSalesOrderModel.getCustomerObj();
        lblInvoiceNumberValue.setText("" + mSalesOrderModel.getInvoiceNumber());
        lblFirmNameValue.setText(customerObj.getFirm_name());
        lblTinNoValue.setText(customerObj.getTinNo());
        fldTax.setText("" + mSalesOrderModel.getTax());
        lblTax1Value.setText("" + mSalesOrderModel.getTaxValue());

        fldFright.setText("" + mSalesOrderModel.getFreight());

        fldDiscount.setText("" + mSalesOrderModel.getDiscountValue());
        lblDiscountValue.setText("" + mSalesOrderModel.getDiscount());

        if (mSalesOrderModel.isIsAmountselected()) {
            rdAmount.setSelected(true);
        } else {
            rdPercantage.setSelected(true);
        }
        tableIndex = 0;
        grandTotalMajor = 0.0;
        for (int i=0;i<mSalesOrderModel.getItems().size();i++) 
        {
            ItemModel mItemModel=mSalesOrderModel.getItems().get(i);
            Double Price = mItemModel.getQuantity() * mItemModel.getRate();
            grandTotalMajor = grandTotalMajor + Price;
            mDefaultTableModel.insertRow(tableIndex++, new Object[]{mItemModel.getDesign_Id() + "", mItemModel.getThickness() + "",
                        mItemModel.getFinish() + "", mItemModel.getQuantity() + "", mItemModel.getRate() + "", mItemModel.getSize() + "", Price + ""});
            if (mListStockModel.size() != 0) {
                for (int j=0;j<mListStockModel.size();j++) {
                    StockModel stockModel=mListStockModel.get(j);
                    if (stockModel.getDesign_Id().equalsIgnoreCase(mItemModel.getDesign_Id())
                            && stockModel.getThickness().equalsIgnoreCase(mItemModel.getThickness())
                            && stockModel.getFinish().equalsIgnoreCase(mItemModel.getFinish())) {
                        stockModel.setQuantity(stockModel.getQuantity() - mItemModel.getQuantity());
                        break;
                    } else {

                        int RightQuantity = ItemService.checkItemQuantity(mItemModel);
                        if (RightQuantity != -1) {
                            StockModel mStockModel = new StockModel();
                            mStockModel.setDesign_Id(mItemModel.getDesign_Id());
                            mStockModel.setThickness(mItemModel.getThickness());
                            mStockModel.setFinish(mItemModel.getFinish());
                            mStockModel.setQuantity(RightQuantity-mItemModel.getQuantity());
                            mListStockModel.add(mStockModel);
                        }

                    }
                }
            }
                       else {
                int RightQuantity = ItemService.checkItemQuantity(mItemModel);
                if (RightQuantity != -1) {
                    StockModel mStockModel = new StockModel();
                    mStockModel.setDesign_Id(mItemModel.getDesign_Id());
                    mStockModel.setThickness(mItemModel.getThickness());
                    mStockModel.setFinish(mItemModel.getFinish());
                    mStockModel.setQuantity(RightQuantity-mItemModel.getQuantity());
                    mListStockModel.add(mStockModel);
                }
            }
        }





        setValues();
    }
    
    private void btnYesActionPerformed(java.awt.event.ActionEvent evt) {
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
}
