package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Beans.CustInfo;

public class RemoveCustomer 
{
  public void removeCustomer(CustInfo cinfo1)
  {
	  try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop", "root", "Shivanjali@35");
//	        PreparedStatement ps=con.prepareStatement("select * from custinfo");
//			ResultSet rs=ps.executeQuery();
//			//*******
//			//for counting the number of rows in result set
//			int x = 0,y;
//			if(rs.last()) {
//				x=rs.getRow();
//				rs.beforeFirst();
//			}
//			//*******
//			if(x==0)
//				System.out.println("NO CUSTOMERS AVAIALABLE");
//			else
//			{		
				PreparedStatement ps1=con.prepareStatement("delete from custinfo where custID=?");
				PreparedStatement ps2=con.prepareStatement("delete from logininfo where userID=?");
				ps1.setInt(1,cinfo1.getCustId());
				ps2.setInt(1,cinfo1.getCustId());
				
				int x=ps1.executeUpdate();
				int y=ps2.executeUpdate();
				System.out.println(x);
				System.out.println(x);
				
				if(x!=0 && y!=0)
					System.out.println("CUSTOMER INFO DELETED SUCCESSFULLY !");
				else
					System.out.println("CUSTOMER INFO NOT FOUND !");
				
//			}
			
	  }
	  catch(Exception e)
		{
			System.out.println(e);
		}
	}

  }

