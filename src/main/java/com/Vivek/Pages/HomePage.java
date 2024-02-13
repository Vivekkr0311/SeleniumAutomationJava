package com.Vivek.Pages;

import org.openqa.selenium.WebDriver;

import static com.Vivek.Utils.WebDriverFactory.createWebDriver;

public class HomePage {

    private static final String targetURL = "https://practice.automationtesting.in";

    public static WebDriver launchWebSite(String browser){
        WebDriver driver = createWebDriver(browser);
        driver.get(targetURL);

        return driver;
    }
}
