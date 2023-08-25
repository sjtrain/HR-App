package com.training.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class UserMenuPage extends BasePage {

	@FindBy(id = "username")
	WebElement userNameText;

	@FindBy(id = "password")
	WebElement passwordText;

	@FindBy(id = "Login")
	WebElement loginButton;

	@FindBy(id = "userNavLabel")
	WebElement usermenuButton;

	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	WebElement myProfileLink;

	@FindBy(id = "userNav-menuItems")
	WebElement divElement;

	@FindBy(xpath = "//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img")
	WebElement editProfileButton;

	@FindBy(id = "aboutTab")
	WebElement aboutTab;

	@FindBy(id = "contactTab")
	WebElement contactTab;

	@FindBy(id = "contactInfoContentId")
	WebElement EditProfileFrame;

	@FindBy(id = "lastName")
	WebElement Lastname;

	@FindBy(xpath = "//input[@value='Save All']")
	WebElement SaveAllButton;

	@FindBy(xpath = "//span[text()='Post']")
	WebElement postLink;

	@FindBy(xpath = "//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
	WebElement postFrame;

	@FindBy(xpath = "//body[text()='Share an update, @mention someone...']")
	WebElement writeText;

	@FindBy(xpath = "//input[@title='Share']")
	WebElement share;

	@FindBy(xpath = "//p[contains(text(),'Hello, this is my message!')]")
	WebElement checkPostText;

	@FindBy(xpath = "//span[text()='File']")
	WebElement file;

	@FindBy(xpath = "//a[contains(text(),'Upload a file from your computer')]")
	WebElement upload;

	@FindBy(id = "chatterFile")
	WebElement chooseTextFile;

	@FindBy(id = "publishersharebutton")
	WebElement shareButton;

	@FindBy(xpath = "//img[@src='https://tekarch164-dev-ed.develop.file.force.com/profilephoto/005/F']")
	WebElement image;

	@FindBy(xpath = "//a[contains(text(),'Add Photo')]")
	WebElement addPhotoLink;

	@FindBy(id = "uploadPhotoContentId")
	WebElement photoUploadFrame1;

	@FindBy(xpath = "//input[@id=\"j_id0:uploadFileForm:uploadInputFile\"]")
	WebElement choosePhotoFile;

	@FindBy(id = "j_id0:uploadFileForm:uploadBtn")
	WebElement imageUploadSaveButton;

	@FindBy(xpath = "//iframe[@id='uploadPhotoContentId']")
	WebElement photoUploadFrame2;

	@FindBy(id = "j_id0:j_id7:save")
	WebElement photoSaveButton;
	
	@FindBy(xpath = "//a[contains(text(),'My Settings')]")
	WebElement mySettings;
	
	@FindBy(id = "PersonalInfo_font")
	WebElement personalLink;
	
	@FindBy(id = "LoginHistory_font")
	WebElement loginhistory;
	
	@FindBy(xpath = "//div[@class='pShowMore']")
	WebElement downloadLoginHistory;
	
	@FindBy(id = "DisplayAndLayout_font")
	WebElement displayAndLayoutLink;  
	
	
	@FindBy(id = "CustomizeTabs_font")
	WebElement customizeTab;
	
	@FindBy(id = "p4")
	WebElement customAppDropDown;
	
	@FindBy(id = "duel_select_0")
	WebElement availableTab;
	
	@FindBy(xpath = "//img[@alt='Add']")
	WebElement add;
	
	@FindBy(xpath = "//input[@name='save']")
	WebElement save;
	
	@FindBy(id = "tabBar")
	WebElement ulElement;
	
	@FindBy(id = "EmailSetup_font")
	WebElement emailLink;
	
	@FindBy(id = "EmailSettings_font")
	WebElement myEmailSettingsLink;
	
	@FindBy(id = "sender_name")
	WebElement emailName;
	
	@FindBy(id = "sender_email")
	WebElement emailAddress;
	
	@FindBy(id = "auto_bcc1")
	WebElement radioButton;
	
	@FindBy(xpath = "//input[@name='save']")
	WebElement saveButton;
	
	@FindBy(id = "meSaveCompleteMessage")
	WebElement saveMessage;
	
	@FindBy(id = "CalendarAndReminders_font")
	WebElement calendersAndReminders;
	
	@FindBy(id = "Reminders_font")
	WebElement activityReminders;
	
	@FindBy(id = "testbtn")
	WebElement openATestReminderButton;
	
	@FindBy(xpath = "//a[contains(text(),\"Developer Console\")]")
	WebElement developerConsole;
	
	@FindBy(xpath = "//a[text()=\"Logout\"]")
	WebElement logout;
	

	public UserMenuPage(WebDriver driver) { // creating a constructor 'UserMenuPage'

		super(driver);

	}
	
	public void addProfilePhoto(String choosephotofile) {
		//Adding a profile photo
		clickOnAddPhotoLink();
		enterIntoChoosePhotoFile(choosephotofile);
		clickOnImageUploadSaveButton();
		clickOnPhotoSaveButton();
	}


	public void clickOnUsermenuButton() {

		usermenuButton.click();
	}
	
	public String getLoggedInUserDisplayName() {
		return usermenuButton.getText();
	}

	public void clickOnMyProfileLink() {

		myProfileLink.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> getDisplayLinks() {
		List<WebElement> links = divElement.findElements(By.tagName("a"));
		// Create a list to store the link titles
		List<String> linkTitles = new ArrayList<String>();
		// Iterate through each link element and get its title attribute
		for (WebElement link : links) {
			if (link.isDisplayed()) {
				String title = link.getText();
				if (title != null && !title.isEmpty()) {
					linkTitles.add(title);
				}
			}
		}
		return linkTitles;
	}

	public List<String> getExpectedLinks() {
		List<String> expectedList = Arrays.asList("My Profile", "My Settings", "Developer Console",
				"Switch to Lightning Experience", "Logout");
		return expectedList;

	}

	public void clickOnEditMyProfileButton() {

		editProfileButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<String> verifyAboutContactTab() {

		driver.switchTo().frame(EditProfileFrame);
		// Find all the list elements
		List<WebElement> lists = driver.findElements(By.tagName("li"));

		// Create a list to store the list titles
		List<String> listTitles = new ArrayList<String>();

		// Iterate through each list element and get its title attribute
		for (WebElement list : lists) {
			if (list.isDisplayed()) {
				String title = list.getText();
				System.out.println(title);
				if (title != null && !title.isEmpty()) {
					listTitles.add(title);
				}
			}
		}
		return listTitles;
	}

	public void updateLastname(String lastname) {
		aboutTab.click();
		Lastname.clear();
		Lastname.sendKeys(lastname);
		SaveAllButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickOnPostLink() {
		postLink.click();
	}

	public void enterIntoWriteText(String writetext) {

		driver.switchTo().frame(postFrame);
		writeText.sendKeys(writetext);

	}

	public WebElement verifyPostLink() {

		return checkPostText;
	}

	public void clickOnShareLink() {

		driver.switchTo().defaultContent();// getting out of frame
		share.click(); // share button not part of frame
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickOnFileLink() {

		file.click();

	}

	public void clickOnUploadFile() {

		upload.click();

	}

	public void enterIntoChooseTextFile(String choosetextfile) {

		chooseTextFile.sendKeys(choosetextfile);// since choose file is not a button we can't perform click.
		// TODO Replace with waitForElement
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickOnShareButton() {

		shareButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addPost(String postText) {
		clickOnPostLink();
		enterIntoWriteText(postText);
		clickOnShareLink();
	}

	public void clickOnAddPhotoLink() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creating object of an Actions class
		Actions action = new Actions(driver);
		// Performing the mouse hover action on the target element.
		action.moveToElement(image).perform();
		addPhotoLink.click(); // new frame opened
		driver.switchTo().frame(photoUploadFrame1);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterIntoChoosePhotoFile(String choosephotofile) {

		choosePhotoFile.sendKeys(choosephotofile);
	}

	public void clickOnImageUploadSaveButton() {

		imageUploadSaveButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.switchTo().defaultContent();// move out of the frame
	}

	public void clickOnPhotoSaveButton() {
		driver.switchTo().frame(photoUploadFrame2);
		photoSaveButton.click();

	}

	public void clickOnmySettings() {

		mySettings.click();

	}

	public void clickOnpersonalLink() {

		personalLink.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickOnloginhistory() {

		loginhistory.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void clickOndownloadLoginHistory() {
		

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;// create an instance of JavascriptExecutor
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", downloadLoginHistory);// Scroll to the desired option
		downloadLoginHistory.click();

	}

	public void downloadLoginHistory() {
		clickOnUsermenuButton();
		clickOnmySettings();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickOnpersonalLink();
		clickOnloginhistory();
		clickOndownloadLoginHistory();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void clickOndisplayAndLayoutLink() {

		displayAndLayoutLink.click();

	}
	
	public void clickOncustomizeTab() {

		customizeTab.click();

	}
	
	public void clickOnAdd() {

		add.click();
		

	}
	
	public void clickOnSave() {

		save.click();

	}
	
	
	public List<String> addReportsTab() {

		clickOndisplayAndLayoutLink();

		clickOncustomizeTab();

		Select dropdown1 = new Select(customAppDropDown);
		dropdown1.selectByVisibleText("Salesforce Chatter");

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;// create an instance of JavascriptExecutor
		// locating the entire drop down with <select>tab
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", availableTab);// Scroll to the desired option

		Select select = new Select(availableTab);
		select.selectByValue("report");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clickOnAdd();
		clickOnSave();
		
		

		// Find the <ul> element. Get all the child <li> elements under the <ul> element into a list
		List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

		// Create an ArrayList to store the text from list items
		List<String> itemsText = new ArrayList<String>();

		// Extract the text from each <li> element in list and store it in the list
		for (WebElement liElement : liElements) {
			String itemText = liElement.getText();
			itemsText.add(itemText);
		}
		
		return itemsText;

	}
	
	public void clickOnEmailLink() {

		emailLink.click();
		

	}
	
	
	public void clickOnMyEmailSettingsLink() {

		myEmailSettingsLink.click();
		

	}
	
	public void clickOnRadioButton() {

		radioButton.click();
		
	}
	
	public void clickOnSaveButton() {
		
		saveButton.click();
	
	}
	
	public void enterIntoEmailName(String sendername) {
		
		emailName.clear();
		emailName.sendKeys("sendername");
		
	}
	
	
	public void enterIntoEmailAddress(String senderemail) {
		
		emailAddress.clear();
		emailAddress.sendKeys("senderemail");
	
	}
	
	
	
	public String updateEmailSettings(String sendername, String senderemail) {
		
		clickOnEmailLink();
		clickOnMyEmailSettingsLink();
		
		enterIntoEmailName(sendername);
		
		enterIntoEmailAddress(senderemail);
		clickOnRadioButton();
		clickOnSaveButton();

		String actualDisplayMessage = saveMessage.getText();
		
		return actualDisplayMessage;
	}
	
	public void clickOnCalendersAndReminders() {
	
		calendersAndReminders.click();
	
	}
	
	public void clickOnActivityReminders() {
		
		activityReminders.click();
	
	}
	
	public void clickOnOpenATestReminderButton() {
		
		openATestReminderButton.click();
	
	}
	public void openCalendersAndReminders() {
		clickOnCalendersAndReminders();		
		clickOnActivityReminders();
		clickOnOpenATestReminderButton();
		
	}
	
	public void clickOnDeveloperConsole() {
		
		developerConsole.click();
	}
	
	public String clickOnLogout() {
		
		logout.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title=driver.getTitle();
		System.out.println(title);
		return (title);
	}

	
}
