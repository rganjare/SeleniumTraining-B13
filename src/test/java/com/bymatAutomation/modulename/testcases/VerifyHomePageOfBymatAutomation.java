package com.bymatAutomation.modulename.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bymatAutomation.modulename.testbase.TestBase;
import com.relevantcodes.extentreports.ExtentTest;

public class VerifyHomePageOfBymatAutomation extends TestBase {

//	@BeforeMethod
//	public static void launchBrowser() {
//		
//		getDriver();
//	}

	@BeforeClass
	public void isSkip() {

		testCaseName = this.getClass().getSimpleName();
		
		 // System.out.println("testCaseName is :-" +testCaseName);
		  
		  if(run_mode.get(testCaseName).equalsIgnoreCase("Y")) {
		  System.out.println("Executing Test Case:- " +testCaseName); 
		  }
		  else throw new SkipException("Skipping Test case "+testCaseName+" as it's run mode is set to No");
		 
	}

	@Test(dataProvider = "data_Collection")
	public static void verifyHomePageOfBYMATAutomation(Hashtable<String, String> htData) throws InterruptedException { // Test
																														// Step
																														// and
																														// Verification
																													// Points

		// test = reports.startTest("VerifyHomePageOfBymatAutomation");

//		HomePage hp = new HomePage();
//		
//		hp.verifyHomePageTitle();         // VerifY user landed on XYZ website or Page // Input Base line Document
//		
//		hp.verifyHomePageLinksTextAndButtons(); // Verify user should be able to see So button's, Links, Text  
//		
//		hp.clickOnSeleniumButtons();      // Click on Selenium button
//		
//		SeleniumAndCucumberPage sac = new SeleniumAndCucumberPage();
//		
//		sac.verifyHomePageTitle();     /// User should be redirected to Selenium and Cucumber page 	
//		sac.clickOnSeleniumButtons();

		hp.verifyHomePageTitle().verifyHomePageLinksTextAndButtons().clickOnSeleniumButtons();

		// driver.manage().window().maximize(); // Sel Dev // POM -- Object chaining
		// concept

	}

//	@AfterMethod
//	public static void quitDriver() {
//		teardown();
//	}

	// 500*9 = 4500
}
