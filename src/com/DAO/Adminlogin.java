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

public class Adminlogin {

	public boolean Admincheck(LoginInfo li2,AdminInfo ainfo) throws SQLException {
		 try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop", "root", "Shivanjali@35");

		        PreparedStatement userIdCheckStmt = con.prepareStatement("select a.AdminId , a.`Name` \r\n"
		        		+ "from admininfo a JOIN logininfo l\r\n"
		        		+ "ON a.AdminId = l.userID\r\n"
		        		+ "WHERE userID=?;");
		        userIdCheckStmt.setInt(1,li2.getUserID());

		        ResultSet userIdCheckResult = userIdCheckStmt.executeQuery();
		        
		        PreparedStatement passwordCheckStmt = con.prepareStatement("select a.`Name` \r\n"
		        		+ "from admininfo a JOIN logininfo l\r\n"
		        		+ "ON a.AdminId = l.userID\r\n"
		        		+ "WHERE password=?;");
		        passwordCheckStmt.setString(1, li2.getPassword());

		        ResultSet passwordCheckResult = passwordCheckStmt.executeQuery();
		        
		        
		        // Check if there are any results
		        if (userIdCheckResult.next()) {
		            if (passwordCheckResult.next()) {
			            String Name = passwordCheckResult.getString("Name");
			            int ADId = userIdCheckResult.getInt("AdminId");
			            ainfo.setName(Name);
			            li2.setADuserId2(ADId);
			           
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

		       
		        // Check if there are any results
		       

		        // Both email and password are matching
		       

		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    }
		return false;
		}	
		
	}


