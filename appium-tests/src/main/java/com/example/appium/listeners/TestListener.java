package com.example.appium.listeners;

import com.example.appium.utils.ScreenshotUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.log4j.Logger;


public class TestListener implements ITestListener {
    
    private static final Logger logger = Logger.getLogger(TestListener.class);
    
    @Override
    public void onStart(ITestContext context) {
        logger.info("======================================");
        logger.info("Test Suite Started: " + context.getName());
        logger.info("======================================");
    }
    
    @Override
    public void onFinish(ITestContext context) {
        logger.info("======================================");
        logger.info("Test Suite Finished: " + context.getName());
        logger.info("Total Tests: " + context.getAllTestMethods().length);
        logger.info("Passed: " + context.getPassedTests().size());
        logger.info("Failed: " + context.getFailedTests().size());
        logger.info("Skipped: " + context.getSkippedTests().size());
        logger.info("======================================");
    }
    
    @Override
    public void onTestStart(ITestResult result) {
        logger.info("");
        logger.info(">>> TEST STARTED: " + result.getTestClass().getRealClass().getSimpleName() 
                  + "." + result.getMethod().getMethodName());
        logger.info("Description: " + result.getMethod().getDescription());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        long duration = result.getEndMillis() - result.getStartMillis();
        logger.info("âœ“ TEST PASSED: " + result.getMethod().getMethodName() 
                  + " (Duration: " + duration + "ms)");
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        long duration = result.getEndMillis() - result.getStartMillis();
        logger.error("âœ— TEST FAILED: " + result.getMethod().getMethodName() 
                   + " (Duration: " + duration + "ms)");
        logger.error("Failure Message: " + result.getThrowable().getMessage());
        
        
        try {
            String screenshotPath = ScreenshotUtils.captureScreenshot(
                result.getTestClass().getRealClass().getSimpleName() 
                + "_" + result.getMethod().getMethodName() + "_FAILED"
            );
            logger.error("Screenshot captured: " + screenshotPath);
        } catch (Exception e) {
            logger.error("Failed to capture screenshot on failure", e);
        }
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("â— TEST SKIPPED: " + result.getMethod().getMethodName());
        logger.warn("Reason: " + result.getThrowable().getMessage());
    }
    
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.warn("â  TEST FAILED BUT WITHIN SUCCESS PERCENTAGE: " + result.getMethod().getMethodName());
    }
}
