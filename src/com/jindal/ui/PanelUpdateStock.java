/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.ui;


import com.jindal.forms.HomePage;
import com.jindal.model.ItemModel;
import com.jindal.service.ItemService;
import com.jindal.service.S16MaximumMatch;
import com.jindal.service.SalesService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author RUBAL GARG
 */
public class PanelUpdateStock extends JPanel implements ActionListener {
    
    private javax.swing.JButton btnAddItem;
    private javax.swing.JComboBox ddFinish;
    private javax.swing.JTextField fldDesignId;
    private javax.swing.JTextField fldPrice;
    private javax.swing.JTextField fldQuantity;
    private javax.swing.JTextField fldSize;
    private javax.swing.JTextField fldThickness;
    private javax.swing.JLabel lblAddStock;
    private javax.swing.JLabel lblDesignId;
    private javax.swing.JLabel lblFinish;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel lblThickness;
    ItemModel itemModelold;
    public PanelUpdateStock()
    {
        lblAddStock = new com.jindal.ui.CustomLabel("Update Stock", new java.awt.Font("Calibri", 1, 36), java.awt.Color.orange);
        lblDesignId = new com.jindal.ui.CustomLabel("Design Id", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblThickness = new com.jindal.ui.CustomLabel("Thickness", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblFinish = new com.jindal.ui.CustomLabel("Finish", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblQuantity = new com.jindal.ui.CustomLabel("Quantity", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblSize = new com.jindal.ui.CustomLabel("Size", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        
        fldDesignId = new JTextField();
        fldThickness = new JTextField();
        ddFinish = new JComboBox();
        
        // Finish
        ArrayList<String> finishArrayList2 = SalesService.getFinish();
        ddFinish.setModel(new javax.swing.DefaultComboBoxModel(finishArrayList2.toArray()));
        new S16MaximumMatch(ddFinish);
        
        //ddFinish.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"GL", "AB"}));
        fldQuantity = new JTextField();
        fldSize = new JTextField();

        btnAddItem = new com.jindal.ui.CustomButton("Update Item", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
    
        /**
         * ******************** layout and background ******************
         */
        
        /**
         * ************ add components to panel *********
         */
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
        /**
         * ************************ Set bounds of components
         * *********************************
         */
        lblAddStock.setBounds(580, 46, 238, 31);
        lblDesignId.setBounds(129, 138, 89, 24);
        lblThickness.setBounds(833, 138, 89, 24);
        lblFinish.setBounds(129, 228, 89, 24);
        lblQuantity.setBounds(833, 228, 89, 24);
        
        lblSize.setBounds(129, 318, 358, 26);

        fldDesignId.setBounds(283, 138, 174, 28);
        fldThickness.setBounds(982, 138, 174, 28);
        ddFinish.setBounds(283, 228, 174, 28);
        fldQuantity.setBounds(982, 228, 174, 28);
        
        fldSize.setBounds(283, 319, 174, 28);

        btnAddItem.setBounds(1179, 389, 120, 37);
        
        /**
         * ***************** Register listener *****************
         */
        btnAddItem.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == btnAddItem) {
            btnAddItemActionPerformed(e);
        }
    }
    
    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {                                           
       
        if (!fldDesignId.getText().equalsIgnoreCase("") && !fldThickness.getText().equalsIgnoreCase("")
               && !fldQuantity.getText().equalsIgnoreCase("") && !fldSize.getText().equalsIgnoreCase("")&&Integer.parseInt(fldQuantity.getText())>0) {

            ItemModel itemModel = new ItemModel();
            int quantity = Integer.parseInt(fldQuantity.getText());
            //double rate = Double.parseDouble(fldPrice.getText());
            itemModel.setDesign_Id(fldDesignId.getText());
            itemModel.setThickness(fldThickness.getText());
            itemModel.setFinish(ddFinish.getSelectedItem().toString());
            itemModel.setQuantity(quantity);
            //itemModel.setRate(rate);
            itemModel.setSize(fldSize.getText());

            boolean success = ItemService.updateItemDetails(itemModel,itemModelold);
            if (success)
                {
                    if (!HomePage.designIdArray.contains(fldDesignId.getText())) {
                        HomePage.designIdArray.add(fldDesignId.getText());
                    }
                    JOptionPane.showMessageDialog(this, "Item has been updated into stock");
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Item has not been updated into stock successfully."
                            + " Please provide proper input");
                }
            }
        
        else
        {
            if(Integer.parseInt(fldQuantity.getText())<=0)
            {
                  JOptionPane.showMessageDialog(this, "Quantity Should be greater than 0");
            }
            else
            {   
                JOptionPane.showMessageDialog(this," Please provide proper input");
            }
        }
    }
    
    public void setData(String DesignId,String Thickness,String Finish,String Quantity,String Size)
        {
            
             itemModelold=new ItemModel();
            
             itemModelold.setDesign_Id(DesignId);
             itemModelold.setThickness(Thickness);
             itemModelold.setFinish(Finish);
             itemModelold.setQuantity(Integer.parseInt(Quantity));
             itemModelold.setSize(Size);
             
             
        fldDesignId.setText(DesignId);
        fldThickness.setText(Thickness);
        ddFinish.setSelectedItem(Finish);
        fldQuantity.setText(Quantity);
        fldSize.setText(Size);
      }

}
