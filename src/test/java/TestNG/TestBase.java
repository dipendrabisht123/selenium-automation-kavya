package TestNG;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.Driver;
import Utilities.ConfigDetails;

public class TestBase {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports report;
	public ExtentTest test;
	
	@BeforeTest
	public void setUpBeforeTest(){
		Driver.getDriverObj(ConfigDetails.getProperty("browser"));
	}

}
