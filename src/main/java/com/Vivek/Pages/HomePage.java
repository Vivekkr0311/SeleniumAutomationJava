package com.Vivek.Pages;

import com.Vivek.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.testng.Assert;

public class HomePage {

    static TestConfig config = new TestConfig();
    private static final String targetURL = config.getAccess().getProperty("WEB_URL");
    private static final String HOME_PAGE_SHOP_BUTTON_XPATH = "//li[@id='menu-item-40']";
    private static final String HOME_PAGE_HOME_BUTTON_XPATH = "//a[contains(text(), 'Home')]";
    private static final String NEW_ARRIVALS_XPATH = "(((//h2[contains(text(), 'new arrivals')]/ancestor::div)[11])/div[@class='tb-column-inner']/div)[2]/div";
    private static final String THREE_SLIDERS_XPATH = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div";
    private static final String FIRST_PRODUCT_NEW_ARRIVAL_IMAGE_XPATH = "(//a[@class='woocommerce-LoopProduct-link'])[1]/img";

    public static WebDriver launchWebSite(WebDriver driver){
        driver.get(targetURL);
        return driver;
    }

    public static WebDriver clickOnShopButton(WebDriver driver){
        WebElement shopButton = driver.findElement(By.xpath(HOME_PAGE_SHOP_BUTTON_XPATH));
        shopButton.click();
        return driver;
    }

    public static WebDriver clickOnHomePage(WebDriver driver){
        WebElement homePageButton = driver.findElement(By.xpath(HOME_PAGE_HOME_BUTTON_XPATH));
        homePageButton.click();
        return driver;
    }

    public static WebDriver countSliders(WebDriver driver){
        List<WebElement> sliders = driver.findElements(By.xpath(THREE_SLIDERS_XPATH));
        Assert.assertEquals(3, sliders.size());
        return driver;
    }

    public static WebDriver countNewArrivals(WebDriver driver){
        List<WebElement> sliders = driver.findElements(By.xpath(NEW_ARRIVALS_XPATH));
        Assert.assertEquals(3, sliders.size());
        return driver;
    }

    public static WebDriver addProductIntoTheBasket(WebDriver driver){
        WebElement firstProductNewArrival = driver.findElement(By.xpath(FIRST_PRODUCT_NEW_ARRIVAL_IMAGE_XPATH));
        firstProductNewArrival.click();
        return driver;
    }
}
