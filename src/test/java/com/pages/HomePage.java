package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	public static WebDriver driver;

	static By Grocery = By.xpath("(//img[@class='_396cs4  _3exPp9'])[2]");
	static By Mobiles = By.xpath("//img[@alt='Mobiles' and @class='_396cs4  _3exPp9']");
	static By Travel =By.xpath("//img[@alt='Travel' and @class='_396cs4  _3exPp9']");

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	public static void clickGrocery(){
		driver.findElement(Grocery).click();
	}
	
	public static void clickMobiles(){
		driver.findElement(Mobiles).click();
	}
	
	public static void clickTravel(){
		driver.findElement(Travel).click();
	}
	
	
}
