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

public class CommonLib 
{


	//-----------------------------------------------
	//Define the method for Proxy
	//-----------------------------------------------
	public static Proxy getProxy() throws Exception
	{
		Proxy oProxy = new Proxy();
		String sProxyString = String.format("%s:%d", AutomationConstants.sProxyHostName,AutomationConstants.iProxyPort);

		oProxy.setProxyType(ProxyType.MANUAL);
		oProxy.setHttpProxy(sProxyString);
		oProxy.setSslProxy(sProxyString);

		return oProxy;

	}

	//-----------------------------------------------
	//Define the method of Desired capability of the browsers - javascript = true and set the Proxy for the browser
	//-----------------------------------------------
	public static DesiredCapabilities getCapability() throws Exception
	{
		DesiredCapabilities oCapability = new DesiredCapabilities();
		oCapability.setJavascriptEnabled(true);
		//oCapability.setCapability("proxy", getProxy());

		return oCapability;
	}

	//-----------------------------------------------
	//set InterExplorer options by merging the Desired Capability
	//-----------------------------------------------
	public static InternetExplorerOptions getIEOptions() throws Exception
	{
		InternetExplorerOptions oIEOptions = new InternetExplorerOptions();
		oIEOptions.merge(getCapability());
		oIEOptions.ignoreZoomSettings();
		oIEOptions.introduceFlakinessByIgnoringSecurityDomains();

		return oIEOptions;
	}

	//-----------------------------------------------
	//set ChromeOptions by merging the Desired Capability
	//-----------------------------------------------
	public static ChromeOptions getChromeOptions() throws Exception
	{
		ChromeOptions oChromeOptions = new ChromeOptions();
		oChromeOptions.merge(getCapability());

		return oChromeOptions;
	}

	//-----------------------------------------------
	//set FirefoxOptions by merging the Desired Capability
	//-----------------------------------------------
	public static FirefoxOptions getFirefoxOptions() throws Exception
	{
		FirefoxOptions oFirefoxOptions = new FirefoxOptions();
		oFirefoxOptions.merge(getCapability());

		return oFirefoxOptions;
	}

	//----------------------------------------
	//Define browserId
	//----------------------------------------
	public static int getBrowserId(String sBrowserName) throws Exception
	{
		if (sBrowserName.equalsIgnoreCase("ie")) return 1;
		if (sBrowserName.equalsIgnoreCase("firefox")) return 2;
		if (sBrowserName.equalsIgnoreCase("chrome")) return 3;
		if (sBrowserName.equalsIgnoreCase("htmlunit")) return 4;

		return -1;
	}

