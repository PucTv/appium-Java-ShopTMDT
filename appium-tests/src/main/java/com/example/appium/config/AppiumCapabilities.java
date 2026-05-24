package com.example.appium.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * AppiumCapabilities - Quản lý tất cả Desired Capabilities cho Android và iOS
 * Trách nhiệm: Cấu hình driver dựa trên platform
 */
public class AppiumCapabilities {

    private static final String APPIUM_SERVER_URL = ConfigProperties.getAppiumServerUrl();

    /**
     * Tạo Android Driver với các capabilities cơ bản
     * @param appPath - Đường dẫn đến APK file
     * @param appPackage - Package name của app
     * @param appActivity - Activity name của app
     * @return AndroidDriver instance
     */
    public static AppiumDriver getAndroidDriver(String appPath, String appPackage, String appActivity) 
            throws MalformedURLException {
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", ConfigProperties.getAndroidDeviceName());
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", appPath);
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);
        
        // Thêm các capabilities phổ biến
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("noReset", false);
        caps.setCapability("fullReset", false);
        
        AppiumDriver driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), caps);
        setImplicitWait(driver, ConfigProperties.getImplicitWait());
        
        return driver;
    }

    /**
     * Tạo iOS Driver với các capabilities cơ bản
     * @param bundleId - Bundle ID của app
     * @param udid - UDID của thiết bị
     * @return IOSDriver instance
     */
    public static AppiumDriver getIOSDriver(String bundleId, String udid) 
            throws MalformedURLException {
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("deviceName", ConfigProperties.getIOSDeviceName());
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("bundleId", bundleId);
        caps.setCapability("udid", udid);
        
        // Thêm các capabilities phổ biến
        caps.setCapability("autoAcceptAlerts", true);
        
        AppiumDriver driver = new IOSDriver(new URL(APPIUM_SERVER_URL), caps);
        setImplicitWait(driver, ConfigProperties.getImplicitWait());
        
        return driver;
    }

    /**
     * Thiết lập implicit wait time
     */
    private static void setImplicitWait(AppiumDriver driver, long seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
