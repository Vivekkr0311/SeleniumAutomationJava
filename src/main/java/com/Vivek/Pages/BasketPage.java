package com.Vivek.Pages;

import com.Vivek.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage {

    static TestConfig config = new TestConfig();

    private static final String ADD_PRODUCT_TO_BASKET_BUTTON = "//button[contains(text(), 'Add to basket')]";

    public static WebDriver addProductToBasketMethod(WebDriver driver){
        WebElement addToBasket = driver.findElement(By.xpath(ADD_PRODUCT_TO_BASKET_BUTTON));
        addToBasket.click();
        return driver;
    }
}
