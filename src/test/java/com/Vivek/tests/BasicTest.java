package com.Vivek.tests;

import com.Vivek.Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BasicTest {
    static WebDriver driver = null;

    @Test
    public static void test() throws InterruptedException {
        driver = HomePage.launchWebSite("chrome");
        System.out.println("Website Launched!");
        Thread.sleep(1000);
        driver.quit();
    }
}
