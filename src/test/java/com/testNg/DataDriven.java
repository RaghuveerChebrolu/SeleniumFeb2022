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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class DataDriven extends libraryBusinessFunctions {
	
	@Test(priority = 1)
	public void ValidatingDataDriven() {
		try {
			System.out.println("inside ValidatingDataDriven");
			driver.navigate().to(ObjProp.getProperty("AutomationRegister"));
			waitForPageToLoad(); 
			Thread.sleep(10000);
			File objFile = new File(System.getProperty("user.dir")+"//src//test/resources//AutomationDemoSIte.xlsx") ;
			FileInputStream objFileInput = new FileInputStream(objFile);
			XSSFWorkbook objXSSFWorkBook = new XSSFWorkbook(objFileInput);//for .xlsx foramt
			XSSFSheet objXSSFSheet = objXSSFWorkBook.getSheet("TestData"); //for .xlsx foramt
			
			//HSSFWorkbook objHSSFWorkbook = new HSSFWorkbook(objFileInput);  //for .xls format
			//HSSFSheet objHSSFSheet =  objHSSFWorkbook.getSheet("TestData"); //for .xls foramt
			
			int NumberOfRows = objXSSFSheet.getLastRowNum();
			System.out.println("NumberOfRows: "+NumberOfRows);
			for (int row =1; row<=NumberOfRows;row++) {
			
				hmap = ReadTestDataFromExcel(objXSSFSheet,row);
				if(hmap.get("RunMode").equalsIgnoreCase("Yes")){
				WebElement Firstname = libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenFirstName);
				WebDriverWait wait = new WebDriverWait(driver,60);
				wait.until(ExpectedConditions.elementToBeClickable(Firstname));
				Firstname.clear();
				Firstname.sendKeys(hmap.get("FirstName"));
				
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenLasttName).clear();
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenLasttName).sendKeys(hmap.get("LastName"));
				
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenAddress).clear();
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenAddress).sendKeys(hmap.get("Address"));
				
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenEmail).clear();
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenEmail).sendKeys(hmap.get("EmailAddress"));
				
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenPhone).clear();
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenPhone).sendKeys(hmap.get("PhoneNumber"));
				
				if(hmap.get("Gender").equals("Male")) {
					libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenGenderMale).click();
				}else if(hmap.get("Gender").equals("Female")) {
					libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenGenderFeMale).click();
				}
				
				if(hmap.get("Hobbies").equalsIgnoreCase("cricket")) {
					libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenHobbiesCricket).click();
				}else if(hmap.get("Hobbies").equalsIgnoreCase("movies")) {
					libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenHobbiesMovies).click();
				}else if(hmap.get("Hobbies").equalsIgnoreCase("hockey")) {
					libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenHobbiesHockey).click();
				}
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,500)");
				
				if(row>1) {
					libraryBusinessFunctions.FindElement(ObjectRepository.CloseIconSkillsField).click();
				}
				
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenLanguages).click();
				List<WebElement> AllLanguages = libraryBusinessFunctions.FindElements(ObjectRepository.DataDrivenAllLanguages);
				String LanguagesDropDownValue = hmap.get("Languages");
				SelectValueFromDropDown(AllLanguages,LanguagesDropDownValue);
				
				
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenSkillsField).click();
				
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenskills).click();
				List<WebElement> AllSkills = libraryBusinessFunctions.FindElements(ObjectRepository.DataDrivenAllSkills);
				String SkillsDropDownValue = hmap.get("Skills");
				SelectValueFromDropDown(AllSkills,SkillsDropDownValue);
				
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenSelectCountry).click();
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenTextBox_SelectCountry).sendKeys(hmap.get("SelectCountry"));
				Robot objRobot = new Robot();
				objRobot.keyPress(KeyEvent.VK_ENTER);
				objRobot.keyRelease(KeyEvent.VK_ENTER);
				
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenLDOB_Year).click();
				List<WebElement> AllYears = libraryBusinessFunctions.FindElements(ObjectRepository.DataDrivenDOB_AllYears);
				String YearDropDownValue = hmap.get("DOB_YY");
				SelectValueFromDropDown(AllYears,YearDropDownValue);
				
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenLDOB_Month).click();
				List<WebElement> AllMonths = libraryBusinessFunctions.FindElements(ObjectRepository.DataDrivenDOB_AllMonths);
				String MnthDropDownValue = hmap.get("DOB_MM");
				SelectValueFromDropDown(AllMonths,MnthDropDownValue);
				
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDrivenLDOB_Day).click();
				List<WebElement> AllDays = libraryBusinessFunctions.FindElements(ObjectRepository.DataDrivenDOB_AllDays);
				String DayDropDownValue = hmap.get("DOB_DD");
				SelectValueFromDropDown(AllDays,DayDropDownValue);
				
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDriven_Password).clear();
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDriven_Password).sendKeys(hmap.get("Password"));
				
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDriven_ConfirmPassword).clear();
				libraryBusinessFunctions.FindElement(ObjectRepository.DataDriven_ConfirmPassword).sendKeys(hmap.get("confirmPwd"));
			
			
				FileOutputStream objFileOutput = new FileOutputStream(objFile);
				WriteToExcelFile(objXSSFWorkBook,objXSSFSheet,row);
				objXSSFWorkBook.write(objFileOutput);
			}
			else if(hmap.get("RunMode").equalsIgnoreCase("No")){
				int count = row+1;
				System.out.println("RunMode in test data excel file is not marked as Yes for row number :"+count);
			}
			}
			objXSSFWorkBook.close();
			objFileInput.close();
			
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
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		ReadPropertyFile();
		
	}
}
	