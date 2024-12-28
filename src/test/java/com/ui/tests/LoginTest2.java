package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;

public class LoginTest2 {

	public static void main(String[] args) {
		WebDriver webDriver = new EdgeDriver();//launch a Browser Window!! Browser session is created !!
		HomePage homePage = new HomePage(webDriver);
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.doLoginWith("roloh10731@digopm.com", "password");
		
	}

}


