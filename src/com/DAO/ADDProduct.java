package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.Beans.Products;

public class ADDProduct {

	public void AddProduct(Products pr) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root","Shivanjali@35");
			PreparedStatement ps=con.prepareStatement("insert into products(productID,Name,Type,Quantity,Price) values(?,?,?,?,?)");
			ps.setInt(1,pr.getProductID());
			ps.setString(2,pr.getName());
			ps.setString(3,pr.getType());
			ps.setInt(4,pr.getQuantity());
			System.out.println(pr.getQuantity());
			ps.setFloat(5,pr.getPrice());
			
			int x=ps.executeUpdate();
			
			if(x>0 )
				System.out.println(" SUCCESSFULLY ADDED PRODUCT !\n");
			else
				System.out.println(" UNSUCCESSFULL TO ADD PRODUCT !\n");
			}
		
			catch(Exception e)
			{
				System.out.println(e);
			}
			
	}

}
