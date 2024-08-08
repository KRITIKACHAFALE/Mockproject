package Listners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseclass.BaseClass_DWS;



public class Listeners_DWS extends BaseClass_DWS implements ITestListener{

	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		Reporter.log(name,true);
		test = report.createTest(name);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		Reporter.log("onTestSuccess",true);
		test.log(Status.PASS, name+" is Passed !");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		String message = result.getThrowable().toString();
		Reporter.log("onTestFailure",true);
		test.log(Status.FAIL, message);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		String from = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		Reporter.log("onTestSkipped",true);
		test.log(Status.SKIP, name+" is Skipped !");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("onTestFailedButWithinSuccessPercentage",true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("onTestFailedWithTimeout",true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("onStart",true);
		
		spark = new ExtentSparkReporter("./ExtentReports/DWS_Report");
		spark.config().setDocumentTitle("Demo Web Shop");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Mani Sir");
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows11");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Version", "125");
		report.setSystemInfo("Author", "kritika");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
}
