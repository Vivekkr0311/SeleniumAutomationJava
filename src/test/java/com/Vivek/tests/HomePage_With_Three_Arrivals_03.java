package com.Vivek.tests;

import com.Vivek.Pages.HomePage;
import com.Vivek.Utils.WebDriverFactory;
import com.Vivek.config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePage_With_Three_Arrivals_03 {

    static WebDriver driver = null;
    static TestConfig config = new TestConfig();
    private static final String SAFARI = config.getAccess().getProperty("SAFARI");
    private static final String CHROME = config.getAccess().getProperty("CHROME");
    private static final String WEB_BROWSER = CHROME;
    private static final Logger logger = Logger.getLogger(Class.class.getName());

    @BeforeClass
    public void setUpMethod(){
        logger.log(Level.INFO, "Crating web driver " + WEB_BROWSER);
        driver = WebDriverFactory.createWebDriver(WEB_BROWSER);
    }

    @AfterClass
    public void cleanUpMethod(){
        logger.log(Level.INFO, "Cleaning up web driver " + WEB_BROWSER);
        WebDriverFactory.quitWebDriver(driver);
    }

    @Test
    public static void homePage_With_New_Arrivals_03(){
        clickOnShop();
        clickOnHomeButton();
        validateNewArrivals();
    }

    private static void clickOnShop(){
        logger.log(Level.INFO, "Click on shop method execution");
        try {
            HomePage.launchWebSite(driver);
            HomePage.clickOnShopButton(driver);
            Thread.sleep(1000);
        } catch (Exception e){
            logger.log(Level.WARNING, "Click on shop button method failed\n" + e.getStackTrace());
        }
    }

    private static void clickOnHomeButton(){
        logger.log(Level.INFO, "Click on shop method execution");
        try{
            HomePage.clickOnHomePage(driver);
            Thread.sleep(1000);
        } catch (Exception e){
            logger.log(Level.WARNING, "Click on home button method failed\n" + e.getStackTrace());
        }

    }

    private static void validateNewArrivals(){
        logger.log(Level.INFO, "Validating new arrivals");
        try {
            HomePage.countNewArrivals(driver);
            Thread.sleep(1000);
        } catch (Exception e){
            logger.log(Level.WARNING, "Validating new arrivals failed\n" + e.getStackTrace());
        }
    }
}
