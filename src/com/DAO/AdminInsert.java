package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.Beans.*;

public class AdminInsert 
{

	public void AdminPrint(AdminInfo ainfo,LoginInfo linfo)
	{

		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root","Shivanjali@35");

		PreparedStatement ps=con.prepareStatement("insert into adminInfo(AdminID,Name,Age,Email,Address,ContactNumber) values(?,?,?,?,?,?)");
		PreparedStatement ps1=con.prepareStatement("insert into loginInfo(userID,password,userType) values(?,?,?)");
		ps.setInt(1,ainfo.getAdminId());
		ps.setString(2,ainfo.getName());
		ps.setInt(3,ainfo.getAge());
		ps.setString(4,ainfo.getEmail());
		ps.setString(5,ainfo.getAddress());
		ps.setString(6,ainfo.getContactNumber());
		
		ps1.setInt(1,linfo.getUserID());
		ps1.setString(2,linfo.getPassword());
		ps1.setString(3, Character.toString('A'));
		int x=ps.executeUpdate();
		int y=ps1.executeUpdate();
		if(x>0 && y>0)
			System.out.println("REGISTRATION DONE SUCCESSFULLY !\n");
		else
			System.out.println("REGISTRATION FAILED !\n");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}


		
	}
 

