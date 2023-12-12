package com.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.Beans.*;
import com.DAO.*;

public class OSMS {

	LoginInfo li2 = new LoginInfo();
	
	static int AdminId, UserId,CustId;
	
	
	public static void main(String[] args) throws SQLException 
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("WELCOME TO ONLINE SHOPPING SYSTEM\n");
		int ch;
		do
		{
			System.out.println("*****************************************************\n");
			System.out.println("1 - REGISTER AS ADMIN");
			System.out.println("2 - REGISTER AS CUSTOMER");
			System.out.println("3 - LOGIN TO SYSTEM");
			System.out.println("4 - EXIT");
			System.out.println("*****************************************************\n");
			System.out.print("Enter choice : ");
			ch=sc.nextInt();
			if(ch==1)
				registerAdmin();
			else if(ch==2)
				registerCustomer();
			else if(ch==3)
				loginSystem();
			else if(ch==4)
				System.out.println("Thank you");
			else
				System.out.println("Wrong choice");
		}while(ch!=4);
	
	}
	private static void loginSystem() throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int c;
		System.out.println("\nWELCOME TO LOGIN PAGE\n");
		System.out.println("*****************************************************\n");
		System.out.println("Choose Login as a Admin or Customer : ");
		System.out.println("1 - Login AS ADMIN");
		System.out.println("2 - Login AS CUSTOMER");
		System.out.println("*****************************************************\n");
		System.out.print("Enter choice : ");
		c=sc.nextInt();
		if(c==1)
			loginAdmin();
		else if(c==2)
			loginCustomer();
	}
		
	private static void loginCustomer() throws SQLException 
	{
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner( System.in);
		System.out.println("Enter Customer ID : ");
		int UserId=sc.nextInt();
		
		System.out.println("Enter Customer Password : ");
		String Password=sc.next();
		
		LoginInfo li2= new LoginInfo();
		  li2.setUserID(UserId);
		  li2.setPassword(Password);
		 
		  
		  CustInfo cinfo = new CustInfo();
		  
		 Customerlogin ac = new Customerlogin();	 
	
//		 System.out.println("Customer id : "+CustId);
		   boolean loginstatus = ac.Customercheck(li2,cinfo);
		   CustId=li2.getCuserId();
		   ac.Customercheck(li2,cinfo);
		   if(loginstatus==true) {
			   cart();
		   }else {
			   registerCustomer();
		   }
		   
	}

	private static void cart() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nWELCOME TO CART MANAGEMENT PAGE\n");
		int ch = 0;
	        do {
			System.out.println("*****************************************************\n");
			System.out.println("1 - VIEW ALL PRODUCTS");//completed
			System.out.println("2 - ADD PRODUCTS TO YOUR CART");//completed
			System.out.println("3 - DELETE PRODUCT FROM CART");//completed
			System.out.println("4 - EDIT CART");//completed
			System.out.println("5 - BILL");//completed
			System.out.println("6 - Log Out ");
			System.out.println("*****************************************************\n");
			System.out.print("Enter choice : ");
			ch=sc.nextInt();
			
			if(ch==1)
				viewProducts();
			else if(ch==2)
				addtocart();
			else if(ch==3)
				deletefromcart();
			else if(ch==4)
				editcart();
			else if(ch==5)
				createbill();
			else if(ch==6)
				logout();
			else
				System.out.println("Wrong choice ");
	        }while(ch!=6);
	}
	private static void logout() throws SQLException 
	{
		Scanner sc = new Scanner(System.in);
		Cart ct = new Cart();
		ct.setCartId(CustId);
		
		DeleteCart DC = new DeleteCart();
		DC.deleteCart(ct);
		  boolean loginstatus = DC.deleteCart(ct);
		   DC.deleteCart(ct);
		   
		   if(loginstatus==true) {
			   loginSystem();
		   }else {
			  
		   }	   
		
	}
	private static void createbill() throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("----- Generating Your Final Bill -----");
		
		Bills bi = new Bills();
		bi.setBillID(CustId);
		GenerateBill GB = new GenerateBill();
		
		GB.generateBill(bi);
		
//		 CustomerDataFetch employeeDataFetch = new CustomerDataFetch();
		
	        List<Cart> arr = GenerateBill.generateBill(bi);
	        System.out.println("--------------------------- Customer Data ---------------------------");
	        int i=0;
	            System.out.println("Customer Name  : " + arr.get(i));
	            System.out.println("Total Amount : " + arr.get(i + 1));
