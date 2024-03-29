package com.Vivek.tests;

import com.Vivek.Pages.BasketPage;
import com.Vivek.Pages.HomePage;
import com.Vivek.Utils.RunTimeStorage;
import com.Vivek.Utils.WebDriverFactory;
import com.Vivek.config.TestConfig;
import io.qameta.allure.Step;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePage_Desciption_Validation_05 {
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
        RunTimeStorage.clearStorage();
    }

    @Test
    public static void homePage_Add_Product_To_Basket(){
        clickOnShop();
        clickOnHomeButton();
        validateNewArrivals();
        addProductInBasket();
        storeProductDescription();
        validateProductDescription();
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
            Throw.valueOf(e.getMessage());
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
            Throw.valueOf(e.getMessage());
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
            Throw.valueOf(e.getMessage());
        }
    }

    @Step
    private static void addProductInBasket(){
        logger.log(Level.INFO, "Adding product into the basket");
        try{
            HomePage.addProductIntoTheBasket(driver);
            Thread.sleep(1000);
        } catch (Exception e){
            logger.log(Level.WARNING, "Adding product into the basket failed\n" + e.getStackTrace());
            Throw.valueOf(e.getMessage());
        }
    }

    @Step
    private static void storeProductDescription(){
        logger.log(Level.INFO, "Storing product description");
        try{
            BasketPage.storeProductDescription(driver);
            Thread.sleep(1000);
        } catch (Exception e){
            logger.log(Level.WARNING, "Storing product description failed " + e.getStackTrace());
            Throw.valueOf(e.getMessage());
        }
    }

    @Step
    private static void validateProductDescription(){
        logger.log(Level.INFO, "Validating product description");
        try{
            String productDescription = RunTimeStorage.getValue("productDescription");
            Assert.assertTrue(!productDescription.isEmpty());
        }catch (Exception e){
            logger.log(Level.WARNING, "Validating product description failed");
            Throw.valueOf(e.getMessage());
        }
    }
}
