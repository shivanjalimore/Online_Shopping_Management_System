package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Beans.Products;

public class SearchParticularProduct
{
	public static List<Products> datafetch(Products ps) throws SQLException 
	{
		 ArrayList arr= new ArrayList();
		 try
		 {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root","Shivanjali@35");
		 PreparedStatement stmt=con.prepareStatement("SELECT * from products where productID = ? ; ");
	     
	     stmt.setInt(1,ps.getProductID());
	     
	     ResultSet rs = stmt.executeQuery();
	     
	     while(rs.next())
		 {
			  arr.add(rs.getInt(1));
			  arr.add(rs.getString(2));
			  arr.add(rs.getString(3));	 
			  arr.add(rs.getInt(4));	 
			  arr.add(rs.getInt(5));	 
		 }
	     
	 	return arr;	
		 }
		 catch (ClassNotFoundException e) {
	    		e.printStackTrace();
	    	}
		return null;
		 
	}

	
}