//	            System.out.println("Age : " + arr.get(i + 2));
//	            System.out.println("Email : " + arr.get(i + 3));
//	            System.out.println("Address : " + arr.get(i + 4));
//	            System.out.println("Conatact Number : " + arr.get(i + 5));
	            System.out.println("-----------------------------------------------------------------------");
	        
		
		
	
	}
	private static void editcart() throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Product ID to edit  : ");
		int id = sc.nextInt();
		Cart ct = new Cart();
		ct.setCartId(CustId);
		ct.setProductID(id);
		
		int ch=0,quantity=0;
		Float price;
		String s=" ";
		do
		{
			System.out.println("************************************************************");
			
			System.out.println("1 - EDIT Quantity");
			System.out.println("2 - EDIT Price");
			System.out.println("3 - EXIT");
			System.out.println("************************************************************");
			System.out.print("Enter choice : ");
			ch=sc.nextInt();
			
			if(ch==1)
			{
				System.out.print("ENTER NEW Product Quantity  : ");
				quantity=sc.nextInt();
				s="quantity";
				   ct.setQuantity(quantity);
				   ct.setS(s);	
				   EditCart EC = new EditCart();
				   EC.editcart(ct);
				  
			}
			else if(ch==2)
			{
				System.out.print("ENTER NEW PRODUCT Price  : ");
				price=sc.nextFloat();
				s="price";
				ct.setPrice(price);
				ct.setS(s);
				 EditCart EC = new EditCart();
				   EC.editcart(ct);
				
			}
			else if(ch==3)
				System.out.println("Thank you");
			else
				System.out.println("Wrong choice");
		}while(ch!=3);
		
	}
	private static void deletefromcart() throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		System.out.println("------------ DELETE PRODUCT ---------- ");
		System.out.println("Enter Product ID : ");
		int id =sc.nextInt();
		
		Cart ct = new Cart();
		ct.setCartId(CustId);
		ct.setProductID(id);
		
		DeleteProduct DP = new DeleteProduct();
		DP.deletefromcart(ct);
		
		
		
	}
	private static void addtocart() throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		LoginInfo li2 = new LoginInfo();
		
		CustInfo ci1 = new CustInfo();
