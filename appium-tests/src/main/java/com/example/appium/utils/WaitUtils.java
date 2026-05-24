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

/**
 * WaitUtils - Cung cấp các phương thức chờ (wait) cho các elements
 * Trách nhiệ: Xử lý explicit wait, expected conditions
 * 
 * Các loại wait:
 * 1. waitForElementToBeVisible - Chờ element visible
 * 2. waitForElementToBeClickable - Chờ element clickable
 * 3. waitForElementToBePresent - Chờ element present trong DOM
 * 4. waitForElementToDisappear - Chờ element biến mất
 * 5. waitForMultipleElements - Chờ multiple elements
 */
public class WaitUtils {
    
    private static final Logger logger = Logger.getLogger(WaitUtils.class);
    private static AppiumDriver driver = DriverManager.getDriver();
    
    /**
     * Chờ element visible với explicit wait time
     */
    public static WebElement waitForElementToBeVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProperties.getExplicitWait()));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("✓ Element is visible: " + locator);
            return element;
        } catch (Exception e) {
            logger.error("✗ Element not visible within timeout: " + locator, e);
            throw e;
        }
    }
    
    /**
     * Chờ element visible với custom wait time
     */
    public static WebElement waitForElementToBeVisible(By locator, long timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("✓ Element is visible: " + locator);
            return element;
        } catch (Exception e) {
            logger.error("✗ Element not visible within timeout: " + locator, e);
            throw e;
        }
    }
    
    /**
     * Chờ element clickable
     */
    public static WebElement waitForElementToBeClickable(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProperties.getExplicitWait()));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            logger.info("✓ Element is clickable: " + locator);
            return element;
        } catch (Exception e) {
            logger.error("✗ Element not clickable within timeout: " + locator, e);
            throw e;
        }
    }
    
    /**
     * Chờ element present trong DOM
     */
    public static WebElement waitForElementToBePresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProperties.getExplicitWait()));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            logger.info("✓ Element is present: " + locator);
            return element;
        } catch (Exception e) {
            logger.error("✗ Element not present within timeout: " + locator, e);
            throw e;
        }
    }
    
    /**
     * Chờ element biến mất (invisibility)
     */
    public static boolean waitForElementToDisappear(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProperties.getExplicitWait()));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            logger.info("✓ Element disappeared: " + locator);
            return true;
        } catch (Exception e) {
            logger.error("✗ Element still visible: " + locator, e);
            return false;
        }
    }
    
    /**
     * Chờ multiple elements có trong DOM
     */
    public static List<WebElement> waitForElementsToBePresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProperties.getExplicitWait()));
            List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            logger.info("✓ Elements are present: " + locator + " (count: " + elements.size() + ")");
            return elements;
        } catch (Exception e) {
            logger.error("✗ Elements not present within timeout: " + locator, e);
            throw e;
        }
    }
    
    /**
     * Chờ multiple elements visible
     */
    public static List<WebElement> waitForElementsToBeVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProperties.getExplicitWait()));
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            logger.info("✓ Elements are visible: " + locator + " (count: " + elements.size() + ")");
            return elements;
        } catch (Exception e) {
            logger.error("✗ Elements not visible within timeout: " + locator, e);
            throw e;
        }
    }
}
