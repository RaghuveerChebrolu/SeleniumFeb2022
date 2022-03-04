package com.testNg;

import org.testng.annotations.Test;

import com.utility.libraryBusinessFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNg2 extends libraryBusinessFunctions {
	
	libraryBusinessFunctions obj = new libraryBusinessFunctions();

	@Test(priority = 0)
	public void ValidateGmoOnlineLoadedSuccessfully() {
		String title = driver.getTitle();
		// below are the 
		 System.out.println(title);
		Assert.assertEquals(title, "Welcome to Green Mountain Outpost");
	}

	@Test(priority = 1, dependsOnMethods = { "ValidateGmoOnlineLoadedSuccessfully" })
	public void ValidatioEnterGmoOnline() {
		driver.findElement(By.name("bSubmit")).click();
		Order3PersonDomeTent();
		OrderExternalFrameBackpack();
		driver.findElement(By.name("bSubmit")).click();
		String unitPrice = driver
				.findElement(By.cssSelector(
						"center:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(2) > td:nth-child(4)"))
				.getText();
		System.out.println(unitPrice);

	}

	 void Order3PersonDomeTent() {
		driver.findElement(By.name("QTY_TENTS")).clear();
		driver.findElement(By.name("QTY_TENTS")).sendKeys(ObjProp.getProperty("QTY_BackPacks"));
	}
	
	public void OrderExternalFrameBackpack() {
		driver.findElement(By.name("QTY_BACKPACKS")).clear();
		driver.findElement(By.name("QTY_BACKPACKS")).sendKeys(ObjProp.getProperty("QTY_BackPacks"));
	}
	
	public void OrderGlacierSunGlasses() {
		driver.findElement(By.xpath("//input[@type='text' and @name='QTY_GLASSES']")).clear();
		driver.findElement(By.xpath("//input[@type='text' and @name='QTY_GLASSES']")).sendKeys(ObjProp.getProperty("QTY_classes"));
	}

	@Test(priority=2)
	public void ValidatePriceCalculationDomeTent() throws InterruptedException{
		/*absolute xpath : going to start from / from html tag from starting of DOM
		 *Relative Xpath : going to start from // from any where in DOM 
		absolute xpath example : /html/body/form/table/tbody/tr[1]/td/div/center/table/tbody/tr[2]/td[4]
		Relative xpath syntax : //tagname[@attributename = 'value']
		Relative xpath example : //table[@border=1]/tbody/tr[2]/td[4] */
		String UnitPrice = driver.findElement(By.xpath("//table[@border=1]/tbody/tr[2]/td[4]")).getText();
		int UnitPricelength = UnitPrice.length();
		System.out.println("UnitPrice:"+UnitPrice);
		System.out.println("UnitPricelength:"+UnitPricelength);
		String removeDollerFromUnitPrice = UnitPrice.substring(2);
		System.out.println("removeDollerFromUnixPrice"+removeDollerFromUnitPrice);
		Float calculatedPrice = Float.parseFloat(removeDollerFromUnitPrice)*Float.parseFloat(ObjProp.getProperty("QTY_classes"));
		System.out.println("calculatedPrice:"+calculatedPrice);
		String TotalPriceFromWebpagewithDoller = driver.findElement(By.xpath("//table[@border=1]/tbody/tr[2]/td[5]")).getText();
		System.out.println("TotalPriveFromWebpage:"+TotalPriceFromWebpagewithDoller);
		String ToatlPriceWebpage = TotalPriceFromWebpagewithDoller.substring(2).trim();
		System.out.println("ToatlPriceWebpage:"+ToatlPriceWebpage);
		Float ToatlPriceWebpageinFLoat=Float.parseFloat(ToatlPriceWebpage);
		Assert.assertEquals(calculatedPrice,ToatlPriceWebpageinFLoat);
		Thread.sleep(8000);
		driver.navigate().back();
		Thread.sleep(8000);
		driver.navigate().forward();
		
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
		
		obj.launchBrowser();
	}


	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		obj.ReadPropertyFile();
	}


	
	

	@AfterSuite
	public void afterSuite() {
	}

}
