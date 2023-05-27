package com.bymatAutomation.modulename.pages;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bymatAutomation.modulename.commonmethods.CommonMethods;
import com.bymatAutomation.modulename.testbase.TestBase;

public class InquireRegisterPage extends TestBase {
	
	public InquireRegisterPage() {
	      /* Initialize Elements */
		PageFactory.initElements(driver, this);
		
	}
	
//Xpaths -- a concept of Page Factory in POM framework
//	@FindBy(name = "")
//	@FindBy(id = "")
//	@FindBy(className = "")
//	@FindBy(linkText = "")
//	@FindBy(partialLinkText = "")
//	@FindBy(css = "")
	
	@FindBy(xpath = "//*[@id=\"navigation\"]/div/div[1]/div/div/div[1]/div/div/div/a")       
	//private By hp_logo;
	private WebElement hp_logo;
	
	@FindBy(xpath = "//*[@id=\"wpforms-1830-field_0\"]")       
	private WebElement firstName;
	
	@FindBy(xpath = "//*[@id=\"wpforms-1830-field_1\"]")
	private WebElement emailAddress;
	
	@FindBy(xpath = "//*[@id=\"wpforms-1830-field_7\"]")
	private WebElement phoneNumber;
	
	@FindBy(xpath = "//*[@id=\"wpforms-1830-field_10_1\"]")
	private WebElement seleniumCheckBox;
	
	@FindBy(xpath = "//*[@id=\"wpforms-1830-field_10_2\"]")
	private WebElement devOpsCheckBox;
	
	@FindBy(xpath = "//*[@id=\"wpforms-1830-field_2223323\"]")
	private WebElement message;
	
	@FindBy(xpath = "//*[@id=\"wpforms-submit-1830\"]")
	private WebElement submit_btn;
	
	
	public InquireRegisterPage verifyHomePageTitle() { // Non Static Method 
		// I need to create Object of this class to access Non Static method
		
		System.out.println(driver.getTitle()); 
		
		Assert.assertEquals(driver.getTitle(), "BYMAT Automation - Boost your Mind with Automation Technology");
		
		return this;
			
	}
	
	public InquireRegisterPage enterUserDetails(Hashtable<String, String> htData) throws InterruptedException { // Non Static Method 
		// I need to create Object of this class to access Non Static method
		
//		firstName.isDisplayed();
//		firstName.sendKeys("FirstName");
//		
//		emailAddress.isDisplayed();
//		emailAddress.sendKeys("test@test.com");
//		
//		phoneNumber.isDisplayed();
//		phoneNumber.sendKeys("1234567892");
//		
//		seleniumCheckBox.isDisplayed();
//		seleniumCheckBox.click();
//		
//		message.isDisplayed();
//		message.sendKeys("Enter message");
//		
//		submit_btn.isDisplayed();
//		submit_btn.click();
		
		CommonMethods.enterDataToInputBox(firstName, htData.get("First_Name"), "First Name entered");
		CommonMethods.enterDataToInputBox(emailAddress, htData.get("Email_ID"), "Email Address entered");
		CommonMethods.enterDataToInputBox(phoneNumber,  htData.get("Phone_No"), "Enter phone number");
		
		CommonMethods.clickSelectCheckBoxAndRedioButton(seleniumCheckBox, "Selenium Check box is clicked");
		
		CommonMethods.enterDataToInputBox(message, htData.get("Message"), "Message has been enter");
		
		//takeaScreenShot();
		CommonMethods.clickSelectCheckBoxAndRedioButton(submit_btn, "submit_btn is clicked");
		//takeaScreenShot();
		
		return this;
		
	}

	
	

}

