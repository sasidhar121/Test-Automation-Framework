package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtlity;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtlity.getLogger(this.getClass());
	private boolean isLambdaTest;

	@Parameters({"browser","isLambdaTest","isHeadLess"})
	@BeforeMethod(description = "Load the Homepage of the website")

	public void setup(@Optional("chrome") String browser, @Optional("false") boolean isLambdaTest,
			@Optional("true") boolean isHeadLess, ITestResult result) {

		this.isLambdaTest = isLambdaTest;

		WebDriver lambdaDriver;
		if (isLambdaTest) {

			lambdaDriver = LambdaTestUtility.intializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);

		} else {
			// Running the test on local machine!!!
			logger.info("Load the Homepage of the website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadLess);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {
		if (isLambdaTest) {
			LambdaTestUtility.quitSession();// close the browsersession on LT
		}
		homePage.quit();// local
	}
}
