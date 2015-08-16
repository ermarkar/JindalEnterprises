/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.service;

import com.jindal.database.ConnectDB;
import com.jindal.model.ItemModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author RUBAL GARG
 */
public class ItemService {

    public static String checkExistingItem(String design_id, String thickness, String finish)
	{
		
                int quantity=0;
                String success = quantity+",false";
		Connection connection = ConnectDB.openConnection();
                PreparedStatement preparedStatement;
		try 
		{
			preparedStatement = connection.prepareStatement("select * from stock_detail " +
					"where design_id = ? and thickness = ? and finish = ?");
			preparedStatement.setString (1, design_id);
                        preparedStatement.setString (2, thickness);
                        preparedStatement.setString (3, finish);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			   
			while(resultSet.next())
			{
                            quantity = resultSet.getInt(4);
                            success = quantity+",true";
			}
			preparedStatement.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return success;
	}

        public static boolean insertItem(ItemModel itemObj)
	{
                boolean success = false;
                String design_id = itemObj.getDesign_Id();
                String thickness = itemObj.getThickness();
                String finish = itemObj.getFinish();
                String result = checkExistingItem(design_id, thickness, finish);
                
                String isUpdate[] = result.split(",");
                if(isUpdate[1].equalsIgnoreCase("false"))
                {
                    Connection connection = ConnectDB.openConnection();
                    PreparedStatement preparedStatement;
                    try 
                    {
                        				Calendar calendar = Calendar.getInstance();
			    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

			preparedStatement = connection.prepareStatement("insert into stock_detail"
                                + "(design_id,thickness,finish,quantity,rate,size,modify_stock) "
                                + "values(?,?,?,?,?,?,?)");
			preparedStatement.setString (1, design_id);
                        preparedStatement.setString (2, itemObj.getThickness());
                        preparedStatement.setString (3, itemObj.getFinish());
                        preparedStatement.setInt (4, itemObj.getQuantity());
                        preparedStatement.setDouble (5, itemObj.getRate());
                        preparedStatement.setString (6, itemObj.getSize());
                        preparedStatement.setDate(7, date);
			
			int isInsert = preparedStatement.executeUpdate();
			   
			if(isInsert > 0)
                        {
                            success = true;
                        }
			preparedStatement.close();
                    }
                    catch (SQLException e)
                    {
			e.printStackTrace();
                    }
                }
                else
                {
                    success = updateItem(itemObj,Integer.parseInt(isUpdate[0]));
                }
		return success;
	}
        
        public static boolean updateItem(ItemModel itemObj,int existingquantity)
        {
            boolean success = false;
            Connection connection = ConnectDB.openConnection();
                    PreparedStatement preparedStatement;
                    try 
                    {
                        				Calendar calendar = Calendar.getInstance();
			    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

			preparedStatement = connection.prepareStatement("update stock_detail"
                                + " set quantity = ?, modify_stock=? where design_id = ? and thickness = ? and finish = ?");
			preparedStatement.setInt (1, existingquantity+itemObj.getQuantity());
                        preparedStatement.setDate (2, date);
                        preparedStatement.setString (3, itemObj.getDesign_Id());
                        preparedStatement.setString (4, itemObj.getThickness());
                        preparedStatement.setString (5, itemObj.getFinish());
                  
			int isUpdate = preparedStatement.executeUpdate();
			   
			if(isUpdate > 0)
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
        
        public static int checkItemQuantity(ItemModel itemObj)
        {
            int quantity=-1;
            Connection connection = ConnectDB.openConnection();
                    PreparedStatement preparedStatement;
                    try 
                    {
			preparedStatement = connection.prepareStatement("select * from stock_detail " +
					"where design_id = ? and thickness = ? and finish = ?");
                        preparedStatement.setString (1, itemObj.getDesign_Id());
                        preparedStatement.setString (2, itemObj.getThickness());
                        preparedStatement.setString (3, itemObj.getFinish());
                  
			ResultSet resultset = preparedStatement.executeQuery();
			   
			if(resultset.next())
                        {
                            quantity = resultset.getInt("quantity");
                        }
                        
			preparedStatement.close();
                    }
                    catch (SQLException e)
                    {
			e.printStackTrace();
                    }
                    return quantity;
        }
        
        public static ArrayList<ItemModel> getStock()
        {
            ArrayList<ItemModel> items = new ArrayList<ItemModel>();
            Connection connection = ConnectDB.openConnection();
                 Statement statement;
                    try 
                    {
			statement = connection.createStatement();
                        ResultSet resultset = statement.executeQuery("select * from stock_detail "
                                + "group by design_id,thickness, finish");
			   
			while(resultset.next())
                        {
                          ItemModel item = new ItemModel();
                          item.setDesign_Id(resultset.getString(1));
                          item.setThickness(resultset.getString(2));
                          item.setFinish(resultset.getString(3));
                          item.setQuantity(resultset.getInt(4));
                          
                          items.add(item);
                        }
                        
			statement.close();
                    }
                    catch (SQLException e)
                    {
			e.printStackTrace();
                    }
            
            return items;
        }
        
   public static HashMap getStockStatement()
        {
            ArrayList<ItemModel> items = new ArrayList<ItemModel>();
            HashMap<String, Integer> count = new HashMap<String, Integer>();
            HashMap map = new HashMap();
            Connection connection = ConnectDB.openConnection();
                 Statement statement;
                    try 
                    {
			statement = connection.createStatement();
                        ResultSet resultset = statement.executeQuery("select * from stock_detail "
                                + "group by design_id,thickness, finish, quantity order by design_id");
			   
			while(resultset.next())
                        {
                          ItemModel item = new ItemModel();
                          item.setDesign_Id(resultset.getString(1));
                          item.setThickness(resultset.getString(2));
                          item.setFinish(resultset.getString(3));
                          item.setQuantity(resultset.getInt(4));
                          
                          int countDesignId = checkCountByDesignId(resultset.getString(1));
                          count.put(resultset.getString(1), countDesignId);
                          items.add(item);
                        }
                        
			statement.close();
                    }
                    catch (SQLException e)
                    {
			e.printStackTrace();
                    }
            map.put("count", count);
            map.put("items", items);
            
            return map;
        }
        
        public static int checkCountByDesignId(String design_id)
        {
            int count = 0;
              Connection connection = ConnectDB.openConnection();
                    PreparedStatement preparedStatement;
                    try 
                    {
			preparedStatement = connection.prepareStatement("select count(*) as countDesignId from stock_detail " +
					"where design_id = ?");
                        preparedStatement.setString (1, design_id);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        
                        if(resultSet.next())
                        {
                            count = resultSet.getInt("countDesignId");
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
            return count;
        }
        
        public static int deleteItem(ItemModel item)
        {
            int count = 0;
              Connection connection = ConnectDB.openConnection();
                    PreparedStatement preparedStatement;
                    try 
                    {
                        String success=checkExistingItem(item.getDesign_Id(),item.getThickness(),item.getFinish());
                        String result[] = success.split(",");
                        int quantity = Integer.parseInt(result[0]);
                        if(result[1].equals("true") && quantity == item.getQuantity())
                        {
                                preparedStatement = connection.prepareStatement("delete from stock_detail"
                                        + " where design_id = ? and thickness = ? and finish = ?");
                                preparedStatement.setString (1, item.getDesign_Id());
                                preparedStatement.setString (2, item.getThickness());
                                preparedStatement.setString (3, item.getFinish());
                                int resultSet = preparedStatement.executeUpdate();
                        }
                        else if(result[1].equals("true"))
                        {
                            Calendar calendar = Calendar.getInstance();
			    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

                            preparedStatement = connection.prepareStatement("update stock_detail"
                                + " set quantity = ?, modify_stock=? where design_id = ? and thickness = ? and finish = ?");
                            preparedStatement.setInt (1, quantity - item.getQuantity());
                            preparedStatement.setDate (2, date);
                            preparedStatement.setString (3, item.getDesign_Id());
                            preparedStatement.setString (4, item.getThickness());
                            preparedStatement.setString (5, item.getFinish());
                  
                            int isUpdate = preparedStatement.executeUpdate();
			
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
            return count;
        }
        
        public static ArrayList<ItemModel> FetchItem(int page_no, String DesignId, String Thickness, String Finish, String StartDate,String EndDate)
        {
                Connection connection = ConnectDB.openConnection();
                PreparedStatement preparedStatement,preparedStatement1;
                ArrayList<ItemModel> itemArray = new ArrayList<ItemModel>();   
		try 
		{
                    
                    String Query="select * from stock_detail "
                                + "WHERE design_id like '"+DesignId+"%' and thickness like '"+Thickness+"%'"+
                                    "and finish like '"+Finish+"%'";
		
                    if(!StartDate.equalsIgnoreCase(""))
                    {
                        Query=Query+" and modify_stock >='"+StartDate+"'";
                    }
                    
                     if(!EndDate.equalsIgnoreCase(""))
                    {
                        Query=Query+" and modify_stock <='"+EndDate+"'";
                    }
                     Query = Query + " order by modify_stock desc ";
                     Query=Query+" limit "+ page_no+",5";
                    
                    
                    
                    preparedStatement = connection.prepareStatement(Query);
			
                        
			ResultSet resultSet = preparedStatement.executeQuery();
			
                        while(resultSet.next())
			{
                            ItemModel item = new ItemModel();
                            item.setDesign_Id(resultSet.getString("design_id"));
                            item.setThickness(resultSet.getString("thickness"));
                            item.setFinish(resultSet.getString("finish"));
                            item.setQuantity(resultSet.getInt("quantity"));
                            item.setSize(resultSet.getString("size"));

                            item.setModifyStock(resultSet.getDate("modify_stock"));
                            
                            
                            itemArray.add(item);
			}
			
                        String Query2 = "select count(*) from stock_detail "
                                + "WHERE design_id like '"+DesignId+"%' and thickness like '"+Thickness+"%'"+
                                    "and finish like '"+Finish+"%'";
                        
                        if(!StartDate.equalsIgnoreCase(""))
                        {
                            Query2=Query2+" and modify_stock >='"+StartDate+"'";
                        }
                    
                        if(!EndDate.equalsIgnoreCase(""))
                        {   
                            Query2=Query2+" and modify_stock <='"+EndDate+"'";
                        }
                        preparedStatement1 = connection.prepareStatement(Query2);
                        	ResultSet resultSet1 = preparedStatement1.executeQuery();
                        
                        preparedStatement.close();
                       
                        if(itemArray!=null&&itemArray.size()>0)
                        {
                            resultSet1.next();
                            itemArray.get(0).setRowCount(Integer.parseInt(resultSet1.getString("count(*)")));
                        }
			preparedStatement1.close();


		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
           return itemArray;
       }
        
        public static boolean updateItemDetails(ItemModel itemObj,ItemModel itemObjold)
        {
            boolean success = false;
            Connection connection = ConnectDB.openConnection();
                    PreparedStatement preparedStatement;
                    try 
                    {
                        				Calendar calendar = Calendar.getInstance();
			    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

			preparedStatement = connection.prepareStatement("update stock_detail"
                                + " set design_id =?, thickness=?, finish =?,quantity = ?,size=?, modify_stock=? where design_id = ? and thickness = ? and finish = ? and size =?");
			preparedStatement.setString (1, itemObj.getDesign_Id());
                        preparedStatement.setString (2, itemObj.getThickness());
                        preparedStatement.setString (3, itemObj.getFinish());
                        preparedStatement.setInt (4, itemObj.getQuantity());
                        preparedStatement.setString (5, itemObj.getSize());
                        preparedStatement.setDate (6, date);
                        preparedStatement.setString (7, itemObjold.getDesign_Id());
                        preparedStatement.setString (8, itemObjold.getThickness());
                        preparedStatement.setString (9, itemObjold.getFinish());
                        preparedStatement.setString (10, itemObjold.getSize());
                        
                  
			int isUpdate = preparedStatement.executeUpdate();
			   
			if(isUpdate > 0)
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
        
}
