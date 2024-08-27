package SGS.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReporterNG {
	
	public static ExtentReports   getReportObject() {
		

		String path = System.getProperty ("user.dir") +"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("SGS Editor page");
		reporter.config().setDocumentTitle("SportsGearSwag");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester name", "Ramanpreet singh");
		return extent;
	}

}
