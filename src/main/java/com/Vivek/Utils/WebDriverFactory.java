package com.Vivek.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private static final String CHROME_DRIVER_PATH = "path/to/chromedriver.exe";
    private static final String GECKO_DRIVER_PATH = "path/to/geckodriver.exe";

    public static WebDriver createWebDriver(String browser) {
        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;
    }

    public static void quitWebDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
