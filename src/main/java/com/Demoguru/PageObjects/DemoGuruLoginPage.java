package com.Demoguru.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Demoguru.BaseTest.BaseTest;

public class DemoGuruLoginPage extends BaseTest {
	
	@CacheLookup
	@FindBy(css="input[type*='text'][name='uid']") 
	WebElement userid;
	
	
	@FindBy(xpath = "//input[@type='password']" ) 
	@CacheLookup
	WebElement password;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement login;
	WebDriver driver;
	
	public DemoGuruLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String usr)
	{
	 userid.sendKeys(usr);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void setSumbit()
	{
		login.click();
	}
	
	
	
	
	
	
	
	
	

}
