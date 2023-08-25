package com.training.base;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.training.utilities.CommonUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected WebDriver driver;
	
	CommonUtilities common = new CommonUtilities();
		
	public WebDriver getDriver() {
	 
		if(driver==null){	
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
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

