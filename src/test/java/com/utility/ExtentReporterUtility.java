package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void setupSparkReporter(String reportName) {
        if (extentReports == null) { // Ensure it is initialized only once
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
                    System.getProperty("user.dir") + "/" + reportName);
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
        }
    }

    public static void createExtentTest(String testName) {
        if (extentReports == null) {
            throw new IllegalStateException("ExtentReports is not initialized. Call setupSparkReporter() first.");
        }
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
    }

    public static ExtentTest getTest() {
        ExtentTest test = extentTest.get();
        if (test == null) {
            throw new IllegalStateException("No ExtentTest found for the current thread. Ensure createExtentTest() is called.");
        }
        return test;
    }

    public static void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
        } else {
            throw new IllegalStateException("ExtentReports is not initialized. Cannot flush the report.");
        }
    }
}
