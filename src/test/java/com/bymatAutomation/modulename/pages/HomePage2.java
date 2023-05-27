package com.bymatAutomation.modulename.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bymatAutomation.modulename.testbase.TestBase;

public class HomePage2 extends TestBase {
	
	//Xpaths -- a concept of Page Factory in POM framework
	public HomePage2() {
	      // this.driver = web_driver;
	       /* Initialize Elements */
	       PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText ="REGISTER")
	private WebElement register_menu_element;
	
	@FindBy(xpath = "//*[@rel =\"home\"][1]")
	private WebElement home_logo;
	
	@FindBy(xpath = "//*[text()=\"About us\"][1]")
	private WebElement about_us;
	
	@FindBy(linkText ="Reviews")
	private WebElement review;
	
	//@FindBy(className = "")
	
	//@FindBy(partialLinkText = "")
	
	//@FindBy(css = "")
	
	
	public void verifyHomePage() throws InterruptedException {
		
		about_us.click();
		Thread.sleep(2000);
		
		review.click();
		Thread.sleep(2000);
		
		home_logo.click();
		Thread.sleep(2000);
		
	}

}
