package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class SearchProduct extends BrowserUtility {
	private static final By SEARCH_NAME_LOCATOR=By.xpath("//*[@id=\"center_column\"]/h1/span[1]");

	public SearchProduct(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String getVisibleText() {
		return getVisibleText(SEARCH_NAME_LOCATOR);
		
	}
	
	

}
