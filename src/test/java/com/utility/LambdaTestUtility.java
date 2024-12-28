package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {

	private static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
    private static ThreadLocal<WebDriver> driverlocal = new ThreadLocal<WebDriver>();
    private static ThreadLocal<DesiredCapabilities> capabiltiesLocal = new ThreadLocal<DesiredCapabilities>();
    
    
    public static WebDriver intializeLambdaTestSession(String browser,String testName) {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ltOptions = new HashMap();
        ltOptions.put("user", "sasidhargandikota10");
        ltOptions.put("accessKey", "MymTrB05zohMxLdSHzrDRvNSgAlACZAIs3Mq3qaKCj94QpLEPq");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.23.0");
        capabilities.setCapability("LT:Options", ltOptions);
        capabiltiesLocal.set(capabilities);
        WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(HUB_URL), capabiltiesLocal.get());
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
        driverlocal.set(driver);
        
        return driverlocal.get();
    }
  
 public static void quitSession() {
	 if(driverlocal.get() != null) {
		 driverlocal.get().quit();
	 
	 }
 }

}


