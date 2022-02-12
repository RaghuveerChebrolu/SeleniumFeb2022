package com.testNg;

import io.github.bonigarcia.wdm.WebDriverManager;

public class helloWorld {
	public int i,j;
	void add(int i, int j){
		int sum = i+j;
		System.out.println("sum"+sum);
	}
	public static void main(String[] args) {
		System.out.println("hello world");
		int i=10;
		//single line comment 
		//System.out.println("singlelineCOmment");
		
		//multi line comments
		/*System.out.println("multi line1");
		System.out.println("hello world");
		System.out.println("hello world");*/
		
		helloWorld obj = new helloWorld();
		obj.add(4, 6);
		
		WebDriverManager.chromedriver().setup();
		
	}

}
