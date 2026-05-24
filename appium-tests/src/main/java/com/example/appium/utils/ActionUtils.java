package com.example.appium.utils;

import com.example.appium.config.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;

/**
 * ActionUtils - Cung cấp các phương thức action trên elements
 * Trách nhiệm: Click, type, tap, swipe, scroll, etc.
 * 
 * Các phương thức:
 * 1. click - Click element
 * 2. sendKeys - Type text vào element
 * 3. getText - Lấy text từ element
 * 4. getAttribute - Lấy attribute value
 * 5. clearText - Xóa text
 * 6. isElementDisplayed - Kiểm tra element hiển thị
 * 7. isElementEnabled - Kiểm tra element enabled
 * 8. isElementSelected - Kiểm tra element selected
 */
public class ActionUtils {
    
    private static final Logger logger = Logger.getLogger(ActionUtils.class);
    private static AppiumDriver driver = DriverManager.getDriver();
    
    /**
     * Click element với wait
     */
    public static void click(By locator) {
        try {
            WebElement element = WaitUtils.waitForElementToBeClickable(locator);
            element.click();
            logger.info("✓ Clicked on element: " + locator);
        } catch (Exception e) {
            logger.error("✗ Failed to click element: " + locator, e);
            throw e;
        }
    }
    
    /**
     * Click element directly (không chờ)
     */
    public static void clickDirect(WebElement element) {
        try {
            element.click();
            logger.info("✓ Clicked on element");
        } catch (Exception e) {
            logger.error("✗ Failed to click element", e);
            throw e;
        }
    }
    
    /**
     * Type text vào input field
     */
    public static void sendKeys(By locator, String text) {
        try {
            WebElement element = WaitUtils.waitForElementToBeVisible(locator);
            element.clear();
            element.sendKeys(text);
            logger.info("✓ Typed text: '" + text + "' into element: " + locator);
        } catch (Exception e) {
            logger.error("✗ Failed to type text into element: " + locator, e);
            throw e;
        }
    }
    
    /**
     * Type text vào element (không clear trước)
     */
    public static void typeText(WebElement element, String text) {
        try {
            element.sendKeys(text);
            logger.info("✓ Typed text: '" + text + "'");
        } catch (Exception e) {
            logger.error("✗ Failed to type text", e);
            throw e;
        }
    }
    
    /**
     * Lấy text từ element
     */
    public static String getText(By locator) {
        try {
            WebElement element = WaitUtils.waitForElementToBeVisible(locator);
            String text = element.getText();
            logger.info("✓ Got text from element: '" + text + "'");
            return text;
        } catch (Exception e) {
            logger.error("✗ Failed to get text from element: " + locator, e);
            throw e;
        }
    }
    
    /**
     * Lấy text trực tiếp từ element
     */
    public static String getTextDirect(WebElement element) {
        try {
            String text = element.getText();
            logger.info("✓ Got text: '" + text + "'");
            return text;
        } catch (Exception e) {
            logger.error("✗ Failed to get text", e);
            throw e;
        }
    }
    
    /**
     * Lấy attribute value
     */
    public static String getAttribute(By locator, String attributeName) {
        try {
            WebElement element = WaitUtils.waitForElementToBePresent(locator);
            String value = element.getAttribute(attributeName);
            logger.info("✓ Got attribute '" + attributeName + "': '" + value + "'");
            return value;
        } catch (Exception e) {
            logger.error("✗ Failed to get attribute: " + attributeName, e);
            throw e;
        }
    }
    
    /**
     * Xóa text từ input field
     */
    public static void clearText(By locator) {
        try {
            WebElement element = WaitUtils.waitForElementToBeVisible(locator);
            element.clear();
            logger.info("✓ Cleared text from element: " + locator);
        } catch (Exception e) {
            logger.error("✗ Failed to clear text: " + locator, e);
            throw e;
        }
    }
    
    /**
     * Kiểm tra element có hiển thị không
     */
    public static boolean isElementDisplayed(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            logger.warn("✗ Element not displayed: " + locator);
            return false;
        }
    }
    
    /**
     * Kiểm tra element có enabled không
     */
    public static boolean isElementEnabled(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isEnabled();
        } catch (Exception e) {
            logger.warn("✗ Element not enabled: " + locator);
            return false;
        }
    }
    
    /**
     * Kiểm tra element có selected không (cho checkbox, radio button)
     */
    public static boolean isElementSelected(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isSelected();
        } catch (Exception e) {
            logger.warn("✗ Element not selected: " + locator);
            return false;
        }
    }
}
