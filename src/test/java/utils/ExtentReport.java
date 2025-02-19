package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports getReport() {
		String path="C:\\Users\\Anbarasan_SAM\\eclipse-workspace\\miniProject\\reports\\demoblazeReport.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("DemoBlazeTestResults");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
}