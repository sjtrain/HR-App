package com.training.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LeadsPage extends BasePage {
	
	
	@FindBy(xpath = "//a[@title=\"Leads Tab\"]")
	WebElement leadsTab;
	
	@FindBy(id = "tryLexDialogX")
	WebElement close;
	
	@FindBy(xpath = "//select[@id=\"fcf\"]")
	WebElement leadsDropdownElement;
	
	@FindBy(id = "userNavLabel")
	WebElement usermenuButton;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath = "//input[@title=\"Go!\"]")
	WebElement goButton;
	
	@FindBy(xpath = "//input[@title=\"New\"]")
	WebElement newButton;
	
	
	@FindBy(id = "name_lastlea2")
	WebElement lastNameTextBox;
	
	
	@FindBy(id = "lea3")
	WebElement companyTextBox;
	
	@FindBy(xpath = "//input[@title=\"Save\"]")
	WebElement saveButton;
	
	public LeadsPage(WebDriver driver) { // Creating a constructor LeadsPage which is called in LeadsTest
												

		super(driver);

	}
	
	public String clickOnLeadsTab() {
		
		leadsTab.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int timeout = 5;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			//WebElement close = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tryLexDialogX")));
			//WebElement closeButton = wait.until(ExpectedConditions.visibilityOf(close));
			wait.until(ExpectedConditions.visibilityOf(close));		
				close.click();// closing pop up generated
			
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.getTitle();

	}

	public List<String> getLeadsDropDownElements() {

		// Locate the dropdown element
		// leadsDropdownElement.click();
		// Create a Select object from the dropdown element
		Select dropdown = new Select(leadsDropdownElement);

		// Get all the options from the dropdown
		List<WebElement> options = dropdown.getOptions();
		

		// Create a list to store option texts
		List<String> optionTexts = new ArrayList<String>();
		for (WebElement option : options) {
			optionTexts.add(option.getText());
		}

		return optionTexts;

	}

	public List<String> getExpectedLinks() {
		List<String> expectedList = Arrays.asList("All Open Leads", "My Unread Leads", "Recently Viewed Leads", "Today's Leads");
		return expectedList;

	}
	
	public String selectViewAndLogout() {
		
		//leadsDropdownElement.click();
		Select dropdown = new Select(leadsDropdownElement);
		dropdown.selectByVisibleText("My Unread Leads");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usermenuButton.click();
		logout.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driver.getTitle();
	}
	
	public void clickOnGo() {
		
		goButton.click();
		
	}
	
	public void clickOnTodaysLeadDropdownElement() {
		
		Select dropdown = new Select(leadsDropdownElement);
		dropdown.selectByVisibleText("Today's Leads");
		
		
	}
	public void clickOnNewButton() {
		newButton.click();
		
	}
	public void enterInToLastName(String newleadlastname) {
		lastNameTextBox.sendKeys(newleadlastname);
		
	}
	
	public void enterInToCompanyName(String newleadcompanyname) {
		
		companyTextBox.sendKeys(newleadcompanyname);
		
	}
	public void clickOnSave() {
		saveButton.click();
		
	}

}
