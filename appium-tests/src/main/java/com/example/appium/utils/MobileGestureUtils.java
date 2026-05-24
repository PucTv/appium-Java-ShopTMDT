package com.example.appium.utils;

import com.example.appium.config.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.apache.log4j.Logger;

import java.time.Duration;
import java.util.Arrays;

/**
 * MobileGestureUtils - Cung cấp các phương thức gesture trên mobile (swipe, scroll, tap, etc.)
 * Trách nhiệm: Xử lý các mobile-specific actions
 * 
 * Các phương thức:
 * 1. swipe - Swipe từ một điểm tới điểm khác
 * 2. scroll - Scroll up, down
 * 3. tap - Tap tại một vị trí
 * 4. longPress - Long press element
 * 5. doubleTap - Double tap element
 */
public class MobileGestureUtils {
    
    private static final Logger logger = Logger.getLogger(MobileGestureUtils.class);
    private static AppiumDriver driver = DriverManager.getDriver();
    
    /**
     * Swipe từ tọa độ này đến tọa độ khác
     * @param startX - Tọa độ X bắt đầu
     * @param startY - Tọa độ Y bắt đầu
     * @param endX - Tọa độ X kết thúc
     * @param endY - Tọa độ Y kết thúc
     * @param duration - Thời gian swipe (milliseconds)
     */
    public static void swipe(int startX, int startY, int endX, int endY, int duration) {
        try {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(finger, 0);
            sequence.addAction(finger.createPointerMove(Duration.ZERO, startX, startY));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(finger.createPointerMove(Duration.ofMillis(duration), endX, endY));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            
            driver.perform(Arrays.asList(sequence));
            logger.info("✓ Swiped from (" + startX + "," + startY + ") to (" + endX + "," + endY + ")");
        } catch (Exception e) {
            logger.error("✗ Failed to swipe", e);
            throw e;
        }
    }
    
    /**
     * Scroll up trong page
     */
    public static void scrollUp() {
        try {
            Dimension size = driver.manage().window().getSize();
            swipe(size.width / 2, size.height * 3 / 4, size.width / 2, size.height / 4, 500);
            logger.info("✓ Scrolled up");
        } catch (Exception e) {
            logger.error("✗ Failed to scroll up", e);
            throw e;
        }
    }
    
    /**
     * Scroll down trong page
     */
    public static void scrollDown() {
        try {
            Dimension size = driver.manage().window().getSize();
            swipe(size.width / 2, size.height / 4, size.width / 2, size.height * 3 / 4, 500);
            logger.info("✓ Scrolled down");
        } catch (Exception e) {
            logger.error("✗ Failed to scroll down", e);
            throw e;
        }
    }
    
    /**
     * Tap tại một vị trí cụ thể
     */
    public static void tap(int x, int y) {
        try {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(finger, 0);
            sequence.addAction(finger.createPointerMove(Duration.ZERO, x, y));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            
            driver.perform(Arrays.asList(sequence));
            logger.info("✓ Tapped at (" + x + "," + y + ")");
        } catch (Exception e) {
            logger.error("✗ Failed to tap", e);
            throw e;
        }
    }
    
    /**
     * Double tap tại một vị trí
     */
    public static void doubleTap(int x, int y) {
        try {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(finger, 0);
            
            // Lần tap thứ 1
            sequence.addAction(finger.createPointerMove(Duration.ZERO, x, y));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            
            // Lần tap thứ 2
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            
            driver.perform(Arrays.asList(sequence));
            logger.info("✓ Double tapped at (" + x + "," + y + ")");
        } catch (Exception e) {
            logger.error("✗ Failed to double tap", e);
            throw e;
        }
    }
    
    /**
     * Long press tại một vị trí
     */
    public static void longPress(int x, int y, int durationMs) {
        try {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(finger, 0);
            sequence.addAction(finger.createPointerMove(Duration.ZERO, x, y));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(finger.createPointerMove(Duration.ofMillis(durationMs), x, y));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            
            driver.perform(Arrays.asList(sequence));
            logger.info("✓ Long pressed at (" + x + "," + y + ") for " + durationMs + "ms");
        } catch (Exception e) {
            logger.error("✗ Failed to long press", e);
            throw e;
        }
    }
}
