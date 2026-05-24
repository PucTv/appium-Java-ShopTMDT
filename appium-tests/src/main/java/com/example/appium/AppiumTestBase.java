package com.example.appium;

import com.example.appium.config.DriverManager;
import com.example.appium.utils.ActionUtils;
import com.example.appium.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;

public class AppiumTestBase extends AppiumBaseClass {

    private static final Logger logger = Logger.getLogger(AppiumTestBase.class);

    @Deprecated
    public static WebElement findElementById(String id) {
        logger.warn("â  findElementById() is deprecated. Use WaitUtils or ActionUtils instead.");
        return DriverManager.getDriver().findElement(By.id(id));
    }

    @Deprecated
    public static WebElement findElementByXPath(String xpath) {
        logger.warn("â  findElementByXPath() is deprecated. Use WaitUtils or ActionUtils instead.");
        return DriverManager.getDriver().findElement(By.xpath(xpath));
    }

    @Deprecated
    public static void clickElement(WebElement element) {
        logger.warn("â  clickElement() is deprecated. Use ActionUtils.click() instead.");
        element.click();
    }

    @Deprecated
    public static void typeText(WebElement element, String text) {
        logger.warn("â  typeText() is deprecated. Use ActionUtils.sendKeys() instead.");
        element.sendKeys(text);
    }

    @Deprecated
    public static String getElementText(WebElement element) {
        logger.warn("â  getElementText() is deprecated. Use ActionUtils.getText() instead.");
        return element.getText();
    }
}
