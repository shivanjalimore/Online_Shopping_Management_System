package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Beans.Products;

public class RemoveProduct {

	public void removeproduct(Products p) throws SQLException {
		// TODO Auto-generated method stub

        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop", "root", "Shivanjali@35");
		        PreparedStatement ps1=con.prepareStatement("delete from products where  productID = ?");
		        ps1.setInt(1,p.getProductID());
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
