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
	

	
	
	By QTY_TENTS = By.name("QTY_TENTS");
}
