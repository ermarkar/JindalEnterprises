package com.jindal.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.jindal.database.ConnectDB;
import com.jindal.model.CustomerServiceModel;
import java.sql.Connection;


public class CustomerSearchService
{
	
	public static ArrayList<CustomerServiceModel> getResultantCustomer(CustomerServiceModel customerServiceObj) 
	{
		ArrayList<CustomerServiceModel> customerServiceArray = new ArrayList<CustomerServiceModel>();
		try
		{
			String firstName = customerServiceObj.getFirst_name();
			String lastName = customerServiceObj.getLast_name();
			String firmName = customerServiceObj.getFirm_name();
			String city = customerServiceObj.getCity();
			String mobile = customerServiceObj.getMobile_no();
			
			Connection connection = ConnectDB.openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from customer_detail " +
					"where first_name = ? or last_name = ? or firm_name = ? or city = ? or mobile = ?");
			preparedStatement.setString (1, firstName);
			preparedStatement.setString (2, lastName);
			preparedStatement.setString (3, firmName);
			preparedStatement.setString (4, city);
			preparedStatement.setString (5, mobile);
			
			   ResultSet resultSet = preparedStatement.executeQuery();
			   
			   while(resultSet.next())
			   {
				   CustomerServiceModel customerObj = new CustomerServiceModel();
				   customerObj.setFirst_name(resultSet.getString("first_name"));
				   customerObj.setLast_name(resultSet.getString("last_name"));
				   customerObj.setFirm_name(resultSet.getString("firm_name"));
				   customerObj.setAddress(resultSet.getString("address"));
				   customerServiceObj.setCity(resultSet.getString("city"));
				   customerServiceObj.setMobile_no(resultSet.getString("mobile_no"));
				   customerServiceObj.setPhone(resultSet.getString("phone"));
				   customerServiceObj.setFax_no(resultSet.getString("fax_no"));
                                   customerServiceObj.setTax(resultSet.getDouble("Tax"));
				   customerServiceArray.add(customerServiceObj);
				}
			   preparedStatement.close ();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return customerServiceArray;
	}
	
