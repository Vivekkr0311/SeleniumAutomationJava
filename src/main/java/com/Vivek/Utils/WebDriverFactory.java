package com.Vivek.Utils;

import com.Vivek.config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriverFactory {

    static TestConfig config = new TestConfig();
    private static final String REMOTE_URL = config.getAccess().getProperty("remote_driver_url");
    private static final Logger logger = Logger.getLogger(Class.class.getName());

    public static WebDriver createWebDriver(String browser) {
        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;
    }

    public static WebDriver createRemoteDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        URL url = new URL(REMOTE_URL);
        return new RemoteWebDriver(url, options);
    }

    public static WebDriver createWebDriver(String browser, String source){
        WebDriver driver = null;
        try{
            if(source.contains("internal")){
                driver = createRemoteDriver();
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
