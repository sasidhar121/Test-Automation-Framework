package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
    Logger logger = LoggerUtility.getLogger(this.getClass());

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        try {
            ExtentReporterUtility.setupSparkReporter("TestExecutionReport.html");
        } catch (Exception e) {
            logger.error("Failed to initialize ExtentReporter: " + e.getMessage());
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Starting Test: " + result.getMethod().getMethodName());
        ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test Passed: " + result.getMethod().getMethodName());
        ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed: " + result.getMethod().getMethodName());
        logger.error("Reason: " + result.getThrowable().getMessage());
        ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
        ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().toString());

        try {
            Object testClass = result.getInstance();
            if (testClass instanceof com.ui.tests.TestBase) {
                BrowserUtility browserUtility = ((com.ui.tests.TestBase) testClass).getInstance();
                String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
                logger.info("Screenshot captured at: " + screenshotPath);
                ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
            }
        } catch (Exception e) {
            logger.error("Error while capturing screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test Skipped: " + result.getMethod().getMethodName());
        ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        try {
            ExtentReporterUtility.flushReport();
        } catch (Exception e) {
            logger.error("Failed to flush ExtentReport: " + e.getMessage());
        }
    }
}
