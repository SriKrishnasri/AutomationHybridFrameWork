package Hybridframework.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports GenerateExtentreport() {

		ExtentReports extentReport = new ExtentReports();

		File extentReportFile = new File(
				System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

		sparkReporter.config().setTheme(Theme.DARK);

		sparkReporter.config().setReportName("Automation framework");

		sparkReporter.config().setDocumentTitle("testing framework");

		sparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm::ss");

		extentReport.attachReporter(sparkReporter);

		Properties configProp = new Properties();

		File configPropFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\Hybridframework\\config\\config.properties");
		try {
			FileInputStream fisConfigProp = new FileInputStream(configPropFile);

			configProp.load(fisConfigProp);
		} catch (Throwable e) {

			e.printStackTrace();

		}
		extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));

		extentReport.setSystemInfo("broswerName", configProp.getProperty("browser"));

		extentReport.setSystemInfo("email", configProp.getProperty("Email"));

		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));

		extentReport.setSystemInfo("Java Version", System.getProperty("user.name"));

		extentReport.setSystemInfo("UserName", System.getProperty("java.version"));

		return extentReport;

	}
	
}
