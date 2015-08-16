/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.ui;

import com.jindal.forms.CustomerTableSales;
import com.jindal.forms.HomePage;
import com.jindal.model.CustomerServiceModel;
import com.jindal.model.ItemModel;
import com.jindal.service.CustomerSearchService;
import com.jindal.service.ItemService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.Date;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author RUBAL GARG
 */
public class PanelStock extends JPanel implements ActionListener {

    private javax.swing.JLabel lblStockMain;
    private javax.swing.JPanel panelLabel;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JScrollPane paneStock;
    private javax.swing.JLabel lblDesign;
    private javax.swing.JLabel lblThickness;
    private javax.swing.JLabel lblFinish;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblStock;
    private javax.swing.JTextField fldDesignId;
    private javax.swing.JTextField fldThickness;
    private javax.swing.JTextField fldFinish;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnUpDate;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnDelete;

    private javax.swing.JTable tableStock;
    JDatePickerImpl fldStartDate,fldEndDate;
    int mPageNo = 0;
    int mTotalPageCount = 0;
    String[][] array;
    JTable table;
    String mDesignId = "", mThickness = "", mFinish = "", mStartDate = "",mEndDate="";
    SimpleDefaulTable mDefaultTableModel = null;
    UtilDateModel model = null;
    JDatePanelImpl datePanel = null;
    JDatePickerImpl datePicker = null;
            
