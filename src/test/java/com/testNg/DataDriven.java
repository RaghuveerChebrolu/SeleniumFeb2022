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
	HashMap<String,String> hmap = new HashMap<String,String>();
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
				
				
				
			}
			
			/*
			 * for (Map.Entry m : hmap.entrySet()) { System.out.println(m.getKey() +
			 * ":"+m.getValue()); }
			 */
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, String> ReadTestDataFromExcel(XSSFSheet objXSSFSheet, int row) {
		DataFormatter ObjFormatter = new DataFormatter();
		hmap.put("RunMode", objXSSFSheet.getRow(row).getCell(0).getStringCellValue());
		hmap.put("TestCaseName", objXSSFSheet.getRow(row).getCell(1).getStringCellValue());
		hmap.put("FirstName", objXSSFSheet.getRow(row).getCell(2).getStringCellValue());
		hmap.put("LastName", objXSSFSheet.getRow(row).getCell(3).getStringCellValue());
		hmap.put("Address", objXSSFSheet.getRow(row).getCell(4).getStringCellValue());
		
		hmap.put("EmailAddress", objXSSFSheet.getRow(row).getCell(5).getStringCellValue());
		hmap.put("PhoneNumber", ObjFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(6)));
		hmap.put("Gender", objXSSFSheet.getRow(row).getCell(7).getStringCellValue());
		hmap.put("Hobbies", objXSSFSheet.getRow(row).getCell(8).getStringCellValue());
		hmap.put("Languages", objXSSFSheet.getRow(row).getCell(9).getStringCellValue());
		
		hmap.put("Skills", objXSSFSheet.getRow(row).getCell(10).getStringCellValue());
		hmap.put("Country", objXSSFSheet.getRow(row).getCell(11).getStringCellValue());
		hmap.put("SelectCountry", objXSSFSheet.getRow(row).getCell(12).getStringCellValue());
		
		hmap.put("DOB_YY", ObjFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(13)));
		
		hmap.put("DOB_MM", objXSSFSheet.getRow(row).getCell(14).getStringCellValue());
		
		hmap.put("DOB_DD",  ObjFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(15)));
		
		hmap.put("Password", objXSSFSheet.getRow(row).getCell(16).getStringCellValue());
		hmap.put("confirmPassword", objXSSFSheet.getRow(row).getCell(17).getStringCellValue());
		

		return hmap;
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
	