//		ci1.setCustId(CustId);
		
		System.out.println("Customer ID : "+CustId);
	
		System.out.println("ENTER PRODUCT ID : ");
		int pid = sc.nextInt();
		
		System.out.println("ENTER Quantity : ");
		int quantity = sc.nextInt();
		
		System.out.println("ENTER PRICE : ");
		int price = sc.nextInt();
		
		Cart ct = new Cart();
		ct.setCartId(CustId);
		ct.setProductID(pid);
		ct.setQuantity(quantity);
		ct.setPrice(price);
		
		AddToCart ATC = new AddToCart();
		ATC.addtocart(ct);
		
	}
	private static void productinfo() throws SQLException 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nWELCOME TO PRODUCTS MANAGEMENT PAGE\n");
		int ch = 0;
	        do {
			System.out.println("*****************************************************\n");
			System.out.println("1 - ADD PRODUCTS");//completed
			System.out.println("2 - REMOVE PRODUCTS");//completed
			System.out.println("3 - UPDATE PRODUCT INFO");//completed
			System.out.println("4 - VIEW ALL PRODUCTS");//completed
			System.out.println("5 - SEARCH A PARTICULAR PRODUCT");//completed
			System.out.println("6 - EXIT PAGE");
			System.out.println("*****************************************************\n");
			System.out.print("Enter choice : ");
			ch = sc.nextInt();
			switch (ch) {
			    case 1:
			        addProducts();
			        break;
			    case 2:
			        removeProducts();
			        break;
			    case 3:
			        updateProduct();
			        break;
			    case 4:
			        viewProducts();
			        break;
			    case 5:
			        searchProduct();
			        break;
			    case 6:
			        System.out.println("Thank you");
			        break;
			    default:
			        System.out.println("Wrong choice");
			}

	        }while(ch!=6);
		
	}
	private static void searchProduct() throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter product ID to search : ");
		int id = sc.nextInt();
		
		Products ps = new Products();
		ps.setProductID(id);
		
		SearchParticularProduct spp = new SearchParticularProduct();
		spp.datafetch(ps);
		
		SearchParticularProduct spp1 = new SearchParticularProduct();
        List<Products> arr = spp1.datafetch(ps);
        
        int i=0;
            System.out.println("Product ID: " + arr.get(i));
            System.out.println("Product Name: " + arr.get(i + 1));
            System.out.println("Product Type: " + arr.get(i + 2));
            System.out.println("Product Quantity: " + arr.get(i + 3));
            System.out.println("Product Price: " + arr.get(i + 4));
            System.out.println("-----------------------------------------------------------------------");
    
	}
	private static void viewProducts() throws SQLException {
		
		 ProductDataFetch productDataFetch = new ProductDataFetch();
	        List<Products> arr = ProductDataFetch.datafetch();

	        for (int i = 0; i < arr.size(); i=i+5) {
	            System.out.println("Product ID: " + arr.get(i));
	            System.out.println("Product Name: " + arr.get(i + 1));
	            System.out.println("Product Type: " + arr.get(i + 2));
	            System.out.println("Product Quantity: " + arr.get(i + 3));
	            System.out.println("Product Price: " + arr.get(i + 4));
	            System.out.println("-----------------------------------------------------------------------");
	        }
		
	}
	private static void updateProduct() throws SQLException {
		Scanner sc = new Scanner(System.in);
		 String s="";
			String name="",type="";
			int id=0,quantity=0,price=0;
			int ch=0;
			System.out.println("Enter product ID to update the infomation  :");
			id=sc.nextInt();
			Products pp=new Products();
			pp.setProductID(id);
		do
		{
			System.out.println("************************************************************");
			
			System.out.println("1 - EDIT Name");
			System.out.println("2 - EDIT Type");
			System.out.println("3 - EDIT Quantity");
			System.out.println("4 - EDIT Price");
			System.out.println("5 - EXIT");
			System.out.println("************************************************************");
			System.out.print("Enter choice : ");
			ch=sc.nextInt();
			
			if(ch==1)
			{
				System.out.print("ENTER NEW Product Name : ");
				name=sc.next();
				s="name";
				   pp.setName(name);
				   pp.setS(s);	
				   UpdateProduct up = new UpdateProduct();
				   up.editProduct(pp);
				  
			}
			else if(ch==2)
			{
				System.out.print("ENTER NEW PRODUCT TYPE  : ");
				type=sc.next();
				s="type";
				pp.setType(type);
				pp.setS(s);
				UpdateProduct up = new UpdateProduct();
				   up.editProduct(pp);
				
			}
			else if(ch==3)
			{
				System.out.print("ENTER NEW Quantity : ");
				quantity=sc.nextInt();
				s="quantity";
			    pp.setQuantity(quantity);
			    pp.setS(s);
			    UpdateProduct up = new UpdateProduct();
				   up.editProduct(pp);
			    
			}
			else if(ch==4)
			{
				System.out.print("ENTER NEW PRICE : ");
				price=sc.nextInt();
				s="price";
				pp.setPrice(price);
				pp.setS(s);
				   UpdateProduct up = new UpdateProduct();
				   up.editProduct(pp);
				
			}
			
			else if(ch==5)
			{
				System.out.println("Thank you");
				break;
			}
			else
				System.out.println("Wrong choice");
		}
			while(ch!=5);
	
		
	}
	private static void removeProducts() throws SQLException {
        Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Product ID to delete the product  : ");
		int  productID=sc.nextInt();
		
		Products p = new Products();
		p.setProductID(productID);
		
		RemoveProduct rp = new RemoveProduct();
		rp.removeproduct(p);
		
	}
	private static void addProducts()
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Product ID : ");
		int  productID=sc.nextInt();
		System.out.println("Enter Product Name : ");
		String Name = sc.next();
		System.out.println("Enter Product Type : ");
		String Type = sc.next();
		System.out.println("Enter Product Quantity : ");
		int Quantity = sc.nextInt();
		System.out.println("Enter Product price : ");
		int price = sc.nextInt();
        
		Products pr = new Products();
		pr.setProductID(productID);
		pr.setName(Name);
		pr.setType(Type);
		pr.setQuantity(Quantity);
		pr.setPrice(price);
		
		ADDProduct ADDP = new ADDProduct();
		ADDP.AddProduct(pr);
	}
	private static void loginAdmin() throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner( System.in);
		System.out.println("Enter Admin ID : ");
		 UserId=sc.nextInt();
		
		System.out.println("Enter Admin Password : ");
		String Password=sc.next();
		
		LoginInfo li2= new LoginInfo();
		  li2.setUserID(UserId);
		  li2.setPassword(Password);
		  
		  AdminInfo ainfo = new AdminInfo();
		  
		 Adminlogin ac = new Adminlogin();
		  boolean loginstatus = ac.Admincheck(li2,ainfo);
		  AdminId=li2.getADuserId2();
