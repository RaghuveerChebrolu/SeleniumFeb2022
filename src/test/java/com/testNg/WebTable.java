package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utility.ObjectRepository;
import com.utility.constants;
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
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class WebTable extends libraryBusinessFunctions {
	@Test(priority = 1)
	public void ValidatingWebTable() {
		try {
			System.out.println("inside ValidatingWebTable");
			
			  driver.navigate().to(ObjProp.getProperty("WebTableURL"));
			  waitForPageToLoad(); //Right click operation using Actions class
			  JavascriptExecutor js = (JavascriptExecutor)driver;
			  js.executeScript("window.scrollBy(0,600)");
			 List<WebElement> AllLast_Names = libraryBusinessFunctions.FindElements(ObjectRepository.WebTableAllLastNames);
			  for(int i=1;i<=AllLast_Names.size();i++) {
				String IndividualLasName = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[3]")).getText();
				  System.out.println("IndividualLasName for "+ i +" row is "+ IndividualLasName );
				  if(IndividualLasName.equals("Vance")) {
					  String IndividualFirstName = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText();
					  String Position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[4]")).getText();
					  String Office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[5]")).getText();
					  String StartDate = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[6]")).getText();
					  String Salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[7]")).getText();
					  
					  System.out.println("IndividualFirstName "+IndividualFirstName);
					  System.out.println("Position "+Position);
					  System.out.println("Office "+Office);
					  System.out.println("StartDate "+StartDate);
					  System.out.println("Salary "+Salary);
				  }
			  }
			
			 
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
}
