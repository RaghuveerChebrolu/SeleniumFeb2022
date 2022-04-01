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

public class FileUpload extends libraryBusinessFunctions {
	@Test(priority = 1)
	public void ValidatingFileUpload() {
		try {
			System.out.println("inside ValidatingFileUpload");

			driver.navigate().to(ObjProp.getProperty("FileUpload"));
			waitForPageToLoad(); // Right click operation using Actions class
			//libraryBusinessFunctions.FindElement(ObjectRepository.FileUploadBrowseButton).click();

			Actions obj = new Actions(driver);
			WebElement element = libraryBusinessFunctions.FindElement(ObjectRepository.FileUploadBrowseButton);
			obj.click(element).build().perform();
			Thread.sleep(5000);
			StringSelection objStringSelection = new StringSelection(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Sample.jpg");
			Clipboard objClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			objClipboard.setContents(objStringSelection, null);
			Transferable objTransferable = objClipboard.getContents(null);
			if (objTransferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				try {
					System.out.println(objTransferable.getTransferData(DataFlavor.stringFlavor));
				} catch (UnsupportedFlavorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Robot objRobot = new Robot();
				objRobot.delay(250);
				objRobot.keyPress(KeyEvent.VK_ENTER);
				objRobot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				objRobot.keyPress(KeyEvent.VK_CONTROL);
				objRobot.keyPress(KeyEvent.VK_V);
				Thread.sleep(2000);
				objRobot.keyRelease(KeyEvent.VK_V);
				objRobot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(2000);
				objRobot.keyPress(KeyEvent.VK_ENTER);
				objRobot.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