	public static boolean insertCustomer(CustomerServiceModel customerServiceObj) 
	{
		boolean success = false;
		String firstName = customerServiceObj.getFirst_name();
		String lastName = customerServiceObj.getLast_name();
		String mobile = customerServiceObj.getMobile_no();
		String firmName = customerServiceObj.getFirm_name();
		String address = customerServiceObj.getAddress();
		String city = customerServiceObj.getCity();
		String tinNo = customerServiceObj.getTinNo();
		String phone = customerServiceObj.getPhone();
		String fax = customerServiceObj.getFax_no();
                double tax = customerServiceObj.getTax();
		boolean isCustomerExist = checkExistingCustomer(customerServiceObj);
		
		if(isCustomerExist)
		{
			// show dialog..
			success = false;
		}
		else
		{
			Connection connection = ConnectDB.openConnection();
			PreparedStatement preparedStatement;
			try
			{
				Calendar calendar = Calendar.getInstance();
			    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
			    
				preparedStatement = connection.prepareStatement("insert into customer_detail " +
						"(first_name, last_name, firm_name, address, city, tin_no, mobile, phone_office, fax_no, tax, created_on) " +
						"values(?,?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setString (1, firstName);
				preparedStatement.setString (2, lastName);
				preparedStatement.setString (3, firmName);
				preparedStatement.setString (4, address);
				preparedStatement.setString (5, city);
				preparedStatement.setString (6, tinNo);
				preparedStatement.setString (7, mobile);
				preparedStatement.setString (8, phone);
				preparedStatement.setString (9, fax);
                                preparedStatement.setDouble(10, tax);
				preparedStatement.setDate (11, date);
                                
				int resultSet = preparedStatement.executeUpdate();
				if(resultSet > 0)
				{
					success = true;
				}
				preparedStatement.close ();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return success;	   
	}
	
	public static boolean checkExistingCustomer(CustomerServiceModel customerObj)
	{
		boolean success = false;
                String firstName = customerObj.getFirst_name();
                String lastName = customerObj.getLast_name();
                String mobile = customerObj.getMobile_no();
		Connection connection = ConnectDB.openConnection();
                PreparedStatement preparedStatement;
		try 
		{
			preparedStatement = connection.prepareStatement("select * from customer_detail " +
					"where first_name = ? and last_name = ? and mobile = ?");
			preparedStatement.setString (1, firstName);
			preparedStatement.setString (2, lastName);
			preparedStatement.setString (3, mobile);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			   
			while(resultSet.next())
			{
				   success = true;
			}
			preparedStatement.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return success;
	}
        
        public static ArrayList<CustomerServiceModel> SearchCustomer(CustomerServiceModel customerObj)
	{
                ResultSet resultSet =null;
                String firstName = customerObj.getFirst_name();
                String lastName = customerObj.getLast_name();
                String mobile = customerObj.getMobile_no();
                String city = customerObj.getCity();System.out.println("first name "+firstName);
                Connection connection = ConnectDB.openConnection();
                ArrayList<CustomerServiceModel> customerArray = new ArrayList<CustomerServiceModel>();
                PreparedStatement preparedStatement;
		try 
		{
			preparedStatement = connection.prepareStatement("select first_name, last_name, firm_name,"
                                + "address, city, tin_no, mobile, phone_office, fax_no, tax from customer_detail " +
					"where first_name = ? or last_name = ? or mobile = ? or city = ?");
			preparedStatement.setString (1, firstName);
			preparedStatement.setString (2, lastName);
			preparedStatement.setString (3, mobile);
			preparedStatement.setString (4, city);
                        
			resultSet = preparedStatement.executeQuery();
			
                        
			while(resultSet.next())
			{System.out.println("name="+resultSet.getString("first_name"));
                            CustomerServiceModel custObj = new CustomerServiceModel();
                            custObj.setFirst_name(resultSet.getString("first_name"));
                            custObj.setLast_name(resultSet.getString("last_name"));
                            custObj.setFirm_name(resultSet.getString("firm_name"));
                            custObj.setAddress(resultSet.getString("address"));
                            custObj.setCity(resultSet.getString("city"));
                            custObj.setMobile_no(resultSet.getString("mobile"));
                            custObj.setTinNo(resultSet.getString("tin_no"));
                            custObj.setPhone(resultSet.getString("phone_office"));
                            custObj.setFax_no(resultSet.getString("fax_no"));
                            custObj.setTax(resultSet.getDouble("tax"));
                            customerArray.add(custObj);
			}
			preparedStatement.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}System.out.println(customerArray.toString());
                return customerArray;
        }
        
       public static int updateCustomer(CustomerServiceModel customerObj)
	{
                int result = 0;
                int customerId = customerObj.getCustomer_id();
                String firstName = customerObj.getFirst_name();
                String lastName = customerObj.getLast_name();
                String firmName = customerObj.getFirm_name();
                String address = customerObj.getAddress();
                String city = customerObj.getCity();
                String tinNo = customerObj.getTinNo();
                String mobile = customerObj.getMobile_no();
                String phone = customerObj.getPhone();
                String faxNo = customerObj.getFax_no();
                double tax = customerObj.getTax();
                
                Connection connection = ConnectDB.openConnection();
                PreparedStatement preparedStatement;
		try 
		{
			preparedStatement = connection.prepareStatement("update customer_detail set first_name = ?,"
                                + "last_name = ?, firm_name = ?, city = ?, address = ?, tin_no = ?, mobile = ?,"
                                + " phone_office = ?, fax_no = ?, tax = ? where customer_id = ?");
			preparedStatement.setString (1, firstName);
			preparedStatement.setString (2, lastName);
			preparedStatement.setString (3, firmName);
			preparedStatement.setString (4, city);
                        preparedStatement.setString (5, address);
			preparedStatement.setString (6, tinNo);
			preparedStatement.setString (7, mobile);
			preparedStatement.setString (8, phone);
                        preparedStatement.setString (9, faxNo);
                        preparedStatement.setDouble(10, tax);
			preparedStatement.setInt (11, customerId);

			result = preparedStatement.executeUpdate();
			
                        preparedStatement.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
                return result;
        }
       
       public static int findCustomerId(CustomerServiceModel customerObj)
       {
                int customer_id = 0;
		Connection connection = ConnectDB.openConnection();
                PreparedStatement preparedStatement;
		try 
		{
			preparedStatement = connection.prepareStatement("select customer_id from customer_detail " +
					"where first_name = ? and last_name = ? and firm_name = ? and"
                                + " city = ? and address = ? and tin_no = ? and mobile = ? and phone_office = ?"
                                + " and fax_no = ? and tax = ?");
			preparedStatement.setString (1, customerObj.getFirst_name());
			preparedStatement.setString (2, customerObj.getLast_name());
			preparedStatement.setString (3, customerObj.getFirm_name());
                        preparedStatement.setString (4, customerObj.getCity());
                        preparedStatement.setString (5, customerObj.getAddress());
                        preparedStatement.setString (6, customerObj.getTinNo());
                        preparedStatement.setString (7, customerObj.getMobile_no());
                        preparedStatement.setString (8, customerObj.getPhone());
                        preparedStatement.setString (9, customerObj.getFax_no());
                        preparedStatement.setDouble(10, customerObj.getTax());
                        
			ResultSet resultSet = preparedStatement.executeQuery();
			   
			while(resultSet.next())
			{
				   customer_id = resultSet.getInt("customer_id");
			}
			preparedStatement.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
           return customer_id;
       }
       
       public static ArrayList<CustomerServiceModel> FetchCustomer(int page_no, String first_name, String firm_name, String city, String mobile)
       {
                Connection connection = ConnectDB.openConnection();
                PreparedStatement preparedStatement,preparedStatement1;
                ArrayList<CustomerServiceModel> customerArray = new ArrayList<CustomerServiceModel>();   
		try 
		{
			preparedStatement = connection.prepareStatement("select * from customer_detail "
                                + "WHERE first_name like '"+first_name+"%' and firm_name like '"+firm_name+"%'"+
                                    "and city like '"+city+"%' and mobile like '"+mobile+"%' limit ?,5");
			preparedStatement.setInt(1, page_no);
                        
			ResultSet resultSet = preparedStatement.executeQuery();
			
                        while(resultSet.next())
			{
                            CustomerServiceModel customer = new CustomerServiceModel();
                            
                            customer.setFirst_name(resultSet.getString("first_name"));
                            customer.setLast_name(resultSet.getString("last_name"));
                            customer.setFirm_name(resultSet.getString("firm_name"));
                            customer.setCity(resultSet.getString("city"));
                            customer.setTinNo(resultSet.getString("tin_no"));
                            customer.setTax(Double.parseDouble(resultSet.getString("tax")));
                            customer.setMobile_no(resultSet.getString("mobile"));
                            customer.setPhone(resultSet.getString("phone_office"));
                            customer.setFax_no(resultSet.getString("fax_no"));
                            customer.setAddress(resultSet.getString("address"));
                            customer.setCustomer_id(resultSet.getInt("customer_id"));
                            
                            customerArray.add(customer);
			}
			
                        
                        preparedStatement1 = connection.prepareStatement("select count(*) from customer_detail "
                                + "WHERE first_name like '"+first_name+"%' and firm_name like '"+firm_name+"%'"+
                                    "and city like '"+city+"%' and mobile like '"+mobile+"%' ");
                        	ResultSet resultSet1 = preparedStatement1.executeQuery();
                        
                        preparedStatement.close();
                       
                        if(customerArray!=null&&customerArray.size()>0)
                        {
                            resultSet1.next();
                            customerArray.get(0).setRowcount(Integer.parseInt(resultSet1.getString("count(*)")));
                        }
			preparedStatement1.close();


		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
           return customerArray;
       }
}
