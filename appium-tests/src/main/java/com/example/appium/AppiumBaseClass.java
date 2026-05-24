package com.example.appium;

import com.example.appium.config.DriverManager;
import org.apache.log4j.Logger;

/**
 * AppiumBaseClass - Base class cho tất cả test classes
 * 
 * DEPRECATED: Sử dụng DriverManager từ com.example.appium.config package thay vì class này
 * 
 * Cách sử dụng:
 * public class MyTest extends AppiumBaseClass {
 *     @BeforeMethod
 *     public void setup() throws MalformedURLException {
 *         DriverManager.initializeDriver();
 *     }
 *     
 *     @AfterMethod
 *     public void tearDown() {
 *         DriverManager.quitDriver();
 *     }
 * }
 */
public class AppiumBaseClass {
    
    protected static final Logger logger = Logger.getLogger(AppiumBaseClass.class);

    /**
     * Initialize driver
     * Wrapper method - sử dụng DriverManager.initializeDriver() thay vì
     */
    public static void initializeDriver() throws Exception {
        DriverManager.initializeDriver();
    }

    /**
     * Close the driver
     * Wrapper method - sử dụng DriverManager.quitDriver() thay vì
     */
    public static void tearDown() {
        DriverManager.quitDriver();
    }

    /**
     * Get the current driver
     * Wrapper method - sử dụng DriverManager.getDriver() thay vì
     */
    public static Object getDriver() {
        return DriverManager.getDriver();
    }
}
