package com.java.basics;

class staticvariable {
	// Java Program to demonstrate the use of static variable

	int rollno;// instance variable
	String name;// instance variable
	static String college;// static variable
	// constructor

	static {
		college = "ITS";
		System.out.println("executing static block before main method");
	}
	
	{
		System.out.println("inside instance block");
	}
	
	staticvariable(int r, String n) {
		rollno = r;
		name = n;
	}
	staticvariable() {
		System.out.println("inside default constructor");
	}
	

	// method to display the values
	void display() {
		System.out.println(rollno + " " + name + " " + college);
	}

	public static void main(String args[]) {
		System.out.println("inside main method");
		staticvariable s = new staticvariable();
		staticvariable s1 = new staticvariable(111, "Karan");
		staticvariable s2 = new staticvariable(222, "Aryan");
		// we can change the college of all objects by the single line of code
		//TestStaticVariable1.college = "BBDIT";
		s1.display();
		s2.display();
	}
}