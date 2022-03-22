package com.pages;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	protected static WebDriver driver ;
	
	protected BaseClass(WebDriver driver){
		this.driver=driver;
	}

}
