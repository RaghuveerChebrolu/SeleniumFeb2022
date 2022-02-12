package com.java;

public class Varaibles {
	int data = 50;// instance variable : variable present inside a class but outside a method
	static int m = 100;// static variable

	void method() {
		int n = 90;// local variable which is present inside a method
		System.out.println(n);
	}

	public static void main(String args[]) {
		Varaibles obj = new Varaibles();
		// System.out.println(n);
		System.out.println(obj.data);
		obj.method();
	}

}
