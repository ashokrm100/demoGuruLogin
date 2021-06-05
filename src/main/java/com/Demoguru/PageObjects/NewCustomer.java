package com.Demoguru.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class NewCustomer {

	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement customerlink;
	
	@FindBy(name="name") 
	@CacheLookup
	WebElement customername;
	
	@FindBy(xpath="//input[@type='radio' and @value='m']")
	@CacheLookup
	WebElement gender;
	
	@FindBy(name="dob")
	@CacheLookup
	WebElement dob;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement address;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement city;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement state;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement pincode;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement telephoneno;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement emailid;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(css="input[type='submit']")
	@CacheLookup
	WebElement submit;
	
	public NewCustomer(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void openCustomerpage()
	{
		customerlink.click();
	}
	
	public void customerName(String name)
	{
		customername.sendKeys(name);
		
	}
	
	public void Gender()
	{
		gender.click();
	}
	
	public void getDOB(String day, String month, String Year)
	{
		dob.sendKeys(day);
		dob.sendKeys(month);
		dob.click();
		dob.sendKeys(Year);
	}
	
	public void addAddress(String add)
	{
		address.sendKeys(add);
		
	}
	
	public void place(String location)
	{
		city.sendKeys(location);
	}
	
	public void getState(String loc)
	{
		state.sendKeys(loc);
	}
	
	public void pincode(String pin)
	{
		pincode.sendKeys(pin);
	}
	
	public void getMobile(String mob)
	{
		telephoneno.sendKeys(mob);
	}
	
	public void getEmailId(String mail)
	{
		emailid.sendKeys(mail);
	}
	
	public void getPwd(String pass) {
		pwd.sendKeys(pass);
	}
	
	public void doSubmission()
	{
		submit.click();
	}
	

}
