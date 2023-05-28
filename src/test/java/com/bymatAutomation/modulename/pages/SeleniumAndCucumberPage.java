package com.bymatAutomation.modulename.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bymatAutomation.modulename.testbase.TestBase;

public class SeleniumAndCucumberPage extends TestBase {
	
	public SeleniumAndCucumberPage() {
		
		PageFactory.initElements(driver, this);
	}
	
//Xpaths -- a concept of Page Factory in POM framework
//	@FindBy(name = "")
//	@FindBy(id = "")
//	@FindBy(className = "")
//	@FindBy(linkText = "")
//	@FindBy(partialLinkText = "")
//	@FindBy(css = "")
	
	@FindBy(xpath = "//*[@id=\"menu-item-3130\"]")       
	private WebElement about_us;
	
	@FindBy(xpath = "//*[@id=\"menu-item-1743\"]")
	private WebElement training;
	
	@FindBy(xpath = "//*[@id=\"menu-item-1743\"]")
	private WebElement reviews;
	
	@FindBy(xpath = "//*[@id=\"menu-item-1870\"]")
	private WebElement inquryRegister;
	
	@FindBy(xpath = "//*[@id=\"menu-item-2439\"]")
	private WebElement feedback;
	
	@FindBy(xpath = "//*[@id=\"menu-item-111\"]")
	private WebElement contact_Us;
	
	@FindBy(xpath = "//*[text()=\"Selenium\"]")
	private WebElement selenium_btn;
	
	@FindBy(xpath = "//*[text()=\"Selenium\"]")
	private WebElement selenium_btn11;
	
	
	public void verifyHomePageTitle() { // Non Static Method 
		// I need to create Object of this class to access Non Static method
		
		System.out.println(driver.getTitle()); 
		
	//	Assert.assertEquals(driver.getTitle(), "BYMAT Automation - Boost your Mind with Automation Technology");
			
	}
	
	public void verifyHomePageLinksTextAndButtons() { // Non Static Method 
		// I need to create Object of this class to access Non Static method
		
		about_us.isDisplayed();
		about_us.click();
		
	}

	public void clickOnSeleniumButtons() { // Non Static Method 
		// I need to create Object of this class to access Non Static method
		
		selenium_btn.isDisplayed();
		selenium_btn.click();
		
	}
}
