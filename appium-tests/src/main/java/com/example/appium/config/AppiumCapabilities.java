package com.example.appium.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class AppiumCapabilities {

    private static final String APPIUM_SERVER_URL = ConfigProperties.getAppiumServerUrl();

    public static AppiumDriver getAndroidDriver(String appPath, String appPackage, String appActivity) 
            throws MalformedURLException {
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", ConfigProperties.getAndroidDeviceName());
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", appPath);
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);
        
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("noReset", true);
        caps.setCapability("fullReset", false);
        
        AppiumDriver driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), caps);
        setImplicitWait(driver, ConfigProperties.getImplicitWait());
        
        return driver;
    }

    public static AppiumDriver getIOSDriver(String bundleId, String udid) 
            throws MalformedURLException {
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("deviceName", ConfigProperties.getIOSDeviceName());
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("bundleId", bundleId);
        caps.setCapability("udid", udid);
        
        caps.setCapability("autoAcceptAlerts", true);
        
        AppiumDriver driver = new IOSDriver(new URL(APPIUM_SERVER_URL), caps);
        setImplicitWait(driver, ConfigProperties.getImplicitWait());
        
        return driver;
    }

    private static void setImplicitWait(AppiumDriver driver, long seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
