package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public static WebDriver driver;

	static By userName = By.xpath("(//img[@class='_396cs4  _3exPp9'])[2]");
	static By Password = By.xpath("//img[@alt='Mobiles' and @class='_396cs4  _3exPp9']");
	static By LoginButton =By.xpath("//img[@alt='Travel' and @class='_396cs4  _3exPp9']");
	static By closeIconOfLoginPopUp = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public static void clickcloseIconOfLoginPopUp(){
		driver.findElement(closeIconOfLoginPopUp).click();
	}
	
	
	
}
