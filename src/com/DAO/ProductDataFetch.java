package com.DAO;
import java.beans.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Beans.CustInfo;
import com.Beans.Products;

public class ProductDataFetch
{
	 public static List<Products> datafetch() throws SQLException
 {
	        ArrayList arr= new ArrayList();
	       
	        try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root","Shivanjali@35");
	    	     Statement stmt = con.createStatement();
	    		 
	    		 ResultSet rs = stmt.executeQuery( "SELECT * from products ; ");
	    		 
	    		 while(rs.next())
	    		 {
	    			  arr.add(rs.getInt(1));
	    			  arr.add(rs.getString(2));
	    			  arr.add(rs.getString(3));	 
	    			  arr.add(rs.getInt(4));	 
	    			  arr.add(rs.getInt(5));	 
	    		 }
	    		  
//	    		   System.out.println(arr);
	    			return arr;	
//	    		 
	    	} catch (ClassNotFoundException e) {
	    		e.printStackTrace();
	    	}
	    	return null;
	    	
	    	}
} 
