package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utility.ObjectRepository;
import com.utility.Orep;
import com.utility.constants;
import com.utility.libraryBusinessFunctions;
import com.utility.library_BusinessFunctions;

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

public class MouseOperations extends libraryBusinessFunctions {
	@Test(priority = 1)
	public void ValidatingMouseOperationsRightClick() {
		try {
			System.out.println("inside ValidatingMouseOperationsRightClick");
			
			  driver.navigate().to(ObjProp.getProperty("mouseOpeartionRightClick"));
			  waitForPageToLoad(); //Right click operation using Actions class
			  WebDriverWait wait = new WebDriverWait(driver,60); 
			  WebElement RigtClick =libraryBusinessFunctions.FindElement(ObjectRepository.
			  MouseOperationRightClick);
			  wait.until(ExpectedConditions.visibilityOf(RigtClick)); 
			  Actions Obj = new Actions(driver); 
			  Obj.contextClick(RigtClick).build().perform();
			  Thread.sleep(5000); libraryBusinessFunctions.FindElement(ObjectRepository.
			  MouseOperationCopyFromRightClickMenu).click(); 
			  //driver.findElement(By. xpath("//ul[@class='context-menu-list context-menu-root']/li[3]")).click();
			  Alert objAlert = driver.switchTo().alert(); String text = objAlert.getText();
			  Assert.assertEquals(text,
			  ObjProp.getProperty("mouseOpeartionRightclickCopyActionText"));
			  Thread.sleep(5000); objAlert.accept();
			 
			 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void ValidatingMouseOperationsDoubleCLick() {
		try {
			System.out.println("inside ValidatingMouseOperationsDoubleCLick");
		
			//Double click operation using Actions class
			driver.navigate().to(ObjProp.getProperty("mouseOpeartionDoubleClick"));
			waitForPageToLoad();
			Thread.sleep(8000);
			  JavascriptExecutor js = (JavascriptExecutor)driver;
			 // js.executeScript("window.scrollBy(0,1000)");//To scroll vertically Down by 1000 pixels 
			 // js.executeScript("window.scrollBy(0,-500)");//To scroll vertically Up by 500 pixels 
			//  js.executeScript("window.scrollBy(500,0)");//To scroll horizontally right by 500 pixels
			//  js.executeScript("window.scrollBy(-500,0)");//To scroll horizontally left by 500 pixels
			//libraryBusinessFunctions.ScrollDownByPixels(constants.scrollDown);
			  Actions Obj1 = new Actions(driver); 
			  WebDriverWait wait = new WebDriverWait(driver,60);
			  WebElement frameElement = libraryBusinessFunctions.FindElement(ObjectRepository.MouseOperationFrameOfDoubleCLick);
			  js.executeScript("arguments[0].scrollIntoView();", frameElement);
			  wait.until(ExpectedConditions.visibilityOf(frameElement)); 
			  driver.switchTo().frame(frameElement);
			  WebElement DoubleClick = libraryBusinessFunctions.FindElement(ObjectRepository.MouseOperationDoubleClick);
			  Obj1.doubleClick(DoubleClick).build().perform();
			  
			  Color BackGroundColor = Color.fromString(libraryBusinessFunctions.FindElement(ObjectRepository.MouseOperationDoubleClick).getCssValue("background-color"));
				System.out.println("BackGroundColor:" + BackGroundColor);
				String ActualBackGroundColor = BackGroundColor.asRgba();
				System.out.println("ActualBackGroundColor:" + ActualBackGroundColor);
				Assert.assertEquals(ActualBackGroundColor, "rgba(255, 255, 0, 1)");
				driver.switchTo().defaultContent();//to come out of frame
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Test(priority = 3)
	public void ValidatingMouseOperationsDragAndDrop() {
		try {
			System.out.println("inside ValidatingMouseOperationsDragAndDrop");
		
				//Drag and Drop Operation
				driver.navigate().to(ObjProp.getProperty("mouseOperationDragAndDrop"));
				waitForPageToLoad();
				WebElement DragAndDropFrame = libraryBusinessFunctions.FindElement(ObjectRepository.MouseOperationFrameforDragAndDrop);
				driver.switchTo().frame(DragAndDropFrame);
				Actions Obj3 = new Actions(driver); 
				WebElement source = libraryBusinessFunctions.FindElement(ObjectRepository.MouseOperationDragID);
				WebElement target = libraryBusinessFunctions.FindElement(ObjectRepository.MouseOperationDropID);
				//one way
				//Obj3.dragAndDrop(source,target).build().perform();
				//other way
				Obj3.clickAndHold(source);
				Obj3.moveToElement(target).build().perform();
			
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
