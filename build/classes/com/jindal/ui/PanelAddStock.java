/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.ui;

import com.jindal.forms.HomePage;
import com.jindal.model.CustomerServiceModel;
import com.jindal.model.ItemModel;
import com.jindal.service.CustomerSearchService;
import com.jindal.service.ItemService;
import com.jindal.service.S16MaximumMatch;
import com.jindal.service.SalesService;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author RUBAL GARG
 */
public class PanelAddStock extends JPanel implements ActionListener {

    private javax.swing.JButton btnAddItem;
    private javax.swing.JTextField ddFinish;
    private javax.swing.JTextField fldDesignId;
    
    private javax.swing.JTextField fldQuantity;
    private javax.swing.JTextField fldSize;
    private javax.swing.JTextField fldThickness;
    private javax.swing.JLabel lblAddStock;
    private javax.swing.JLabel lblDesignId;
    private javax.swing.JLabel lblFinish;
    
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel lblThickness;
    private javax.swing.JTable tableStock;
    SimpleDefaulTable mDefaultTableModel = null;
    private javax.swing.JScrollPane paneStock;
    String[][] array;
    String mDesignId = "", mThickness = "", mFinish = "", mQuantity = "", mSize = "";
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnDelete;
    
    int rowNum = 0;
    private javax.swing.JButton btnPrevious;
    int mPageNo = 0;
    int mTotalPageCount = 0;
    int tableIndex = 0;
    private List<ItemModel> mListItemModel;
private int selecetdeIndex=-6;
    public PanelAddStock() {
        lblAddStock = new com.jindal.ui.CustomLabel("Add Stock", new java.awt.Font("Calibri", 1, 36), java.awt.Color.orange);
        lblDesignId = new com.jindal.ui.CustomLabel("Design Id", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblThickness = new com.jindal.ui.CustomLabel("Thickness", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblFinish = new com.jindal.ui.CustomLabel("Finish", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblQuantity = new com.jindal.ui.CustomLabel("Quantity", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        //lblPrice = new com.jindal.ui.CustomLabel("Price", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblSize = new com.jindal.ui.CustomLabel("Size", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));

        
        fldDesignId = new JTextField();
                    
        fldThickness = new JTextField();
        ddFinish = new JTextField();
        mListItemModel = new ArrayList<>();
        // Finish
        //ArrayList<String> finishArrayList2 = SalesService.getFinish();
        //ddFinish.setModel(new javax.swing.DefaultComboBoxModel(finishArrayList2.toArray()));
        //new S16MaximumMatch(ddFinish);

        //ddFinish.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"GL", "AB"}));
        fldQuantity = new JTextField();
        //fldPrice = new JTextField();
        fldSize = new JTextField();

        btnAddItem = new com.jindal.ui.CustomButton("Add Item", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnNext = new com.jindal.ui.CustomButton("Next", new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 51, 0));
        btnPrevious = new com.jindal.ui.CustomButton("Previous", new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 51, 0));
        btnUpdate = new com.jindal.ui.CustomButton("Update", new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 51, 0));
        btnDelete = new com.jindal.ui.CustomButton("Delete", new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 51, 0));
        

        final Object[] columnNames = {"Design Id",
            "Thickness",
            "Finish","Quantity",
            "Size"};

        array = new String[0][0];

        mDefaultTableModel = new SimpleDefaulTable(array, columnNames);


        tableStock = new JTable();
        tableStock.setModel(mDefaultTableModel);
        tableStock.getTableHeader().setReorderingAllowed(false);
        tableStock.setRowHeight(30);
        tableStock.setFont(new Font("Tahoma", 0, 18));
        tableStock.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = JTable.createScrollPaneForTable(tableStock);
        
        btnUpdate.setVisible(false);
        btnDelete.setVisible(false);
        fldSize.setText("8*4");
        ddFinish.setText("SDF");
        /**
         * ************ add components to panel *********
         */
        add(scrollPane);
        add(lblAddStock);
        add(lblDesignId);
        add(lblThickness);
        add(lblFinish);
        add(lblQuantity);
        add(lblSize);
        
        
        add(fldDesignId);
        add(fldThickness);
        add(ddFinish);
        add(fldQuantity);
        add(fldSize);
        add(btnAddItem);
        add(btnNext);
        add(btnUpdate);
        add(btnDelete);
        
        
        add(btnPrevious);

        
      
        
        /**
         * ************************ Set bounds of components
         * *********************************
         */
        lblAddStock.setBounds(580, 26, 238, 31);

        lblDesignId.setBounds(32, 104, 82, 25);
        lblThickness.setBounds(303, 104, 89, 24);
        lblFinish.setBounds(32, 187, 89, 24);
        lblQuantity.setBounds(303, 187, 89, 24);
        lblSize.setBounds(32, 253, 358, 26);
        btnAddItem.setBounds(422, 314, 112, 30);
        fldDesignId.setBounds(154, 101, 120, 28);
        fldThickness.setBounds(422, 101, 120, 28);
        ddFinish.setBounds(154, 184, 120, 28);
        fldQuantity.setBounds(422, 184, 120, 28);
        fldSize.setBounds(154, 250, 120, 28);

        //btnNext.setBounds(1111,400, 112, 30);
        //btnPrevious.setBounds(819,400, 112, 30);
        
        btnNext.setBounds(1160,400, 112, 30);
        btnPrevious.setBounds(1020,400, 112, 30);
        
        btnUpdate.setBounds(750,400, 112, 30);
        btnDelete.setBounds(880,400, 112, 30);
        
scrollPane.setBounds(565, 94, 718, 302);

        /**
         * ***************** Register listener *****************
         */
        btnAddItem.addActionListener(this);
btnNext.addActionListener(this);btnPrevious.addActionListener(this);
btnUpdate.addActionListener(this);
btnDelete.addActionListener(this);

fldDesignId.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
           if(e.getKeyCode()==KeyEvent.VK_TAB)
           {
               fldThickness.getCursor();
           }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
                 if(e.getKeyCode()==KeyEvent.VK_TAB)
           {
               fldThickness.getCursor();
           }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            
             if(e.getKeyCode()==KeyEvent.VK_TAB)
           {
               fldThickness.getCursor();
           }
            }
        });



