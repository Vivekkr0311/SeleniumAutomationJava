package com.Vivek.tests;

import com.Vivek.Pages.BasketPage;
import com.Vivek.Pages.HomePage;
import com.Vivek.Utils.RunTimeStorage;
import com.Vivek.Utils.WebDriverFactory;
import com.Vivek.config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePage_Add_Product_Into_Basket_04 {

    static WebDriver driver = null;
    static TestConfig config = new TestConfig();
    private static final String WEB_BROWSER = config.getAccess().getProperty("web_browser");
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
        RunTimeStorage.clearStorage();
    }

    @Test
    public static void homePage_Add_Product_To_Basket(){
        clickOnShop();
        clickOnHomeButton();
        validateNewArrivals();
        addProductInBasket();
        clickOnBasketPage();
        validatingProduct();
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

    private static void addProductInBasket(){
        logger.log(Level.INFO, "Adding product into the basket");
        try{
            HomePage.addProductIntoTheBasket(driver);
            Thread.sleep(1000);
        } catch (Exception e){
            logger.log(Level.WARNING, "Adding product into the basket failed\n" + e.getStackTrace());
        }
    }

    private static void clickOnBasketPage(){
        logger.log(Level.INFO, "Click on add to basket button");
        try{
            BasketPage.addProductToBasketMethod(driver);
            Thread.sleep(1000);
        } catch (Exception e){
            logger.log(Level.WARNING, "Click on add to basket failed\n" + e.getStackTrace());
        }
    }

    private static void validatingProduct(){
        logger.log(Level.INFO, "Validating product name");
        try{
            BasketPage.validatingProductName(driver);
            Thread.sleep(1000);
        }catch (Exception e){
            logger.log(Level.WARNING, "Validating product name failed " + e.getStackTrace());
        }
    }
}
