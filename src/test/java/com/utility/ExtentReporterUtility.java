package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
    private static ExtentReports extentReports; // Global ExtentReports instance
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // Set up the ExtentReports and SparkReporter
    public static void setupSparkReporter(String reportName) {
        if (extentReports == null) { // Ensure it's initialized only once
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
                    System.getProperty("user.dir") + "/" + reportName);

            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
        }
    }

    // Create an ExtentTest for the current thread
    public static void createExtentTest(String testName) {
        if (extentReports == null) {
            throw new IllegalStateException("ExtentReports is not initialized. Call setupSparkReporter() first.");
        }
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
    }

    // Get the ExtentTest for the current thread
    public static ExtentTest getTest() {
        ExtentTest test = extentTest.get();
        if (test == null) {
            throw new IllegalStateException("No ExtentTest found for the current thread. Ensure createExtentTest() is called.");
        }
        return test;
    }

    // Flush the ExtentReports to write results
    public static void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
