package com.training.base;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) { // creating a constructor BasePage
		this.driver = driver;

		// Page factory initialization (To initialize all the elements) then only all
		// the elements will be in the driver
		PageFactory.initElements(driver, this);

	}

	public String getActiveWindows() {

		String mainWindowHandle = driver.getWindowHandle();// Get the window handle of the main window
		//System.out.println("Title of the main window is: " + driver.getTitle());
		Set<String> allWindowHandles = driver.getWindowHandles();// Get all window handles
		// Switch to the new window
				for (String windowHandle : allWindowHandles) {
					if (!windowHandle.equals(mainWindowHandle)) {
						driver.switchTo().window(windowHandle);
						break;
					}
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String newWindowActualTitle = driver.getTitle();
				System.out.println("Title of the new window is: " + newWindowActualTitle);
				return newWindowActualTitle;

	}
}

