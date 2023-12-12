package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.Beans.*;

public class CustInsert {

	public void CustomerInsert(CustInfo cinfo,LoginInfo linfo1, Cart cart)
	{
		// TODO Auto-generated method stub
	 
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root","Shivanjali@35");

		PreparedStatement ps=con.prepareStatement("insert into custInfo(CustID,Name,Age,Email,Address,ContactNumber) values(?,?,?,?,?,?)");
		PreparedStatement ps1=con.prepareStatement("insert into loginInfo(userID,password,userType) values(?,?,?)");
		ps.setInt(1,cinfo.getCustId());
		ps.setString(2,cinfo.getName());
		ps.setInt(3,cinfo.getAge());
		ps.setString(4,cinfo.getEmail());
		ps.setString(5,cinfo.getAddress());
		ps.setString(6,cinfo.getContactNumber());
		
		
		ps1.setInt(1,linfo1.getUserID());
		ps1.setString(2,linfo1.getPassword());
		ps1.setString(3, Character.toString('C'));
		
		
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
