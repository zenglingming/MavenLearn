package com.plam.mavenlearn;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class WebTest1 {

	private AppiumDriver driver;
	
	@Test
	public void initalAppiumSettings() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");  //Browser
	    // http://127.0.0.1:4723/wd/hub地址就是AppiumServer的地址
	    driver = new AndroidDriver(new URL("http://192.168.0.26:4723/wd/hub"),capabilities);
	}
	
	@Test
	public void testWeb() throws InterruptedException {
		driver.get("http://m.yzfcw.com/");
		Thread.sleep(5);
		driver.findElement(By.xpath(".//*[@id='page-1']/ul[1]/li[1]/a/img")).click();
	}
	
//	@AfterMethod
//	public void tearDown() throws Exception {
//		driver.quit();
//	}
	
}
