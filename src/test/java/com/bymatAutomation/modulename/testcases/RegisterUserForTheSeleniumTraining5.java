package com.bymatAutomation.modulename.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bymatAutomation.modulename.testbase.TestBase;

public class RegisterUserForTheSeleniumTraining5 extends TestBase {

	@BeforeClass
	public void isSkip() {
		
		testCaseName = this.getClass().getSimpleName();
		 System.out.println("testCaseName is :-" +testCaseName);		  
		  if(run_mode.get(testCaseName).equalsIgnoreCase("Y"))
		  System.out.println("Executing Test Case:- " +testCaseName); 
		  
		  else throw new SkipException("Skipping Test case "+testCaseName+" as it's run mode is set to No");
	}
	
	@Test (dataProvider = "data_Collection")
	public static void registerUserForTheSeleniumTraining5(Hashtable<String, String> htData) throws InterruptedException { // Test Step and Verification Points 	

	hp.navigateToInquireRegisterPage().enterUserDetails(htData).verifypage();
	
	// Adding new Step to the Test case

	}
	
	
}
