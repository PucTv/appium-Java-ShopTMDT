package com.example.appium.pages;

import com.example.appium.config.DriverManager;
import com.example.appium.utils.ActionUtils;
import com.example.appium.utils.WaitUtils;
import com.example.appium.utils.MobileGestureUtils;
import com.example.appium.utils.ScreenshotUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;





































public class BasePage {
    
    protected static final Logger logger = Logger.getLogger(BasePage.class);
    protected AppiumDriver driver;
    
    


    public BasePage() {
        this.driver = DriverManager.getDriver();
    }
    
    
    protected void click(By locator) {
        ActionUtils.click(locator);
    }
    
    protected void click(WebElement element) {
        ActionUtils.clickDirect(element);
    }
    
    
    protected void type(By locator, String text) {
        ActionUtils.sendKeys(locator, text);
    }
    
    protected void type(WebElement element, String text) {
        ActionUtils.typeText(element, text);
    }
    
    protected void clearAndType(By locator, String text) {
        ActionUtils.sendKeys(locator, text);
    }
    
    protected String getText(By locator) {
        return ActionUtils.getText(locator);
    }
    
    protected String getText(WebElement element) {
        return ActionUtils.getTextDirect(element);
    }
    
    
    protected WebElement waitForElement(By locator) {
        return WaitUtils.waitForElementToBeVisible(locator);
    }
    
    protected WebElement waitForElement(By locator, long timeoutSeconds) {
        return WaitUtils.waitForElementToBeVisible(locator, timeoutSeconds);
    }
    
    protected WebElement waitForClickable(By locator) {
        return WaitUtils.waitForElementToBeClickable(locator);
    }
    
    protected WebElement waitForPresent(By locator) {
        return WaitUtils.waitForElementToBePresent(locator);
    }
    
    
    protected void swipe(int startX, int startY, int endX, int endY, int duration) {
        MobileGestureUtils.swipe(startX, startY, endX, endY, duration);
    }
    
    protected void scrollUp() {
        MobileGestureUtils.scrollUp();
    }
    
    protected void scrollDown() {
        MobileGestureUtils.scrollDown();
    }
    
    protected void tap(int x, int y) {
        MobileGestureUtils.tap(x, y);
    }
    
    protected void doubleTap(int x, int y) {
        MobileGestureUtils.doubleTap(x, y);
    }
    
    protected void longPress(int x, int y, int durationMs) {
        MobileGestureUtils.longPress(x, y, durationMs);
    }
    
    
    protected boolean isElementDisplayed(By locator) {
        return ActionUtils.isElementDisplayed(locator);
    }
    
    protected boolean isElementEnabled(By locator) {
        return ActionUtils.isElementEnabled(locator);
    }
    
    public boolean isElementSelected(By locator) {
        return ActionUtils.isElementSelected(locator);
    }
    
    protected String getAttribute(By locator, String attributeName) {
        return ActionUtils.getAttribute(locator, attributeName);
    }
    
    
    protected String captureScreenshot(String screenshotName) {
        return ScreenshotUtils.captureScreenshot(screenshotName);
    }
    
    protected String captureScreenshot() {
        return ScreenshotUtils.captureScreenshot();
    }
    
    
    



    public void verifyPageLoaded() {
        logger.info("Verifying page loaded...");
        
    }
    
    


    public String getPageTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            logger.error("Failed to get page title", e);
            return "";
        }
    }
    
    


    public String getCurrentUrl() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            logger.error("Failed to get current URL", e);
            return "";
        }
    }
    
    
    


    protected void waitSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
            logger.info("âœ“ Waited for " + seconds + " seconds");
        } catch (InterruptedException e) {
            logger.error("Wait was interrupted", e);
        }
    }
}
