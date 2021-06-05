package com.Demoguru.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Demoguru.BaseTest.BaseTest;

public class GetScreenShot extends BaseTest{

	public String onErrorScreenShot(WebDriver driver,String methodname) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir = System.getProperty("user.dir")+ "//screenshots//" +methodname+System.currentTimeMillis() + ".png";
		FileUtils.copyFile(src,new File(currentdir ));
		return currentdir;
	
		
	}
	
	/*public String TakeScreenShot(String methodname)
	{
		System.out.println(methodname);
		try {
		path = System.getProperty("user.dir")+"\\Screenshots\\"+methodname+ System.currentTimeMillis()+".png";
		//String currentdir = System.getProperty("user.dir")+ "//screenshots//" +methodname+System.currentTimeMillis() + ".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File(path));
		}catch(Exception e)
		{
			
		}
		return path;
	}*/

}
