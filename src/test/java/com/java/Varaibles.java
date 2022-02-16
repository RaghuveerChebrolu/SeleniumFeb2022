package com.java;

public class Varaibles {
	int data = 50;// instance variable : variable present inside a class but
					// outside a method
	static int m = 100;// static variable
	boolean flag = false;
	char ch = '&';
	String str = "";

	int[] arr = { 4, 6, 187, 9 };
	String[] arr1 = { "hi", "hello", "how" };

	void raghu() {
		int n = 90;// local variable which is present inside a method
		System.out.println(n);
	}

	void ragh2() {
		int n = 90;// local variable which is present inside a method
		System.out.println(n);
	}

	void raghu3() {
		int n = 90;// local variable which is present inside a method
		System.out.println(n);
	}

	void ragh4() {
		int n = 90;// local variable which is present inside a method
		System.out.println(n);
	}

	void raghu5() {
		int n = 90;// local variable which is present inside a method
		System.out.println(n);
	}

	void raghu6() {
		int n = 90;// local variable which is present inside a method
		System.out.println(n);
	}

	public static void main(String args[]) {
		Varaibles obj = new Varaibles();
		// System.out.println(n);
		System.out.println(obj.data);
		obj.raghu();
		System.out.println(m);
		int x = 8;
		int a = 6, b=3;
		System.out.println(x++);// 10 (11)
		System.out.println(++x);// 12
		System.out.println(x--);// 12 (11)
		System.out.println(--x);// 10
		int m=(a<b)?a:b;  
		System.out.println(m);
		
		short c=10;  
		short d=10;  
		//a+=b;//a=a+b internally so fine  
		c=(short) (c+d);
		System.out.println(c);
		
		
		
		
	}

}
