package com.example.appium.utils;

import com.example.appium.config.ConfigProperties;
import com.example.appium.config.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

import java.time.Duration;
import java.util.List;












public class WaitUtils {
    
    private static final Logger logger = Logger.getLogger(WaitUtils.class);
    private static AppiumDriver driver = DriverManager.getDriver();
    
    


    public static WebElement waitForElementToBeVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProperties.getExplicitWait()));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("âœ“ Element is visible: " + locator);
            return element;
        } catch (Exception e) {
            logger.error("âœ— Element not visible within timeout: " + locator, e);
            throw e;
        }
    }
    
    


    public static WebElement waitForElementToBeVisible(By locator, long timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("âœ“ Element is visible: " + locator);
            return element;
        } catch (Exception e) {
            logger.error("âœ— Element not visible within timeout: " + locator, e);
            throw e;
        }
    }
    
    


    public static WebElement waitForElementToBeClickable(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProperties.getExplicitWait()));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            logger.info("âœ“ Element is clickable: " + locator);
            return element;
        } catch (Exception e) {
            logger.error("âœ— Element not clickable within timeout: " + locator, e);
            throw e;
        }
    }
    
    


    public static WebElement waitForElementToBePresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProperties.getExplicitWait()));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            logger.info("âœ“ Element is present: " + locator);
            return element;
        } catch (Exception e) {
            logger.error("âœ— Element not present within timeout: " + locator, e);
            throw e;
        }
    }
    
    


    public static boolean waitForElementToDisappear(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProperties.getExplicitWait()));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            logger.info("âœ“ Element disappeared: " + locator);
            return true;
        } catch (Exception e) {
            logger.error("âœ— Element still visible: " + locator, e);
            return false;
        }
    }
    
    


    public static List<WebElement> waitForElementsToBePresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProperties.getExplicitWait()));
            List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            logger.info("âœ“ Elements are present: " + locator + " (count: " + elements.size() + ")");
            return elements;
        } catch (Exception e) {
            logger.error("âœ— Elements not present within timeout: " + locator, e);
            throw e;
        }
    }
    
    


    public static List<WebElement> waitForElementsToBeVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProperties.getExplicitWait()));
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            logger.info("âœ“ Elements are visible: " + locator + " (count: " + elements.size() + ")");
            return elements;
        } catch (Exception e) {
            logger.error("âœ— Elements not visible within timeout: " + locator, e);
            throw e;
        }
    }
}