    public PanelStock() {
        lblStockMain = new com.jindal.ui.CustomLabel("Stock", new java.awt.Font("Calibri", 1, 36), java.awt.Color.orange);
        panelLabel = new javax.swing.JPanel();
        panelSearch = new javax.swing.JPanel();
        panelAdd = new javax.swing.JPanel();
        //paneCustomer = new javax.swing.JScrollPane();


        lblDesign = new com.jindal.ui.CustomLabel("Design Id", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblThickness = new com.jindal.ui.CustomLabel("Thickness", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblFinish = new com.jindal.ui.CustomLabel("Finish", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblStartDate = new com.jindal.ui.CustomLabel("Start date", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblEndDate = new com.jindal.ui.CustomLabel("End date", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblStock = new com.jindal.ui.CustomLabel("Stock", new java.awt.Font("Calibri", 1, 28), java.awt.Color.orange);
        
        UtilDateModel model = new UtilDateModel();
                UtilDateModel model1 = new UtilDateModel();

        //model.setDate(20,04,2014);
        // Need this...
    Properties p = new Properties();
    p.put("text.today", "Today");
    p.put("text.month", "Month");
    p.put("text.year", "Year");
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p);
        
    // Don't know about the formatter, but there it is...
     fldStartDate = new JDatePickerImpl(datePanel, new DateLabelFormatter());

     fldEndDate=new JDatePickerImpl(datePanel1, new DateLabelFormatter());
     
     panelSearch.add(lblStartDate);
     panelSearch.add(lblEndDate);
     
     panelSearch.add(fldStartDate);
     panelSearch.add(fldEndDate);
     
        fldDesignId = new JTextField();
        fldThickness = new JTextField();
        fldFinish = new JTextField();

        
        btnReset = new com.jindal.ui.CustomButton("Reset", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnSearch = new com.jindal.ui.CustomButton("Search", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnAdd = new com.jindal.ui.CustomButton("Add", new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 51, 0));
        btnNext = new com.jindal.ui.CustomButton("Next", new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 51, 0));
        btnPrevious = new com.jindal.ui.CustomButton("Previous", new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 51, 0));
        btnUpDate = new com.jindal.ui.CustomButton("Update", new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 51, 0));
        btnDelete = new com.jindal.ui.CustomButton("Delete", new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 51, 0));

        final Object[] columnNames = {"Design Id",
            "Thickness",
            "Finish", "Quantity",
            "Size", "Date"};

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
        setJtabledata(mDesignId, mThickness, mFinish, mStartDate,mEndDate);

        /**
         * ************************ Set bounds of components
         * *********************************
         */

        panelLabel.setBounds(0, 152, 1326, 35);
        lblStockMain.setBounds(572, 10, 355, 31);
        panelSearch.setBounds(0, 0, 1326, 146);
        panelAdd.setBounds(0, 193, 1326, 300);

        lblStock.setBounds(22, 5, 140, 24);
        
        lblDesign.setBounds(35, 56, 100, 24);
        lblThickness.setBounds(280, 56,100, 24);
        lblFinish.setBounds(540, 56, 80, 24);
        lblStartDate.setBounds(740, 57,100, 24);
        lblEndDate.setBounds(1030,57,100,24);
        
        fldDesignId.setBounds(145, 57, 100, 28);
        fldThickness.setBounds(390, 57, 100, 28);
        fldFinish.setBounds(600, 57, 100, 28);
        fldStartDate.setBounds(830, 57, 160, 28);
        fldEndDate.setBounds(1120, 57, 160, 28);
        
        
        btnReset.setBounds(1037, 95, 115, 37);
        btnSearch.setBounds(1189, 95, 115, 37);

        btnAdd.setBounds(1189, 3, 115, 26);
        btnPrevious.setBounds(1050, 230, 115, 26);
        btnNext.setBounds(1189, 230, 115, 26);
        btnUpDate.setBounds(770, 230, 115, 26);
        btnDelete.setBounds(911, 230, 115, 26);
        
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
        panelSearch.add(lblStockMain);
        panelSearch.add(lblDesign);
        panelSearch.add(lblThickness);
        panelSearch.add(lblFinish);
        panelSearch.add(lblStartDate);
        panelSearch.add(fldDesignId);
        panelSearch.add(fldThickness);
        panelSearch.add(fldFinish);
        //panelSearch.add(fldStartDate);
        panelSearch.add(btnReset);
        panelSearch.add(btnSearch);

        panelLabel.add(btnAdd);
        panelLabel.add(lblStock);

        panelAdd.add(scrollPane);
        panelAdd.add(btnNext);
        panelAdd.add(btnPrevious);
        panelAdd.add(btnUpDate);
        panelAdd.add(btnDelete);
        btnUpDate.setVisible(false);
        btnDelete.setVisible(false);
        /**
         * ***************** Register listener *****************
         */
        btnAdd.addActionListener(this);
        btnSearch.addActionListener(this);
        btnReset.addActionListener(this);
        btnNext.addActionListener(this);
        btnPrevious.addActionListener(this);
        btnUpDate.addActionListener(this);
        btnDelete.addActionListener(this);

        
        
       
        

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                btnUpDate.setVisible(true);
                btnDelete.setVisible(true);
            }
        });

       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnDelete){
        if(table.getSelectedRow() >= 0){
            int rowNum = table.getSelectedRow();
                ItemModel item = new ItemModel();
                
                
                item.setDesign_Id(array[rowNum][0]);
                item.setThickness(array[rowNum][1]);
                item.setFinish(array[rowNum][2]);
                item.setQuantity(Integer.parseInt(array[rowNum][3]));
                item.setSize(array[rowNum][4]);
                
                ItemService.deleteItem(item);
                mDefaultTableModel.removeRow(rowNum);
                mPageNo = 0;
            }

        }
        
        else if (e.getSource() == btnAdd) {
            btnUpDate.setVisible(false);
            JRootPane mJRootPane = this.getRootPane();
            final int WIDTH = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;    //This is maximum width of the windows
            final int HEIGHT = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;	//This is maximum height of the windows

            mJRootPane.getContentPane().revalidate();
            mJRootPane.getContentPane().repaint();
            mJRootPane.getContentPane().remove(this);
            HomePage.sLoadedPanel = new PanelAddStock();
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
            setJtabledata(mDesignId, mThickness, mFinish, mStartDate,mEndDate);
btnUpDate.setVisible(false);
        } else if (e.getSource() == btnPrevious) {
            if (mPageNo > 0) {
                mPageNo = mPageNo - 5;
                setJtabledata(mDesignId, mThickness, mFinish, mStartDate,mEndDate);
            }
        btnUpDate.setVisible(false);
        } else if (e.getSource() == btnReset) {
            mPageNo = 0;
            mDesignId = "";
            mThickness = "";
            mFinish = "";
            mStartDate = "";
            fldDesignId.setText("");
            fldThickness.setText("");
            fldFinish.setText("");
            mEndDate="";
        
            setJtabledata(mDesignId, mThickness, mFinish, mStartDate,mEndDate);
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
                    HomePage.sLoadedPanel = new PanelUpdateStock();

                HomePage.sLoadedPanel.setLayout(null);
                HomePage.sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
                HomePage.sLoadedPanel.setBackground(new java.awt.Color(255, 255, 255));

                mJRootPane.getContentPane().add(HomePage.sLoadedPanel);

                HomePage.sLoadedPanel.setVisible(true);
                    if (HomePage.sLoadedPanel instanceof PanelUpdateStock) {
                        ((PanelUpdateStock) HomePage.sLoadedPanel).setData(array[selectedRow][0], array[selectedRow][1], array[selectedRow][2], array[selectedRow][3], array[selectedRow][4]);

                    }
                } 
            }

        }

    }

    private List<ItemModel> fetchData(int pageNo, String DesignId, String Thickness, String Finish, String StartDate,String EndDate) {
        
        List<ItemModel> mList;
        mList = ItemService.FetchItem(pageNo, DesignId, Thickness, Finish, StartDate,EndDate);
      
        if (mList.size() > 0) {
            mTotalPageCount = mList.get(0).getRowCount();
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

        if (!fldDesignId.getText().toString().equals("") || !fldThickness.getText().toString().equals("") || !fldFinish.getText().toString().equals("")||fldStartDate.getModel().getValue()!=null||fldEndDate.getModel().getValue()!=null) {
            {
                mPageNo = 0;
                mDesignId = fldDesignId.getText().toString();
                mThickness = fldThickness.getText().toString();
                mFinish = fldFinish.getText().toString();
                Date startdate=null,endDate=null;
                    if(fldStartDate.getModel().getValue()!=null)
                        {
                            startdate=((Date)fldStartDate.getModel().getValue());
                        }
                
                    if(fldEndDate.getModel().getValue()!=null)
                        {
                            endDate=((Date)fldEndDate.getModel().getValue());
                        }
                
                    if(fldStartDate.getModel().getValue()!=null&&fldEndDate.getModel().getValue()!=null)
                        {
                            if(startdate.compareTo(endDate)==1)
                                {
                                    JOptionPane.showMessageDialog(this, "End date cannot be before than Start date");
                                }
                    else
                        {
                            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                    
                            mStartDate=sdf.format(startdate).toString();
                            mEndDate=sdf.format(endDate).toString();
                    
                            setJtabledata(mDesignId, mThickness, mFinish,mStartDate,mEndDate);
                        }
                }
                else
                {
                    
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                    if(startdate!=null)
                        mStartDate=sdf.format(startdate).toString();
                    if(endDate!=null)
                        mEndDate=sdf.format(endDate).toString();
                    setJtabledata(mDesignId, mThickness, mFinish,mStartDate,mEndDate);
                }
                
            }
        }

    }

    private void setJtabledata(String Designid, String thickness, String finish, String startdate,String enddate) {
        List<ItemModel> mListItemServiceModel = fetchData(mPageNo, Designid, thickness, finish, startdate,enddate);
        array = new String[mListItemServiceModel.size()][11];
        for (int i = 0; i < mListItemServiceModel.size(); i++) {
            ItemModel mItemModel = mListItemServiceModel.get(i);
            array[i][0] = mItemModel.getDesign_Id();
            array[i][1] = mItemModel.getThickness();
            array[i][2] = mItemModel.getFinish();
            array[i][3] = mItemModel.getQuantity()+"";
            array[i][4] = mItemModel.getSize();
            array[i][5] = mItemModel.getModifyStock()+"";
            
        }

        final Object[] columnNames = {"Design Id",
            "Thickness",
            "Finish", "Quantity",
            "Size", "Date"};


        mDefaultTableModel = new SimpleDefaulTable(array, columnNames);
        table.setModel(mDefaultTableModel);

    
}


}
class DateLabelFormatter extends AbstractFormatter {

    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

}