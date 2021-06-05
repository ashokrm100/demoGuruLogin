package com.Demoguru.TestCases;

import org.testng.annotations.Test;
import com.Demoguru.BaseTest.BaseTest;
import com.Demoguru.PageObjects.DemoGuruLoginPage;
import com.Demoguru.PageObjects.NewCustomer;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class TC_003_AddCustomerTest extends BaseTest {
	
	Logger Log = LogManager.getLogger(TC_003_AddCustomerTest.class.getName());
	NewCustomer cust;
	
	@Test
	public void addNewCustomer() throws InterruptedException
	{
		DemoGuruLoginPage dm = new DemoGuruLoginPage(driver);
		dm.setUsername(username);
		dm.setPassword(pwd);
		dm.setSumbit();
		Log.info("Customer Page Opened");
		cust = new NewCustomer(driver);
		Log.info("Click on add new customer");
		cust.openCustomerpage();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cust.customerName("ashok");
		cust.Gender();
		cust.getDOB("12","09","1990");
		cust.addAddress("This is AshokKumar in Valtertheru");
		cust.place("Ootacalmund");
		cust.getState("Karunatak");
		cust.pincode(GeneratePincode());
		cust.getMobile("7676767676");
		cust.getEmailId(generateMailid()+"@gmail.com");
		cust.getPwd(GeneratePincode());
		Thread.sleep(3000);
		cust.doSubmission();
		Log.info("Details Added Successfully");
		boolean val= driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(val==true)
		{
			Assert.assertTrue(true);
			Log.info("Customer added successfully");
		}
		else 
		{
			Assert.assertTrue(false);
			Log.info("Failed to add new Customer");
		}

	}
	
	public String GeneratePincode()
	{
		String genString=RandomStringUtils.randomNumeric(7);
		return genString;
		
	}
	public String generateMailid()
	{
		String genEmail=RandomStringUtils.randomAlphabetic(6);
		return genEmail;
	}

}
