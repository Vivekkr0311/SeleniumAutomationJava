package com.Vivek.Pages;

import com.Vivek.Utils.RunTimeStorage;
import com.Vivek.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BasketPage {

    static TestConfig config = new TestConfig();

    private static final String ADD_PRODUCT_TO_BASKET_BUTTON = "//button[contains(text(), 'Add to basket')]";
    private static final String VIEW_BASKET_BUTTON = "//a[contains(text(), 'View Basket')]";
    private static final String PRODUCT_TITLE = "//td[@class='product-name']/a";
    private static final String PRODUCT_DESCRIPTION_XAPTH = "//div[@id='tab-description']/p";
    private static final String PRODUCT_REVIEW_TAB = "//a[contains(text(), 'Reviews')]";
    private static final String REVIEWS_HEADING_REVIEW_TAB = "//h2[contains(text(), 'Reviews')]";

    public static WebDriver addProductToBasketMethod(WebDriver driver){
        WebElement addToBasket = driver.findElement(By.xpath(ADD_PRODUCT_TO_BASKET_BUTTON));
        addToBasket.click();
        return driver;
    }

    public static WebDriver validatingProductName(WebDriver driver){
        WebElement viewBasketButton = driver.findElement(By.xpath(VIEW_BASKET_BUTTON));
        viewBasketButton.click();

        String productName = RunTimeStorage.getValue("productTitle");
        String productTitleInBasketPage = driver.findElement(By.xpath(PRODUCT_TITLE)).getText();

        Assert.assertEquals(productName, productTitleInBasketPage);
        return driver;
    }

    public static WebDriver storeProductDescription(WebDriver driver){
        WebElement productDescription = driver.findElement(By.xpath(PRODUCT_DESCRIPTION_XAPTH));
        String productDescriptionText = productDescription.getText();
        RunTimeStorage.storeValue("productDescription", productDescriptionText);
        return driver;
    }

    public static WebDriver clickOnReviewTab(WebDriver driver){
        WebElement reviewTab = driver.findElement(By.xpath(PRODUCT_REVIEW_TAB));
        reviewTab.click();

        WebElement reviewHeading = driver.findElement(By.xpath(REVIEWS_HEADING_REVIEW_TAB));
        boolean reviewHeadDisplayed = reviewHeading.isDisplayed();
        RunTimeStorage.storeValue("isHeadingDisplayed", String.valueOf(reviewHeadDisplayed));
        return driver;
    }
}
