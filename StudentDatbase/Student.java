package studentDatabaseApp;

import java.util.*;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance;
	private static int costOfCourse = 600;
	private static int id = 1000;

	//Constructor: prompt user to enter student name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Student first name: ");
		this.firstName = in.nextLine();
		
		System.out.println("Enter Student last name: ");
		this.lastName = in.nextLine();
		
		System.out.println("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior: ");
		this.gradeYear = in.nextInt();
		
		setStudentID();
	}
	
	//Generate unique 5 digit id
	private void setStudentID() {
		//Every time a Student is created, id increases by 1 digit
		id++;
		this.studentID = gradeYear + "" + id;
	}
	
	//Enroll in courses
	public void enroll() {
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("Q")) {
				courses = courses + "\n  " + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			}
			else {break;}
		}
		while (1 != 0);
	}
	
	//View balance 
	public void viewBalance() {
		System.out.println("Your balance is: " + tuitionBalance);
	}
	
	//Pay tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter you payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance -= payment;
		System.out.println("Thank you for your payment of: " + payment);
		viewBalance();
	}
	
	//Show status
	public String toString() {
		return "Name: " + firstName + " " + lastName +
				"\nGrade level: " + gradeYear +
				"\nCourses enrolled: " + courses +
				"\nBalance: $" + tuitionBalance;
	}
}
