package com.training.base;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.training.utilities.CommonUtilities;

public class BaseTest {
	
	protected WebDriver driver;
	
	CommonUtilities common = new CommonUtilities();
		
	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/sherin/Downloads/chromedriver-mac-x64/chromedriver");
		if(driver==null){	
			//WebDriverManager.chromedriver().setup();
			//driver= new ChromeDriver();
	        ChromeOptions options = new ChromeOptions();
	        //options.addArguments("--headless");     
	        //options.addArguments("--disable-gpu");
	        //options.addArguments("--window-size=1400,800");  
	        driver = new ChromeDriver(options); 
			
		}
	    return driver;

	}
	
	//public void closebrowser(WebDriver driver) {
	//	driver.close();
		//driver=null;
	//}

	public String getvalue(String key) {
		String value = common.getProperty(key); 
		return value;
	}
	
	//common method to check if a fileprefix exists in a local system directory
	public boolean checkLocalFilePrefixExists(String directory, String filePrefix) {
		//File fileLocation = new File("/Users/sherin/Downloads")
		File dir = new File(directory);;
		File[] totalFiles = dir.listFiles(); // getting all the files using listFiles() and storing it in an
														// array
		boolean flag=false;
		for (File file : totalFiles) {

			if (file.getName().contains(filePrefix)) {
				// System.out.println("File is downloaded");
				flag=true;
				break;
			}

		}
		return flag;
		
	}
	
	//common method 
	public boolean listContainsCharacter(List<String> stringList, String containString) {
		boolean flag = true;
        for (String text : stringList) {
            if (!text.contains(containString)) {
                flag = false;
                break;
            }
		 }
		return flag;
	}
	
}

