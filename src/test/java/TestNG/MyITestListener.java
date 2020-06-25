package TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class MyITestListener extends TestBase implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("---onTestStart----");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("---onTestSuccess----");
		test.log(Status.PASS, "onTestSuccess -> PASSED: "+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("---onTestFailure----");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("---onTestSkipped----");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("---onStart----");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("---onFinish----");
		
	}

}
