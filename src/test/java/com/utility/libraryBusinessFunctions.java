package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class libraryBusinessFunctions {
	public static WebDriver driver;
	public static Properties ObjProp;

	public void ReadPropertyFile() {
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

	public void launchBrowser() {
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

}
