package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroceryPage {
	public static WebDriver driver;

	static By currentLocation = By.xpath("//button[@class='_2KpZ6l _1IsWyb _3dESVI']");
	
	
	public GroceryPage(WebDriver driver) {
		this.driver = driver;

	}

	public static String clickcurrentLocation(){
		driver.findElement(currentLocation).click();
		String title = driver.getTitle();
		return title;
	}
	
	
	
}
