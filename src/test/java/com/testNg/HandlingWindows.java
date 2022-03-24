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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class HandlingWindows extends libraryBusinessFunctions {
	
	@Test(priority = 1)
	public void Val() {
		ArrayList obj = new ArrayList();
		obj.add("hi");
		obj.add(Boolean.TRUE);
		obj.add("hello");
		System.out.println(obj);
		System.out.println(10/1);
		
		LinkedList<String> all = new LinkedList<String>();
		all.add("hi 1");
		all.add("hello 2");
		all.add("val 3");
		all.add("Random");
		Iterator obj23 = all.descendingIterator();
				while(obj23.hasNext()){
				System.out.println(" "+obj23.next());
	}}

	@Test(priority = 3,enabled=false)
	public void ValidatingWindows() {
		try {
		System.out.println("inside ValidatingWindows");
		driver.navigate().to(ObjProp.getProperty("nxtgenaiacademyURL"));
		waitForPageToLoad();
		libraryBusinessFunctions.FindElement(ObjectRepository.NewBrowserWindow).click();
		waitForPageToLoad();
		String parentWindow = driver.getWindowHandle();
		Set<String> AllWindows = driver.getWindowHandles();
		for(String IndidvidualWindow:AllWindows) {
			driver.switchTo().window(IndidvidualWindow);
			String Title = driver.getTitle();
			System.out.println("Title:"+Title);
			if(Title.equals("Title:NxtGen A.I Academy – Learn With Clarity")) {
				driver.manage().window().maximize();
				libraryBusinessFunctions.FindElement(ObjectRepository.MenuInNewwindow).click();
					Thread.sleep(5000);
				libraryBusinessFunctions.FindElement(ObjectRepository.AboutMeInNewwindow).click();
				break;
			}
		}
		driver.switchTo().window(parentWindow);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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
