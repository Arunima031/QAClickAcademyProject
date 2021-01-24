package Academy.ETEProject;




import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNG;
import resources.base;


public class Listners extends base implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObjects();
	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	
	}
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		WebDriver driver= null;
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
		try {
		driver=	(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			getScreenShotpath(testName,driver);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public void onStart(ITestContext context) {
		
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}
	

	
	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestStart(ITestResult result) {
String TestName = result.getMethod().getMethodName();
	test = extent.createTest(TestName);
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	
	}
	
	
}
