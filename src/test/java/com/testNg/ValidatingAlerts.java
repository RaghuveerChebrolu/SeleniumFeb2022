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
		waitForPageToLoad();
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(15000);
		Alert objAlert = driver.switchTo().alert();
		String TextOfAlert = objAlert.getText();
		System.out.println("TextOfAlert:"+TextOfAlert);
		Assert.assertEquals(TextOfAlert,ObjProp.getProperty("Alert1Text"));
		objAlert.accept();
		
		//timer Alert
		
		/*
		 * driver.findElement(By.id("timerAlertButton")).click(); Thread.sleep(15000);
		 * Alert objtimerAlertButton = driver.switchTo().alert(); String
		 * TextOftimerAlert = objtimerAlertButton.getText();
		 * System.out.println("TextOftimerAlert:"+TextOftimerAlert);
		 * Assert.assertEquals(TextOftimerAlert,ObjProp.getProperty("Alert2Text"));
		 * objAlert.accept();
		 */
		
		//confirm Button Alert
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(8000);
		Alert objconfirmButton = driver.switchTo().alert();
		String AlertMessage = objconfirmButton.getText();
		System.out.println("AlertMessage:"+AlertMessage);
		Assert.assertEquals(AlertMessage,"Do you confirm action?");
		objconfirmButton.dismiss();
		String TextAppear = driver.findElement(By.id("confirmResult")).getText();
		System.out.println("TextAppear:"+TextAppear);
		Assert.assertEquals(TextAppear,ObjProp.getProperty("Alert3ResultCancel"));
		
		//PromptButton Alert
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(8000); //static wait : halting the execution upto specified seconds
		Alert promtButtonAlert = driver.switchTo().alert();
		promtButtonAlert.sendKeys("I am doing good");
		Thread.sleep(4000);
		promtButtonAlert.accept();
		String TextPropmptResult = driver.findElement(By.id("promptResult")).getText();
		System.out.println("TextPropmptResult"+TextPropmptResult);
		Assert.assertEquals(TextPropmptResult,ObjProp.getProperty("Alert4Result"));
		
		
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
