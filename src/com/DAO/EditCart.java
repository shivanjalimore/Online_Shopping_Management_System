package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Beans.Cart;

public class EditCart {

	public void editcart(Cart ct) throws SQLException
	{
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop", "root", "Shivanjali@35");
		        int x=0;
				PreparedStatement ps;
				
			    if(ct.getS().equalsIgnoreCase("quantity"))
				{
					ps=con.prepareStatement("update Cart set Quantity = ? where  productID =? AND CartId =? ");
					ps.setInt(1,ct.getQuantity());
					ps.setInt(2,ct.getProductID());
					ps.setInt(3,ct.getCartId());
					 x = ps.executeUpdate();
				}
				else if(ct.getS().equalsIgnoreCase("price"))
				{
					ps=con.prepareStatement("update products set Price = ? where  productID =? AND CartId = ? ");
					ps.setFloat(1,ct.getPrice());
					ps.setInt(2,ct.getProductID());
					ps.setInt(3,ct.getCartId());
					 x = ps.executeUpdate();
				}
			    if(x!=0)
					System.out.println("CART EDITED SUCCESSFULLY !");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

}
