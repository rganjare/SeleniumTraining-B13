package com.bymatAutomation.modulename.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.bymatAutomation.modulename.pages.HomePage;
import com.bymatautomation.seleniumtraining.DataCollection;
import com.bymatautomation.seleniumtraining.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {  /// Heart or Engine of the Framework
	
	
	public static WebDriver driver;
	
	//public static String browser; // Configuration 
	
	public static FileInputStream fis;
	public static Properties config;
	public static Wait<WebDriver> f_wait;
	public static ExcelReader excel;
	public static HomePage hp;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static String testCaseName;
	public static Hashtable<String, String> run_mode = new Hashtable<>();

	//public static WebDriverManager wdm;
	@BeforeSuite // Before Test case Suite execution -- 350, 500, 700
	public static void setup()  {
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")
					+"\\src\\test\\resources\\propertiesFiles\\Config.properties");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		//Properties config = new Properties();
		config = new Properties();
		try {
			config.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		System.out.println("Config file has been loaded");
		
		excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		reports = new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\resources\\executionReports\\ExtentReportResults_"+timeStamp+".html");
		
		loadRunModeHashtable();
	}
	
	
	public static void getDriver() {
		
		if(config.getProperty("browser").equalsIgnoreCase("Chrome")) {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();  	// Sel 4.0
		    driver = new ChromeDriver(ops);
		} else if(config.getProperty("browser").equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		} else if(config.getProperty("browser").equalsIgnoreCase("FF")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			
			driver = new EdgeDriver(); // Default Action
		}
		
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000)); // Selenium-server Jar
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		driver.get(config.getProperty("app_url_test"));
		
		test = reports.startTest(testCaseName);
		
		System.out.println("User Navigated to "+config.getProperty("app_url_test")+" URL");
		test.log(LogStatus.INFO, "User Navigated to "+config.getProperty("app_url_test")+" URL");
		
		hp = new HomePage();
		
	}
	
	public static void teardown() {
		try {
			Thread.sleep(2000);
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void takeaScreenShot() {
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenShotPath = System.getProperty("user.dir") +"\\src\\test\\resources\\screenShots\\screenshot_"+timeStamp+".png";
		
	//	File destfile = new File(screenShotPath);
	
		try {
			FileHandler.copy(scrFile, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
	}
	
	
		public static void loadRunModeHashtable() {
		
		int rows = excel.getRowCount("Test_Cases");
		
		for(int i = 2; i<=rows ; i++) {
		
		String key = excel.getCellData("Test_Cases", "TestCaseName", i);
		
		String value = excel.getCellData("Test_Cases", "Run_Mode", i);
		
		run_mode.put(key, value);
		}
		
		System.out.println("HashTable Run Mode :- " +run_mode);
	}
	
	
	
	@DataProvider
	public Object[][] data_Collection() {
		
		DataCollection dc = new DataCollection(excel, "Test_Data", testCaseName);
			
		return dc.dataArray();
		
	}
	
	@AfterSuite
	public static void endTest()
	{
	reports.endTest(test);
	reports.flush();
	}

}
