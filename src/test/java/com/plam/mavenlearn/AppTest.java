package com.plam.mavenlearn;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;



public class AppTest {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */	
	private AppiumDriver driver;
	
	@BeforeClass
	public void initalAppiumSettings() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName","Android Emulator");
//		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("appActivity", ".Calculator");
		capabilities.setCapability("appPackage", "com.android.calculator2");		
		//capabilities.setCapability("appWaitActivity", "com.android.calculator2.calculator");
		//capabilities.setCapability("appWaitPackage", "com.android.calculator2");
	    //capabilities.setCapability("ignoreUnimportantViews", "true");
	    // http://127.0.0.1:4723/wd/hub地址就是AppiumServer的地址
	    driver = new AndroidDriver(new URL("http://192.168.0.26:4723/wd/hub"),capabilities);
	}
	
	@Test
	public void testCalculator() {
		try{
			driver.findElement(By.id("com.android.calculator2:id/clear")).click();
		}catch(Exception e){
			driver.findElement(By.id("com.android.calculator2:id/del")).click();
		}
		driver.findElement(By.id("com.android.calculator2:id/digit1")).click();
		driver.findElement(By.id("com.android.calculator2:id/plus")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit2")).click();
		driver.findElement(By.id("com.android.calculator2:id/equal")).click();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
