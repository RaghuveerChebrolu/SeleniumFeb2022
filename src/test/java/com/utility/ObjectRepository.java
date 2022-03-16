package com.utility;

public class ObjectRepository {

	public static String singleFrameID = "singleframe";
	public static String FrameTextbox = constants.xpath+"&"+"//input[@type='text']";
	public static String FrameWithInIframe = constants.xpath+"&"+"//a[contains(text(),'Iframe with in an Iframe')]";
	public static String Singleframe = constants.xpath+"&"+"//iframe[@src='SingleFrame.html']";
	public static String Multipleframe = constants.xpath+"&"+"//iframe[@src='MultipleFrames.html']";
	
	
}
