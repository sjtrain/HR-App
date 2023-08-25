package com.training.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.training.base.BaseTest;
import com.training.pages.AccountPage;
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;
import com.training.pages.UserMenuPage;

public class LeadsTest extends BaseTest {

	// Webdriver driver
	LoginPage loginpage;// object created for LoginPage
	UserMenuPage usermenupage;// object created for user menu page

	LeadsPage leadspage;

	String url;
	String username;
	String password;
	String loginuserdisplayname;
	String newleadlastname;
	String newleadcompanyname;

	@BeforeMethod
	public void beforemethod() throws InterruptedException {

		driver = getDriver(); // getDriver() defined in BaseTest
		url = getvalue("qaurl");
		driver.get(url);

		username = getvalue("username");
		password = getvalue("password");
		loginuserdisplayname = getvalue("loginuserdisplayname");
		newleadlastname=getvalue("newleadlastname");
		newleadcompanyname=getvalue("newleadcompanyname");

		loginpage = new LoginPage(driver);
		usermenupage = new UserMenuPage(driver);
		leadspage = new LeadsPage(driver);// creating an object of Opportunity page and calling constructor by passing
											// driver

	}

	@Test
	public void testLeadsTab() {

		// 1) Asserting Leads home page is displayed
		loginpage.login(username, password);

		String actualTitle = leadspage.clickOnLeadsTab();
		Assert.assertTrue(actualTitle.contains("Leads"));

	}

	@Test
	public void leadsSelectView() {

		// 1) Asserting Leads home page is displayed
		loginpage.login(username, password);
		String actualTitle = leadspage.clickOnLeadsTab();
		Assert.assertTrue(actualTitle.contains("Leads"));

		// 2)asserting all the drop down elements present
		leadspage.getLeadsDropDownElements();
		Assert.assertTrue(leadspage.getLeadsDropDownElements().containsAll(leadspage.getExpectedLinks()));

	}

	@Test
	public void defaultView() {

		// 1) Asserting Leads home page is displayed
		loginpage.login(username, password);
		String actualTitle = leadspage.clickOnLeadsTab();
		Assert.assertTrue(actualTitle.contains("Leads"));

		// 2)asserting login page displayed after logging out from Leads page
		String loginPageTitle = leadspage.selectViewAndLogout();
		Assert.assertEquals(loginPageTitle, "Login | Salesforce");

		// 3)Asserting application home page is again logged in with correct user name
		loginpage.login(username, password);
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 4)Asserting Leads home page is displayed again
		leadspage.clickOnLeadsTab();
		Assert.assertTrue(driver.getTitle().contains("Leads"));

		// 5)Asserting the previous leads view was selected and clicking Go button will
		// display all its elements
		leadspage.clickOnGo();

	}

	@Test
	public void todaysLead() {

		// 1) Asserting Leads home page is displayed
		loginpage.login(username, password);
		String actualTitle = leadspage.clickOnLeadsTab();
		Assert.assertTrue(actualTitle.contains("Leads"));
		
		//2)asserting todays lead page is displayed
		leadspage.clickOnTodaysLeadDropdownElement();
		
	}
	
	@Test
	public void createNewLead() {

		// 1) Asserting Leads home page is displayed
		loginpage.login(username, password);
		String actualTitle = leadspage.clickOnLeadsTab();
		Assert.assertTrue(actualTitle.contains("Leads"));
		
		//2)
		leadspage.clickOnNewButton();
		
		//3)
		leadspage.enterInToLastName(newleadlastname);
		
		//4)
		leadspage.enterInToCompanyName(newleadcompanyname);
		
		//5)
		leadspage.clickOnSave();
		
	}

	@AfterMethod
	public void aftermethod() {

		driver.quit();
		driver = null;
		// System.out.println("Driver afterMethod "+driver);
	}

}
