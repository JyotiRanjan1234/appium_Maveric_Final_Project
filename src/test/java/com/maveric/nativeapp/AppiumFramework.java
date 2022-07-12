package com.maveric.nativeapp;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.maveric.pom.FindCarPage;
import com.maveric.pom.SignUpPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.Assert;


public class AppiumFramework 
{

	static AppiumDriverLocalService service=null;
	public static String RunStatus;
	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		try
		{
			AppiumServiceBuilder builder=new AppiumServiceBuilder()
					.usingAnyFreePort()
					.withLogFile(new File("appium_log.log"))
					.withArgument(GeneralServerFlag.RELAXED_SECURITY)
					.withArgument(GeneralServerFlag.BASEPATH,"/wd/hub");
			
			service = AppiumDriverLocalService.buildService(builder);
			
			service.start();
			
			System.out.println("-----------------------------------");
			System.out.println(service.getUrl());
			System.out.println(service.isRunning());
			System.out.println("-----------------------------------");
			
			Thread.sleep(4000);
			
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setCapability("platformName", "android");
			cap.setCapability("deviceName", "redmi");
			cap.setCapability("app", "F:\\Mobile_Automation\\Appium\\com.bsl.hyundai_2021-08-09.apk");
			cap.setCapability("noReset", "true");
			
			AndroidDriver driver= new AndroidDriver(service, cap);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			String Appsource=driver.getPageSource();
			System.out.println(Appsource);
			
			
			
			  if(driver.findElements(SignUpPage.accessdeny).size()!=0) 
			  {
			  driver.findElement(SignUpPage.accessdeny).click();
			  System.out.println(driver.findElement(SignUpPage.accessdeny).isDisplayed());
			  }
			  
			  if(driver.findElements(SignUpPage.accessdeny).size()!=0) {
			  driver.findElement(SignUpPage.accessdeny).click();
			  System.out.println(driver.findElement(SignUpPage.signup).isDisplayed());
			  
			  }
			 
			 
			
			driver.findElement(SignUpPage.signup).click();
			RunStatus=new Boolean(driver.findElement(SignUpPage.name).isDisplayed()).toString();
			Assert.assertEquals(RunStatus, "true");
			
			driver.findElement(SignUpPage.name).sendKeys("JyotiRanjan");
			RunStatus=new Boolean(driver.findElement(SignUpPage.mobilenum).isDisplayed()).toString();
			Assert.assertEquals(RunStatus, "true");
			
			driver.findElement(SignUpPage.mobilenum).sendKeys("9456327650");
			RunStatus=new Boolean(driver.findElement(SignUpPage.emailid).isDisplayed()).toString();
			Assert.assertEquals(RunStatus, "true");
			
			driver.findElement(SignUpPage.emailid).sendKeys("JyotiRanjan@gmail.com");
			RunStatus=new Boolean(driver.findElement(SignUpPage.password).isDisplayed()).toString();
			Assert.assertEquals(RunStatus, "true");
			
			driver.findElement(SignUpPage.password).sendKeys("Welcome123");
			RunStatus=new Boolean(driver.findElement(SignUpPage.cnfmpassword).isDisplayed()).toString();
			Assert.assertEquals(RunStatus, "true");
			
			driver.findElement(SignUpPage.cnfmpassword).sendKeys("Welcome123");
			RunStatus=new Boolean(driver.findElement(SignUpPage.checkbox).isDisplayed()).toString();
			Assert.assertEquals(RunStatus, "true");
			
			driver.findElement(SignUpPage.checkbox).click();
			RunStatus=new Boolean(driver.findElement(SignUpPage.register).isDisplayed()).toString();
			Assert.assertEquals(RunStatus, "true");
			
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Actions action = new Actions(driver);
			
			while (driver.findElements(SignUpPage.backbutton).size() == 0) 
			{
				action.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 971, 1276))
						.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
						.tick(new Pause(finger, Duration.ofMillis(600)))
						.tick(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), 982, 1045))
						.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg())).build().perform();
			}
			
			RunStatus=new Boolean(driver.findElement(SignUpPage.backbutton).isDisplayed()).toString();
			Assert.assertEquals(RunStatus, "true");
			
			driver.findElement(SignUpPage.backbutton).click();
			RunStatus=new Boolean(driver.findElement(SignUpPage.signup).isDisplayed()).toString();
			Assert.assertEquals(RunStatus, "true");
			
			//Find a Car(Testcase 2)
			
			 driver.findElement(FindCarPage.skiplogin).click(); 
			 /* Boolean(driver.findElement(FindCarPage.hyndaiexstingcostm).isDisplayed()).
			 * toString(); Assert.assertEquals(RunStatus, "true");
			 
			
			driver.findElement(FindCarPage.hyndaiexstingcostm).click();
			*/
			RunStatus=new Boolean(driver.findElement(FindCarPage.findacar).isDisplayed()).toString();
			Assert.assertEquals(RunStatus, "true");

			
			driver.findElement(FindCarPage.findacar).click();
			RunStatus=new Boolean(driver.findElement(FindCarPage.carlistpage).isDisplayed()).toString();
			Assert.assertEquals(RunStatus, "true");

			Map<String, Object> map=new HashMap<String , Object>();
			map.put("strategy", "-android uiautomator");
			map.put("selector", "UiSelector().text(\"New Creta\")");
			
			driver.executeScript("mobile: scroll", map);
			
			driver.findElement(FindCarPage.newcreta).click();
			RunStatus=new Boolean(driver.findElement(FindCarPage.highlightpage).isDisplayed()).toString();
			Assert.assertEquals(RunStatus, "true");
			
			/*
			 * driver.findElement(FindCarPage.highlights1).click(); Map<String, Object>
			 * map2=new HashMap<String , Object>();
			 * map2.put("strategy","-android uiautomator");
			 * map2.put("selector","UiSelector().textContains(\"All New CRETA has\")");
			 * 
			 * driver.executeScript("mobile: scroll", map2);
			 */
			  
			
			Map<String,Object> map3= new HashMap<String, Object>();
			map3.put("command","input touchscreen swipe 971 1276 982 1045");
			//map.put("command","am start -a android.bluetooth.adapter.action.REQUEST_ENABLE");
			driver.executeScript("mobile: shell", map3);
			
			  String Highlights=driver.findElement(FindCarPage.highlights1).getText();
			  
			  System.out.println(Highlights);
			  Highlights=Highlights+" "
			  +driver.findElement(FindCarPage.highlights2).getText();
			  
			  System.out.println(Highlights);
			 
			
			service.stop();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			service.stop();
		}

	}	
}
