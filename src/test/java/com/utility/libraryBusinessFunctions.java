package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class libraryBusinessFunctions  {
	public static WebDriver driver;
	public static Properties ObjProp;

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
			driver = new ChromeDriver();
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
	
	public static void find_ElementAndClick(By locator) {
		driver.findElement(locator).click();
	}

}
