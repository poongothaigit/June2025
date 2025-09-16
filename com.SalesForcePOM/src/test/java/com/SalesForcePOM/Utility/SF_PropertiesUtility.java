package com.SalesForcePOM.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SF_PropertiesUtility {
	public static String readDataFromPropertiesFile(String path, String key)
	{	
		File file=new File(path);
		FileInputStream fis=null;
		Properties pro=new Properties();
		String data=null;
		
		
		try {
			fis=new FileInputStream(file);
			pro.load(fis);
			data=pro.getProperty(key);
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("error in the file path, please try with correct path");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error in loading the file in properties object");
			e.printStackTrace();
		}
		return data;
	}

}
