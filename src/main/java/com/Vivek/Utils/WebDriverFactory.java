package com.Vivek.Utils;

import com.Vivek.config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriverFactory {

    static TestConfig config = new TestConfig();
    private static final String REMOTE_URL = config.getAccess().getProperty("remote_driver_url");
    private static final String WEB_DRIVER_SOURCE = config.getAccess().getProperty("webdriver_source");
    private static final String MODE = config.getAccess().getProperty("mode");
    private static final Logger logger = Logger.getLogger(Class.class.getName());

    public static WebDriver createWebDriver(String browser) {
        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(MODE);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(MODE);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "safari":
                if(MODE.contains("--headless")){
                    logger.log(Level.INFO, "Safari does not support headless mode.");
                }
                driver = new SafariDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;
    }

    public static WebDriver createRemoteDriver(String browser) throws MalformedURLException {
        URL url = new URL(REMOTE_URL);
        RemoteWebDriver driver;
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(MODE);
                driver = new RemoteWebDriver(url, chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(MODE);
                driver =new RemoteWebDriver(url, firefoxOptions);
                break;
            case "safari":
                SafariOptions safariOptions = new SafariOptions();
                if(MODE.contains("--headless")){
                    logger.log(Level.INFO, "Safari does not support headless mode.");
                }
                driver = new RemoteWebDriver(url, safariOptions);
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;
    }

    public static WebDriver createWebDriver(String browser, String source){
        WebDriver driver = null;
        try{
            if(WEB_DRIVER_SOURCE.contains("remote")){
                driver = createRemoteDriver(browser);
            } else {
                driver = createWebDriver(browser);
            }
        } catch (Exception e){
            logger.log(Level.INFO, "Web driver not created " + e.getStackTrace());
        }
        return driver;
    }

    public static void quitWebDriver(WebDriver driver) {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
