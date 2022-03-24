package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utility.ObjectRepository;
import com.utility.libraryBusinessFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MouseOperations extends libraryBusinessFunctions {
	@Test(priority = 3)
	public void ValidatingMouseOperations() {
		try {
			System.out.println("inside ValidatingMouseOperations");
			driver.navigate().to(ObjProp.getProperty("mouseOpeartionRightClick"));
			waitForPageToLoad();
			WebDriverWait wait = new WebDriverWait(driver,60);
			WebElement RigtClick = libraryBusinessFunctions.FindElement(ObjectRepository.MouseOperationRightClick);
			wait.until(ExpectedConditions.visibilityOf(RigtClick));
			Actions Obj = new Actions(driver);
			Obj.contextClick(RigtClick).build().perform();
			Thread.sleep(5000);
			libraryBusinessFunctions.FindElement(ObjectRepository.MouseOperationCopyFromRightClickMenu).click();
			//driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[3]")).click();
			Alert objAlert = driver.switchTo().alert();
			String text = objAlert.getText();
			Assert.assertEquals(text, "clicked: copy");
			Thread.sleep(5000);
			objAlert.accept();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
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
