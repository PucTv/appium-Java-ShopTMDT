package com.example.appium.pages;

import com.example.appium.locators.HomePageLocators;
import org.openqa.selenium.By;













public class HomePage extends BasePage {
    
    
    
    
    


    @Override
    public void verifyPageLoaded() {
        logger.info("Verifying HomePage loaded...");
        if (!isElementDisplayed(HomePageLocators.WELCOME_MESSAGE)) {
            throw new RuntimeException("HomePage did not load properly. Welcome message not found.");
        }
        logger.info("âœ“ HomePage loaded successfully");
    }
    
    


    public String getWelcomeMessage() {
        logger.info("Getting welcome message");
        return getText(HomePageLocators.WELCOME_MESSAGE);
    }
    
    


    public String getUserNameDisplay() {
        logger.info("Getting displayed user name");
        return getText(HomePageLocators.USER_NAME_DISPLAY);
    }
    
    


    public void clickProfileIcon() {
        logger.info("Clicking profile icon");
        click(HomePageLocators.PROFILE_ICON);
    }
    
    


    public void clickNotificationBell() {
        logger.info("Clicking notification bell");
        click(HomePageLocators.NOTIFICATION_BELL);
    }
    
    


    public void search(String keyword) {
        logger.info("Searching for: " + keyword);
        click(HomePageLocators.SEARCH_BOX);
        type(HomePageLocators.SEARCH_BOX, keyword);
    }
    
    


    public void clickHomeTab() {
        logger.info("Clicking home tab");
        click(HomePageLocators.HOME_TAB);
    }
    
    


    public void clickSettingsTab() {
        logger.info("Clicking settings tab");
        click(HomePageLocators.SETTINGS_TAB);
    }
    
    


    public void clickLogoutButton() {
        logger.info("Clicking logout button");
        click(HomePageLocators.LOGOUT_BUTTON);
    }
    
    


    public void logout() {
        logger.info("Starting logout process");
        clickLogoutButton();
        
        
        waitForElement(HomePageLocators.LOGOUT_CONFIRMATION_DIALOG);
        
        
        click(HomePageLocators.CONFIRM_BUTTON);
        logger.info("âœ“ Logout confirmed");
    }
    
    


    public void cancelLogout() {
        logger.info("Cancelling logout");
        click(HomePageLocators.CANCEL_BUTTON);
    }
    
    


    public boolean isLogoutDialogDisplayed() {
        return isElementDisplayed(HomePageLocators.LOGOUT_CONFIRMATION_DIALOG);
    }
}
