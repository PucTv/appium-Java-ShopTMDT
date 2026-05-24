package com.example.appium.pages;

import com.example.appium.locators.HomePageLocators;
import org.openqa.selenium.By;

/**
 * HomePage - Page Object cho Home screen
 * 
 * Trách nhiệm:
 * - Chứa tất cả locators và actions cho home page
 * - Cung cấp methods để interact với home page elements
 * 
 * Cách sử dụng:
 * HomePage homePage = new HomePage();
 * homePage.verifyPageLoaded();
 * homePage.clickSettings();
 */
public class HomePage extends BasePage {
    
    // ============ Locators ============
    // Sử dụng HomePageLocators
    
    /**
     * Verify HomePage load thành công
     */
    @Override
    public void verifyPageLoaded() {
        logger.info("Verifying HomePage loaded...");
        if (!isElementDisplayed(HomePageLocators.WELCOME_MESSAGE)) {
            throw new RuntimeException("HomePage did not load properly. Welcome message not found.");
        }
        logger.info("✓ HomePage loaded successfully");
    }
    
    /**
     * Lấy welcome message
     */
    public String getWelcomeMessage() {
        logger.info("Getting welcome message");
        return getText(HomePageLocators.WELCOME_MESSAGE);
    }
    
    /**
     * Lấy user name hiển thị
     */
    public String getUserNameDisplay() {
        logger.info("Getting displayed user name");
        return getText(HomePageLocators.USER_NAME_DISPLAY);
    }
    
    /**
     * Click profile icon
     */
    public void clickProfileIcon() {
        logger.info("Clicking profile icon");
        click(HomePageLocators.PROFILE_ICON);
    }
    
    /**
     * Click notification bell
     */
    public void clickNotificationBell() {
        logger.info("Clicking notification bell");
        click(HomePageLocators.NOTIFICATION_BELL);
    }
    
    /**
     * Search với keyword
     */
    public void search(String keyword) {
        logger.info("Searching for: " + keyword);
        click(HomePageLocators.SEARCH_BOX);
        type(HomePageLocators.SEARCH_BOX, keyword);
    }
    
    /**
     * Click home tab
     */
    public void clickHomeTab() {
        logger.info("Clicking home tab");
        click(HomePageLocators.HOME_TAB);
    }
    
    /**
     * Click settings tab
     */
    public void clickSettingsTab() {
        logger.info("Clicking settings tab");
        click(HomePageLocators.SETTINGS_TAB);
    }
    
    /**
     * Click logout button
     */
    public void clickLogoutButton() {
        logger.info("Clicking logout button");
        click(HomePageLocators.LOGOUT_BUTTON);
    }
    
    /**
     * Logout - click logout button và confirm
     */
    public void logout() {
        logger.info("Starting logout process");
        clickLogoutButton();
        
        // Wait cho confirmation dialog
        waitForElement(HomePageLocators.LOGOUT_CONFIRMATION_DIALOG);
        
        // Click confirm button
        click(HomePageLocators.CONFIRM_BUTTON);
        logger.info("✓ Logout confirmed");
    }
    
    /**
     * Cancel logout
     */
    public void cancelLogout() {
        logger.info("Cancelling logout");
        click(HomePageLocators.CANCEL_BUTTON);
    }
    
    /**
     * Kiểm tra có logout dialog không
     */
    public boolean isLogoutDialogDisplayed() {
        return isElementDisplayed(HomePageLocators.LOGOUT_CONFIRMATION_DIALOG);
    }
}
