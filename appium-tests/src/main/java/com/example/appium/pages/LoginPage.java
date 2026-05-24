package com.example.appium.pages;

import com.example.appium.locators.LoginPageLocators;
import org.openqa.selenium.By;

/**
 * LoginPage - Page Object cho Login screen
 * 
 * Trách nhiệ: 
 * - Chứa tất cả locators và actions cho login page
 * - Cung cấp business-level methods (login, enterUsername, enterPassword, etc.)
 * 
 * Cách sử dụng:
 * LoginPage loginPage = new LoginPage();
 * loginPage.enterUsername("user@example.com");
 * loginPage.enterPassword("password123");
 * loginPage.clickLoginButton();
 * 
 * Hoặc chaining:
 * loginPage.login("user@example.com", "password123");
 */
public class LoginPage extends BasePage {
    
    // ============ Locators ============
    // Sử dụng LoginPageLocators
    
    /**
     * Verify LoginPage load thành công
     */
    @Override
    public void verifyPageLoaded() {
        logger.info("Verifying LoginPage loaded...");
        if (!isElementDisplayed(LoginPageLocators.USERNAME_INPUT)) {
            throw new RuntimeException("LoginPage did not load properly. Username input not found.");
        }
        logger.info("✓ LoginPage loaded successfully");
    }
    
    /**
     * Nhập username/email
     */
    public void enterUsername(String username) {
        logger.info("Entering username: " + username);
        type(LoginPageLocators.USERNAME_INPUT, username);
    }
    
    /**
     * Nhập password
     */
    public void enterPassword(String password) {
        logger.info("Entering password");
        type(LoginPageLocators.PASSWORD_INPUT, password);
    }
    
    /**
     * Click login button
     */
    public void clickLoginButton() {
        logger.info("Clicking login button");
        click(LoginPageLocators.LOGIN_BUTTON);
    }
    
    /**
     * Login với username và password
     * Business-level method
     */
    public void login(String username, String password) {
        logger.info("Starting login process with username: " + username);
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
    
    /**
     * Click forgot password link
     */
    public void clickForgotPasswordLink() {
        logger.info("Clicking forgot password link");
        click(LoginPageLocators.FORGOT_PASSWORD_LINK);
    }
    
    /**
     * Click sign up link
     */
    public void clickSignUpLink() {
        logger.info("Clicking sign up link");
        click(LoginPageLocators.SIGN_UP_LINK);
    }
    
    /**
     * Check remember me checkbox
     */
    public void checkRememberMe() {
        logger.info("Checking remember me checkbox");
        if (!isElementSelected(LoginPageLocators.REMEMBER_ME_CHECKBOX)) {
            click(LoginPageLocators.REMEMBER_ME_CHECKBOX);
        }
    }
    
    /**
     * Lấy error message nếu login fail
     */
    public String getErrorMessage() {
        logger.info("Getting error message");
        if (isElementDisplayed(LoginPageLocators.ERROR_MESSAGE)) {
            return getText(LoginPageLocators.ERROR_MESSAGE);
        }
        return "";
    }
    
    /**
     * Kiểm tra có error message không
     */
    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(LoginPageLocators.ERROR_MESSAGE);
    }
}
