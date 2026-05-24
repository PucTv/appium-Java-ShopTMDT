package com.example.appium.config;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;

import io.appium.java_client.AppiumDriver;

public class DriverManager {

    private static final Logger logger = Logger.getLogger(DriverManager.class);
    private static final ThreadLocal<AppiumDriver> driverThreadLocal = new ThreadLocal<>();

    public static synchronized void initializeDriver() throws MalformedURLException {
        String platform = ConfigProperties.getPlatform();

        if (driverThreadLocal.get() == null) {
            AppiumDriver driver;

            if ("Android".equalsIgnoreCase(platform)) {
                driver = AppiumCapabilities.getAndroidDriver(
                    ConfigProperties.getAppPath(),
                    ConfigProperties.getAppPackage(),
                    ConfigProperties.getAppActivity()
                );
                logger.info("Android Driver initialized successfully");
            } else if ("iOS".equalsIgnoreCase(platform)) {
                driver = AppiumCapabilities.getIOSDriver(
                    ConfigProperties.getAppPackage(),
                    ConfigProperties.getAppActivity()
                );
                logger.info("iOS Driver initialized successfully");
            } else {
                throw new IllegalArgumentException("Unsupported platform: " + platform);
            }

            driverThreadLocal.set(driver);
        } else {
            logger.warn("Driver already initialized");
        }
    }

    public static AppiumDriver getDriver() {
        AppiumDriver driver = driverThreadLocal.get();
        if (driver == null) {
            throw new RuntimeException("AppiumDriver is not initialized. Call initializeDriver() first.");
        }
        return driver;
    }

    public static void quitDriver() {
        AppiumDriver driver = driverThreadLocal.get();
        if (driver != null) {
            try {
                driver.quit();
                logger.info("Driver quit successfully");
            } catch (Exception e) {
                logger.error("Error closing driver: " + e.getMessage(), e);
            } finally {
                driverThreadLocal.remove();
            }
        }
    }

    public static boolean isDriverInitialized() {
        return driverThreadLocal.get() != null;
    }
}
