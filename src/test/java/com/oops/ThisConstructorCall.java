package com.oops;

class car {
	car() {
		System.out.println("hello a");
		
	}

	car(int x) {
		//System.out.println("hi");//complie time error
		this();
		System.out.println(x);
	}
}

class ThisConstructorCall {
	public static void main(String args[]) {
		car a = new car(10);
	}
}