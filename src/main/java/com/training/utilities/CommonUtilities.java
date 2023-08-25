package com.training.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonUtilities {
	
	FileInputStream fileinput;
	
	public String getProperty(String key) {
		
		String spath = "/Users/sherin/eclipse-workspace/TestNgFramework/properties/application.properties";
		FileInputStream fileinput = null;
		
		try {
			fileinput = new FileInputStream(spath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		Properties property = new Properties();
		try {
			property.load(fileinput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = property.getProperty(key);
		return value;
		
		
	}

}
