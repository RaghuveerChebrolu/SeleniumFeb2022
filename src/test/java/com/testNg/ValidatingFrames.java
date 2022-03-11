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

public class ValidatingFrames extends libraryBusinessFunctions{

	@Test(priority=3)
	public void ValidatingFrames() throws InterruptedException {
		System.out.println("inside ValidatingFrames");
		driver.navigate().to(ObjProp.getProperty("FramesURL"));
		waitForPageToLoad();
		//Below line is for switching control from web page to iframe
		driver.switchTo().frame("singleframe");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello How are you Doing ?");
		TakeScreenShot();
		//Below line is for coming out from the frame.
		driver.switchTo().defaultContent();
		
		//iframe with in iframe
		driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]")).click();
		WebElement FrameElement =  driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(FrameElement);
		WebElement singleFrameElement  = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(singleFrameElement);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello I am inside singleFrame on MultipleFrames");
		//Below line is used to come out of the frame
		driver.switchTo().defaultContent();
		TakeScreenShot();
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
