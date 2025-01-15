package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})

public class SearchProductTest extends TestBase {
    private MyAccountPage myAccountPage;
    private static final String SEARCH_TERM = "Printed Summer Dress ";
	@BeforeMethod(description = "Valid user logs into the application")
	public void setup() {
		myAccountPage =	homePage.goToLoginPage().doLoginWith("roloh10731@digopm.com", "password");
	}
	
    
    

@Test(description = "Verify if the logged in user  is able to search for a product and correct products", groups = {"e2e" , "sanity","smoke"})
	public void VerifyProductSearchTest() {
		
	String data = myAccountPage.searchForAProduct("Printed Summer Dress").getSearchResultTitle();
	System.out.println(data);
	}



@Test(description = "Verify if the user is logged and all the Dress Names are getting printed on the console", groups = {"e2e" , "sanity","smoke"})
public void getAllDressNames() {
	
boolean actualResult = myAccountPage.searchForAProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
Assert.assertEquals(actualResult, true);
}
}

