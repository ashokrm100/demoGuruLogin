package com.Demoguru.PageObjects;

import java.io.FileInputStream;
import java.util.Properties;

public class SetConfig {
	
	FileInputStream fis;
	Properties prop;
	
	public SetConfig()
	{
		try {
			fis = new FileInputStream(".\\src\\main\\java\\com\\Demoguru\\Config\\config.properties");
			//System.out.println(fis.toString());
			prop = new Properties();
			prop.load(fis);
			}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	public String getUserName()
	{
		String userN=prop.getProperty("username");
		System.out.println(userN);
		return userN;
	}
	
	public String getPassword()
	{
		String passWord=prop.getProperty("password");
		System.out.println(passWord);
		return passWord;
	}
	
	public String getUrl()
	{
		String url = prop.getProperty("url");
		System.out.println(url);
		return url;
	}
	
	
	

}
