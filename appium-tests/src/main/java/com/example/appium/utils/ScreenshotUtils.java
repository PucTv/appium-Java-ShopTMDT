package com.example.appium.utils;

import com.example.appium.config.ConfigProperties;
import com.example.appium.config.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ScreenshotUtils - Cung cấp phương thức capture screenshot
 * Trách nhiệm: Chụp ảnh màn hình khi test fail hoặc cần verify
 */
public class ScreenshotUtils {
    
    private static final Logger logger = Logger.getLogger(ScreenshotUtils.class);
    private static AppiumDriver driver = DriverManager.getDriver();
    
    /**
     * Capture screenshot và lưu vào file
     * @param screenshotName - Tên screenshot
     * @return Đường dẫn file screenshot
     */
    public static String captureScreenshot(String screenshotName) {
        try {
            String screenshotPath = ConfigProperties.getScreenshotPath();
            File directory = new File(screenshotPath);
            
            if (!directory.exists()) {
                directory.mkdirs();
            }
            
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = screenshotName + "_" + timestamp + ".png";
            String fullPath = screenshotPath + fileName;
            
            File screenshotFile = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
            org.apache.commons.io.FileUtils.copyFile(screenshotFile, new File(fullPath));
            
            logger.info("✓ Screenshot captured: " + fullPath);
            return fullPath;
        } catch (Exception e) {
            logger.error("✗ Failed to capture screenshot", e);
            return null;
        }
    }
    
    /**
     * Capture screenshot với default naming
     */
    public static String captureScreenshot() {
        return captureScreenshot("screenshot");
    }
}
