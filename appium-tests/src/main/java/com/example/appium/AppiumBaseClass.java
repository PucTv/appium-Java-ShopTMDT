package com.example.appium;

import com.example.appium.config.DriverManager;
import com.example.appium.config.AppiumCapabilities;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;

public class AppiumBaseClass {

    protected static final Logger logger = Logger.getLogger(AppiumBaseClass.class);

    public static void initializeDriver() throws Exception {
        DriverManager.initializeDriver();
    }

    public static AppiumDriver initializeAndroidDriver(String appPath, String appPackage, String appActivity) throws Exception {
        return AppiumCapabilities.getAndroidDriver(appPath, appPackage, appActivity);
    }

    public static void tearDown() {
        DriverManager.quitDriver();
    }

    public static AppiumDriver getDriver() {
        return DriverManager.getDriver();
    }
}
