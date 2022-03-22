package com.testNg;

import org.testng.annotations.Test;

import com.pages.GroceryPage;
import com.pages.HomePage;
import com.pages.LoginPage;
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
import org.openqa.selenium.WebElement;
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

public class flipkart extends libraryBusinessFunctions {
	HomePage homePage;
	LoginPage loginPage;
	GroceryPage groceryPage;
	libraryBusinessFunctions obj = new libraryBusinessFunctions();


	@Test(priority = 1)
	public void ValidatioFlipkartGrocery() {
		driver.navigate().to("https://www.flipkart.com/");
		waitForPageToLoad();
		loginPage = new LoginPage(driver);
		LoginPage.clickcloseIconOfLoginPopUp();
		homePage = new HomePage(driver);
		HomePage.clickGrocery();
		groceryPage = new GroceryPage(driver);
		String title = GroceryPage.clickcurrentLocation();
		Assert.assertEquals(title, ObjProp.getProperty(""));
		
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
		int i=1;
		System.out.println (( ++i + ++i )+( --i + i++ ));
		obj.ReadPropertyFile();
	}


	
	

	@AfterSuite
	public void afterSuite() {
	}

}
