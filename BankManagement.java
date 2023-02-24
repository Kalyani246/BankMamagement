package com.jsp.bankmanagement;
import java.sql.SQLException;
import java.util.Scanner;
//user- logic class --- contains only execution execution
public class BankManagement {
  public static void main(String[] args) {
	CustomerDetails details = new CustomerDetails();
	Bank bank = new Bank();
	Scanner sc = new Scanner(System.in);
	
	System.out.println("*********Welcome to JSP-Bank***********");
	System.out.println("----Register for New Account----");
	System.out.println("Enter your Name : ");
	/*
	 * String name = sc.next();details.setCustomerName(name);
	 */
	details.setCustName(sc.next());
	System.out.println("Enter Mobile number :");
	details.setMobile(sc.next());
	System.out.println("Enter Email-Id :");
	details.setEmail(sc.next());
	System.out.println("Enter Password :");
	details.setPassword(sc.next());
	System.out.println("Enter AadharCard Number :");
	details.setAadharNo(sc.next());
	System.out.println("Enetr gender :");
	details.setGender(sc.next());
	System.out.println("Enter default balance :");
	details.setBalance(sc.nextDouble());
	try {
		bank.registration(details);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
