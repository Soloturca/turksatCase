package com.saf.framework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.util.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.saf.framework.AutomationConstants;
import com.saf.framework.DataDriver;
import com.saf.framework.HashMapNew;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;

public class MyTestNGBaseClass {
	
	//public static WebDriver oDriver;
	public static MobileDriver<MobileElement> oDriver;
	//public static ThreadLocal<MobileDriver<MobileElement>> oDriver;
	public static ExtentReports oExtentReport;
	public static ExtentTest oExtentTest;
	public static int ssNumber;
	public static String reportPath;
	public static boolean dbFlag;
	public static int testCaseId = 0;
	public static String sDriverName = "";
	public static String className = "";
	DataDriver oDataDriver = new DataDriver();
	HashMap<String, HashMap<String, String>> myMap = new HashMap<String, HashMap<String,String>>();
	protected static HashMapNew dataMap = new HashMapNew();
	static HashMapNew keysMap = new HashMapNew();
	
	@Parameters({"PLATFORM_NAME","PLATFORM_VERSION","UDID","appPackage", "appActivity", "appWaitPackage", "appWaitActivity", "URL"})
	@BeforeSuite
	//@BeforeTest
	public void BeforeSuite(@Optional("")String platformName, @Optional("")String platformVersion, @Optional("")String UDID, @Optional("")String appPackage, @Optional("")String appActivity, @Optional("")String appWaitPackage, @Optional("")String appWaitActivity, @Optional("")String URL) throws Throwable{
	//public void BeforeSuite() throws Throwable{
		reportPath = "Report_" + new Date().getDate() + "-" + (new Date().getMonth() + 1) + "-" + new Date().getHours() + "-" + new Date().getMinutes() + "-" + new Date().getSeconds();
		File f = new File("Reports/" + reportPath);
		File ss = new File("Reports/" + reportPath + "/Screenshots");
		try{
			f.mkdir();
			ss.mkdir();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		oExtentReport = new ExtentReports("Reports/" + reportPath + "/TestSuiteReport.html", true);
		oExtentReport.loadConfig(new File("config.xml"));
		ssNumber=0;
		
		//oDriver = CommonLib.getMobileDriver("Android");
		if (platformName.equalsIgnoreCase("Android")) {
			sDriverName = "Android";
		}
		else {
			sDriverName = "iOS";
		}
		
		oDriver = CommonLib.getMobileDriver(sDriverName, platformName, platformVersion, UDID,  appPackage, appActivity, appWaitPackage, appWaitActivity);
		//oDriver = CommonLib.getThreadMobileDriver(sDriverName, platformName, platformVersion, UDID,  appPackage, appActivity, appWaitPackage, appWaitActivity);
		/*DriverFactory driverFactory =  DriverFactory.getInstance();
		driverFactory.setMobileDriver(sDriverName, platformName, platformVersion, UDID,  appPackage, appActivity, appWaitPackage, appWaitActivity, URL);
		oDriver = driverFactory.getMobileDriver();*/
	}
	
	//********************************************************
	//preconditions
	//********************************************************
	
 /*	@Parameters({"CalendarName","BrowserToOpen","AppUrl","TestName"})
	@BeforeClass
	public void automationSetup(@Optional("")String calendarName, @Optional("") String sBrowserName,@Optional("") String sUrl,@Optional("") String sTestName) throws Exception
	{
		dbFlag = false;
		//myMap = oDataDriver.getData();
		//To fetch input data from calendar 
		myMap = DataDriver.getData(calendarName, this.getClass().getSimpleName().toString(),sTestName);
		
		//dataMap has final input data
		dataMap = fConvertHashToHashNew(myMap.get("Dictionary"));
		//keysMap has keywords to be written in KR
		keysMap = fConvertHashToHashNew(myMap.get("KeysToWrite"));
			
		if(sBrowserName.equals("") || sUrl.equals("") ) {
			dbFlag = true;
		}else {
			oDriver = CommonLib.getDriver(sBrowserName);
			oDriver.get(sUrl);
		}
		
		//oDriver = CommonLib.getRemoteDriver("http://192.168.228.2:4444/wd/hub", sBrowserName);
		Thread.sleep(6000);
	}
	
	*/
	
	@Parameters({"CalendarName", "TestName"})
	@BeforeClass
	public void automationSetup(@Optional("")String calendarName, @Optional("") String sTestName) throws Exception
	{
		// passing className to read from excel file
		
		/*StackTraceElement[] completeClassName = new Exception().getStackTrace();
		for (StackTraceElement e : completeClassName) {
			System.out.println(e);
		}*/
		//className = completeClassName.split("\\.")[completeClassName.split("\\.").length - 1];
		
	/*	System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName());
		
		System.out.println(Thread.currentThread().getStackTrace()[2].getFileName());*/
		//
		
		dbFlag = false;
		//myMap = oDataDriver.getData();
		//To fetch input data from calendar 
		myMap = DataDriver.getData(calendarName, this.getClass().getSimpleName().toString(),sTestName);
		//myMap = DataDriver.getData(calendarName, this.getClass().getSimpleName().toString(),className);
		
		//dataMap has final input data
		dataMap = fConvertHashToHashNew(myMap.get("Dictionary"));
		
		//keysMap has keywords to be written in KR
		keysMap = fConvertHashToHashNew(myMap.get("KeysToWrite"));
				
		//oDriver = CommonLib.getRemoteDriver("http://192.168.228.2:4444/wd/hub", sBrowserName);
		Thread.sleep(6000);
		
	}
	
	
	/*public void automationSetup(String sTestName) throws InterruptedException {
				//To fetch input data from calendar 
				myMap = DataDriver.getData("Calendar.xlsx", this.getClass().getSimpleName().toString(),sTestName);
				//myMap = DataDriver.getData(calendarName, this.getClass().getSimpleName().toString(),className);
				
				//dataMap has final input data
				dataMap = fConvertHashToHashNew(myMap.get("Dictionary"));
				
				//keysMap has keywords to be written in KR
				keysMap = fConvertHashToHashNew(myMap.get("KeysToWrite"));
						
				//oDriver = CommonLib.getRemoteDriver("http://192.168.228.2:4444/wd/hub", sBrowserName);
				Thread.sleep(6000);
	}*/
	@Parameters({"VIDEO_RECORDING"})
	@BeforeMethod
	public void startRecording(@Optional("")String VIDEO_RECORDING) throws Exception
	{
		if (VIDEO_RECORDING.equalsIgnoreCase("true")) {
			//if video recording is required
			//start recording the video of execution
			//((CanRecordScreen) oDriver).startRecordingScreen();
			
			((CanRecordScreen) oDriver).startRecordingScreen(new AndroidStartScreenRecordingOptions().enableBugReport());
			//((CanRecordScreen) oDriver).startRecordingScreen(new AndroidStartScreenRecordingOptions().withVideoSize(""));
		}
	}
	
	@Parameters({"VIDEO_RECORDING"})
	@AfterMethod
	public void stopRecording(@Optional("")String VIDEO_RECORDING, ITestResult result) throws Exception
	{
		if (VIDEO_RECORDING.equalsIgnoreCase("true")) {
			//Stop recording and convert to .mp4 file
			String media = ((CanRecordScreen) oDriver).stopRecordingScreen();
			
			File video = new File("Reports/" + reportPath + "/Videos");
			
			if(!video.exists()) {
				video.mkdirs();
			}
			
			FileOutputStream stream = new FileOutputStream(video + "/" + result.getName() + ".mp4");
			stream.write(Base64.decodeBase64(media));
		}
		
	}
	//********************************************************
	//End of execution
	//********************************************************
	@AfterClass
	public void automationTeardown() throws Exception
	{
	  /*	if(!dbFlag) {
			oDriver.quit();
		}
	  */	
		//DataDriver oDataDriver = new DataDriver();
		oDataDriver.fWriteKeepRefer(AutomationConstants.testDataPath + "Calendar.xlsx", keysMap, dataMap);
		testCaseId = 0;
		
	}
	
		
	@AfterSuite
//	@AfterTest
	public void afterSuite()  throws Throwable{
		oExtentReport.endTest(oExtentTest);
		oExtentReport.flush();
		
		//EmailReporting.sendMail();
		oDriver.quit();
		//oDriver.remove();
	}


	public static HashMapNew fConvertHashToHashNew(HashMap<String, String> hashOld) {
		
		try {
			HashMapNew hashNew = (HashMapNew)hashOld;
			return hashNew;
		}
		catch(Exception e){
			return null;
		}
		
		
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//This method is used to add a reporting event to the Extent Report for the test running
	//Params: 
	//status - Used to mark the status of the step in the test case
	//message - Test Step description
	//ssFlag - Flag for Screenshot
	//Note: Screenshots are always taken in case a failure is reported in the step
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static boolean reportResult(String status, String message, boolean ssFlag){
		try {
			String dest = "";
			if(ssFlag) {
				ssNumber++;
				TakesScreenshot ts = (TakesScreenshot)oDriver;
		        File source = ts.getScreenshotAs(OutputType.FILE);
		        dest = System.getProperty("user.dir") + "/Reports/" + reportPath + "/Screenshots/" + ssNumber + ".png";
		        File destination = new File(dest);
		        FileUtils.copyFile(source, destination);
			}
			
	        
	        if(status.equalsIgnoreCase("PASS")) {
	        	if(ssFlag) {
	        		oExtentTest.log(LogStatus.PASS, message + "\n" + oExtentTest.addScreenCapture(dest));
	        	}else {
	        		oExtentTest.log(LogStatus.PASS, message);
	        	}
	        	//DBReporting.insertExecutionDetailsIntoDB(testCaseId, "PASS", message, className, System.getProperty("user.name"));
			}else if(status.equalsIgnoreCase("FAIL")) {
				if(ssFlag) {
					oExtentTest.log(LogStatus.FAIL, message + "\n" + oExtentTest.addScreenCapture(dest));
	        	}else {
	        		oExtentTest.log(LogStatus.FAIL, message);
	        	}
				//DBReporting.insertExecutionDetailsIntoDB(testCaseId, "FAIL", message, className, System.getProperty("user.name"));
			}else {
				if(ssFlag) {
					oExtentTest.log(LogStatus.INFO, message + "\n" + oExtentTest.addScreenCapture(dest));
	        	}else {
	        		oExtentTest.log(LogStatus.INFO, message);
	        	}
				//DBReporting.insertExecutionDetailsIntoDB(testCaseId, "INFO", message, className, System.getProperty("user.name"));
			}
	        //oExtentTest.log(LogStatus.INFO, oExtentTest.addScreenCapture(dest));
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
        
        return true;
    }
	
	public static boolean startTest() {
		String completeClassName = new Exception().getStackTrace()[1].getClassName();
		className = completeClassName.split("\\.")[completeClassName.split("\\.").length - 1];
		oExtentTest = oExtentReport.startTest(className);
		//MyTestNGBaseClass.
		//Create entry in the Test Execution table for the test started
		//testCaseId = DBReporting.insertExecutionRecord(className);
		//testCaseId = DBReporting.insertExecutionRecordInGrafana(className);
		//AutomationConstants.itestCaseID = testCaseId;
		
		return true;
	}
	
	
	
}
