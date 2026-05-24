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












public class MobileGestureUtils {
    
    private static final Logger logger = Logger.getLogger(MobileGestureUtils.class);
    







    public static void swipe(int startX, int startY, int endX, int endY, int duration) {
        try {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(finger, 0);
            sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), endX, endY));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            
            getDriver().perform(Arrays.asList(sequence));
            logger.info("âœ“ Swiped from (" + startX + "," + startY + ") to (" + endX + "," + endY + ")");
        } catch (Exception e) {
            logger.error("âœ— Failed to swipe", e);
            throw e;
        }
    }
    
    


    public static void scrollUp() {
        try {
            Dimension size = getDriver().manage().window().getSize();
            swipe(size.width / 2, size.height * 3 / 4, size.width / 2, size.height / 4, 500);
            logger.info("âœ“ Scrolled up");
        } catch (Exception e) {
            logger.error("âœ— Failed to scroll up", e);
            throw e;
        }
    }
    
    


    public static void scrollDown() {
        try {
            Dimension size = getDriver().manage().window().getSize();
            swipe(size.width / 2, size.height / 4, size.width / 2, size.height * 3 / 4, 500);
            logger.info("âœ“ Scrolled down");
        } catch (Exception e) {
            logger.error("âœ— Failed to scroll down", e);
            throw e;
        }
    }
    
    


    public static void tap(int x, int y) {
        try {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(finger, 0);
            sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            
            getDriver().perform(Arrays.asList(sequence));
            logger.info("âœ“ Tapped at (" + x + "," + y + ")");
        } catch (Exception e) {
            logger.error("âœ— Failed to tap", e);
            throw e;
        }
    }
    
    


    public static void doubleTap(int x, int y) {
        try {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(finger, 0);
            
            
            sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            
            
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            
            getDriver().perform(Arrays.asList(sequence));
            logger.info("âœ“ Double tapped at (" + x + "," + y + ")");
        } catch (Exception e) {
            logger.error("âœ— Failed to double tap", e);
            throw e;
        }
    }
    
    


    public static void longPress(int x, int y, int durationMs) {
        try {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(finger, 0);
            sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(finger.createPointerMove(Duration.ofMillis(durationMs), PointerInput.Origin.viewport(), x, y));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            
            getDriver().perform(Arrays.asList(sequence));
            logger.info("âœ“ Long pressed at (" + x + "," + y + ") for " + durationMs + "ms");
        } catch (Exception e) {
            logger.error("âœ— Failed to long press", e);
            throw e;
        }
    }

    private static AppiumDriver getDriver() {
        return DriverManager.getDriver();
    }
}
