package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Beans.Cart;

public class DeleteProduct {

	public void deletefromcart(Cart ct) throws SQLException {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop", "root", "Shivanjali@35");
		        PreparedStatement ps1=con.prepareStatement("delete from cart where  productID = ? AND  CartId =? ");
		        ps1.setInt(1,ct.getProductID());
		        ps1.setInt(2,ct.getCartId());
		        int x=ps1.executeUpdate();
		        
		    	if(x!=0)
					System.out.println("PRODUCT DELETED SUCCESSFULLY !");
				else
					System.out.println("PRODUCT NOT FOUND !");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
	}

}
