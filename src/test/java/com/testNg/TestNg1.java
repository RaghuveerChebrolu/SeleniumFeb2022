package com.testNg;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNg1 {
	WebDriver driver;
  @Test(priority=0)
  public void ValidateGmoOnlineLoadedSuccessfully() {
	  String title = driver.getTitle();
	  System.out.println(title);
	  Assert.assertEquals(title, "Welcome to Green Mountain Outpost");
  }
  
  @Test(priority=1,dependsOnMethods = { "ValidateGmoOnlineLoadedSuccessfully"})
  public void ValidatioEnterGmoOnline(){
	  driver.findElement(By.name("bSubmit")).click();
	  driver.findElement(By.name("QTY_TENTS")).clear();
	  driver.findElement(By.name("QTY_TENTS")).sendKeys("5");
	  driver.findElement(By.name("bSubmit")).click();
	 String unitPrice = driver.findElement(By.cssSelector("center:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(2) > td:nth-child(4)")).getText();
	  System.out.println(unitPrice);
	  
  }
  
  
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside beforeSuite");
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("http://demo.borland.com/gmopost/");
	  driver.manage().window().maximize();
  }

  @AfterSuite
  public void afterSuite() {
  }

}
