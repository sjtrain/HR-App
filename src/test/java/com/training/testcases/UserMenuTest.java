package com.training.testcases;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.base.BaseTest;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuPage;

public class UserMenuTest extends BaseTest {

	// WebDriver driver;
	LoginPage loginpage;// Declaring instance variable
	UserMenuPage usermenupage;//  instance variable
	
	String url;
	String username;
	String password;
	String lastname;
	String writetext;
	String choosetextfile;
	String choosephotofile;
	String sendername;
	String senderemail;

	@BeforeMethod
	public void beforemethod() throws InterruptedException {

		driver = getDriver(); // getDriver() defined in BaseTest
		url = getvalue("qaurl"); //getvalue() defined in BaseTest
		driver.get(url);

		username = getvalue("username");
		password = getvalue("password");
		lastname = getvalue("lastname");
		writetext = getvalue("writetext");
		choosetextfile = getvalue("choosetextfile");
		choosephotofile = getvalue("choosephotofile");
		sendername = getvalue("sendername");
		senderemail = getvalue("senderemail");

		loginpage = new LoginPage(driver); //creating an object of Login page class by passing driver
		usermenupage = new UserMenuPage(driver); //creating an object of Class user menu page by passing driver
	}

	@Test
	public void testUsermenuDisplayElements() {

		// loginpage.enterIntoUsername(username);
		// loginpage.enterIntoPassword(password);
		// loginpage.clickOnLogin();
		loginpage.login(username, password);
		usermenupage.clickOnUsermenuButton();

		Assert.assertTrue(usermenupage.getDisplayLinks().containsAll(usermenupage.getExpectedLinks()));

	}

	@Test
	public void testMyProfileLink() throws InterruptedException {

		// loginpage.enterIntoUsername(username);
		// loginpage.enterIntoPassword(password);
		// loginpage.clickOnLogin();
		loginpage.login(username, password);// all 3 methods into one method

		usermenupage.clickOnUsermenuButton();

		// Checking correct user name is displayed on My profile page
		usermenupage.clickOnMyProfileLink();
		Assert.assertEquals("User: Sherin Soman ~ Salesforce - Developer Edition", driver.getTitle());

		// Checking about and contact tab displayed or not
		usermenupage.clickOnEditMyProfileButton();
		Assert.assertTrue(usermenupage.verifyAboutContactTab().containsAll(Arrays.asList("About", "Contact")));

		// Updating the last name and checking
		usermenupage.updateLastname(lastname);
		Assert.assertEquals("User: Sherin Soman ~ Salesforce - Developer Edition", driver.getTitle());

		// Posting a text message and verifying it is displayed
		usermenupage.addPost(writetext);
		Assert.assertTrue(usermenupage.verifyPostLink().isDisplayed());
		//Assert.assertEquals("Hello, this is my message!", usermenupage.verifyPostLink().getText()); //verifying it is the same post

		// Uploading a file from system and posting it
		usermenupage.clickOnFileLink();
		usermenupage.clickOnUploadFile();
		usermenupage.enterIntoChooseTextFile(choosetextfile);
		usermenupage.clickOnShareButton();

		usermenupage.addProfilePhoto(choosephotofile);

	}

	@Test
	public void testMySettingsLink() { //deleting all files with name LoginHistory before downloading
		File fileLocation = new File("/Users/sherin/Downloads");
		File[] totalFiles = fileLocation.listFiles(); // getting all the files using listFiles() and storing it in an
														// array
		for (File file : totalFiles) {

			if (file.getName().contains("LoginHistory")) {
				file.delete();
			}

		}

		loginpage.login(username, password);

		// loginhistory downloaded and verifying if it is downloaded
		usermenupage.downloadLoginHistory();
		Assert.assertTrue(checkLocalFilePrefixExists("/Users/sherin/Downloads", "LoginHistory")); // calling from
																									// Basetest

		// adding reports tab to available and verifying if it is displayed on tabs list
		List<String> tabItems = usermenupage.addReportsTab();
		Assert.assertTrue(tabItems.contains("Reports"));

		String actualDisplayMessage = usermenupage.updateEmailSettings(sendername, senderemail);
		Assert.assertEquals("Your settings have been successfully saved.", actualDisplayMessage);

		usermenupage.openCalendersAndReminders();
		Assert.assertEquals("Activity Reminders ~ Salesforce - Developer Edition", usermenupage.getActiveWindows());

	}
	
	@Test
	public void testDeveloperConsoleLink()  {

		loginpage.login(username, password);// all 3 methods into one method

		usermenupage.clickOnUsermenuButton();
		usermenupage.clickOnDeveloperConsole();
		Assert.assertEquals("Developer Console", usermenupage.getActiveWindows());
	}
	
	@Test
	public void logout()  {

		loginpage.login(username, password);// all 3 methods into one method

		usermenupage.clickOnUsermenuButton();
		String title=usermenupage.clickOnLogout();
		Assert.assertEquals("Login | Salesforce", title);
		
	}

	@AfterMethod
	public void aftermethod() {

		driver.quit();
		driver = null;
		// System.out.println("Driver afterMethod "+driver);

	}

}
