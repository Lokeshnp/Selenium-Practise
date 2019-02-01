package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: Lokesh Np')]")
	//@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(), 'New Contact')]")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Tasks'])")
	WebElement tasksLink;
	
	//Initializing Page Objects/OR:
		public HomePage(){
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle(){
			return driver.getTitle();
			
		}
		
		public Contacts clickOnContactsLink(){
			contactsLink.click();
			return new Contacts();
		}
		public Deals clickOnDealsLink(){
			dealsLink.click();
			return new Deals();
		}
		public Tasks clickOnTasksLink(){
			tasksLink.click();
			return new Tasks();
		}
		
		public void clickOnNewContactlink(){
			Actions action=new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			newContactsLink.click();
			
			
		}

		public boolean verifyCorrectUserName() {
			// TODO Auto-generated method stub
			return userNameLabel.isDisplayed();
		}

		

}
