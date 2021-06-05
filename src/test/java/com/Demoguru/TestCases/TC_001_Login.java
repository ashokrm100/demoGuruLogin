package com.Demoguru.TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Demoguru.BaseTest.BaseTest;
import com.Demoguru.PageObjects.DemoGuruLoginPage;
import com.Demoguru.PageObjects.SetConfig;


public class TC_001_Login extends BaseTest {
	Logger log = LogManager.getLogger(TC_001_Login.class.getName());
	SetConfig se = new SetConfig();
	
	/*@BeforeTest
	public void initialize()
	{
		driver=setup();
	}*/
	
	@Test
	public void LoginTest() throws Exception
	{
		//driver = setup();
		log.info("Driver Initialized");
		DemoGuruLoginPage dp = new DemoGuruLoginPage(driver);
		log.info("Username send");
		dp.setUsername(se.getUserName());
		Thread.sleep(2000);
		log.info("Password send");		
		dp.setPassword(se.getPassword());
		Thread.sleep(2000);
		dp.setSumbit();
		log.info("Login Successfull");
		String Expected ="Guru99 Bank Manager HomePage";
		Assert.assertEquals(driver.getTitle(),Expected);
		
	}
	

}
