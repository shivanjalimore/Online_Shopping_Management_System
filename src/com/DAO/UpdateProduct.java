package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Beans.Products;

public class UpdateProduct 
{

	public void editProduct(Products pp) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root","Shivanjali@35");
			int x=0;
			PreparedStatement ps;
			if(pp.getS().equalsIgnoreCase("name"))
			{
				ps=con.prepareStatement("update products set Name = ? where  productID =? ");
				ps.setString(1,pp.getName());
				ps.setInt(2,pp.getProductID());
				 x = ps.executeUpdate();
			}
			
			else if(pp.getS().equalsIgnoreCase("type"))
			{
				ps=con.prepareStatement("update products set Type  = ? where  productID =? ");
				ps.setString(1,pp.getType());
				ps.setInt(2,pp.getProductID());
				 x = ps.executeUpdate();
			}
			else if(pp.getS().equalsIgnoreCase("quantity"))
			{
				ps=con.prepareStatement("update products set Quantity = ? where  productID =? ");
				ps.setInt(1,pp.getQuantity());
				ps.setInt(2,pp.getProductID());
				 x = ps.executeUpdate();
			}
			else if(pp.getS().equalsIgnoreCase("price"))
			{
				ps=con.prepareStatement("update products set Price = ? where  productID =? ");
				ps.setFloat(1,pp.getPrice());
				ps.setInt(2,pp.getProductID());
				 x = ps.executeUpdate();
			}
			if(x!=0)
				System.out.println("INFORMATION UPDATED SUCCESSFULLY !");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
  
}
