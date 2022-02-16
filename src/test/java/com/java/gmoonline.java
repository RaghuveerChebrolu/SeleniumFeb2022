package com.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gmoonline {
	 WebDriver driver = null;
	static String qty="5";
	public static void main(String args[]) {
		gmoonline obj = new gmoonline();
		System.out.println("inside beforeSuite");
		WebDriverManager.chromedriver().setup();
		obj.driver = new ChromeDriver();
		obj.driver.get("http://demo.borland.com/gmopost/");
		obj.driver.manage().window().maximize();

		String title = obj.driver.getTitle();
		// System.out.println(title);
		// Assert.assertEquals(title, "Welcome to Green Mountain Outpos");

		obj.driver.findElement(By.name("bSubmit")).click();
		obj.driver.findElement(By.name("QTY_TENTS")).clear();
		obj.driver.findElement(By.name("QTY_TENTS")).sendKeys(qty);
		obj.driver.findElement(By.name("bSubmit")).click();
		String unitPrice = obj.driver
				.findElement(By.cssSelector(
						"center:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(2) > td:nth-child(4)"))
				.getText();
		System.out.println(unitPrice);
	}

}
