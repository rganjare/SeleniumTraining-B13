package com.bymatAutomation.modulename.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bymatAutomation.modulename.commonmethods.CommonMethods;
import com.bymatAutomation.modulename.testbase.TestBase;

public class HomePage extends TestBase {
	
	public HomePage() {
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
	
	@FindBy(xpath = "//*[@id=\"menu-item-3130\"]")       
	//private By about_us;
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
	//private By selenium_btn;
	
	
	
	public HomePage verifyHomePageTitle() { // Non Static Method 
		// I need to create Object of this class to access Non Static method
		
//		System.out.println(driver.getTitle()); 
//		
//		Assert.assertEquals(driver.getTitle(), "BYMAT Automation - Boost your Mind with Automation Technology");
		
		CommonMethods.getPageTitle("BYMAT Automation - Boost your Mind with Automation Technology");
		return this;
			
	}
	
	public HomePage verifyHomePageLinksTextAndButtons() throws InterruptedException { // Non Static Method 
		// I need to create Object of this class to access Non Static method
		
//		about_us.isDisplayed();
//		about_us.click();
		
		CommonMethods.clickSelectCheckBoxAndRedioButton(about_us, "User clicked on about_us");
		
		return this;
		
	}

	public SeleniumAndCucumberPage clickOnSeleniumButtons() throws InterruptedException { // Non Static Method 
		// I need to create Object of this class to access Non Static method
		
		CommonMethods.clickSelectCheckBoxAndRedioButton(hp_logo, "User clicked on about_us");
	//	hp_logo.click();
	//	Thread.sleep(2000);
		CommonMethods.clickSelectCheckBoxAndRedioButton(selenium_btn, "User clicked on selenium_btn");
	//	selenium_btn.isDisplayed();
	//	selenium_btn.click();
		
		return new SeleniumAndCucumberPage();
		
	}
	
	public InquireRegisterPage navigateToInquireRegisterPage() { // Non Static Method 
		// I need to create Object of this class to access Non Static method
		//takeaScreenShot();
		CommonMethods.clickSelectCheckBoxAndRedioButton(inquryRegister, "User clicked on inquryRegister page");
	//	inquryRegister.isDisplayed();
	//	inquryRegister.click();
		
		return new InquireRegisterPage();
		
	}
	
	
 // POM Concept -- Whichever method is taking control to next page, that method should be responsible to return the 
	//		            object of that page (Where my control goes)		

}

