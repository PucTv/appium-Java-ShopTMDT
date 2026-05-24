package com.example.appium.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.appium.config.DriverManager;

import io.appium.java_client.AppiumDriver;

public class ActionUtils {

    private static final Logger logger = Logger.getLogger(ActionUtils.class);
    private static AppiumDriver driver = DriverManager.getDriver();

    public static void click(By locator) {
        try {
            WebElement element = WaitUtils.waitForElementToBeClickable(locator);
            element.click();
            logger.info("âœ“ Clicked on element: " + locator);
        } catch (Exception e) {
            logger.error("âœ— Failed to click element: " + locator, e);
            throw e;
        }
    }

    public static void clickDirect(WebElement element) {
        try {
            element.click();
            logger.info("âœ“ Clicked on element");
        } catch (Exception e) {
            logger.error("âœ— Failed to click element", e);
            throw e;
        }
    }

    public static void sendKeys(By locator, String text) {
        try {
            WebElement element = WaitUtils.waitForElementToBeVisible(locator);
            element.clear();
            element.sendKeys(text);
            logger.info("âœ“ Typed text: '" + text + "' into element: " + locator);
        } catch (Exception e) {
            logger.error("âœ— Failed to type text into element: " + locator, e);
            throw e;
        }
    }

    public static void typeText(WebElement element, String text) {
        try {
            element.sendKeys(text);
            logger.info("âœ“ Typed text: '" + text + "'");
        } catch (Exception e) {
            logger.error("âœ— Failed to type text", e);
            throw e;
        }
    }

    public static String getText(By locator) {
        try {
            WebElement element = WaitUtils.waitForElementToBeVisible(locator);
            String text = element.getText();
            logger.info("âœ“ Got text from element: '" + text + "'");
            return text;
        } catch (Exception e) {
            logger.error("âœ— Failed to get text from element: " + locator, e);
            throw e;
        }
    }

    public static String getTextDirect(WebElement element) {
        try {
            String text = element.getText();
            logger.info("âœ“ Got text: '" + text + "'");
            return text;
        } catch (Exception e) {
            logger.error("âœ— Failed to get text", e);
            throw e;
        }
    }

    public static String getAttribute(By locator, String attributeName) {
        try {
            WebElement element = WaitUtils.waitForElementToBePresent(locator);
            String value = element.getAttribute(attributeName);
            logger.info("âœ“ Got attribute '" + attributeName + "': '" + value + "'");
            return value;
        } catch (Exception e) {
            logger.error("âœ— Failed to get attribute: " + attributeName, e);
            throw e;
        }
    }

    public static void clearText(By locator) {
        try {
            WebElement element = WaitUtils.waitForElementToBeVisible(locator);
            element.clear();
            logger.info("âœ“ Cleared text from element: " + locator);
        } catch (Exception e) {
            logger.error("âœ— Failed to clear text: " + locator, e);
            throw e;
        }
    }

    public static boolean isElementDisplayed(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            logger.warn("âœ— Element not displayed: " + locator);
            return false;
        }
    }

    public static boolean isElementEnabled(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isEnabled();
        } catch (Exception e) {
            logger.warn("âœ— Element not enabled: " + locator);
            return false;
        }
    }

    public static boolean isElementSelected(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isSelected();
        } catch (Exception e) {
            logger.warn("âœ— Element not selected: " + locator);
            return false;
        }
    }
}
