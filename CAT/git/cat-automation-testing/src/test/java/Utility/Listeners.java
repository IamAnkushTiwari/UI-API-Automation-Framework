package Utility;

import Base.Browser;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners implements ITestListener {
	// public WebDriver driver;

	Logger log = LogManager.getLogger("Listeners");

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	public ExtentTest test;

	public void configReport() {
		File file = new File("Reports/Report.html");
		htmlReporter = new ExtentSparkReporter(file);
		reports = new ExtentReports();
		// ExtentSparkReporter spark = new ExtentSparkReporter(file);
		// reports.attachReporter(spark);
		reports.attachReporter(htmlReporter);

		reports.setSystemInfo("Module","Competitor Analysis Tool");
		reports.setSystemInfo("Developed By ", "Ankush Tiwari");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Browser ", "Chrome");


		htmlReporter.config().setDocumentTitle("Extent report");
		htmlReporter.config().setReportName("Ankush Tiwari");
		htmlReporter.config().setTheme(Theme.DARK);

	}

	public void onTestStart(ITestResult result) {

		System.out.println(result.getName() + " test case started");

	}

	public void onTestSuccess(ITestResult result) {

		test = reports.createTest(result.getName());

		test.log(com.aventstack.extentreports.Status.PASS,
				MarkupHelper.createLabel(result.getName() + "<b>Test Case Passed<b>", ExtentColor.GREEN));

		System.out.println(result.getName() + " test case is passed ");
	}

	public void onTestFailure(ITestResult result) {

		System.out.println(result.getName() + " testcase is failed  :");

		if (result.FAILURE == result.getStatus()) {

			try {
				TakesScreenshot screenshot = (TakesScreenshot) Browser.driver;

				File src = screenshot.getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(src, new File("./Reports/screenShots/" + result.getName() + ".png"));
				System.out.println("Successfully captured a screenshot");

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());

			}

		}
		test = reports.createTest(result.getName() + " test case Failed");

		test.log(com.aventstack.extentreports.Status.FAIL,
				MarkupHelper.createLabel(result.getName() + " Test Case Failed", ExtentColor.RED));

		// test.addScreenCaptureFromPath("./screenShots/" + result.getName() + ".png",
		// result.getName() + ".png");

		test.log(Status.FAIL, result.getThrowable())
				.addScreenCaptureFromPath("./screenShots/" + result.getName() + ".png", result.getName() + ".png");

		// com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath("./screenShots/",result.getName()
		// + ".png").build();

	}

	public void onTestSkipped(ITestResult result) {
		test = reports.createTest(result.getName() + " test case Skipped");
		test.log(com.aventstack.extentreports.Status.SKIP,
				MarkupHelper.createLabel(result.getName() + " Test Case Failed", ExtentColor.YELLOW));

		System.out.println("The name of the testcase Skipped is :" + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("on Test fail ButWithin Success Percentage method invked.......");

	}

	public void onTestFailedWithTimeout(ITestResult result) {

		System.out.println("Name of Test failed With Timeouts is :-" + result.getTestName());

	}

	public void onStart(ITestContext context) {

		configReport();
		System.out.println(" Test is started ");
	}

	public void onFinish(ITestContext context) {
		reports.flush();
		/*
		 * try { Desktop.getDesktop().browse(new File("Reports/Report.html").toURI()); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		System.out.println("Name of finished test  is :-" + context.getName());
	}

}
