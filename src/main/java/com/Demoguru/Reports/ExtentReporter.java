package com.Demoguru.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports extent;
	public static ExtentSparkReporter report;
	public static ExtentReports generateReport()
	{
		String path = System.getProperty("user.dir")+"//Reports";
		report = new ExtentSparkReporter(path);
		report.config().setReportName("DemoGuru Automation Test");
		report.config().setDocumentTitle("Automation Extent Reporter");
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Ashok Kumar");
		extent.setSystemInfo("Host name","Local Host");
		extent.setSystemInfo("Environment","QA");
		return extent;
	}
}
