package com.maveric.pom;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class FindCarPage 
{
	public static By skiplogin=AppiumBy.xpath("//android.widget.TextView[@text='SKIP LOGIN']");
	public static By hyndaiexstingcostm=AppiumBy.xpath("//android.widget.Button[@resource-id='com.bsl.hyundai:id/btnOK']");
	public static By findacar=AppiumBy.xpath("//android.widget.TextView[@text='Find a Car']");
	public static By newcreta=AppiumBy.xpath("(//android.widget.ImageView[@resource-id='com.bsl.hyundai:id/img_card_item'])[5]");
	public static By highlights1=AppiumBy.xpath("//android.widget.TextView[@resource-id='com.bsl.hyundai:id/txtTitle']");
	public static By highlights2=AppiumBy.xpath("//android.widget.TextView[@resource-id='com.bsl.hyundai:id/description']");
	public static By carlistpage=AppiumBy.xpath("//android.widget.TextView[@text='Hatchback']");
	public static By highlightpage=AppiumBy.xpath("//android.widget.TextView[@text='HIGHLIGHTS']");
	
}
