package com.java.controlStatements;

public class forLoopEx {

	public static void main(String[] args) {
		char[] ch={'e','r','t','o','p'};
		// TODO Auto-generated method stub
		for(int i=1; i<=10;i++){
			System.out.println("The value of i: "+i);
		}
		for(char c:ch){
			System.out.println(c);
			if(c=='t'){
				System.out.println("i have identified character t");
				break;
			}
		}
	}

}