	//-------------------------------------------
	//Define getDriver type
	//-------------------------------------------
	//getMobileDriver(sDriverName, platformName, platformVersion, UDID,  appPackage, appActivity, appWaitPackage, appWaitActivity)
	//public static MobileDriver<MobileElement> getMobileDriver(String sDriverName) throws MalformedURLException
	public static MobileDriver<MobileElement> getMobileDriver(String sDriverName, String platformName, String platformVersion, String UDID, String appPackage, String appActivity, String appWaitPackage, String appWaitActivity) throws MalformedURLException
	{
			DesiredCapabilities caps = new DesiredCapabilities();
			MobileDriver<MobileElement> oDriver = null;
					
			//Local Devices
			final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
			//final String URL_STRING = "http://0.0.0.0:4723/wd/hub";
		    URL url = new URL(URL_STRING);
		    
			// we need to define platform name
			//caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		    caps.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
			// Set the device name as well (you can give any name)
			caps.setCapability(MobileCapabilityType.DEVICE_NAME,"MyPhone");
			//Automation MAe for appium
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
			//Appium (default), UiAutomator2
			//Device ID
			//caps.setCapability(MobileCapabilityType.UDID,"89RX0ED00");
			caps.setCapability(MobileCapabilityType.UDID,UDID);
			//ANDROID Version
			//caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);
			//App Name
			
			
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

				oDriver = new AndroidDriver<MobileElement>(url, caps);

			    //Use a higher value if your mobile elements take time to show up
				oDriver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);

			}
			return oDriver;
		
	}
	
	@SuppressWarnings({ "unchecked" })
	public static MobileDriver<MobileElement> getThreadMobileDriver(String sDriverName, String platformName, String platformVersion, String UDID, String appPackage, String appActivity, String appWaitPackage, String appWaitActivity) throws MalformedURLException
	{
			DesiredCapabilities caps = new DesiredCapabilities();
			final ThreadLocal<MobileDriver<MobileElement>> oDriver = new ThreadLocal<MobileDriver<MobileElement>>();
			
			//Local Devices
			final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
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


			
			caps.setCapability("newCommandTimeout",90000);
			
			caps.setCapability("autoGrantPermissions",true);
			caps.setCapability("noReset",true);
			


			caps.setCapability("appPackage",appPackage);
			caps.setCapability("appActivity",appActivity);
			caps.setCapability("appWaitPackage",appWaitPackage);
			caps.setCapability("appWaitActivity",appWaitActivity);

			
			if (sDriverName.equalsIgnoreCase("Android"))
			{
				if(oDriver.get() == null) {
					oDriver.set(new AndroidDriver<MobileElement>(url, caps));

				    //Use a higher value if your mobile elements take time to show up
					oDriver.get().manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
				}

			}
			return oDriver.get();
		
	}


	public static WebDriver getDriver(String sBrowserName) throws Exception
	{
		WebDriver oDriver;

		switch (getBrowserId(sBrowserName))
		{
		case 1:
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+ AutomationConstants.sIEDriverPath);
			oDriver = new InternetExplorerDriver(getIEOptions());
			break;

		case 2:
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+AutomationConstants.sGeckoDriverPath);
			oDriver = new FirefoxDriver(getFirefoxOptions());
			break;

		case 3:
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+AutomationConstants.sChromeDriverPath);
			oDriver = new ChromeDriver(getChromeOptions());
			break;

		default:
			throw new Exception("Unknown browsername =" + sBrowserName +
					" valid names are: ie,firefox,chrome,htmlunit");			
		}


		if (getBrowserId(sBrowserName) != 4)
		{
			oDriver.manage().window().maximize();
		}

		oDriver.manage().deleteAllCookies();
		oDriver.manage().timeouts().pageLoadTimeout(AutomationConstants.lngPageLoadTimeout, TimeUnit.SECONDS);
		oDriver.manage().timeouts().implicitlyWait(AutomationConstants.lngImplicitWaitTimeout, TimeUnit.SECONDS);

		return oDriver;

	}

	//-------------------------------------------
	//Define remoteDriver type
	//-------------------------------------------
	public static WebDriver getRemoteDriver(String sHubUrl, String sBrowserName) throws Exception
	{
		WebDriver oDriver;
		DesiredCapabilities oCapability = getCapability();

		switch (getBrowserId(sBrowserName)) 
		{
		case 1:
			oCapability.setBrowserName("internet explorer");
			break;

		case 2:
			oCapability.setBrowserName("firefox");
			break;

		case 3:
			oCapability.setBrowserName("chrome");
			break;

		case 4:
			oCapability.setBrowserName("htmlunit");

		default:
			throw new Exception("Unknown browsername = " + sBrowserName +
					"  Valid names are: ie,firefox,chrome,htmlunit");
		}

		oCapability.setPlatform(Platform.WINDOWS);

		oDriver = new RemoteWebDriver(new URL(sHubUrl), oCapability);

		if (getBrowserId(sBrowserName) != 4)
		{
			oDriver.manage().window().maximize();
		}


		oDriver.manage().deleteAllCookies();
		oDriver.manage().timeouts().pageLoadTimeout(AutomationConstants.lngPageLoadTimeout, TimeUnit.SECONDS);
		oDriver.manage().timeouts().implicitlyWait(AutomationConstants.lngImplicitWaitTimeout, TimeUnit.SECONDS);

		return oDriver;
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//This method is used to perform Send Keys after validation
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static boolean sendKeys(WebDriver oDriver, By identifier, String text){
		if(oDriver.findElements(identifier).size() > 0) {
			WebElement oElement = oDriver.findElement(identifier);
			if(oElement.isDisplayed() && oElement.isEnabled()) {
				oElement.sendKeys(text);
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//This method is used to set a particular attribute using JavaScript
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static boolean setAttribute(WebDriver oDriver, By identifier, String attribute, String value){
		if(oDriver.findElements(identifier).size() > 0) {
			WebElement oElement = oDriver.findElement(identifier);
			if(oElement.isDisplayed() && oElement.isEnabled()) {
				JavascriptExecutor jsExec = (JavascriptExecutor)oDriver;
				jsExec.executeScript("arguments[0].setAttribute('" + attribute + "','" + value + "')",oElement);
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//This method is used to validate if an element is visible
	//Make sure the same method is used throughout the pages classes as well as other generic methods  
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static boolean checkElementVisibility(WebDriver oDriver, By identifier) {
		boolean res = false;
		
		if(oDriver.findElements(identifier).size() > 0) {
			if(oDriver.findElement(identifier).isDisplayed()) {
				res = true;
			}else {
				return false;
			}
		}
		
		return res;
	}
	
	public static boolean checkElementDisplayed(WebDriver oDriver, By identifier)
	{
		boolean status = false;
		oDriver.manage().timeouts().implicitlyWait(AutomationConstants.lngImplicitWaitTimeout, TimeUnit.SECONDS);
		try
		{
			if(oDriver.findElement(identifier).isDisplayed()) {
				status = true;
			}
		}
		catch (NoSuchElementException e) {
			System.out.println("Element not found");
		}
		return status;
	}

}
