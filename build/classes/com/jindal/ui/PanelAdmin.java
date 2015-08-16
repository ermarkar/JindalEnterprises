/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.ui;

import com.jindal.forms.Admin;
import com.jindal.service.SalesService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author RUBAL GARG
 */
public class PanelAdmin extends JPanel implements ActionListener
{   
    JTabbedPane tabPane;
    JPanel taxPanel;
    JPanel invoiceNumberPanel;
    JPanel databasePanel;
    JPanel panel;
    JLabel lblAdmin;
    JLabel lblTax;
    JLabel lblInvoiceNumber;
    JLabel lblDatabase;
    JLabel lblCurrentInvoice;
    JTextField fldInvoiceNumber;
    JButton btnInvoiceSubmit;
    JLabel lblSurcharge;
    JLabel lblTaxRate;
    JLabel lblTip;
    JTextField fldSurcharge;
    JTextField fldTaxRate;
    JButton btnTaxSubmit;
    JButton btnBackup;
    JButton btnRestore;
    
    public PanelAdmin()
    {
	tabPane = new JTabbedPane();
	taxPanel = createTaxPanel();
        invoiceNumberPanel = createInvoiceNumberPanel();
        databasePanel = createDatabasePanel();
        lblAdmin = new com.jindal.ui.CustomLabel("Admin", new java.awt.Font("Calibri", 1, 36), java.awt.Color.orange);
        /**
         * ************ add components to panel *********
         */
        tabPane.addTab("Tax", taxPanel);
	tabPane.setSelectedIndex(0);
        tabPane.addTab("Invoice Number", invoiceNumberPanel);
	tabPane.addTab("Database", databasePanel);
        
        /**
         * ******************** layout and background ******************
         */
        setLayout(new GridLayout(1, 1));
        tabPane.setFont(  new java.awt.Font("Tahoma", 1, 14) );
        tabPane.setBackground(Color.orange);
        tabPane.setForeground(Color.orange);
        
        javax.swing.border.Border border = BorderFactory.createLineBorder(Color.RED, 2);
        taxPanel.setBorder(border);
        invoiceNumberPanel.setBorder(border);
        databasePanel.setBorder(border);
        taxPanel.setBackground(new java.awt.Color(255, 255, 255));
        invoiceNumberPanel.setBackground(new java.awt.Color(255, 255, 255));
        databasePanel.setBackground(new java.awt.Color(255, 255, 255));
        
        /**
         * ************************ Set bounds of components
         * *********************************
         */
        tabPane.setBounds(160, 105, 1025, 328);
        lblAdmin.setBounds(580, 46, 110, 31);
        
        // Add the tabbed pane to this panel.
	this.add(tabPane);
        add(lblAdmin);
        /**
         * ***************** Register listener *****************
         */
        btnTaxSubmit.addActionListener(this);
        btnInvoiceSubmit.addActionListener(this);
        btnBackup.addActionListener(this);
        btnRestore.addActionListener(this);
    }
	protected JPanel createTaxPanel() {
		lblTax = new com.jindal.ui.CustomLabel("Enter Tax Details", new java.awt.Font("Calibri", 1, 28), java.awt.Color.orange);
                panel = new JPanel();
                lblSurcharge = new com.jindal.ui.CustomLabel("Surcharge Rate",  new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
                lblTaxRate = new com.jindal.ui.CustomLabel("Applicable on which Tax rate",  new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
                lblTip = new com.jindal.ui.CustomLabel("(Provide ,(comma) seperated if more than one)",  new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(204, 51, 0));
                fldSurcharge = new JTextField();
                fldTaxRate = new JTextField();
                btnTaxSubmit = new com.jindal.ui.CustomButton("Submit", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
                
                panel.setLayout(null);
                lblTax.setBounds(333, 31, 217, 31);
                lblSurcharge.setBounds(265, 99, 141, 24);
                fldSurcharge.setBounds(461, 95, 174, 28);
                lblTaxRate.setBounds(163, 148, 254, 24);
                fldTaxRate.setBounds(461, 148, 174, 28);
                lblTip.setBounds(163, 176, 450, 13);
                btnTaxSubmit.setBounds(388, 220, 93, 37);
               
                panel.add(lblTax);
                panel.add(lblSurcharge);
                panel.add(lblTaxRate);
                panel.add(lblTip);
                panel.add(fldSurcharge);
                panel.add(fldTaxRate);
                panel.add(btnTaxSubmit);
                
		return panel;
	}
        
        protected JPanel createInvoiceNumberPanel() {
		lblInvoiceNumber = new com.jindal.ui.CustomLabel("Enter Current Invoice Number", new java.awt.Font("Calibri", 1, 28), java.awt.Color.orange);
                panel = new JPanel();
                lblCurrentInvoice = new com.jindal.ui.CustomLabel("Invoice Number",  new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 51, 0));
                fldInvoiceNumber = new JTextField();
                btnInvoiceSubmit = new com.jindal.ui.CustomButton("Submit", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
                
                panel.setLayout(null);
                lblInvoiceNumber.setBounds(270, 35, 374, 31);
                lblCurrentInvoice.setBounds(195, 116, 211, 24);
                fldInvoiceNumber.setBounds(461, 112, 174, 28);
                btnInvoiceSubmit.setBounds(388, 186, 93, 37);
                
                panel.add(lblInvoiceNumber);
                panel.add(lblCurrentInvoice);
                panel.add(fldInvoiceNumber);
                panel.add(btnInvoiceSubmit);
                
		return panel;
	}
        
        protected JPanel createDatabasePanel() {
		lblDatabase = new com.jindal.ui.CustomLabel("Database Backup and Restore", new java.awt.Font("Calibri", 1, 28), java.awt.Color.orange);
                panel = new JPanel();
                btnBackup = new com.jindal.ui.CustomButton("Backup", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
                btnRestore = new com.jindal.ui.CustomButton("Restore", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
                panel.setLayout(null);
                lblDatabase.setBounds(305, 45, 384, 31);
                btnBackup.setBounds(287, 122, 93, 37);
                btnRestore.setBounds(619, 122, 93, 37);
                
                panel.add(lblDatabase);
                panel.add(btnBackup);
                panel.add(btnRestore);
                
		return panel;
	}

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == btnTaxSubmit)
        {
            btnTaxSubmitActionPerformed(e);
        }
        else if(e.getSource() == btnInvoiceSubmit)
        {
            btnInvoiceSubmitActionPerformed(e);
        }
        else if(e.getSource() == btnBackup)
        {
            
        }
        if(e.getSource() == btnRestore)
        {
            
        }
    }
    
        private void btnInvoiceSubmitActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if (fldInvoiceNumber.getText() != null) {
            try {
                int invoiceNumber = Integer.parseInt(fldInvoiceNumber.getText());
                boolean success = SalesService.setCurrentInvoiceNumber(invoiceNumber, true);
                if (!success) {
                    JOptionPane.showMessageDialog(this, "Invoice Number you have entered is not already taken");
                } else {
                    JOptionPane.showMessageDialog(this, "You have successfully updated the Invoice Number");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
    private void btnTaxSubmitActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (fldSurcharge.getText() != null && fldTaxRate.getText() != null) {
            String applicableTaxes = fldTaxRate.getText();
            boolean applicableTaxCorrect = true;
            String taxes[] = applicableTaxes.split(",");

            for (String tax : taxes) {
                try {
                    Double.parseDouble(tax);
                } catch (NumberFormatException e) {
                    applicableTaxCorrect = false;
                    break;
                }
            }
            if (!applicableTaxCorrect) {
                JOptionPane.showMessageDialog(this, "Please enter a valid input");
                return;
            } else {
                SalesService.setApplicableTaxes(applicableTaxes);
                JOptionPane.showMessageDialog(this, "You have successfully updated the surcharge.");
            }
        }
    }

}
