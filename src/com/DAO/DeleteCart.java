package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Beans.Cart;

public class DeleteCart 
{

	public boolean deleteCart(Cart ct) throws SQLException
	{
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root","Shivanjali@35");
			
			PreparedStatement ps = con.prepareStatement("delete from cart where  CartId= ?");
			ps.setInt(1,ct.getCartId());
			
			int x  = ps.executeUpdate();
			
			if (x>0)
			{
				System.out.println("-----Successfully Log Out from System -----");
				return true;
			}
			else {
			return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
		
		
		
	}

}
