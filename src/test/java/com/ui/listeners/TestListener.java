package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
    Logger logger = LoggerUtility.getLogger(this.getClass());

    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        // Create a new ExtentTest instance when the test starts
        ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " " + "PASSED");
        // Check if the ExtentTest instance is valid before logging
        ExtentTest test = ExtentReporterUtility.getTest();
        if (test != null) {
            test.log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
        }
    }

    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + " " + "FAILED");
        logger.error(result.getThrowable().getMessage());
        // Check if the ExtentTest instance is valid before logging
        ExtentTest test = ExtentReporterUtility.getTest();
        if (test != null) {
            test.log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
            test.log(Status.FAIL, result.getThrowable().getMessage());

            // Capture screenshot and attach it to the report
            Object testClass = result.getInstance();
            BrowserUtility browserUtility = ((TestBase) testClass).getInstance();
            String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(screenshotPath);
        }
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
        // Check if the ExtentTest instance is valid before logging
        ExtentTest test = ExtentReporterUtility.getTest();
        if (test != null) {
            test.log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");
        }
    }

    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        // Initialize the report at the start of the test suite
        ExtentReporterUtility.setupSparkReporter("report.html");
    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        // Ensure the report is flushed after all tests are finished
        ExtentReporterUtility.flushReport();
    }
}
