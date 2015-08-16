package com.jindal.forms;

import com.jindal.ui.CustomButton;
import com.jindal.ui.CustomLabel;
import com.jindal.model.CustomerServiceModel;
import com.jindal.model.ItemModel;
import com.jindal.reports.JasperReport;
import com.jindal.service.CustomerSearchService;
import com.jindal.service.ItemService;
import com.jindal.service.SalesService;
import com.jindal.stockReport.StockReport;
import com.jindal.ui.PanelAdmin;
import com.jindal.ui.PanelCustomer;
import com.jindal.ui.PanelSales;
import com.jindal.ui.PanelStock;
import com.jindal.ui.ReportMenuPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jindalenterprises.PrintFileToPrinter;
import java.util.Date;
import java.awt.event.ActionEvent;

public class HomePage extends javax.swing.JFrame implements ActionListener {

    String fileName;
    final int WIDTH = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;    //This is maximum width of the windows
    final int HEIGHT = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;	//This is maximum height of the windows
    //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //setBounds(0,0,screenSize.width, screenSize.height);
    //final int WIDTH = screenSize.width;    //This is maximum width of the windows
    //final int HEIGHT = screenSize.height;       //This is maximum height of the windows
    public static javax.swing.JPanel sLoadedPanel = null;
    public static ArrayList<String> designIdArray = new ArrayList<String>(); 
    
    
    
    
    public HomePage() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        System.out.println(HEIGHT);
        setLayout(null);
        //this.setExtendedState(this.MAXIMIZED_BOTH);
        setBounds(0, 0, WIDTH, HEIGHT);
        designIdArray = SalesService.getDesignId();
        customInitComponents();
        //pack();
    }

    
    private void customInitComponents() {
        System.out.println(WIDTH + "g" + HEIGHT);
        panelHeading = new javax.swing.JPanel();
        lblHeading1 = new CustomLabel("XXXXXX Enterprises", new java.awt.Font("Calibri", 1, 36), java.awt.Color.orange);
        lblHeading2 = new CustomLabel("XXX, Industrial Area - II, XXXXXXXXX", new java.awt.Font("Calibri", 0, 24), java.awt.Color.orange);

       // panelSales = new PanelSales();
        btnAdministrator = new CustomButton("Admin", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0)); // NOI18N
        btnHome = new CustomButton("Logout", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0)); // NOI18N
        btnExit = new CustomButton("Exit", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));

        btnStockMenu = new CustomButton("Stock Inventory", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnCustomerMenu = new CustomButton("Customer", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnReportsMenu = new CustomButton("Reports", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));
        btnSalesInventoryMenu = new CustomButton("Sales Inventory", new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 51, 0));

        /**
         * ******************** layout and background ******************
         */
        panelHeading.setLayout(null);
        panelHeading.setBackground(new java.awt.Color(255, 255, 255));

       // panelSales.setLayout(null);
       // panelSales.setBackground(new java.awt.Color(255, 255, 255));

         sLoadedPanel = new com.jindal.ui.PanelCustomer(false);
         sLoadedPanel.setLayout(null);
         sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
         HomePage.this.getContentPane().add(sLoadedPanel);

         sLoadedPanel.setVisible(true);
        
            

        /**
         * ************ add components to panel *********
         */
        panelHeading.add(lblHeading1);
        panelHeading.add(lblHeading2);

        /**
         * ************************ Set bounds of components
         * *********************************
         */
        lblHeading1.setBounds(522, 17, 330, 31);
        lblHeading2.setBounds(480, 54, 358, 26);

        btnAdministrator.setBounds(1085, 120, 112, 30);
        btnHome.setBounds(1085, 120, 112, 30);
        btnExit.setBounds(1226, 120, 112, 30);

        panelHeading.setBounds(12, 12, WIDTH - 40, 100);
       // panelSales.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);

        btnStockMenu.setBounds(697, 632, 305, 37);
        btnCustomerMenu.setBounds(351, 632, 305, 37);
        btnReportsMenu.setBounds(1033, 632, 305, 37);
        btnSalesInventoryMenu.setBounds(13, 632, 305, 37);

       

        /**
         * ************************ Add Components on Frame
         * *********************************
         */
        add(panelHeading);
        add(btnAdministrator);
        add(btnExit);
        add(btnStockMenu);
        add(btnCustomerMenu);
        add(btnReportsMenu);
        add(btnSalesInventoryMenu);


        /**
         * ***************** Register listener *****************
         */
        //btnAddItem.addActionListener(this);
        btnAdministrator.addActionListener(this);
        btnHome.addActionListener(this);
        btnExit.addActionListener(this);
        btnStockMenu.addActionListener(this);
        btnReportsMenu.addActionListener(this);
        btnSalesInventoryMenu.addActionListener(this);
        btnCustomerMenu.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStockMenu) {
            HomePage.this.getContentPane().revalidate();
            HomePage.this.getContentPane().repaint();

            if (sLoadedPanel != null) {
                HomePage.this.getContentPane().remove(sLoadedPanel);
            }
            sLoadedPanel = new PanelStock();
            sLoadedPanel.setLayout(null);
            sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
            sLoadedPanel.setLayout(null);
            //sLoadedPanel.setBackground(new java.awt.Color(255, 255, 255));

            HomePage.this.getContentPane().add(sLoadedPanel);

            sLoadedPanel.setVisible(true);
        } else if (e.getSource() == btnAdministrator) {
            //btnAdministratorActionPerformed(e);
            HomePage.this.getContentPane().revalidate();
            HomePage.this.getContentPane().repaint();
            HomePage.this.add(btnHome);
            if (sLoadedPanel != null) {
                HomePage.this.getContentPane().remove(sLoadedPanel);
            }
            sLoadedPanel = new PanelAdmin();
            sLoadedPanel.setLayout(null);
            sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
            sLoadedPanel.setLayout(null);
            sLoadedPanel.setBackground(new java.awt.Color(255, 255, 255));

            HomePage.this.getContentPane().add(sLoadedPanel);

            sLoadedPanel.setVisible(true);
        } else if (e.getSource() == btnExit) {
            this.dispose();
        } else if (e.getSource() == btnSalesInventoryMenu) {
            HomePage.this.getContentPane().revalidate();
            HomePage.this.getContentPane().repaint();

            if (sLoadedPanel != null) {
                HomePage.this.getContentPane().remove(sLoadedPanel);
            }
            sLoadedPanel = new PanelCustomer(false);
            sLoadedPanel.setLayout(null);
            sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
            sLoadedPanel.setLayout(null);
            //sLoadedPanel.setBackground(new java.awt.Color(255, 255, 255));

            HomePage.this.getContentPane().add(sLoadedPanel);

            sLoadedPanel.setVisible(true);
        }
        else if (e.getSource() == btnReportsMenu) {

            HomePage.this.getContentPane().revalidate();
            HomePage.this.getContentPane().repaint();

            if (sLoadedPanel != null) {
                HomePage.this.getContentPane().remove(sLoadedPanel);
            }
            sLoadedPanel = new ReportMenuPanel();
            sLoadedPanel.setLayout(null);
            sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
            sLoadedPanel.setLayout(null);
            sLoadedPanel.setBackground(new java.awt.Color(255, 255, 255));

            HomePage.this.getContentPane().add(sLoadedPanel);

            sLoadedPanel.setVisible(true);
        }
        if (e.getSource() == btnCustomerMenu) {
            HomePage.this.getContentPane().revalidate();
            HomePage.this.getContentPane().repaint();

            if (sLoadedPanel != null) {
                HomePage.this.getContentPane().remove(sLoadedPanel);
            }
            sLoadedPanel = new PanelCustomer(true);
            sLoadedPanel.setLayout(null);
            sLoadedPanel.setBounds(12, 153, WIDTH - 40, HEIGHT - 253);
            //sLoadedPanel.setLayout(null);
            //sLoadedPanel.setBackground(new java.awt.Color(255, 255, 255));

            HomePage.this.getContentPane().add(sLoadedPanel);

            sLoadedPanel.setVisible(true);
        }
    }
    private void btnReportsMenuActionPerformed(java.awt.event.ActionEvent evt) {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    // End of variables declaration
    private CustomButton btnStockMenu;
    private CustomButton btnCustomerMenu;
    private CustomButton btnReportsMenu;
    private CustomButton btnSalesInventoryMenu;
    private CustomButton btnHome;
    private javax.swing.JDialog PackingListDialog;
    private javax.swing.JDialog StockStatementDialog;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnAdministrator;
    private javax.swing.JButton btnCancelPackingList;
    private javax.swing.JButton btnCancelStockList1;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGetDetails;
    private javax.swing.JButton btnPrintPackingList;
    private javax.swing.JButton btnPrintStockList1;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchSales;
    private javax.swing.JButton btnStockReport;
    private javax.swing.JComboBox ddFinish;
    private javax.swing.JTextField fldAddress;
    private javax.swing.JTextField fldCity;
    private javax.swing.JTextField fldCitySales;
    private javax.swing.JTextField fldCityUpdate;
    private javax.swing.JTextField fldDesignId;
    private javax.swing.JTextField fldFaxNo;
    private javax.swing.JTextField fldFirmName;
    private javax.swing.JTextField fldFirstName;
    private javax.swing.JTextField fldFirstNameSales;
    private javax.swing.JTextField fldFirstNameUpdate;
    private javax.swing.JTextField fldInvoiceNumber;
    private javax.swing.JTextField fldLastName;
    private javax.swing.JTextField fldLastNameSales;
    private javax.swing.JTextField fldLastNameUpdate;
    private javax.swing.JTextField fldMobileNo;
    private javax.swing.JTextField fldMobileNoSales;
    private javax.swing.JTextField fldMobileNoUpdate;
    private javax.swing.JTextField fldPhone;
    private javax.swing.JTextField fldPrice;
    private javax.swing.JTextField fldQuantity;
    private javax.swing.JTextField fldSize;
    private javax.swing.JTextField fldTax;
    private javax.swing.JTextField fldThickness;
    private javax.swing.JTextField fldTinNo;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblAddStock;
    private javax.swing.JLabel lblDesignId;
    private javax.swing.JLabel lblFinish;
    private javax.swing.JLabel lblHeading1;
    private javax.swing.JLabel lblHeading2;
    private javax.swing.JLabel lblPackingListDialog1;
    private javax.swing.JLabel lblPackingListDialog2;
    private javax.swing.JLabel lblPackingListDialog3;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel lblStockListDialog1;
    private javax.swing.JLabel lblStockListDialog2;
    private javax.swing.JLabel lblStockListDialog3;
    private javax.swing.JLabel lblThickness;
    private javax.swing.JPanel panelHeading;
    private javax.swing.JPanel panelStock;
    private javax.swing.JTabbedPane tabAdmin;
    private javax.swing.JTabbedPane tabCustomer;
    private javax.swing.JTabbedPane tabMain;
    // End of variables declaration
}
