/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.ui;

import com.jindal.forms.CustomerTableSales;
import com.jindal.forms.HomePage;
import com.jindal.model.CustomerServiceModel;
import com.jindal.service.CustomerSearchService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RUBAL GARG
 */
public class PanelCustomer extends JPanel implements ActionListener {

    private javax.swing.JLabel lblCustomerAddUpdate;
    private javax.swing.JPanel panelLabel;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JScrollPane paneCustomer;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblFirmName;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblMobile;
    private javax.swing.JLabel lblCustomer;
    private javax.swing.JTextField fldName;
    private javax.swing.JTextField fldFirmName;
    private javax.swing.JTextField fldCity;
    private javax.swing.JTextField fldMobile;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnUpDate;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JTable tableCustomer;
    int mPageNo = 0;
    int mTotalPageCount = 0;
    String[][] array;
    JTable table;
    String mFirstname = "", mFirmname = "", mCity = "", mMobile = "";
    SimpleDefaulTable mDefaultTableModel = null;
    
    public PanelCustomer(){}

    public PanelCustomer(boolean isFromCustomer) {
        lblCustomerAddUpdate = new com.jindal.ui.CustomLabel("Customer Add / Update", new java.awt.Font("Calibri", 1, 36), java.awt.Color.orange);
        panelLabel = new javax.swing.JPanel();
        panelSearch = new javax.swing.JPanel();
        panelAdd = new javax.swing.JPanel();
        //paneCustomer = new javax.swing.JScrollPane();


        lblName = new com.jindal.ui.CustomLabel("Name", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblFirmName = new com.jindal.ui.CustomLabel("Firm Name", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblCity = new com.jindal.ui.CustomLabel("City", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblMobile = new com.jindal.ui.CustomLabel("Mobile", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblCustomer = new com.jindal.ui.CustomLabel("Customers", new java.awt.Font("Calibri", 1, 28), java.awt.Color.orange);

        fldName = new JTextField();
        fldFirmName = new JTextField();
        fldCity = new JTextField();
        fldMobile = new JTextField();

        btnReset = new com.jindal.ui.CustomButton("Reset", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnSearch = new com.jindal.ui.CustomButton("Search", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnAdd = new com.jindal.ui.CustomButton("Add", new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 51, 0));
        btnNext = new com.jindal.ui.CustomButton("Next", new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 51, 0));
        btnPrevious = new com.jindal.ui.CustomButton("Previous", new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 51, 0));
        btnUpDate = new com.jindal.ui.CustomButton("Update", new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 51, 0));
        final Object[] columnNames = {"First Name",
            "Last Name",
            "Firm Name", "Address",
            "City", "Tin No", "Tax", "Mobile Number", "Phone Number", "Fax Number"};

        array = new String[0][0];

        mDefaultTableModel = new SimpleDefaulTable(array, columnNames);


        table = new JTable();
        table.setModel(mDefaultTableModel);
        JScrollPane scrollPane = JTable.createScrollPaneForTable(table);
        /**
         * ******************** layout and background ******************
         */
        panelLabel.setLayout(null);
        panelLabel.setBackground(new java.awt.Color(255, 255, 255));

        panelSearch.setLayout(null);
        panelSearch.setBackground(new java.awt.Color(255, 255, 255));

        panelAdd.setLayout(null);
        panelAdd.setBackground(new java.awt.Color(255, 255, 255));

        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(35);
        table.setFont(new Font("Tahoma", 0, 18));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setJtabledata(mFirstname, mFirmname, mCity, mMobile);

        /**
         * ************************ Set bounds of components
         * *********************************
         */
        panelLabel.setBounds(0, 152, 1326, 35);
        lblCustomerAddUpdate.setBounds(472, 10, 355, 31);
        panelSearch.setBounds(0, 0, 1326, 146);
        panelAdd.setBounds(0, 193, 1326, 300);

        lblCustomer.setBounds(22, 5, 140, 24);
        lblName.setBounds(35, 56, 61, 24);
        lblFirmName.setBounds(323, 56, 104, 24);
        lblCity.setBounds(662, 56, 40, 24);
        lblMobile.setBounds(935, 57, 67, 24);
        fldName.setBounds(122, 57, 174, 28);
        fldFirmName.setBounds(456, 57, 174, 28);
        fldCity.setBounds(728, 57, 174, 28);
        fldMobile.setBounds(1018, 57, 174, 28);

        btnReset.setBounds(1037, 95, 115, 37);
        btnSearch.setBounds(1189, 95, 115, 37);

        btnAdd.setBounds(1189, 3, 115, 26);
        btnPrevious.setBounds(1050, 230, 115, 26);
        btnNext.setBounds(1189, 230, 115, 26);
        btnUpDate.setBounds(911, 230, 115, 26);

        scrollPane.setBounds(0, 0, 1326, 210);
        /**
         * ************************ Add Components on Frame
         * *********************************
         */
        add(panelLabel);
        add(panelSearch);
        add(panelAdd);

        /**
         * ************ add components to panel *********
         */
        panelSearch.add(lblCustomerAddUpdate);
        panelSearch.add(lblName);
        panelSearch.add(lblFirmName);
        panelSearch.add(lblCity);
        panelSearch.add(lblMobile);
        panelSearch.add(fldName);
        panelSearch.add(fldFirmName);
        panelSearch.add(fldCity);
        panelSearch.add(fldMobile);
        panelSearch.add(btnReset);
        panelSearch.add(btnSearch);

        panelLabel.add(btnAdd);
        panelLabel.add(lblCustomer);

        panelAdd.add(scrollPane);
        panelAdd.add(btnNext);
        panelAdd.add(btnPrevious);
        panelAdd.add(btnUpDate);

        btnUpDate.setVisible(false);

        /**
         * ***************** Register listener *****************
         */
        btnAdd.addActionListener(this);
        btnSearch.addActionListener(this);
        btnReset.addActionListener(this);
        btnNext.addActionListener(this);
        btnPrevious.addActionListener(this);
        btnUpDate.addActionListener(this);


        
        
       
        

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                btnUpDate.setVisible(true);
            }
        });

