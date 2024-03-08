package com.Vivek.tests.UITests;

import com.Vivek.Pages.HomePage;
import com.Vivek.Utils.WebDriverFactory;
import com.Vivek.config.TestConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePage_With_Three_Arrivals_03 {

    static WebDriver driver = null;
    static TestConfig config = new TestConfig();
    private static final Logger logger = Logger.getLogger(Class.class.getName());

    @BeforeClass
    public void setUpMethod(){
        logger.log(Level.INFO, "Crating web driver ");
        driver = WebDriverFactory.createWebDriver();
    }

    @AfterClass
    public void cleanUpMethod(){
        logger.log(Level.INFO, "Cleaning up web driver ");
        WebDriverFactory.quitWebDriver(driver);
    }

    @Test
    public static void homePage_With_New_Arrivals_03(){
        clickOnShop();
        clickOnHomeButton();
        validateNewArrivals();
    }

    @Step
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

    @Step
    private static void clickOnHomeButton(){
        logger.log(Level.INFO, "Click on shop method execution");
        try{
            HomePage.clickOnHomePage(driver);
            Thread.sleep(1000);
        } catch (Exception e){
            logger.log(Level.WARNING, "Click on home button method failed\n" + e.getStackTrace());
        }

    }

    @Step
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