//		  System.out.println("Admin ID in controller = "+AdminId);
		   ac.Admincheck(li2,ainfo);
		   
		   if(loginstatus==true) {
	            System.out.println("Login Successful");
		        System.out.println("    WELCOME  "+ainfo.getName());
			   adminpage();
		   }else {
			   registerAdmin();
		   }
		   
		
		
	}

	private static void adminpage() throws SQLException
	{
		
	    Scanner sc = new Scanner(System.in);
		System.out.println("WELCOME TO ADMIN SECTION\n");
		int ch;
		do
		{
			System.out.println("*****************************************************\n");
			System.out.println("1 - MANAGE PRODUCTS");//completed
			System.out.println("2 - ADD CUSTOMERS");//completed
			System.out.println("3 - REMOVE CUSTOMERS");//completed
			System.out.println("4 - EDIT PROFILE");//completed
			System.out.println("5 - VIEW REGISTERED CUSTOMERS");//completed
			System.out.println("6 - LOGOUT FROM SYSTEM");
			System.out.println("*****************************************************\n");
			System.out.print("Enter choice : ");
			ch=sc.nextInt();
			if(ch==1)
			{
				
				productinfo();
			}
			else if(ch==2)
			{
				registerCustomer();
			}
			else if(ch==3)
			{
				removeCustomer();
			}
			else if(ch==4)
			{
				editProfile();
			}
			else if(ch==5)
			{
				viewCustomers();
			}
			else if(ch==6)
				System.out.println("Thank you");
			else
				System.out.println("Wrong choice");
		}while(ch!=6);
		
		
	}
	private static void viewCustomers() throws SQLException {
	
		 CustomerDataFetch employeeDataFetch = new CustomerDataFetch();
	        List<CustInfo> arr = CustomerDataFetch.datafetch();
	        System.out.println("--------------------------- Customer Data ---------------------------");
	        for (int i = 0; i < arr.size(); i=i+6) {
	            System.out.println("Customer ID : " + arr.get(i));
	            System.out.println("Customer Name : " + arr.get(i + 1));
	            System.out.println("Age : " + arr.get(i + 2));
	            System.out.println("Email : " + arr.get(i + 3));
	            System.out.println("Address : " + arr.get(i + 4));
	            System.out.println("Conatact Number : " + arr.get(i + 5));
	            System.out.println("-----------------------------------------------------------------------");
	        }
		
	}
	private static void editProfile() throws SQLException
	{
		 Scanner sc=new Scanner(System.in);
		 String s="";
			int fc=0;
			String name="",email="",addr="",contact="",passw="";
			int age=0;
			int ch=0;
		do
		{
			System.out.println("************************************************************");
			System.out.println("1 - EDIT NAME");
			System.out.println("2 - EDIT AGE");
			System.out.println("3 - EDIT EMAIL ID");
			System.out.println("4 - EDIT ADDRESS");
			System.out.println("5 - EDIT CONTACT NUMBER");
			System.out.println("6 - CHANGE PASSWORD");
			System.out.println("7 - EXIT");
			System.out.println("************************************************************");
			System.out.print("Enter choice : ");
			ch=sc.nextInt();
			AdminInfo ai=new AdminInfo();
//			LoginInfo li = new LoginInfo();
			if(ch==1)
			{
				System.out.print("ENTER NEW NAME : ");
				name=sc.next();
				s="Name";
				fc=1;
				ai.setAdminId(AdminId);
				ai.setName(name);
				  ai.setFc(fc);
				    ai.setS(s);
//				    System.out.println("User Id : "+ UserId);
				    System.out.print("Admin Id : " +ai.getAdminId());
				    UpdateAdmin ua = new UpdateAdmin();
				    
				    
					ua.editAdmin(ai);
			}
			else if(ch==2)
			{
				System.out.print("ENTER AGE : ");
				age=sc.nextInt();
				s="Age";
				fc=1;
				ai.setAdminId(AdminId);
				ai.setAge(age);
				  ai.setFc(fc);
				    ai.setS(s);
				   
				    UpdateAdmin ua = new UpdateAdmin();
					ua.editAdmin(ai);
			}
			else if(ch==3)
			{
				System.out.print("ENTER NEW EMAIL ID : ");
				email=sc.next();
				s="Email";
				fc=1;
				ai.setAdminId(AdminId);
				ai.setEmail(email);
				  ai.setFc(fc);
				    ai.setS(s);
				    
				    UpdateAdmin ua = new UpdateAdmin();
					ua.editAdmin(ai);
			}
			else if(ch==4)
			{
				System.out.print("ENTER ADDRESS : ");
				addr=sc.next();
				s="Address";
				fc=1;
				ai.setAdminId(AdminId);
				ai.setAddress(addr);
				  ai.setFc(fc);
				    ai.setS(s);
				    UpdateAdmin ua = new UpdateAdmin();
					ua.editAdmin(ai);
			}
			else if(ch==5)
			{
				System.out.print("ENTER NEW CONTACT NUMBER : ");
				contact=sc.next();
				s="ContactNumber";
				fc=1;
				ai.setAdminId(AdminId);
				ai.setContactNumber(contact);
				  ai.setFc(fc);
				    ai.setS(s);
				    UpdateAdmin ua = new UpdateAdmin();
					ua.editAdmin(ai);
			}
			else if(ch==6)
			{
				System.out.print("ENTER NEW PASSWORD : ");
				passw=sc.next();
				s="password";
				fc=0;
				ai.setAdminId(AdminId);
				ai.setPassword(passw);
				  ai.setFc(fc);
				    ai.setS(s);
				    UpdateAdmin ua = new UpdateAdmin();
					ua.editAdmin(ai);
			}
			else if(ch==7)
			{
				System.out.println("Thank you");
				break;
			}
			else
				System.out.println("Wrong choice");
		}
			while(ch!=7);
	
		
		
		
	}
	private static void removeCustomer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Cutomer ID : ");
		int CustId=sc.nextInt(); 
		
		CustInfo cinfo1=new CustInfo();
		cinfo1.setCustId(CustId);
        
        RemoveCustomer rs=new RemoveCustomer();
       
			rs.removeCustomer(cinfo1);
		
	}
	private static void registerCustomer()
	{
		Scanner sc = new Scanner(System.in);
		String pass,name,num,addr,email;
		int age,custId;
		System.out.println("\nWELCOME TO CUSTOMER REGISTRATION PAGE\n");
		System.out.println("*****************************************************\n");
//		setCUID();
		System.out.println("CUSTOMER ID = ");
		custId = sc.nextInt();
		System.out.print("Enter password = ");
		pass=sc.next();
		System.out.print("Enter Name = ");
		name=sc.next();
		System.out.print("Enter age = ");
		age=sc.nextInt();
		System.out.print("Enter contact number = ");
		num=sc.next();
		System.out.print("Enter address = ");
		addr=sc.next();
		System.out.print("Enter email = ");
		email=sc.next();
		
		CustInfo cinfo = new CustInfo();
		cinfo.setCustId(custId);
		cinfo.setName(name);
		cinfo.setAddress(addr);
		cinfo.setAge(age);
		cinfo.setContactNumber(num);
		cinfo.setEmail(email);
		
		
		LoginInfo linfo1 = new LoginInfo();
		linfo1.setUserID(custId);
		linfo1.setPassword(pass);
		linfo1.setUserType('C');
		
		Cart cart=new Cart();
		cart.setCartId(custId);
		
		CustInsert cinsert =  new CustInsert();
		cinsert.CustomerInsert(cinfo,linfo1,cart);
		
	}

	private static void registerAdmin()
	{
		Scanner sc=new Scanner(System.in);
		
		String pass,name,num,addr,email;
		int age;
		System.out.println("\nWELCOME TO ADMIN REGISTRATION PAGE\n");
		System.out.println("*****************************************************\n");
		System.out.println("ADMIN ID = ");
		AdminId=sc.nextInt();
		System.out.print("Enter password = ");
		pass=sc.next();
		System.out.print("Enter Name = ");
		name=sc.next();
		System.out.print("Enter age = ");
		age=sc.nextInt();
		System.out.print("Enter contact number = ");
		num=sc.next();
		System.out.print("Enter address = ");
		addr=sc.next();
		System.out.print("Enter email = ");
		email=sc.next();
		
		AdminInfo ainfo = new AdminInfo();
		ainfo.setAdminId(AdminId);
		ainfo.setPassword(pass);
		ainfo.setAddress(addr);
		ainfo.setName(name);
		ainfo.setEmail(email);
		ainfo.setAge(age);
		ainfo.setContactNumber(num);
		
		LoginInfo linfo = new LoginInfo();
		linfo.setUserID(AdminId);
		linfo.setPassword(pass);
		linfo.setUserType('A');

		AdminInsert ainsert = new AdminInsert ();
		ainsert.AdminPrint(ainfo,linfo);
	}
	
	
 
}
