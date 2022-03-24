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
	
	
	By QTY_TENTS = By.name("QTY_TENTS");
}
