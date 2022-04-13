package com.utility;

import org.openqa.selenium.By;

public class ObjectRepository {

	public static String singleFrameID = "singleframe";
	public static String FrameTextbox = constants.xpath+"&"+"//input[@type='text']";
	public static String FrameWithInIframe = constants.xpath+"&"+"//a[contains(text(),'Iframe with in an Iframe')]";
	public static String Singleframe = constants.xpath+"&"+"//iframe[@src='SingleFrame.html']";
	public static String Multipleframe = constants.xpath+"&"+"//iframe[@src='MultipleFrames.html']";
	
	public static String NewBrowserWindow = constants.Name+"&"+"newbrowserwindow123";
	public static String MenuInNewwindow = constants.xpath+"&"+"//span[contains(text(),'Menu')]";
	public static String AboutMeInNewwindow = constants.xpath+"&"+"(//a[contains(text(),'About Me')])[1]";
	public static String MouseOperationRightClick = constants.xpath+"&"+"/html[1]/body[1]/div[1]/section[1]/div[1]/div[1]/div[1]/p[1]/span[1]";
	public static String MouseOperationCopyFromRightClickMenu = constants.xpath+"&"+"//ul[@class='context-menu-list context-menu-root']/li[3]";
	public static String MouseOperationFrameOfDoubleCLick = constants.xpath+"&"+"//iframe";
	public static String MouseOperationDoubleClick = constants.xpath+"&"+"//span[contains(text(),'Double click')]/preceding-sibling::div";
	
	public static String MouseOperationFrameforDragAndDrop =constants.xpath+"&"+ "//iframe[@class='demo-frame']";
	public static String MouseOperationDragID = constants.ID+"&"+"draggable";
	public static String MouseOperationDropID = constants.ID+"&"+"droppable";
	
	public static String WebTableAllLastNames = constants.xpath+"&"+"//table[@id='example']/tbody/tr/td[3]";
	public static String FileUploadBrowseButton = constants.xpath+"&"+"//input[@id='input-4']/preceding-sibling::span";
	public static String FileDownLoad500KB = constants.xpath+"&"+"(//td[@class='text-right file-link'])[2]/a";

	public static String DataDrivenFirstName = constants.xpath+"&"+"//input[@placeholder='First Name']";
	public static String DataDrivenLasttName = constants.xpath+"&"+"//input[@placeholder='Last Name']";
	public static String DataDrivenAddress = constants.xpath+"&"+"//textarea[@ng-model='Adress']";
	public static String DataDrivenEmail = constants.xpath+"&"+"//input[@type='email']";
	public static String DataDrivenPhone = constants.xpath+"&"+"//input[@type='tel']";
	
	public static String DataDrivenGenderMale = constants.xpath+"&"+"//input[@value='Male']";
	public static String DataDrivenGenderFeMale = constants.xpath+"&"+"//input[@value='FeMale']";
	
	public static String DataDrivenHobbiesCricket = constants.ID+"&"+"checkbox1";
	public static String DataDrivenHobbiesMovies = constants.ID+"&"+"checkbox2";
	public static String DataDrivenHobbiesHockey = constants.ID+"&"+"checkbox3";
	
	public static String DataDrivenLanguages = constants.ID+"&"+"msdd";
	public static String DataDrivenAllLanguages = constants.xpath+"&"+"//*[@id='msdd']/following-sibling::div/ul/li";
	public static String DataDrivenSkillsField = constants.xpath+"&"+"//*[text()='Skills']";
	
	public static String DataDrivenskills = constants.ID+"&"+"Skills";
	public static String DataDrivenAllSkills = constants.xpath+"&"+"//select[@id='Skills']/option";
	
	public static String CloseIconSkillsField = constants.xpath+"&"+"//span[@class='ui-icon ui-icon-close']";
	
	public static String DataDrivenSelectCountry = constants.xpath+"&"+"//span[@role='combobox']";
	public static String DataDrivenTextBox_SelectCountry = constants.xpath+"&"+"//input[@type='search']";
	
	public static String DataDrivenLDOB_Year = constants.ID+"&"+"yearbox";
	public static String DataDrivenDOB_AllYears = constants.xpath+"&"+"//select[@id='yearbox']/option";
	
	public static String DataDrivenLDOB_Month = constants.xpath+"&"+"//select[@placeholder='Month']";
	public static String DataDrivenDOB_AllMonths = constants.xpath+"&"+"//select[@placeholder='Month']/option";
	
	public static String DataDrivenLDOB_Day = constants.xpath+"&"+"//select[@id='daybox']";
	public static String DataDrivenDOB_AllDays = constants.xpath+"&"+"//select[@id='daybox']/option";
	
	public static String DataDriven_Password = constants.ID+"&"+"firstpassword";
	public static String DataDriven_ConfirmPassword = constants.ID+"&"+"secondpassword";
	
	
	
	By QTY_TENTS = By.name("QTY_TENTS");
}
