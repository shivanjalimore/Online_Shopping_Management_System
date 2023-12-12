package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Beans.*;

public class GenerateBill 
{
	 public static List<Cart> generateBill(Bills bi) throws SQLException
	 {
		        ArrayList arr= new ArrayList();
		       
		        try {
		    		Class.forName("com.mysql.cj.jdbc.Driver");
		    		 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root","Shivanjali@35");
		    	    
		    	     PreparedStatement ps = con.prepareStatement("SELECT c.Name, SUM(t.Price) AS TotalPrice FROM custinfo c JOIN cart t ON c.CustId = t.CartId GROUP BY c.Name;");
		    	     ResultSet rs = ps.executeQuery();
		    	     
		    		 while(rs.next())
		    		 {
		    			  arr.add(rs.getString(1));
		    			  arr.add(rs.getFloat(2));	 
		    		 }
		    		  
//		    		   System.out.println(arr);
		    			return arr;	
//		    		 
		    	} catch (ClassNotFoundException e) {
		    		e.printStackTrace();
		    	}
		    	return null;
		    	
		    	}
}
