package com.maveric.pom;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class SignUpPage 
{
	public static By accessdeny=AppiumBy.xpath("//android.widget.Button[@text='Deny']");
	public static By signup=AppiumBy.xpath("//android.widget.TextView[@text='SIGN UP!']");
	public static By name=AppiumBy.xpath("//android.widget.EditText[@text='Name*']");
	public static By mobilenum=AppiumBy.xpath("//android.widget.EditText[@text='Mobile Number*']");
	public static By emailid=AppiumBy.xpath("//android.widget.EditText[@text='Email ID*']");
	public static By password=AppiumBy.xpath("//android.widget.EditText[@text='Password*']");
	public static By cnfmpassword=AppiumBy.xpath("//android.widget.EditText[@text='Confirm Password*']");
	public static By checkbox=AppiumBy.xpath("//android.widget.CheckBox[@resource-id='com.bsl.hyundai:id/checkAcceptTermsCondition']");
	public static By backbutton=AppiumBy.xpath("//android.widget.ImageView[@resource-id='com.bsl.hyundai:id/backbtn']");
	public static By register=AppiumBy.xpath("//android.widget.Button[@text='Register']");
	
	

}
