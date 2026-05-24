package com.example.appium.locators;

import org.openqa.selenium.By;

/**
 * HomePageLocators - Chứa tất cả locators cho Home Page
 * 
 * Cấu trúc tổ chức:
 * 1. Header elements
 * 2. Main content elements
 * 3. Footer elements
 * 4. Dialog/Modal elements
 */
public class HomePageLocators extends BaseLocators {
    
    // ============ Header Elements ============
    public static final By PROFILE_ICON = By.id("profile_icon");
    public static final By NOTIFICATION_BELL = By.id("notification_icon");
    public static final By SEARCH_BOX = By.id("search_input");
    
    // ============ Main Content Elements ============
    public static final By WELCOME_MESSAGE = By.id("welcome_text");
    public static final By USER_NAME_DISPLAY = By.id("user_name");
    public static final By MAIN_CONTENT = By.id("main_content");
    
    // ============ Navigation Elements ============
    public static final By HOME_TAB = By.id("home_tab");
    public static final By SETTINGS_TAB = By.id("settings_tab");
    public static final By LOGOUT_BUTTON = By.id("logout_button");
    
    // ============ Dialogs/Modals ============
    public static final By LOGOUT_CONFIRMATION_DIALOG = By.id("logout_confirmation");
    public static final By CONFIRM_BUTTON = By.id("confirm_btn");
    public static final By CANCEL_BUTTON = By.id("cancel_btn");
}
