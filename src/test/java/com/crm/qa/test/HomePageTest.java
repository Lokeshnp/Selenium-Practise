package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	Contacts contacts;
	
	public HomePageTest(){
		super();
	}
	
	
	
    @BeforeMethod
	public void setUp(){
		initialization();
		contacts=new Contacts();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
 
	   
	}
    	@Test(priority=1)
	   public void verifyHomePageTitleTest(){		
		String homePageTitle=homePage.verifyHomePageTitle();
		
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}
	
    	@Test(priority=2)
    	public void verifyUserNameTest(){
    		testUtil.switchToFrame();
    		Assert.assertTrue(homePage.verifyCorrectUserName());
    	}
    	
    	@Test(priority=3)
    	public void verifyContactLinkText(){
    		testUtil.switchToFrame();
    		contacts = homePage.clickOnContactsLink();
    	}
	
	     @AfterMethod
	    public void tearDown(){
	    	driver.quit();
	    }
	
}
