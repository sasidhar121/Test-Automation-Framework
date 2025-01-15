package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Size;
import com.ui.pages.SearchResultPage;


public class ProductCheckoutTest extends TestBase {
	private static final String SEARCH_TERM ="Printed Summer Dress";
	
	private SearchResultPage searchResultPage;
	@BeforeMethod(description = "User logs into the application and searches for a product")
	public void setup() {
		searchResultPage =homePage.goToLoginPage().doLoginWith("roloh10731@digopm.com", "password").searchForAProduct(SEARCH_TERM);
	}
	
	
	
	@Test(description = "Verify if the logged in User is able to buy a dress" , groups = {"e2e" , "sanity","smoke"})
	public void checkoutTest() {
	String result = searchResultPage.clickOnTheProductAtIndex(0).changeSize(Size.L).addProductToCart().proceedToCheckout().goToConfirmAddressPage().goToShipmentPage().goToPaymentPage().makePaymentByWire();
		
  Assert.assertTrue(result.contains("complete"));
	
	}

}
