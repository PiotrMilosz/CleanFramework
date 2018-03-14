package listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import ExcelTest.ExcelTry.BaseTest;
import Logger.LogStatuses;
import extentReports.ReportManager;
import screenshoters.ScreenshotProvider;

public class Listeners extends BaseTest implements ITestListener {
	private ReportManager rM;
	private LogStatuses logS;
	private ScreenshotProvider scr;

	public void onStart(ITestContext context) {
		ExtentTest parent = rM.getReporter().createTest(context.getName());
		rM.getParentTest().set(parent);
		logS.startTestCase(context.getName());
		context.setAttribute("WebDriver", this.driver);
	}

	public void onTestStart(ITestResult result) {
		Log.info("I am in onTestStart method " + result.getMethod().getMethodName() + " start");
		// Start operation for extentreports.
		ExtentTest child = rM.getParentTest().get().createNode(result.getMethod().getDescription());
		rM.getTest().set(child);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Log.info("Test " + result.getMethod() + " Passed!");

		scr.takeScreenshot(result);
	}

	public void onTestFailure(ITestResult result) {
		Log.error("Test " + result.getMethod() + " Failed!");

		scr.takeScreenshot(result);
	}

	public void onTestSkipped(ITestResult result) {

		Log.warn("Test " + result.getMethod() + " Skipped!");
		// Extentreports log operation for skipped tests.
		rM.getTest().get().skip(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		logS.endTestCase();
		// Do tier down operations for extentreports reporting!
		rM.getReporter().flush();
	}
}