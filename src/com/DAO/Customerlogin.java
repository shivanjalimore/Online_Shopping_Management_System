package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Beans.CustInfo;
import com.Beans.LoginInfo;

public class Customerlogin
{

	public boolean Customercheck(LoginInfo li2, CustInfo cinfo) throws SQLException 
	{
		// TODO Auto-generated method stub
		 try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop", "root", "Shivanjali@35");

		        PreparedStatement userIdCheckStmt = con.prepareStatement("select c.CustId,c.`Name` \r\n"
		        		+ "from custinfo c JOIN logininfo l\r\n"
		        		+ "ON c.CustId = l.userID\r\n"
		        		+ "WHERE userID=?;");
		        userIdCheckStmt.setInt(1,li2.getUserID());

		        ResultSet userIdCheckResult = userIdCheckStmt.executeQuery();
		        
		        
		        PreparedStatement passwordCheckStmt = con.prepareStatement("select c.CustId,c.`Name` \r\n"
		        		+ "from custinfo c JOIN logininfo l\r\n"
		        		+ "ON c.CustId = l.userID\r\n"
		        		+ "WHERE password=?;");
		        passwordCheckStmt.setString(1, li2.getPassword());

		        ResultSet passwordCheckResult = passwordCheckStmt.executeQuery();
		        
		        // Check if there are any results
		        if (userIdCheckResult.next()) {
		            if (passwordCheckResult.next()) {
			            String Name = passwordCheckResult.getString("Name");
			            int CID = userIdCheckResult.getInt("CustId");
			            cinfo.setName(Name);
			            li2.setCuserId(CID);
//			            System.out.println("******* CuserId : "+li2.getCuserId());
			            
			            System.out.println("      Login Successful     ");
				        System.out.println("--------------------------WELCOME-------------------------");
				        System.out.println("  " +cinfo.getName() );
				        return true;
		        }
		            else {
			            System.out.println("Password is not matching");
			            return false;
			        }
		        }
		        else {
		            System.out.println("User ID is not matching");
		            return false;
		        }

		    }
		      catch (ClassNotFoundException e) 
		      {
		        e.printStackTrace();
		      }
		 return false;
		}
}
		
		
