package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class libraryBusinessFunctions  {
	public static WebDriver driver;
	public static Properties ObjProp;
	public static JavascriptExecutor js = (JavascriptExecutor)driver;
	public static HashMap<String,String> hmap = new HashMap<String,String>();
	public static ExtentHtmlReporter ExtenthtmlReporter;
	public static ExtentReports ExtentReport;
	public static ExtentTest ExtentTest;
	
	/*
	 * ExtentHtmlReporter : responsible for look and feel of the report ,we can
	 * specify the report name , document title , theme of the report
	 * 
	 * ExtentReports : used to create entries in your report , create test cases in
	 * report , who executed the test case, environment name , browser
	 * 
	 * ExtentTest : update pass fail and skips and logs the test cases results
	 */
	
	public static void ReadPropertyFile() {
		try {
			System.out.println("reading proprties file");
			System.out.println(System.getProperty("user.dir"));
			ObjProp = new Properties();
			File obj = new File(System.getProperty("user.dir") + "//src//test//resources//ConfigProperty.properties");
			/*
			 * FileInputStream -> class used for reading from a file FileOutPutStream ->
			 * class used for wrting to a file
			 */
			FileInputStream objFileInput = new FileInputStream(obj);
			ObjProp.load(objFileInput);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void StartExtentReport(){
		ExtenthtmlReporter =  new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReportV4.html");
		ExtenthtmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		ExtenthtmlReporter.config().setReportName("Functional Testing"); // Name of the report
		ExtenthtmlReporter.config().setTheme(Theme.STANDARD);
		ExtentReport = new ExtentReports();
		ExtentReport.attachReporter(ExtenthtmlReporter);

		// Passing General information
		ExtentReport.setSystemInfo("Host name", "localhost");
		ExtentReport.setSystemInfo("Environemnt", "QA-SIT");
		ExtentReport.setSystemInfo("user", "Raghuveer");
	}

	public static void launchBrowser() {
		String browser = ObjProp.getProperty("browser");
		switch (browser) {
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			ChromeOptions objChromeOptions = new ChromeOptions();
			objChromeOptions.setAcceptInsecureCerts(true);
			// driver= new ChromeDriver(objChromeOptions);
			Map<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.prompt_for_download", false);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
			objChromeOptions.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(objChromeOptions);
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("headless");
		}
		driver.get(ObjProp.getProperty("GmoOnline"));
		driver.manage().window().maximize();
		/*
		 * implicit Wait : Global waiting mechanism applicable for all web Elements
		 * declared under implicit wait. script is going to wait until web element is
		 * Recognized upto maximum of 60 seconds. If not recognised it will throw
		 * noSuchElement Exception Timeout Exception
		 */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}
	
	public static void waitForPageToLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		// explicit wait -> Applicable for one webEllement
		WebDriverWait wait = new WebDriverWait(driver, 120);// 120 seconds
		wait.until(pageLoadCondition);
	}
	
	/* Author : Raghuveer
	 * This method is used to take screen shot and store the screen shots in side ScreenShot folder
	 */
	public static void TakeScreenShot() {
		try {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMDDhhmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "//ScreenShots//" + dateName + "captured.jpeg";
		FileUtils.copyFile(src, new File(destination));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* Author : Raghuveer
	 * This method is used to take screen shot and store the screen shots in side ScreenShot folder
	 */
	public static void TakeScreenShotofSpecifiedWebElement(WebElement element) {
		try {
		File src = element.getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMDDhhmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "//ScreenShots//" + dateName + "captured.jpeg";
		FileUtils.copyFile(src, new File(destination));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static WebElement FindElement(String OrepLocator) {
		By search = null;
		System.out.println(OrepLocator);
		String locator = OrepLocator.split("&")[0];
		String value = OrepLocator.split("&")[1];
		System.out.println(locator);
		System.out.println(value);
		if (locator.equals("name")) {
			search = By.name(value);
		} else if (locator.equals("id")) {
			search = By.id(value);
		} else if (locator.equals("xpath")) {
			search = By.xpath(value);
		} else if (locator.equals("tagName")) {
			search = By.tagName(value);
		} else if (locator.equals("className")) {
			search = By.className(value);
		} else if (locator.equals("partialLinkText")) {
			search = By.partialLinkText(value);
		} else if (locator.equals("cssSelector")) {
			search = By.cssSelector(value);
		} else if (locator.equals("linkText")) {
			search = By.linkText(value);
		}
		return driver.findElement(search);
	}
	
	public static List<WebElement> FindElements(String OrepLocator) {
		By search = null;
		System.out.println(OrepLocator);
		String locator = OrepLocator.split("&")[0];
		String value = OrepLocator.split("&")[1];
		System.out.println(locator);
		System.out.println(value);
		if (locator.equals("name")) {
			search = By.name(value);
		} else if (locator.equals("id")) {
			search = By.id(value);
		} else if (locator.equals("xpath")) {
			search = By.xpath(value);
		} else if (locator.equals("tagName")) {
			search = By.tagName(value);
		} else if (locator.equals("className")) {
			search = By.className(value);
		} else if (locator.equals("partialLinkText")) {
			search = By.partialLinkText(value);
		} else if (locator.equals("cssSelector")) {
			search = By.cssSelector(value);
		} else if (locator.equals("linkText")) {
			search = By.linkText(value);
		}
		return driver.findElements(search);
	}
	
	public static void find_ElementAndClick(By locator) {
		driver.findElement(locator).click();
	}
	
	public static void ScrollDownByPixels(int x){
		js.executeScript("window.scrollBy(0,"+x+")");
	}
	
	public static void ScrollUpByPixels(int x){
		js.executeScript("window.scrollBy(0,"+"-"+x+")");
	}
	
	public static void ScrollRightByPixels(int x){
		js.executeScript("window.scrollBy("+x+",0)");
	}
	
	public static void ScrollLeftByPixels(int x){
		js.executeScript("window.scrollBy("+"-"+x+",0)");
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
		hmap.put("confirmPwd", objXSSFSheet.getRow(row).getCell(17).getStringCellValue());
		

		return hmap;
	}
	

	public static void WriteToExcelFile(XSSFWorkbook objXSSFWorkBook, XSSFSheet objXSSFSheet, int row) {
		objXSSFSheet = objXSSFWorkBook.getSheet(ObjProp.getProperty("DataDrienSheetName"));
		XSSFCellStyle CellStyle = objXSSFWorkBook.createCellStyle();
		// CellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		System.out.println("Row Number in excel is :" + row);
		objXSSFSheet.getRow(row).createCell(18).setCellValue("PASS");
		objXSSFSheet.getRow(row).getCell(18).setCellStyle(CellStyle);
		
	}
	
	public static void SelectValueFromDropDown(List<WebElement>AllDropDownItems, String languagesDropDownValue) {
		for(int i =1 ; i<=AllDropDownItems.size()-1; i++) {
			String SingleDropDownValueFromListOfDropDownValue = AllDropDownItems.get(i).getText();
			if(SingleDropDownValueFromListOfDropDownValue.equalsIgnoreCase(languagesDropDownValue)) {
				AllDropDownItems.get(i).click();
				break;
			}
		}
		
	}
}
