/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.service;

import com.jindal.database.ConnectDB;
import com.jindal.model.CustomerServiceModel;
import com.jindal.model.ItemModel;
import com.jindal.model.SalesOrderModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RUBAL GARG
 */
public class SalesService {
    public static int getCurrentInvoiceNumber()
    {
        int currentInvoiceNumber = 0;
        try
        {
            Connection connection = ConnectDB.openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from admin_details");
            while(resultSet.next())
            {
                currentInvoiceNumber = resultSet.getInt("current_invoice_number");
            }
            connection.close();
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return currentInvoiceNumber;
    }
    
    public static boolean setCurrentInvoiceNumber(int current_invoice_number, boolean enableAdminRights) throws SQLException
    {
        boolean success = false;
        if(enableAdminRights)
        {
            boolean success1 = checkIfExistingInvoiceNumber(current_invoice_number);
            if(!success1)
            {
                return success;
            }
        }
        PreparedStatement preparedStatement =null;
            Connection connection = ConnectDB.openConnection();
            preparedStatement = connection.prepareStatement("update"
                                                        + " admin_details set current_invoice_number = ?");
            if(enableAdminRights)
            {
                preparedStatement.setInt(1, current_invoice_number);
            }
            else
            {
                preparedStatement.setInt(1, current_invoice_number + 1);
            }
            int result = preparedStatement.executeUpdate();
            if(result > 0)
            {
                success = true;
            }
            connection.close();
        return success;
    }
    
    public static ArrayList<String> getFinish()
    {
        ArrayList<String> finish = new ArrayList<String>();
        try {
            Connection connection = ConnectDB.openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select distinct finish from stock_detail order by finish");
            while(resultSet.next())
            {
                finish.add(resultSet.getString("finish"));
            }
            connection.close();
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return finish;
    }

        public static ArrayList<String> getThickness()
    {
        ArrayList<String> thickness = new ArrayList<String>();
        try {
            Connection connection = ConnectDB.openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select distinct thickness from stock_detail order by thickness");
            while(resultSet.next())
            {
                thickness.add(resultSet.getString("thickness"));
            }
            connection.close();
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thickness;
    }

    
    public static ArrayList<String> getDesignId()
    {
        ArrayList<String> finish = new ArrayList<String>();
        try {
            Connection connection = ConnectDB.openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select distinct design_id from stock_detail order by design_id");
            while(resultSet.next())
            {
                finish.add(resultSet.getString("design_id"));
            }
            connection.close();
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return finish;
    }
    
    public static int saveTransaction(SalesOrderModel salesOrderModel)
    {
        Connection connection = ConnectDB.openConnection();
        try
        {
            connection.setAutoCommit(false);
            
            boolean result1 = saveCustomerDetails(salesOrderModel, connection);
            boolean result2 = saveOrderDetails(salesOrderModel, connection);
            boolean result3 = saveTransactionDetails(salesOrderModel, connection);
            boolean result4 = updateStockDetails(salesOrderModel,connection);
            boolean result5 = setCurrentInvoiceNumber(salesOrderModel.getInvoiceNumber(),false);
            if(result1 && result2 && result3 && result4 && result5)
            {
                connection.commit();
            }
        }
        catch (Exception ex)
        {
              if (connection != null) 
                {
                    try
                    {
                        System.err.print(ex.getMessage());
                        System.err.print("Transaction is being rolled back");
                        connection.rollback();
                    } 
                    catch(Exception e) 
                    {
                        System.err.print("Error occur while Transaction is being rolled back" + e.getMessage());
                    }
                }
        }
        finally
        {
            try
            {
                connection.setAutoCommit(true);
                connection.close();
            } 
            catch (Exception ex)
            {
                Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return 0;
    }
    
    public static boolean saveCustomerDetails(SalesOrderModel salesOrderModel, Connection connection) throws SQLException
    {
        boolean success = false;
        PreparedStatement preparedStatement;
            	Calendar calendar = Calendar.getInstance();
			    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
			    
				preparedStatement = connection.prepareStatement("insert into"
                                                        + " customer_order_detail " +
						"(invoice_number, customer_id, transport_mode,"
                                                    + " vehicle_number, order_date) " +
						"values(?,?,?,?,?)");
				preparedStatement.setInt (1, salesOrderModel.getInvoiceNumber());
				preparedStatement.setInt (2, salesOrderModel.getCustomerObj().getCustomer_id());
				preparedStatement.setString (3, salesOrderModel.getTransportMode());
				preparedStatement.setString (4, salesOrderModel.getVehicle());
				preparedStatement.setDate (5, date);
                                        
                                int resultSet = preparedStatement.executeUpdate();
				if(resultSet > 0)
				{
					success = true;
				}
				preparedStatement.close ();
        return success;
    }
    
    public static boolean saveOrderDetails(SalesOrderModel salesOrderModel, Connection connection) throws SQLException
    {
        boolean success = false;
        PreparedStatement preparedStatement = null;
            	Calendar calendar = Calendar.getInstance();
			    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
			    ArrayList<ItemModel> items = salesOrderModel.getItems();
                            for(ItemModel item : items)
                            {
				preparedStatement = connection.prepareStatement("insert into"
                                                        + " order_detail " +
						"(invoice_number, design_id, thickness,"
                                                    + " finish, quantity, rate, size, price, order_date) " +
						"values(?,?,?,?,?,?,?,?,?)");
				preparedStatement.setInt (1, salesOrderModel.getInvoiceNumber());
				preparedStatement.setString (2, item.getDesign_Id());
				preparedStatement.setString (3, item.getThickness());
				preparedStatement.setString (4, item.getFinish());
				preparedStatement.setInt (5, item.getQuantity());
                                preparedStatement.setDouble (6, item.getRate());
				preparedStatement.setString (7, item.getSize());
                                preparedStatement.setDouble (8, item.getPrice());
                                preparedStatement.setDate (9, date);
                                
                                        
                                int resultSet = preparedStatement.executeUpdate();
				if(resultSet >= 0)
				{
					success = true;
				}
                                else
                                {
                                    success = false;
                                    break;
                                }
                            }
        
				preparedStatement.close ();
        return success;
    }
    
    public static boolean saveTransactionDetails(SalesOrderModel salesOrderModel, Connection connection) throws SQLException
    {
        boolean success = false;
        PreparedStatement preparedStatement;
            	Calendar calendar = Calendar.getInstance();
			    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
			    
				preparedStatement = connection.prepareStatement("insert into"
                                                        + " transaction_detail " +
						"(invoice_number, tax, discount, freight, taxValue, surcharge, "
                                        + " surchargeValue, grand_total, "
                                                    + " net_total, transaction_date) " +
						"values(?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setInt (1, salesOrderModel.getInvoiceNumber());
				preparedStatement.setDouble (2, salesOrderModel.getTax());
				preparedStatement.setDouble (3, salesOrderModel.getDiscount());
				preparedStatement.setDouble (4, salesOrderModel.getFreight());
                                preparedStatement.setDouble (5, salesOrderModel.getTaxValue());
                                preparedStatement.setDouble (6, salesOrderModel.getSurcharge());
                                preparedStatement.setDouble (7, salesOrderModel.getSurchargeValue());
                                preparedStatement.setDouble (8, salesOrderModel.getGrandTotal());
				preparedStatement.setDouble (9, salesOrderModel.getNetTotal());
                                preparedStatement.setDate (10, date);
                                int resultSet = preparedStatement.executeUpdate();
				if(resultSet > 0)
				{
					success = true;
				}
				preparedStatement.close ();
        return success;
    }
    
    public static boolean updateStockDetails(SalesOrderModel salesOrderModel, Connection connection) throws SQLException
    {
        boolean success = false;
        int quantity;
        PreparedStatement preparedStatement = null;
            	Calendar calendar = Calendar.getInstance();
			    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
                            ArrayList<ItemModel> items = salesOrderModel.getItems();
                            for(ItemModel item : items)
                            {
                                quantity = getCurrentQuantity(item, connection);
				preparedStatement = connection.prepareStatement("update stock_detail set quantity = ?"
                                        + " where design_id = ? and thickness = ? and finish = ?");
				preparedStatement.setInt (1, quantity - item.getQuantity());
				preparedStatement.setString (2, item.getDesign_Id());
				preparedStatement.setString (3, item.getThickness());
				preparedStatement.setString (4, item.getFinish());
                                int resultSet = preparedStatement.executeUpdate();
				if(resultSet > 0)
				{
					success = true;
				}
                                else
                                {
                                    success = false;
                                    break;
                                }
                            }
			preparedStatement.close ();
        return success;
    }
    
    public static int getCurrentQuantity(ItemModel item, Connection connection) throws SQLException
    {
        boolean success = false;
        int quantity = -1;
        PreparedStatement preparedStatement = null;
            	Calendar calendar = Calendar.getInstance();
			    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
                            //retrive current quanity..
                            preparedStatement = connection.prepareStatement("select quantity from stock_detail"
                                        + " where design_id = ? and thickness = ? and finish = ?");
				
				preparedStatement.setString (1, item.getDesign_Id());
				preparedStatement.setString (2, item.getThickness());
				preparedStatement.setString (3, item.getFinish());
                                ResultSet resultSet = preparedStatement.executeQuery();
                                while(resultSet.next())
                                {
                                    quantity = resultSet.getInt("quantity");
                                }
                         preparedStatement.close ();
        return quantity;
    }
    
        public static SalesOrderModel getPackingDetails(int invoiceNumber) throws SQLException
        {
            boolean success = false;
            int quantity = -1;
            Connection connection = ConnectDB.openConnection();
            PreparedStatement preparedStatement = null;
            PreparedStatement preparedStatement1 = null;
            	Calendar calendar = Calendar.getInstance();
                SalesOrderModel salesOrderModel = new SalesOrderModel();
                CustomerServiceModel customerObj = new CustomerServiceModel();
                ArrayList<ItemModel> itemArray = new ArrayList<ItemModel>();
			    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
                            //retrive current quanity..
                            preparedStatement = connection.prepareStatement("select c_order.customer_id, first_name, "
                                    + "last_name, firm_name, address, "
                                    + "city, tin_no, mobile, phone_office, fax_no, tax, vehicle_number,"
                                    + " order_date from customer_order_detail c_order, "
                                    + "customer_detail c_details"
                                    + " where invoice_number = ? "
                                    + "and c_order.customer_id = "
                                    + "c_details.customer_id");
				
				preparedStatement.setInt (1, invoiceNumber);
				ResultSet resultSet = preparedStatement.executeQuery();
                                while(resultSet.next())
                                {
                                    customerObj.setCustomer_id(resultSet.getInt(1));
                                    customerObj.setFirst_name(resultSet.getString(2));
                                    customerObj.setLast_name(resultSet.getString(3));
                                    customerObj.setFirm_name(resultSet.getString(4));
                                    customerObj.setAddress(resultSet.getString(5));
                                    customerObj.setCity(resultSet.getString(6));
                                    customerObj.setTinNo(resultSet.getString(7));
                                    customerObj.setMobile_no(resultSet.getString(8));
                                    customerObj.setPhone(resultSet.getString(9));
                                    customerObj.setFax_no(resultSet.getString(10));
                                    customerObj.setTax(resultSet.getDouble(11));
                                    
                                    salesOrderModel.setCustomerObj(customerObj);
                                    salesOrderModel.setVehicle(resultSet.getString(12));
                                    salesOrderModel.setOrderDate(resultSet.getDate(13));
                                }
                                
                                preparedStatement1 = connection.prepareStatement("select * from order_detail"
                                        + " where invoice_number = ?");
                                preparedStatement1.setInt(1, invoiceNumber);
                                ResultSet resultSet1 = preparedStatement1.executeQuery();
                                while(resultSet1.next())
                                {
                                    ItemModel item = new ItemModel();
                                    item.setDesign_Id(resultSet1.getString(2));
                                    item.setThickness(resultSet1.getString(3));
                                    item.setFinish(resultSet1.getString(4));
                                    item.setQuantity(resultSet1.getInt(5));
                                    item.setRate(resultSet1.getDouble(6));
                                    item.setSize(resultSet1.getString(7));
                                    item.setPrice(resultSet1.getDouble(8));
                                    itemArray.add(item);
                                }
                                salesOrderModel.setItems(itemArray);
                         preparedStatement.close ();
                         preparedStatement1.close ();
        return salesOrderModel;
    }
        
    public static boolean checkIfExistingInvoiceNumber(int current_invoice_number) throws SQLException
    {
        boolean success = false;
        PreparedStatement preparedStatement =null;
        int invoiceId;
            Connection connection = ConnectDB.openConnection();
            preparedStatement = connection.prepareStatement("select max(invoice_number) from order_detail");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                invoiceId = resultSet.getInt(1);
                if(current_invoice_number > invoiceId)
                {
                    success = true;
                }
            }
            connection.close();
        return success;
    }
    
    public static boolean setApplicableTaxes(String applicableTaxes)
    {
        boolean success = false;
        PreparedStatement preparedStatement =null;
        try 
        {
            Connection connection = ConnectDB.openConnection();
            preparedStatement = connection.prepareStatement("update admin_details set applicable_tax = ?");
            preparedStatement.setString(1, applicableTaxes);
            
            int result = preparedStatement.executeUpdate();
            if(result > 0)
            {
                success = true;
            }
            connection.close();
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
   public static String getApplicableTaxes()
    {
        String applicableTaxes = null;
        double surcharge = 0;
        try
        {
            Connection connection = ConnectDB.openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from admin_details");
            while(resultSet.next())
            {
                surcharge = resultSet.getDouble("surcharge");
                applicableTaxes = resultSet.getString("applicable_tax");
            }
            connection.close();
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return applicableTaxes;
    }

      public static double getSurcharge()
        {
            double surcharge = 0;
            try
            {
                Connection connection = ConnectDB.openConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from admin_details");
                while(resultSet.next())
                {
                    surcharge = resultSet.getDouble("surcharge");
                }
                connection.close();
            } 
            catch (SQLException ex)
            {
                Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return surcharge;
        }

}
