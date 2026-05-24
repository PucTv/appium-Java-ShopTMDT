package com.example.appium;

import com.example.appium.config.DriverManager;
import com.example.appium.utils.ActionUtils;
import com.example.appium.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;

/**
 * AppiumTestBase - Base class cho tất cả test classes (Legacy)
 * 
 * DEPRECATED: Tạo test class mới nên extend từ một page class thay vì class này
 * VÍ DỤ CỔ:
 * public class LoginTest extends AppiumTestBase {
 *     public void testLogin() {
 *         findElementById("username").sendKeys("user");
 *     }
 * }
 * 
 * VÍ DỤ MỚI (KHUYẾN NGHỊ):
 * public class LoginTest extends AppiumBaseClass {
 *     private LoginPage loginPage;
 *     
 *     @BeforeMethod
 *     public void setup() {
 *         DriverManager.initializeDriver();
 *         loginPage = new LoginPage();
 *         loginPage.verifyPageLoaded();
 *     }
 *     
 *     public void testLogin() {
 *         loginPage.login("user@example.com", "password");
 *     }
 * }
 */
public class AppiumTestBase extends AppiumBaseClass {

    private static final Logger logger = Logger.getLogger(AppiumTestBase.class);

    /**
     * Find element by ID
     * @deprecated - Sử dụng WaitUtils.waitForElementToBeVisible() hoặc ActionUtils.click()
     */
    @Deprecated
    public static WebElement findElementById(String id) {
        logger.warn("⚠ findElementById() is deprecated. Use WaitUtils or ActionUtils instead.");
        return DriverManager.getDriver().findElement(By.id(id));
    }

    /**
     * Find element by XPath
     * @deprecated - Sử dụng WaitUtils.waitForElementToBeVisible() hoặc ActionUtils.click()
     */
    @Deprecated
    public static WebElement findElementByXPath(String xpath) {
        logger.warn("⚠ findElementByXPath() is deprecated. Use WaitUtils or ActionUtils instead.");
        return DriverManager.getDriver().findElement(By.xpath(xpath));
    }

    /**
     * Click on element
     * @deprecated - Sử dụng ActionUtils.click()
     */
    @Deprecated
    public static void clickElement(WebElement element) {
        logger.warn("⚠ clickElement() is deprecated. Use ActionUtils.click() instead.");
        element.click();
    }

    /**
     * Type text into element
     * @deprecated - Sử dụng ActionUtils.sendKeys()
     */
    @Deprecated
    public static void typeText(WebElement element, String text) {
        logger.warn("⚠ typeText() is deprecated. Use ActionUtils.sendKeys() instead.");
        element.sendKeys(text);
    }

    /**
     * Get text from element
     * @deprecated - Sử dụng ActionUtils.getText()
     */
    @Deprecated
    public static String getElementText(WebElement element) {
        logger.warn("⚠ getElementText() is deprecated. Use ActionUtils.getText() instead.");
        return element.getText();
    }
}
