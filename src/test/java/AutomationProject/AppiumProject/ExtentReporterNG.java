package AutomationProject.AppiumProject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports extent;

	public static ExtentReports GetReporterObject() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setDocumentTitle("Test Results");
		report.config().setReportName("Mobile Automation Results");

		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Emre");
		return extent;

	}
}
