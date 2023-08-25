package com.training.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.training.base.BaseTest;
import com.training.pages.LoginPage;

public class LoginTest extends BaseTest {
	
    //Webdriver driver	
	LoginPage loginpage;// object created for LoginPage	
	String url;
	String username;
	String password;
	String ForgotusernameEmail;
	String invalidUsername;
	String invalidPassword;
	
	@BeforeMethod
	public void beforemethod() throws InterruptedException {
		//System.out.println(driver);

		driver = getDriver(); //getDriver() defined in BaseTest		
		url=getvalue("qaurl");
		username=getvalue("username");
		password=getvalue("password");
		ForgotusernameEmail=getvalue("usernameEmail");
		invalidUsername=getvalue("wrongUsername");
		invalidPassword=getvalue("wrongPassword");
		driver.get(url);
		loginpage = new LoginPage(driver);// creating an object of Login page and calling constructor by passing driver(ieLoginPage(driver) is the constructor)

	}

	@Test
	public void testLoginPasswordMissingError() throws InterruptedException  {
		
		loginpage.enterIntoUsername(username); // calling the login page methods using the object created(object is loginpage)
		loginpage.clearPassword();
		loginpage.clickOnLogin();
		
		Assert.assertEquals("Please enter your password.", loginpage.getErrorMessage());
		Thread.sleep(5000);

	}
	
	
	@Test	
	public void testSuccessfullLogin() {
		
		loginpage.enterIntoUsername(username); 
		loginpage.enterIntoPassword(password);
		loginpage.clickOnLogin();
		
		Assert.assertEquals("Home Page ~ Salesforce - Developer Edition", driver.getTitle());
		
	}

	@Test	
	public void testCheckRememberMe() throws InterruptedException {
		
		loginpage.enterIntoUsername(username); 
		loginpage.enterIntoPassword(password);
		loginpage.ClickOnCheckRememberMe();
		loginpage.clickOnLogin();
		loginpage.clickOnUserMenu();
		loginpage.clickOnLogout();
		Thread.sleep(5000);
		
		Assert.assertEquals("march@solutions.com", loginpage.getName());
		
	}
	
	@Test	
	public void testForgotPassword() {
		
		loginpage.ClickOnForgotPassword();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginpage.enterIntoUsernameEmail(ForgotusernameEmail);
		loginpage.ClickOnContinueButton();
		
		Assert.assertEquals("Check Your Email", loginpage.getTextMessage());
	}	
	
	@Test	
	public void testLoginInvalidUsernameAndPassword() {
		loginpage.enterIntoUsername(invalidUsername); 
		loginpage.enterIntoPassword(invalidPassword);
		loginpage.clickOnLogin();
		
		Assert.assertEquals("Please check your username and password. If you still can't log in, contact your Salesforce administrator.", loginpage.getErrorMessage());
	}

	@AfterMethod
	public void aftermethod() {
		
		driver.quit();
		driver=null;
		//System.out.println("Driver afterMethod "+driver);
		
	}
		
}	
	
	



