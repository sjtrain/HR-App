package com.training.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class LoginPage extends BasePage {

	@FindBy(id = "username")
	WebElement userNameText;

	@FindBy(id = "password")
	WebElement passwordText;

	@FindBy(id = "Login")
	WebElement loginButton;

	@FindBy(id = "error")
	WebElement errorMessage;

	@FindBy(xpath = "//*[@id=\"rememberUn\"]")
	WebElement checkbox;

	@FindBy(id = "userNavLabel")
	WebElement usermenu;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;

	@FindBy(id = "idcard")
	WebElement userName;
	
	@FindBy(id = "forgot_password_link")
	WebElement forgotPassword;
	
	@FindBy(id = "un")
	WebElement forgotPasswordUsername;
	
	@FindBy(id = "continue")
	WebElement continueButton;
	
	@FindBy(id = "header")
	WebElement emailMessage;
	
	  

	public LoginPage(WebDriver driver) { // creating a parameterized constructor method

		super(driver);

	}
	
	public void login(String username, String password) {

		enterIntoUsername(username);
		enterIntoPassword(password);
		clickOnLogin();
	}

	public void enterIntoUsername(String username) {

		clearUsername();
		userNameText.sendKeys(username);

	}

	public void enterIntoPassword(String password) {

		clearPassword();
		passwordText.sendKeys(password);

	}

	public void clearPassword() {

		passwordText.clear();   //webelement.click

	}

	public void clearUsername() {

		userNameText.clear();
	}

	public void ClickOnCheckRememberMe() {
		checkbox.click();

	}

	public void clickOnLogin() {

		loginButton.click();
	}

	public void clickOnUserMenu() {

		usermenu.click();
	}

	public void clickOnLogout() {

		logout.click();
	}

	public String getErrorMessage() {

		String actualMessage = errorMessage.getText(); // getting text from it
		return actualMessage;

	}

	public String getName() {

		String actualName = userName.getText(); // getting text from it
		return actualName;

	}
	
	public void ClickOnForgotPassword() {
		forgotPassword.click();

	}
	
	public void ClickOnContinueButton() {
		continueButton.click();

	}
	
	public String getTextMessage() {

		String actualText = emailMessage.getText(); // getting text from it
		return actualText;

	}
	
	public void enterIntoUsernameEmail(String ForgotusernameEmail) {

		//clearUsername();
		forgotPasswordUsername.sendKeys(ForgotusernameEmail);

	}
	
	

}
