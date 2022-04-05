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

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
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

public class FileDownload extends libraryBusinessFunctions {
	@Test(priority = 1)
	public void ValidatingFileDownload() {
		try {
			System.out.println("inside ValidatingFileDownload");
			driver.navigate().to(ObjProp.getProperty("FileDownload"));
			waitForPageToLoad(); 
			JavascriptExecutor js = (JavascriptExecutor)driver; 
			js.executeScript("window.scrollBy(0,300)");
			WebDriverWait wait = new WebDriverWait(driver,45);
			WebElement element = libraryBusinessFunctions.FindElement(ObjectRepository.FileDownLoad500KB);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			Thread.sleep(10000);
			File objFile = new File(System.getProperty("user.dir"));
			File[] AllFiles = objFile.listFiles();
			Boolean fileFound = false;
			File obj_File = null;
			for(File IndividualFile :AllFiles ) {
				
				String FileName = IndividualFile.getName();
				System.out.println("FileName: "+FileName);
				if(FileName.contains("500kB")) {
					fileFound=true;
					obj_File = new File(FileName);
				}
			}
			Assert.assertTrue(fileFound, "Downloaded File Not Found");
			obj_File.deleteOnExit();
		} catch (Exception e) {
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
