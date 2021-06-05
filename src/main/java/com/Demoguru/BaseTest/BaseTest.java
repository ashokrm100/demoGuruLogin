package com.Demoguru.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Demoguru.PageObjects.SetConfig;

public class BaseTest {
	public WebDriver driver;
	SetConfig se =new SetConfig();
	String baseUrl = se.getUrl();
	public String username=se.getUserName();
	public String pwd = se.getPassword();
	
	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("chrome") String browser)
	{
		
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","E://CHROMEDRIVER//chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","E://FIREFOX//geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","E://IEDRIVER//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		//return driver;
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
