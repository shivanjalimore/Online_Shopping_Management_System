package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Beans.Cart;

public class AddToCart
{

	public void addtocart(Cart ct) throws SQLException
	{
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop", "root", "Shivanjali@35");
			 
//			 int id ;
//			 PreparedStatement ps1 = con.prepareStatement(" ");
		        
				PreparedStatement ps=con.prepareStatement("insert into cart( CartId, productID,Quantity,Price) values(?,?,?,?)");
	            ps.setInt(1,ct.getCartId());
	            ps.setInt(2,ct.getProductID());
	            ps.setInt(3,ct.getQuantity());
	            ps.setFloat(4, ct.getPrice());
	            
	    		int x=ps.executeUpdate();
	    		if(x>0)
	    			System.out.println(" SUCCESSFULLY ADDED TO CART  !\n");
	    		else
	    			System.out.println(" FAILED TO ADD TO CART !\n");
	    		
		     }
			
		 catch (ClassNotFoundException e)
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 
	}
}
	       
	


