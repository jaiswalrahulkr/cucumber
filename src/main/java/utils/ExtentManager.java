package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-reports/ExtentReport.html");
            spark.config().setTimeStampFormat("MMM DD, YYYY, HH:MM:SS");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }


    public static ExtentTest createTest(String testName) {
        test = getExtentReports().createTest(testName);
        return test;
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