        if (!isFromCustomer) {
            btnAdd.setVisible(false);
            btnUpDate.setText("Link");
            lblCustomerAddUpdate.setText("Sales Inventory");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
        if (e.getSource() == btnAdd) {
            btnUpDate.setVisible(false);
            JRootPane mJRootPane = this.getRootPane();
            final int WIDTH = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;    //This is maximum width of the windows
            final int HEIGHT = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;	//This is maximum height of the windows

            mJRootPane.getContentPane().revalidate();
            mJRootPane.getContentPane().repaint();
            mJRootPane.getContentPane().remove(this);
            HomePage.sLoadedPanel = new PanelAddCustomer();
            HomePage.sLoadedPanel.setLayout(null);
            HomePage.sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
            HomePage.sLoadedPanel.setBackground(new java.awt.Color(255, 255, 255));

            mJRootPane.getContentPane().add(HomePage.sLoadedPanel);

            HomePage.sLoadedPanel.setVisible(true);

        } else if (e.getSource() == btnSearch) {
            btnSearchSalesActionPerformed(e);
        btnUpDate.setVisible(false);
        } else if (e.getSource() == btnNext) {
            mPageNo = mPageNo + 5;
            setJtabledata(mFirstname, mFirmname, mCity, mMobile);
btnUpDate.setVisible(false);
        } else if (e.getSource() == btnPrevious) {
            if (mPageNo > 0) {
                mPageNo = mPageNo - 5;
                setJtabledata(mFirstname, mFirmname, mCity, mMobile);
            }
        btnUpDate.setVisible(false);
        } else if (e.getSource() == btnReset) {
            mPageNo = 0;
            mFirstname = "";
            mFirmname = "";
            mCity = "";
            mMobile = "";
            fldName.setText("");
            fldFirmName.setText("");
            fldCity.setText("");
            fldMobile.setText("");
            
        
            setJtabledata(mFirstname, mFirmname, mCity, mMobile);
        btnUpDate.setVisible(false);
        } else if (e.getSource() == btnUpDate) {
                
            btnUpDate.setVisible(true);
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {

                JRootPane mJRootPane = this.getRootPane();
                final int WIDTH = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;    //This is maximum width of the windows
                final int HEIGHT = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;	//This is maximum height of the windows
                mJRootPane.getContentPane().revalidate();
                mJRootPane.getContentPane().repaint();
                mJRootPane.getContentPane().remove(this);

                
                if (btnUpDate.getText().toString().equalsIgnoreCase("update")) {
                    HomePage.sLoadedPanel = new PanelAddCustomer();

                HomePage.sLoadedPanel.setLayout(null);
                HomePage.sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
                HomePage.sLoadedPanel.setBackground(new java.awt.Color(255, 255, 255));

                mJRootPane.getContentPane().add(HomePage.sLoadedPanel);

                HomePage.sLoadedPanel.setVisible(true);
                    if (HomePage.sLoadedPanel instanceof PanelAddCustomer) {
                        ((PanelAddCustomer) HomePage.sLoadedPanel).setData(array[selectedRow][0], array[selectedRow][1], array[selectedRow][2], array[selectedRow][3], array[selectedRow][4], array[selectedRow][5], array[selectedRow][6], array[selectedRow][7], array[selectedRow][8], array[selectedRow][9], array[selectedRow][10]);

                    }
                } 
                else
                {
                    HomePage.sLoadedPanel = new PanelSales();

                HomePage.sLoadedPanel.setLayout(null);
                HomePage.sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
                //HomePage.sLoadedPanel.setBackground(new java.awt.Color(255, 255, 255));

                mJRootPane.getContentPane().add(HomePage.sLoadedPanel);
                CustomerServiceModel customerObj=new CustomerServiceModel();
                
                customerObj.setFirst_name(array[selectedRow][0]);
                customerObj.setLast_name(array[selectedRow][1]);
                customerObj.setFirm_name(array[selectedRow][2]);
                customerObj.setAddress(array[selectedRow][3]);
                customerObj.setCity(array[selectedRow][4]);
                customerObj.setTinNo(array[selectedRow][5]);
                customerObj.setTax(Double.parseDouble(array[selectedRow][6]));
                customerObj.setMobile_no(array[selectedRow][7]);
                customerObj.setPhone(array[selectedRow][8]);
                customerObj.setFax_no(array[selectedRow][9]);
                customerObj.setCustomer_id(Integer.parseInt(array[selectedRow][10]));
                
               
                
                HomePage.sLoadedPanel.setVisible(true);
                    if (HomePage.sLoadedPanel instanceof PanelSales) {
                        ((PanelSales) HomePage.sLoadedPanel).setData(customerObj);
                    }

                    
                }

            }

        }

    }

