package com.Vivek.tests;

import com.Vivek.Pages.HomePage;
import com.Vivek.config.TestConfig;
import com.Vivek.Utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//    1) Open the browser
//2) Enter the URL “http://practice.automationtesting.in/”
//            3) Click on Shop Menu
//4) Now click on Home menu button
//5) Test whether the Home page has Three Sliders only
//6) The Home page must contains only three sliders
public class HomePage_With_Three_Sliders_02 {

    static WebDriver driver = null;
    static TestConfig config = new TestConfig();
    private static final String SAFARI = config.getAccess().getProperty("SAFARI");
    private static final String CHROME = config.getAccess().getProperty("CHROME");

    @BeforeClass
    public void setUpMethod(){
        driver = WebDriverFactory.createWebDriver(CHROME);
    }

    @AfterClass
    public void cleanUpMethod(){
        WebDriverFactory.quitWebDriver(driver);
    }

    @Test
    public static void test() throws InterruptedException {
        clickOnShop();
        Thread.sleep(1000);
    }

    private static void clickOnShop(){
        HomePage.launchWebSite(driver);
        HomePage.clickOnShopButton(driver);
    }
}
