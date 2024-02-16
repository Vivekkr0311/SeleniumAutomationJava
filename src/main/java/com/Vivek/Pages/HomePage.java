package com.Vivek.Pages;

import com.Vivek.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    static TestConfig config = new TestConfig();
    private static final String targetURL = config.getAccess().getProperty("WEB_URL");
    private static final String HOME_PAGE_SHOP_BUTTON_XPATH = "//li[@id='menu-item-40']";
    private static final String HOME_PAGE_HOME_BUTTON_XPATH = "//li[@id='menu-item-40']";

    public static WebDriver launchWebSite(WebDriver driver){
        driver.get(targetURL);
        return driver;
    }

    public static WebDriver clickOnShopButton(WebDriver driver){
        WebElement shopButton = driver.findElement(By.xpath(HOME_PAGE_SHOP_BUTTON_XPATH));
        shopButton.click();
        return driver;
    }
}
