package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import com.utility.BrowserUtility;

public class LoginTestOLD {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();// launch a Browser Window!! Browser session is created !!
		BrowserUtility browserUtility = new BrowserUtility(wd);

		browserUtility.gotoWebSite("http://www.automationpractice.pl/index.php?");
		browserUtility.maximizeWindow();

		By signInLinkLocator = By.xpath("//a[contains(text(), \"Sign in\")]");
		browserUtility.clickOn(signInLinkLocator);

		By emailTextBoxLocator = By.id("email");
		browserUtility.enterText(emailTextBoxLocator, "roloh10731@digopm.com");

		By passwordTextBoxLocator = By.id("passwd");
		browserUtility.enterText(passwordTextBoxLocator, "password");

		By submitLoginButtonLocator = By.id("SubmitLogin");
		browserUtility.clickOn(submitLoginButtonLocator);
	}

}
