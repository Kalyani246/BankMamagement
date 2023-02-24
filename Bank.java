package com.jsp.bankmanagement;

import java.sql.*;
import java.util.Random;

//Business-logic - code/logic
//database - dao ->data access object - operation on database
public class Bank
{
   public Connection getConnection() throws SQLException
   {
	   String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
	   Connection connection = DriverManager.getConnection(url);
	   return connection;
   }
   public String getAccountNumber()
   {
	   Random random = new Random();
	   int accountNo = random.nextInt(100000000);
	   if(accountNo < 10000000)
	   {
		   accountNo += 10000000;
	   }
	   return "JSP"+accountNo;
   }
   public void registration(CustomerDetails details) throws SQLException
   {
	   String query = "insert into teja18.bankcustdetails values(?,?,?,?,?,?,?,?)";
	   
	   Connection conn = getConnection();
	   PreparedStatement ps = conn.prepareStatement(query);
	   
	   //assign values for placeholder
	   /*
	    * String number = getAccountNumber();
	    * ps.setString(1,number);
	    * String name = details.getCustName();
	    * ps.setString(2,name);
	    */
	    String accountNo = getAccountNumber();
	    ps.setString(1, accountNo);
	    ps.setString(2, details.getCustName());
	    ps.setString(3, details.getMobile());
	    ps.setString(4, details.getEmail());
	    ps.setString(5, details.getPassword());
	    ps.setString(6, details.getAadharNo());
	    ps.setString(7, details.getGender());
	    ps.setDouble(8, details.getBalance());
	    
	    int record = ps.executeUpdate();
	    if(record > 0)
	    {
	    	System.out.println("Registracation successfull. \nYour account Number is :"+accountNo);
	    }
	    else
	    {
	    	System.err.println("Please enter valid details..");
	    }
	    conn.close();
   }
}
