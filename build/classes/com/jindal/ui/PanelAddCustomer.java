/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.ui;

import com.jindal.model.CustomerServiceModel;
import com.jindal.service.CustomerSearchService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author RUBAL GARG
 */
public class PanelAddCustomer extends JPanel  implements ActionListener
{
    private javax.swing.JButton btnAdd;
    
    private javax.swing.JTextField fldFirstName;
    private javax.swing.JTextField fldLastName;
    private javax.swing.JTextField fldFirmName;
    private javax.swing.JTextField fldCity;
    private javax.swing.JTextField fldAddress;
    private javax.swing.JTextField fldTinNo;
    private javax.swing.JTextField fldMobile;
    private javax.swing.JTextField fldPhone;
    private javax.swing.JTextField fldFaxNo;
    private javax.swing.JTextField fldTax;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblFirmName;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblTinNo;
    private javax.swing.JLabel lblMobile;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblFaxNo;
    private javax.swing.JLabel lblTax;
    private javax.swing.JLabel lblAddCustomer;
    int customer_id;
    public PanelAddCustomer()
    {
        
        lblAddCustomer = new com.jindal.ui.CustomLabel("Add Customer", new java.awt.Font("Calibri", 1, 36), java.awt.Color.orange);
        lblFirstName = new com.jindal.ui.CustomLabel("First Name", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblLastName = new com.jindal.ui.CustomLabel("Last Name", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblFirmName = new com.jindal.ui.CustomLabel("Firm Name", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblAddress = new com.jindal.ui.CustomLabel("Address", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblCity = new com.jindal.ui.CustomLabel("City", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblTinNo = new com.jindal.ui.CustomLabel("Tin No", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblTax = new com.jindal.ui.CustomLabel("Tax", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblMobile = new com.jindal.ui.CustomLabel("Mobile", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblPhone = new com.jindal.ui.CustomLabel("Phone", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        lblFaxNo = new com.jindal.ui.CustomLabel("Fax No", new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
        
        fldFirstName = new JTextField();
        fldLastName = new JTextField();
        fldFirmName = new JTextField();
        fldAddress = new JTextField();
        fldCity = new JTextField();
        fldTinNo = new JTextField();
        fldTax = new JTextField();
        fldMobile = new JTextField();
        fldPhone = new JTextField();
        fldFaxNo = new JTextField();
        
        btnAdd = new com.jindal.ui.CustomButton("Add", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
    
        /**
         * ******************** layout and background ******************
         */
        
        
        /**
         * ************************ Set bounds of components
         * *********************************
         */
        lblAddCustomer.setBounds(575, 15, 230, 31);
        
        lblFirstName.setBounds(129, 76, 89, 24);
        lblLastName.setBounds(833, 76, 89, 24);
        lblFirmName.setBounds(129, 147, 89, 24);
        lblAddress.setBounds(833, 147, 89, 24);
        lblCity.setBounds(129, 220, 89, 24);
        lblTinNo.setBounds(833, 220, 89, 24);
        lblTax.setBounds(129, 291, 89, 24);
        lblMobile.setBounds(833, 291, 89, 24);
        lblPhone.setBounds(129, 347, 89, 24);
        lblFaxNo.setBounds(833, 347, 89, 24);
        
        fldFirstName.setBounds(283, 72, 174, 28);
        fldLastName.setBounds(982, 72, 174, 28);
        fldFirmName.setBounds(283, 147, 174, 28);
        fldAddress.setBounds(982, 147, 174, 28);
        fldCity.setBounds(283, 220, 174, 28);
        fldTinNo.setBounds(982, 220, 174, 28);
        fldTax.setBounds(283, 292, 174, 28);
        fldMobile.setBounds(982, 292, 174, 28);
        fldPhone.setBounds(283, 358, 174, 28);
        fldFaxNo.setBounds(982, 358, 174, 28);

        
        btnAdd.setBounds(1179, 389, 93, 37);
        
        /**
         * ************ add components to panel *********
         */
        add(lblAddCustomer);
        add(lblFirstName);
        add(lblLastName);
        add(lblFirmName);
        add(lblAddress);
        add(lblCity);
        add(lblTinNo);
        add(lblTax);
        add(lblMobile);
        add(lblPhone);
        add(lblFaxNo);
        
        add(fldFirstName);
        add(fldLastName);
        add(fldFirmName);
        add(fldAddress);
        add(fldCity);
        add(fldTinNo);
        add(fldTax);
        add(fldMobile);
        add(fldPhone);
        add(fldFaxNo);
        add(btnAdd);
        
        /**
         * ***************** Register listener *****************
         */
        btnAdd.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAdd && btnAdd.getText().toString().equalsIgnoreCase("Add"))
        {
            btnAddActionPerformed(e);
        }
        else if(e.getSource() == btnAdd && btnAdd.getText().toString().equalsIgnoreCase("Update"))
        {
            CustomerServiceModel customer = new CustomerServiceModel();
            customer.setFirst_name(fldFirstName.getText());
            customer.setLast_name(fldLastName.getText());
            customer.setFirm_name(fldFirmName.getText());
            customer.setAddress(fldAddress.getText());
            customer.setCity(fldCity.getText());
            customer.setTinNo(fldTinNo.getText());
            customer.setTax(Double.parseDouble(fldTax.getText()));
            customer.setMobile_no(fldMobile.getText());
            customer.setPhone(fldPhone.getText());
            customer.setFax_no(fldFaxNo.getText());
            customer.setCustomer_id(customer_id);
            
                       int result = CustomerSearchService.updateCustomer(customer);
                        if(result  > 0)
                        {
                            JOptionPane.showMessageDialog(this, "Customer has updated successfully");
                        }

        }
    }
    
        private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        CustomerServiceModel customerObj = new CustomerServiceModel();
        customerObj.setFirst_name(fldFirstName.getText());
        customerObj.setLast_name(fldLastName.getText());
        customerObj.setFirm_name(fldFirmName.getText());
        customerObj.setAddress(fldAddress.getText());
        customerObj.setCity(fldCity.getText());
        customerObj.setTinNo(fldTinNo.getText());
        customerObj.setPhone(fldPhone.getText());
        customerObj.setMobile_no(fldMobile.getText());
        customerObj.setFax_no(fldFaxNo.getText());
        customerObj.setTax(Double.parseDouble(fldTax.getText()));

        boolean success = CustomerSearchService.insertCustomer(customerObj);

        if (success) {
            // Show dialog..
            JOptionPane.showMessageDialog(this, "Customer added successfully");

        } else {
            JOptionPane.showMessageDialog(this, "Customer with same information has already exist");
        }
    }                         
        
        
        
        
        public void setData(String first_name,String Last_name,String Firm,String Address,String City,String TinNO,String Tax,String mobile,String phone,String fax,String customer_id)
        {
            
        fldFirstName.setText(first_name);
        fldLastName.setText(Last_name);
        fldFirmName.setText(Firm);
        fldAddress.setText(Address);
        fldCity.setText(City);
        fldTinNo.setText(TinNO);
        fldTax.setText(Tax);
        fldMobile.setText(mobile);
        fldPhone.setText(phone);
        fldFaxNo.setText(fax);
        this.customer_id = Integer.parseInt(customer_id);
            btnAdd.setText("Update");
            lblAddCustomer.setText("Update Customer");
        }

}
