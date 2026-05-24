package com.example.appium.config;

/**
 * ConfigProperties - Quản lý tất cả configuration properties
 * Lấy values từ system properties, environment variables hoặc default values
 */
public class ConfigProperties {

    // Appium Server Configuration
    private static final String APPIUM_SERVER_URL = getProperty("appium.server.url", "http://localhost:4723");
    private static final String PLATFORM = getProperty("platform", "Android");
    
    // Device Configuration - Android
    private static final String ANDROID_DEVICE_NAME = getProperty("android.device.name", "emulator-5554");
    private static final String ANDROID_PLATFORM_VERSION = getProperty("android.platform.version", "13");
    
    // Device Configuration - iOS
    private static final String IOS_DEVICE_NAME = getProperty("ios.device.name", "iPhone 14");
    private static final String IOS_PLATFORM_VERSION = getProperty("ios.platform.version", "16.0");
    
    // Timeout Configuration
    private static final long IMPLICIT_WAIT = getLongProperty("implicit.wait", 10L);
    private static final long EXPLICIT_WAIT = getLongProperty("explicit.wait", 15L);
    private static final long PAGE_LOAD_TIMEOUT = getLongProperty("page.load.timeout", 30L);
    
    // App Configuration
    private static final String APP_PATH = getProperty("app.path", "");
    private static final String APP_PACKAGE = getProperty("app.package", "");
    private static final String APP_ACTIVITY = getProperty("app.activity", "");
    
    // Test Configuration
    private static final boolean TAKE_SCREENSHOT_ON_FAILURE = getBooleanProperty("screenshot.on.failure", true);
    private static final String SCREENSHOT_PATH = getProperty("screenshot.path", "screenshots/");
    
    public static String getAppiumServerUrl() {
        return APPIUM_SERVER_URL;
    }
    
    public static String getPlatform() {
        return PLATFORM;
    }
    
    public static String getAndroidDeviceName() {
        return ANDROID_DEVICE_NAME;
    }
    
    public static String getAndroidPlatformVersion() {
        return ANDROID_PLATFORM_VERSION;
    }
    
    public static String getIOSDeviceName() {
        return IOS_DEVICE_NAME;
    }
    
    public static String getIOSPlatformVersion() {
        return IOS_PLATFORM_VERSION;
    }
    
    public static long getImplicitWait() {
        return IMPLICIT_WAIT;
    }
    
    public static long getExplicitWait() {
        return EXPLICIT_WAIT;
    }
    
    public static long getPageLoadTimeout() {
        return PAGE_LOAD_TIMEOUT;
    }
    
    public static String getAppPath() {
        return APP_PATH;
    }
    
    public static String getAppPackage() {
        return APP_PACKAGE;
    }
    
    public static String getAppActivity() {
        return APP_ACTIVITY;
    }
    
    public static boolean shouldTakeScreenshotOnFailure() {
        return TAKE_SCREENSHOT_ON_FAILURE;
    }
    
    public static String getScreenshotPath() {
        return SCREENSHOT_PATH;
    }
    
    /**
     * Lấy property từ system properties hoặc environment variables
     */
    private static String getProperty(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value == null) {
            value = System.getenv(key.replace(".", "_").toUpperCase());
        }
        return value != null ? value : defaultValue;
    }
    
    /**
     * Lấy long property
     */
    private static long getLongProperty(String key, long defaultValue) {
        try {
            String value = getProperty(key, String.valueOf(defaultValue));
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    
    /**
     * Lấy boolean property
     */
    private static boolean getBooleanProperty(String key, boolean defaultValue) {
        try {
            String value = getProperty(key, String.valueOf(defaultValue));
            return Boolean.parseBoolean(value);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
