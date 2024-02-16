package com.Vivek.tests;

import com.Vivek.Pages.HomePage;
import com.Vivek.config.TestConfig;
import com.Vivek.Utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BasicTest_01 {
    static WebDriver driver = null;
    static TestConfig config = new TestConfig();
    private static final String SAFARI = config.getAccess().getProperty("SAFARI");
    private static final String CHROME = config.getAccess().getProperty("CHROME");

    @BeforeClass
    public static void setUpMethod(){
        driver = WebDriverFactory.createWebDriver(CHROME);
    }

    @AfterClass
    public static void cleanUpMethod(){
        WebDriverFactory.quitWebDriver(driver);
    }

    @Test
    public static void test() throws InterruptedException {
        HomePage.launchWebSite(driver);
        System.out.println("Website Launched!");
        Thread.sleep(1000);
    }
}
