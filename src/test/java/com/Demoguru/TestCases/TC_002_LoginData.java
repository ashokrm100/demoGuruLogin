package com.Demoguru.TestCases;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import com.Demoguru.BaseTest.BaseTest;
import com.Demoguru.PageObjects.DemoGuruLoginPage;
import com.Demoguru.Utility.ExcelUtility;
import com.Demoguru.Utility.GetScreenShot;

import junit.framework.Assert;

public class TC_002_LoginData extends BaseTest {
	Logger Log = LogManager.getLogger(TC_002_LoginData.class.getName());
	FileInputStream fis;
	String path;

	@Test(dataProvider = "Exceldata")
	public void getLoginData(String username, String password) {
		Log.info("Browser initialized");
		Log.info(username);
		Log.info(password);
		DemoGuruLoginPage dm = new DemoGuruLoginPage(driver);
		Log.info("Data Provider value send");
		dm.setUsername(username);
		Log.info("Data Provider Password send");
		dm.setPassword(password);
		dm.setSumbit();
		if(getalertbox()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else 
		{
			Assert.assertTrue(true);
		}
		//String Expected ="Guru99 Bank Manager HomePage";
		//Assert.assertEquals(driver.getTitle(), Expected,"Not a valid username and password");
		
		
	}
	
	public boolean getalertbox()
	{
		try {
		driver.switchTo().alert();
		return true;
		}catch(Exception e)
		{
			return false;
		}
		
	}

	@DataProvider(name = "Exceldata")
	public Object[][] sendLoginData() throws IOException {

		path = ".\\src\\main\\java\\com\\Demoguru\\Data\\LoginData.xlsx";

		ExcelUtility ex = new ExcelUtility(path);
		int rownum = ex.getRowCount("LoginCredentials");

		int colnum = ex.getCellCount(0, "LoginCredentials");

		Object[][] arr = new Object[rownum][colnum];

		for (int i = 0; i < rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				arr[i][j] = ex.excelContent("LoginCredentials", i + 1, j);
				}
		}
		return arr;
	}
}
