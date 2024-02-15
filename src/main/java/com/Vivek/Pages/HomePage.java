package com.Vivek.Pages;

import com.Vivek.Utils.TestConfig;
import org.openqa.selenium.WebDriver;

public class HomePage {

    static TestConfig config = new TestConfig();
    private static final String targetURL = config.getAccess().getProperty("WEB_URL");

    public static WebDriver launchWebSite(WebDriver driver){
        driver.get(targetURL);
        return driver;
    }
}
