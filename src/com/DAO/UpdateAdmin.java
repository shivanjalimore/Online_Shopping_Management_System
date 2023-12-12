package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Beans.AdminInfo;
import com.Beans.LoginInfo;

public class UpdateAdmin {

	public void editAdmin(AdminInfo ai) throws SQLException 
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root","Shivanjali@35");

			int x=0;
			if(ai.getFc()==1)
			{
				PreparedStatement ps;
				if(ai.getS().equalsIgnoreCase("Name"))
				{
					ps=con.prepareStatement("update admininfo set Name = ? where AdminID=? ");
					ps.setString(1,ai.getName());
					ps.setInt(2,ai.getAdminId());
					 x = ps.executeUpdate();

				}
				else if(ai.getS().equalsIgnoreCase("Age"))
				{
					ps=con.prepareStatement("update admininfo set Age = ? where AdminID=?");
					ps.setInt(1,ai.getAge());
					ps.setInt(2,ai.getAdminId());
					x = ps.executeUpdate();
				}
				else if(ai.getS().equalsIgnoreCase("Email"))
				{
					ps=con.prepareStatement("update admininfo set Email = ? where AdminID=?");
					ps.setString(1,ai.getEmail());
					ps.setInt(2,ai.getAdminId());
					x=ps.executeUpdate();
				}
				else if(ai.getS().equalsIgnoreCase("Address"))
				{
					ps=con.prepareStatement("update admininfo set Address = ? where AdminID=?");
					ps.setString(1,ai.getAddress());
					ps.setInt(2,ai.getAdminId());
					x=ps.executeUpdate();
					
				}
				else if(ai.getS().equalsIgnoreCase("ContactNumber"))
				{
					ps=con.prepareStatement("update admininfo set ContactNumber = ? where AdminID=?");
					ps.setString(1,ai.getContactNumber());
					ps.setInt(2,ai.getAdminId());
					x=ps.executeUpdate();
				}
				if(x!=0)
					System.out.println("INFORMATION UPDATED SUCCESSFULLY !");
			}
				
				else if(ai.getFc()==0)
				{
					PreparedStatement ps1=con.prepareStatement("update logininfo set password=? where userID=?");
					ps1.setString(1,ai.getPassword());
					ps1.setInt(2,ai.getAdminId());
					x=ps1.executeUpdate();
					if(x!=0)
						System.out.println("PASSWORD CHANGED SUCCESSFULLY !");
				}
		}
			
			catch (ClassNotFoundException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	 
	}	