btnAddItem.addKeyListener(new KeyListener() {


    
    @Override
            public void keyTyped(KeyEvent e) {
            }

         @Override
public void keyPressed(KeyEvent e) {
    if (e.getKeyCode()==KeyEvent.VK_ENTER){
addbuttonclick();    }
         }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        tableStock.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
             
//                if(tableStock.getSelectedRow()==selecetdeIndex)
//                {
//                    selecetdeIndex=-1;
//                    tableStock.clearSelection();
//                }
//                else
//                {
//                    selecetdeIndex=tableStock.getSelectedRow();
//                }
                manageButton(true);
            
              }
           
            
        });

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddItem) {
            btnAddItemActionPerformed(e);
        }
        else if(e.getSource() == btnUpdate)
        {
            if(tableStock.getSelectedRow()>=0)
            {
                rowNum = tableStock.getSelectedRow();
                ItemModel item = mListItemModel.get(rowNum);
                btnAddItem.setText("Update");
                btnPrevious.setVisible(false);
                fldDesignId.setText(item.getDesign_Id());
                fldThickness.setText(item.getThickness());
                fldSize.setText(item.getSize());
                ddFinish.setText(item.getFinish());
            }
                
        }
        else if(e.getSource() == btnDelete)
        {
            if(tableStock.getSelectedRow() >= 0){
            rowNum = tableStock.getSelectedRow();
                ItemModel item = mListItemModel.get(rowNum);
                ItemService.deleteItem(item);
                mListItemModel.remove(rowNum);
                mPageNo = 0;
                setJtabledata();
            }
        }
        else if (e.getSource() == btnNext) {
            
                mPageNo++;
                setJtabledata();
            
        } else if (e.getSource() == btnPrevious) {
            

                mPageNo--;
                setJtabledata();
            
        }
    }

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {
        addbuttonclick();
        
        

    
    }
    
    
    private void addbuttonclick()
    {
        if (!fldDesignId.getText().equalsIgnoreCase("") && !fldThickness.getText().equalsIgnoreCase("")
               && !fldQuantity.getText().equalsIgnoreCase("") && !fldSize.getText().equalsIgnoreCase("")&&Integer.parseInt(fldQuantity.getText())>0) {

            ItemModel itemModel = new ItemModel();
            int quantity = Integer.parseInt(fldQuantity.getText());
            //double rate = Double.parseDouble(fldPrice.getText());
            itemModel.setDesign_Id(fldDesignId.getText());
            itemModel.setThickness(fldThickness.getText());
            itemModel.setFinish(ddFinish.getText().toString());
            itemModel.setQuantity(quantity);
            //itemModel.setRate(rate);
            itemModel.setSize(fldSize.getText());

            if (btnAddItem.getText().equalsIgnoreCase("update")) {

                ItemService.deleteItem(mListItemModel.get(rowNum));
                boolean success = ItemService.insertItem(itemModel);
                mListItemModel.get(rowNum).setDesign_Id(fldDesignId.getText());
                mListItemModel.get(rowNum).setThickness(fldThickness.getText());
                mListItemModel.get(rowNum).setFinish(ddFinish.getText().toString());
                mListItemModel.get(rowNum).setQuantity(quantity);
                mListItemModel.get(rowNum).setSize(fldSize.getText());
                if (success) {
                    //JOptionPane.showMessageDialog(this, "Item has been updated into stock");
                    
                    setJtabledata();
                    fldDesignId.setText("");
                    //fldThickness.setText("");
                    //fldSize.setText("8*4");
                    //ddFinish.setText("SDF");
                }
                btnAddItem.setText("Add Item");
            }
            else
            {
                boolean success = ItemService.insertItem(itemModel);
                if (success)
                {
                    if (!HomePage.designIdArray.contains(fldDesignId.getText())) {
                        HomePage.designIdArray.add(fldDesignId.getText());
                    }
                    //JOptionPane.showMessageDialog(this, "Item has been updated into stock");
                    mListItemModel.add(itemModel);
                    setJtabledata();
                    fldDesignId.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Item has not been updated into stock successfully."
                            + " Please provide proper input");
                }
            }
        }
        btnAddItem.setText("Add Item");
       /* else
        {
            if(Integer.parseInt(fldQuantity.getText())<=0)
            {
                  JOptionPane.showMessageDialog(this, "Quantity Should be greater than 0");
            }
            else
            {   
                JOptionPane.showMessageDialog(this," Please provide proper input");
            }
        }*/
    }

    private void setJtabledata() {
        
        mDefaultTableModel.setRowCount(0);
                
        int tableIndex = 0;
        for (int i = (mPageNo * 8); i < mListItemModel.size() && tableIndex < 8; i++) {
            mDefaultTableModel.insertRow(tableIndex++, new Object[]{mListItemModel.get(i).getDesign_Id(), mListItemModel.get(i).getThickness(), mListItemModel.get(i).getFinish(), mListItemModel.get(i).getQuantity(), mListItemModel.get(i).getSize()});
        }
        manageButton(false);
    }

    private void manageButton(boolean isDeleteupdate) {
        if (isDeleteupdate) {
            btnUpdate.setVisible(true);
            btnDelete.setVisible(true);

            //btnPrevious.setText("Update");
            //btnNext.setText("Delete");
        } 
        else {
            btnPrevious.setVisible(true);
            btnNext.setVisible(true);

            if (mListItemModel.size() <= (mPageNo + 1) * 8) {
                btnNext.setVisible(false);
            }
            if (mPageNo == 0) {
                btnPrevious.setVisible(false);
            }
            //btnPrevious.setText("Previous");
            //btnNext.setText("Next");

            if (mDefaultTableModel.getRowCount() > 8) 
            {
               btnPrevious.setVisible(true);
                btnNext.setVisible(true);
            }
        }
    }
}
