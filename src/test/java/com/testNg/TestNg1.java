package com.testNg;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNg1 {
	WebDriver driver;
	String qty = "5";

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
		driver.findElement(By.name("QTY_TENTS")).sendKeys(qty);
	}
	
	public void OrderExternalFrameBackpack() {
		driver.findElement(By.name("QTY_BACKPACKS")).clear();
		driver.findElement(By.name("QTY_BACKPACKS")).sendKeys(qty);
	}
	
	public void OrderGlacierSunGlasses() {
		driver.findElement(By.xpath("//input[@type='text' and @name='QTY_GLASSES']")).clear();
		driver.findElement(By.xpath("//input[@type='text' and @name='QTY_GLASSES']")).sendKeys(qty);
	}

	@Test(priority=2)
	public void ValidatePriceCalculationDomeTent(){
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
		Float calculatedPrice = Float.parseFloat(removeDollerFromUnitPrice)*Float.parseFloat(qty);
		System.out.println("calculatedPrice:"+calculatedPrice);
		String TotalPriceFromWebpagewithDoller = driver.findElement(By.xpath("//table[@border=1]/tbody/tr[2]/td[5]")).getText();
		System.out.println("TotalPriveFromWebpage:"+TotalPriceFromWebpagewithDoller);
		String ToatlPriceWebpage = TotalPriceFromWebpagewithDoller.substring(2).trim();
		System.out.println("ToatlPriceWebpage:"+ToatlPriceWebpage);
		Float ToatlPriceWebpageinFLoat=Float.parseFloat(ToatlPriceWebpage);
		Assert.assertEquals(calculatedPrice,ToatlPriceWebpageinFLoat);
		ValidatioEnterGmoOnline();
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
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		/*
		 * implicit Wait : Global waiting mechanism applicable for all web Elements
		 * declared under implicit wait. script is going to wait until web element is
		 * Recognized upto maximum of 60 seconds. If not recognised it will throw noSuchElement Exception Timeout Exception 
		 */
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}

	@AfterSuite
	public void afterSuite() {
	}

}
