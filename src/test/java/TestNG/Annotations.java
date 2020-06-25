package TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Annotations extends TestBase {

	@Parameters({ "driver", "browser", "version" })
	@Test(priority = 3, groups = { "Regression", "smoke" })
	public void testMethod1(String sDriver, String sName, int iVersion) {

		test = report.createTest("testMethod1");

		System.out.println("testMethod1");

		test.log(Status.PASS, "Test 1 started");

		System.out.println("Browser name: " + sName);

		test.log(Status.PASS, "Browser launched");

		if (iVersion == 70) {
			System.out.println("Correct version: " + iVersion);
			test.log(Status.PASS, "Browser launched with version " + iVersion);
		} else {
			System.out.println("In-Correct version: " + iVersion);
		}

		System.out.println("Driver name: " + sDriver);

		/*
		 * if(1==1){ throw new SkipException("Skipping this test case !!!"); }
		 */

	}

	@Parameters({ "driver" })
	@Test(priority = 1, groups = { "Regression" })
	public void testMethod2(String sDriver) {
		test = report.createTest("testMethod2");
		System.out.println("testMethod2");
		System.out.println("Driver name: " + sDriver);

		if (!sDriver.equalsIgnoreCase("ABC")) {
			test.fail("Incorrect drivr used.");
		}

	}

	@Test(enabled = true, priority = 0, dependsOnMethods = { "testMethod2" }, groups = { "Smoke" })
	public void testMethod3() {

		System.out.println("testMethod3");

		Assert.assertTrue(false);
	}

	

	

	@BeforeSuite
	public void beforeSuite() {
		htmlReporter = new ExtentHtmlReporter("./Reports/RegressionReport.html");

		htmlReporter.config().setDocumentTitle("Report");
		htmlReporter.config().setReportName("Regression Report");
		htmlReporter.config().setTheme(Theme.DARK);

	}

	

	@BeforeTest
	public void setupTest() {
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Plateform", "WIN 10");
		report.setSystemInfo("Browser", "Chrome");

	}

	@AfterTest
	public void cleanupTest() {
		report.flush();

	}

	

}
