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

import org.openqa.selenium.Alert;
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

public class ValidatingAlerts extends libraryBusinessFunctions{

	@Test(priority=3)
	public void ValidatingAlerts() throws InterruptedException {
		System.out.println("inside ValidatingAlerts");
		driver.navigate().to(ObjProp.getProperty("AlertURL"));
		driver.findElement(By.id("alertButton")).click();
		Alert objAlert = driver.switchTo().alert();
		String TextOfAlert = objAlert.getText();
		System.out.println("TextOfAlert:"+TextOfAlert);
		Assert.assertEquals(TextOfAlert,ObjProp.getProperty("Alert1Text"));
		objAlert.accept();
		
		//timer Alert
		
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(8000);
		Alert objtimerAlertButton = driver.switchTo().alert();
		String TextOftimerAlert = objtimerAlertButton.getText();
		System.out.println("TextOftimerAlert:"+TextOftimerAlert);
		Assert.assertEquals(TextOftimerAlert,ObjProp.getProperty("Alert3Result"));
		objAlert.accept();
		
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
		launchBrowser();
	}


	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		ReadPropertyFile();
	}


	

	@AfterSuite
	public void afterSuite() {
	}

}
