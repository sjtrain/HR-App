package com.training.testcases;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.base.BaseTest;
import com.training.pages.AccountPage;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuPage;

public class AccountTest extends BaseTest {

	// WebDriver driver;
	LoginPage loginpage;// object created for LoginPage
	UserMenuPage usermenupage;// object created for usermenupage
	AccountPage accountpage;

	String url;
	String username;
	String password;
	String accountname;
	String viewname;
	String newviewname;
	String loginuserdisplayname;
	String selectviewname;

	@BeforeMethod
	public void beforemethod() throws InterruptedException {

		driver = getDriver(); // getDriver() defined in BaseTest
		url = getvalue("qaurl");
		driver.get(url);

		username = getvalue("username");
		password = getvalue("password");
		accountname = getvalue("accountname");
		viewname = getvalue("viewname");
		newviewname = getvalue("newviewname");
		loginuserdisplayname = getvalue("loginuserdisplayname");
		selectviewname = getvalue("selectviewname");

		loginpage = new LoginPage(driver); // creating an object of Login page and calling constructor by passing driver
		usermenupage = new UserMenuPage(driver);
		accountpage = new AccountPage(driver);
	}

	@Test
	public void createAccount() {

		// 1) Asserting aapln home page is logged in with correct username
		loginpage.login(username, password);
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 2)Asserting accountpage is displayed with correct username
		accountpage.clickOnAccounts();
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 3)Asserting new account page displayed with correct account details
		// by checking the new created account name is displayed
		String actualAccName = accountpage.createNewAccount(accountname);
		Assert.assertEquals(accountname, actualAccName);

	}

	@Test
	public void createView() {

		// 1) Asserting aapln home page is logged in with correct username
		loginpage.login(username, password);
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 2)Asserting account page is displayed with correct username
		accountpage.clickOnAccounts();
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 3) Asserting newly added View should be displayed in the account view list
		String actualAccViewName = accountpage.createNewView(viewname);
		Assert.assertEquals(viewname, actualAccViewName);

	}

	@Test
	public void editView() {

		// 1)Asserting aapln home page is logged in with correct username
		loginpage.login(username, password);
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 2)Asserting account page is displayed with correct username
		accountpage.clickOnAccounts();
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 3)Asserting edit view page with the selected view name to edit is displayed
		String actualDisplayViewName = accountpage.selectViewName(selectviewname);
		Assert.assertEquals(selectviewname, actualDisplayViewName);

		// 4)a)Asserting the view name displayed in drop down as default is same as the viewname we
		// changed
		accountpage.changeViewName(newviewname);
		String selectedview = accountpage.checkDisplayViewName();
		Assert.assertEquals(newviewname, selectedview); 

		// b)Asserting all the acc names displayed contains "a"
		List<String> accountNames = accountpage.getAccNames();
		boolean flag = listContainsCharacter(accountNames, "a");
		//Assert.assertTrue(flag);

		// c)Asserting Last activity column added
		accountpage.checkLastColumnAdded();

	}

	@Test
	public void mergeAccounts() {

		// 1)Asserting aapln home page is logged in with correct user name
		loginpage.login(username, password);
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 2)Asserting account page is displayed with correct user name
		accountpage.clickOnAccounts();
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 3)Asserting Step2 page is displayed
		String mergeAccountTitle = accountpage.findAccountsToMerge();
		Assert.assertTrue(mergeAccountTitle.contains("Step 2"));

		// 4)Asserting new merged account is displayed
		accountpage.clickOnMerge();
	}

	@Test
	public void createAccountReport() {
		// 1)Asserting aapln home page is logged in with correct user name
		loginpage.login(username, password);
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());

		// 2)Asserting account page is displayed with correct user name
		accountpage.clickOnAccounts();
		Assert.assertEquals(loginuserdisplayname, usermenupage.getLoggedInUserDisplayName());
		
		//3) Asserting unsaved report page is displayed
		accountpage.clickOnAccountsWithLastActivity();
		
		//4)Asserting list of accounts qualified is displayed	
		accountpage.selectAccountOptions();
		
		//5)
		accountpage.saveReport();

	}

	@AfterMethod
	public void aftermethod() {

		driver.quit();
		driver = null;
		// System.out.println("Driver afterMethod "+driver);

	}

}