    private List<CustomerServiceModel> fetchData(int pageNo, String FirstName, String FirmName, String City, String MobileNO) {
        List<CustomerServiceModel> mList = CustomerSearchService.FetchCustomer(pageNo, FirstName, FirmName, City, MobileNO);
        if (mList.size() > 0) {
            mTotalPageCount = mList.get(0).getRowcount();
        }
        btnNext.setVisible(false);
        btnPrevious.setVisible(false);
        if (mTotalPageCount > mPageNo + 5) {
            btnNext.setVisible(true);

        }

        if (mPageNo > 0) {
            btnPrevious.setVisible(true);
        }

        return mList;
    }

    private void btnSearchSalesActionPerformed(java.awt.event.ActionEvent evt) {

        if (!fldName.getText().toString().equals("") || !fldFirmName.getText().toString().equals("") || !fldCity.getText().toString().equals("") || !fldMobile.getText().toString().equals("")) {
            {
                mPageNo = 0;
                mFirstname = fldName.getText().toString();
                mFirmname = fldFirmName.getText().toString();
                mCity = fldCity.getText().toString();
                mMobile = fldMobile.getText().toString();
                setJtabledata(mFirstname, mFirmname, mCity, mMobile);
            }
        }

    }

    private void setJtabledata(String FirstName, String FirmName, String City, String Mobile) {
        List<CustomerServiceModel> mListCustomerServiceModel = fetchData(mPageNo, FirstName, FirmName, City, Mobile);
        array = new String[mListCustomerServiceModel.size()][11];
        for (int i = 0; i < mListCustomerServiceModel.size(); i++) {
            CustomerServiceModel mCustomerServiceModel = mListCustomerServiceModel.get(i);
            array[i][0] = mCustomerServiceModel.getFirst_name();
            array[i][1] = mCustomerServiceModel.getLast_name();
            array[i][2] = mCustomerServiceModel.getFirm_name();
            array[i][3] = mCustomerServiceModel.getAddress();
            array[i][4] = mCustomerServiceModel.getCity();
            array[i][5] = mCustomerServiceModel.getTinNo();
            array[i][6] = "" + mCustomerServiceModel.getTax();
            array[i][7] = mCustomerServiceModel.getMobile_no();
            array[i][8] = mCustomerServiceModel.getPhone();
            array[i][9] = mCustomerServiceModel.getFax_no();
            array[i][10] = "" + mCustomerServiceModel.getCustomer_id();

        }

        final Object[] columnNames = {"First Name",
            "Last Name",
            "Firm Name", "Address",
            "City", "Tin No", "Tax", "Mobile Number", "Phone Number", "Fax Number"};


        mDefaultTableModel = new SimpleDefaulTable(array, columnNames);
        table.setModel(mDefaultTableModel);

    
}


}



class SimpleDefaulTable extends DefaultTableModel {

    SimpleDefaulTable(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}