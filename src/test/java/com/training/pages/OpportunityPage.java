package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class OpportunityPage extends BasePage {

	@FindBy(xpath = "//a[text()='Opportunities']")
	WebElement opportunities;

	@FindBy(id = "tryLexDialogX")
	WebElement close;

	@FindBy(id = "fcf")
	WebElement oppDropdownElement;

	@FindBy(xpath = "//input[@name='new']")
	WebElement newButton;

	@FindBy(id = "opp3")
	WebElement opportunityName;

	@FindBy(id = "opp4_lkwgt")
	WebElement accountNameLookup;

	@FindBy(xpath = "//frame[@id='resultsFrame']")
	WebElement lookupFrame;

	@FindBy(xpath = "//a[text()=\"Account2\"]")
	WebElement Account2;

	@FindBy(id = "opp9")
	WebElement closeDate;

	@FindBy(xpath = "//input[@tabindex=\"18\"]")
	WebElement opportunitySaveButton;

	@FindBy(id = "opp11")
	WebElement stageDropDown;

	@FindBy(xpath = "//a[text()=\"Opportunity Pipeline\"]")
	WebElement opportunityPipeline;

	@FindBy(xpath = "//a[text()=\"Stuck Opportunities\"]")
	WebElement stuckOpportunity;

	@FindBy(id = "quarter_q")
	WebElement intervalDropdownElement;

	@FindBy(id = "open")
	WebElement includeDropdownElement;

	@FindBy(xpath = "//input[@title=\"Run Report\"]")
	WebElement runReportButton;

	public OpportunityPage(WebDriver driver) { // Creating a constructor OpportunityPage which is called in
												// OpportunityTest

		super(driver);

	}

	public void clickOnOpportunityLink() {

		opportunities.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close.click();// closing pop up generated

	}

	public List<String> getOpportunityDropDownItems() {

		// Locate the dropdown element
		oppDropdownElement.click();
		// Create a Select object from the dropdown element
		Select dropdown = new Select(oppDropdownElement);

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
		List<String> expectedList = Arrays.asList("All Opportunities", "Closing Next Month", "Closing This Month",
				"My Opportunities", "New This Week", "Recently Viewed Opportunities", "Won");
		return expectedList;

	}

	public void createNewOpportunity() {

		newButton.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		opportunityName.sendKeys("Test Lead");

		accountNameLookup.click(); // lookup button

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.switchTo().frame("resultsFrame");// its a frame

		Account2.click();

		driver.switchTo().defaultContent();// move out of the frame

		closeDate.sendKeys("8/12/2023");

		// WebElement stageDropDown=driver.findElement(By.id("opp11"));
		Select stage = new Select(stageDropDown);
		stage.selectByVisibleText("Needs Analysis");

		opportunitySaveButton.click();

	}

	public String clickOnOpportunityPipeline() {

		opportunityPipeline.click();
		return driver.getTitle();
	}

	public String clickOnStuckOpportunity() {

		stuckOpportunity.click();
		return driver.getTitle();
	}

	public String testQuaterlySummaryReport() {

		// intervalDropdownElement.click();
		Select intervalDropdown = new Select(intervalDropdownElement);
		intervalDropdown.selectByVisibleText("Next FQ");

		Select includeDropdown = new Select(includeDropdownElement);
		includeDropdown.selectByVisibleText("Closed Opportunities");
		runReportButton.click();
		return driver.getTitle();

	}

}