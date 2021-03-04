package emailapp;

import java.util.*;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "aecompany.com";
	
	//Constructor to receive first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		//Call method asking for department - then return the department
		this.department = setDepartment();
		
		//Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		//Combine given to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}
	
	//Ask for department
	private String setDepartment() {
		System.out.println("Department codes: \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none \nEnter Department Code: ");
		Scanner in = new Scanner(System.in);
		
		int depChoice = in.nextInt();
		
		if (depChoice == 1) {return "sales";}
		else if (depChoice == 2) {return "dev";}
		else if (depChoice == 3) {return "acct";}
		else {return "";}
	}
	
	//Generate Random password
	private String randomPassword(int length) {
		String passwordSet = "abcdefghijklmnopqrxtuvwxyzABCDEFGHIJKLMNOPQRXTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//Set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	//Get methods
	public int getMailCapacity() {return mailboxCapacity;}
	public String getAltEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "Display Name: " + firstName + " " + lastName +
				"\nCompany email: " + email + 
				"\nMailbox Capacity: " + mailboxCapacity + "mb";
	}
}