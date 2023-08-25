package com.training.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.training.base.BaseTest;
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;
import com.training.pages.UserMenuPage;

public class OpportunityTest extends BaseTest {

	// Webdriver driver
	LoginPage loginpage;// object created for LoginPage
	UserMenuPage usermenupage;// object created for user menu page
	OpportunityPage opportunitypage;

	String url;
	String username;
	String password;
	String loginuserdisplayname;

	@BeforeMethod
	public void beforemethod() throws InterruptedException {

		driver = getDriver(); // getDriver() defined in BaseTest
		url = getvalue("qaurl");
		driver.get(url);

		username = getvalue("username");
		password = getvalue("password");
		loginuserdisplayname = getvalue("loginuserdisplayname");

		loginpage = new LoginPage(driver);
		usermenupage = new UserMenuPage(driver);
		opportunitypage = new OpportunityPage(driver);// creating an object of Opportunity page and calling constructor
														// by passing driver

	}

	@Test
	public void opportunityDropdown() {

		// 1) Asserting application home page is logged in with correct user name
		loginpage.login(username, password);
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 2)Asserting opportunity home page is displayed
		opportunitypage.clickOnOpportunityLink();
		Assert.assertEquals(driver.getTitle(), "Opportunities: Home ~ Salesforce - Developer Edition");

		// 3)asserting all the drop down elements present
		opportunitypage.getOpportunityDropDownItems();
		Assert.assertTrue(
				opportunitypage.getOpportunityDropDownItems().containsAll(opportunitypage.getExpectedLinks()));
	}

	@Test
	public void newOpportunity() {

		// 1) Asserting application home page is logged in with correct user name
		loginpage.login(username, password);
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 2)Asserting opportunity home page is displayed
		opportunitypage.clickOnOpportunityLink();
		Assert.assertEquals(driver.getTitle(), "Opportunities: Home ~ Salesforce - Developer Edition");

		// 3)
		opportunitypage.createNewOpportunity();

	}

	@Test
	public void opportunityPipelineReport() {

		// 1) Asserting application home page is logged in with correct user name
		loginpage.login(username, password);
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 2)Asserting opportunity home page is displayed
		opportunitypage.clickOnOpportunityLink();
		Assert.assertEquals(driver.getTitle(), "Opportunities: Home ~ Salesforce - Developer Edition");

		// 3)Asserting Report Page with the Opportunities that are pipelined will be
		// displayed.
		String actualTitle = opportunitypage.clickOnOpportunityPipeline();
		Assert.assertTrue(actualTitle.contains("Opportunity Pipeline"));

	}

	@Test
	public void stuckOpportunityReport() {

		// 1) Asserting application home page is logged in with correct user name
		loginpage.login(username, password);
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 2)Asserting opportunity home page is displayed
		opportunitypage.clickOnOpportunityLink();
		Assert.assertEquals(driver.getTitle(), "Opportunities: Home ~ Salesforce - Developer Edition");

		// 3)Asserting Report Page with the Opportunities that are stuck will be
		// displayed.
		String actualTitle = opportunitypage.clickOnStuckOpportunity();
		Assert.assertTrue(actualTitle.contains("Stuck Opportunities"));

	}

	@Test
	public void quaterlySummaryReport() {

		// 1) Asserting application home page is logged in with correct user name
		loginpage.login(username, password);
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 2)Asserting opportunity home page is displayed
		opportunitypage.clickOnOpportunityLink();
		Assert.assertEquals(driver.getTitle(), "Opportunities: Home ~ Salesforce - Developer Edition");

		// 3)Asserting Report Page with the Opportunities that satisfies the search
		// criteria will be displayed.
		String actualTitle = opportunitypage.testQuaterlySummaryReport();
		Assert.assertTrue(actualTitle.contains("Opportunity Report"));

	}

	@AfterMethod
	public void aftermethod() {

		driver.quit();
		driver = null;
		// System.out.println("Driver afterMethod "+driver);

	}
}
