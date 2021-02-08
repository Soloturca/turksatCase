package com.saf.framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory 
{
   
    private static DriverFactory instance = null;
    ThreadLocal<MobileDriver<MobileElement>> oDriver = new ThreadLocal<MobileDriver<MobileElement>>();
    
    private DriverFactory() {
    	
    }
    
    public static DriverFactory getInstance() {
    	if (instance==null) {
    		instance = new DriverFactory();
    	}
    	return instance;
    }
 		
	
	public final void setMobileDriver(String sDriverName, String platformName, String platformVersion, String UDID, String appPackage, String appActivity, String appWaitPackage, String appWaitActivity, String URL) throws MalformedURLException
	{
			DesiredCapabilities caps = new DesiredCapabilities();
			
			//Local Devices
			final String URL_STRING = URL;
		    URL url = new URL(URL_STRING);
		    
			//Platform Name
		    caps.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
			// Device Name
			caps.setCapability(MobileCapabilityType.DEVICE_NAME,"MyPhone");
			//Automation Name
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
			//Appium (default), UiAutomator2
			//Device ID
			caps.setCapability(MobileCapabilityType.UDID,UDID);
			//ANDROID Version
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);
			//App Name
			//caps.setCapability(MobileCapabilityType.APP, "C:\\Workspace\\uk.gov.tfl.paytodrive.apk");
			
			caps.setCapability("newCommandTimeout",90000);
			
			caps.setCapability("autoGrantPermissions",true);
			caps.setCapability("noReset",true);
			
			//caps.setCapability("uiautomator1ServerLaunchTimeout", 90000);

			caps.setCapability("appPackage",appPackage);
			caps.setCapability("appActivity",appActivity);
			caps.setCapability("appWaitPackage",appWaitPackage);
			caps.setCapability("appWaitActivity",appWaitActivity);

			
			if (sDriverName.equalsIgnoreCase("Android"))
			{
				oDriver.set(new AndroidDriver<MobileElement>(url, caps));
			    //Use a higher value if your mobile elements take time to show up
				oDriver.get().manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
			}

	}
	
	public MobileDriver<MobileElement> getMobileDriver(){
		return oDriver.get();
	}


}
