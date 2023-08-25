package com.training.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class AccountPage extends BasePage {

	@FindBy(xpath = "//a[@title=\"Accounts Tab\"]")
	WebElement accountsTab;

	@FindBy(id = "tryLexDialogX")
	WebElement close;

	@FindBy(xpath = "//input[@name='new']")
	WebElement newButton;

	@FindBy(id = "acc2")
	WebElement accountName;

	@FindBy(id = "acc6")
	WebElement typedropdownElement1;

	@FindBy(id = "00NHu00000NHh48")
	WebElement customerPriorityDropdown;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	WebElement saveButton1;

	@FindBy(xpath = "//*[@id=\"contactHeaderRow\"]/div[2]/h2")
	WebElement accName;

	@FindBy(xpath = "//a[contains(text(),\"Create New View\")]")
	WebElement createNewViewLink;

	@FindBy(id = "fname")
	WebElement viewName;

	@FindBy(id = "devname")
	WebElement uniqueViewName;

	@FindBy(xpath = "//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]")
	WebElement saveButton2;

	@FindBy(xpath = "//select[@name='fcf']")
	WebElement typedropdownElement2;
	
	@FindBy(xpath = "//a[text()='Edit']")
	WebElement edit;
	
	@FindBy(xpath= "//select[@name=\"fcf\"]")
	WebElement viewDropDown;
	
	@FindBy(id = "fname")
	WebElement editviewTextBox;
	
	
	@FindBy(id = "fcol1")
	WebElement fieldDropDown;
	
	
	@FindBy(id = "fop1")
	WebElement operatorDropDown;
	
	
	@FindBy(id = "fval1")
	WebElement valueTextBox;
	
	@FindBy(id = "colselector_select_0")
	WebElement viewAvailableFieldsTab;
	
	
	@FindBy(id = "colselector_select_0_right")
	WebElement add;
	
	
	@FindBy(xpath = "//input[@data-uidsfdc=\"5\"]")
	WebElement save;
	
	
	@FindBy(xpath = "//table/tbody/tr/td[4]/div/a")
	List<WebElement> accountNameElements;
	
	@FindBy(xpath = "//table/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a")
	WebElement mergeAccounts;
	
	
	@FindBy(id = "srch")
	WebElement findAccountTextBox;
	
	@FindBy(xpath = "//input[@value=\"Find Accounts\"]")
	WebElement findAccountButton;
	
	@FindBy(id = "cid0")
	WebElement checkbox1;
	
	@FindBy(id = "cid1")
	WebElement checkbox2;
	
	@FindBy(xpath = "//input[@title=\"Next\"]")
	WebElement nextButton;
	
	@FindBy(xpath = "//*[@id=\"stageForm\"]/div/div[1]/h2")
	WebElement mergeAccountPageTitle;
	
	@FindBy(xpath = "//input[@title=\"Merge\"]")
	WebElement mergeButton;
	
	@FindBy(xpath = "//a[contains(text(),'Accounts with last activity > 30 days')]")
	WebElement accountsWithLastActivityLink;
	
	@FindBy(id = "ext-gen148")
	WebElement dateFieldDropDown;
	

	@FindBy(xpath = "//div[text()=\"Created Date\"]")
	WebElement createdDate;
	
	@FindBy(id= "ext-gen152")
	WebElement fromDateDropDown;
	
	@FindBy(xpath= "//table[@id='ext-comp-1111']/tbody") //cannot locate it with id as it is changing each
	WebElement fromDateToday;
	
	@FindBy(id= "ext-gen154")
	WebElement toDateDropDown;
	
	@FindBy(xpath= "//table[@id='ext-comp-1113']/tbody")
	WebElement toDateToday;
	
	@FindBy(id= "phHeader")
	WebElement tableElement;
	
	
	@FindBy(id= "ext-gen49")
	WebElement reportSaveButton;
	
	@FindBy(id= "saveReportDlg_reportNameField")
	WebElement reportName;
	
	@FindBy(id= "saveReportDlg_DeveloperName")
	WebElement reportUniqueName;
	
	@FindBy(xpath= "//table[@id=\'dlgSaveAndRun\']")
	WebElement saveAndRunReport;
	
	
	public AccountPage(WebDriver driver) { // creating a constructor 'AccountPage'

		super(driver);

	}
	
	
	public void clickOnAccounts() {
		
		accountsTab.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close.click(); // closing the popup generated while automating
	}

	public String createNewAccount(String accountname) {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		newButton.click();

		accountName.sendKeys(accountname);

		// Create a Select object from the dropdown WebElement.
		Select dropdown1 = new Select(typedropdownElement1);
		dropdown1.selectByVisibleText("Technology Partner");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down vertically by 500 pixels.
		js.executeScript("window.scrollBy(0, 500);");

		// Create a Select object from the dropdown WebElement.
		Select dropdown2 = new Select(customerPriorityDropdown);
		dropdown2.selectByVisibleText("High");

		saveButton1.click();

		String actualText = accName.getText();
		return actualText;
	}

	public String createNewView(String viewname) {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		createNewViewLink.click();

		viewName.sendKeys(viewname);

		uniqueViewName.click();

		saveButton2.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Assertion
		// Create a Select object from the dropdown WebElement.
		Select dropdown = new Select(typedropdownElement2);
		// Get the 1st selected option from drop down using the getFirstSelectedOption()
		// method.
		WebElement selectedOption = dropdown.getFirstSelectedOption();

		// Get the value or text of the selected option.
		String selectedview = selectedOption.getText();
		return selectedview;

	}

	public String selectViewName(String selectviewname) {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Select select = new Select(viewDropDown);
		select.selectByVisibleText(selectviewname);

		edit.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String displayView = editviewTextBox.getAttribute("value");

		return displayView;

	}

	public void changeViewName(String newviewname) {

		editviewTextBox.sendKeys(newviewname);

		Select select1 = new Select(fieldDropDown);
		select1.selectByVisibleText("Account Name");

		Select select2 = new Select(operatorDropDown);
		select2.selectByVisibleText("contains");

		valueTextBox.sendKeys("a");

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;// create an instance of JavascriptExecutor
		// locating the entire drop down with <select>tab
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", viewAvailableFieldsTab);// Scroll to the desired
																								// option

		Select select = new Select(viewAvailableFieldsTab);
		select.selectByValue("ACCOUNT.LAST_ACTIVITY");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		add.click();
		save.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String checkDisplayViewName() {
		// Assertion
		Select viewdropdown = new Select(viewDropDown);
		// Get the 1st selected option from drop down using the getFirstSelectedOption()
		// method.
		WebElement selectedOption = viewdropdown.getFirstSelectedOption();

		// Get the value or text of the selected option.
		String selectedview = selectedOption.getText();
		return selectedview;

	}

	public List<String> getAccNames() {

		// Create a List to store the text of each element
		List<String> columnTexts = new ArrayList<String>();

		// Extract and store the text of each element in the List
		for (WebElement element : accountNameElements) {
			columnTexts.add(element.getText());
		}

		return columnTexts;
	}

	public void checkLastColumnAdded() {

	}

	public String findAccountsToMerge() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;// create an instance of JavascriptExecutor
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", mergeAccounts);// Scroll to the desired option
		mergeAccounts.click();
		findAccountTextBox.sendKeys("Account");
		findAccountButton.click();
		checkbox1.click();
		checkbox2.click();
		nextButton.click();
		return mergeAccountPageTitle.getText();

	}

	public void clickOnMerge() {

		mergeButton.click();

		// Switch to the alert
		Alert alert = driver.switchTo().alert();
		// Perform actions on the alert
		alert.accept(); // Click OK button

	}

	public void clickOnAccountsWithLastActivity() {

		accountsWithLastActivityLink.click();
	}

	public void selectAccountOptions() {

		dateFieldDropDown.click();

		createdDate.click();

		fromDateDropDown.click();

		fromDateToday.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		toDateDropDown.click();


		toDateToday.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Locate the table element

		// Find all the rows within the table using the 'tr' tag
		List<WebElement> rows = tableElement.findElements(By.tagName("tr"));

		// Get the number of rows in the table
		int numberOfRows = rows.size();

		// Print the number of rows
		System.out.println("Number of rows in the table: " + numberOfRows);

		// String accountName =
		// driver.findElement(By.xpath("//table/tbody/tr/td[3]/div[text()='Account1']")).getText();
		// Assert.assertEquals(accountName, "Account1");

	}
	
	public void saveReport() {
		
		reportSaveButton.click();
		
		reportName.sendKeys("Account1_Report");
		
		reportUniqueName.click();
		
		saveAndRunReport.click();
	}

}
