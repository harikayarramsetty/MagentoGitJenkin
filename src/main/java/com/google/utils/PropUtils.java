package com.google.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {
	
	
	public static String getValue(String fileDetail,String key) throws IOException
	{
		FileInputStream file = new FileInputStream(fileDetail); // read and location

		Properties prop=new Properties();
		
		prop.load(file);
		
		String value = prop.getProperty(key);
		
		return value;
	}

}
