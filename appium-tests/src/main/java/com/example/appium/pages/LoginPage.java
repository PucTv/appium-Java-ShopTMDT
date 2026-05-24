package com.example.appium.pages;

import com.example.appium.locators.LoginPageLocators;
import org.openqa.selenium.By;

















public class LoginPage extends BasePage {
    
    @Override
    public void verifyPageLoaded() {
        logger.info("Verifying LoginPage loaded...");
        if (!isElementDisplayed(LoginPageLocators.USERNAME_INPUT)) {
            throw new RuntimeException("LoginPage did not load properly. Username input not found.");
        }
        logger.info("âœ“ LoginPage loaded successfully");
    }
    
    public void enterUsername(String username) {
        logger.info("Entering username: " + username);
        type(LoginPageLocators.USERNAME_INPUT, username);
    }
    
    public void enterPassword(String password) {
        logger.info("Entering password");
        type(LoginPageLocators.PASSWORD_INPUT, password);
    }
    
    public void clickLoginButton() {
        logger.info("Clicking login button");
        click(LoginPageLocators.LOGIN_BUTTON);
    }
    
    public void login(String username, String password) {
        logger.info("Starting login process with username: " + username);
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
    
    public void clickForgotPasswordLink() {
        logger.info("Clicking forgot password link");
        click(LoginPageLocators.FORGOT_PASSWORD_LINK);
    }
    
    public void clickSignUpLink() {
        logger.info("Clicking sign up link");
        click(LoginPageLocators.SIGN_UP_LINK);
    }
    
    public void checkRememberMe() {
        logger.info("Checking remember me checkbox");
        if (!isElementSelected(LoginPageLocators.REMEMBER_ME_CHECKBOX)) {
            click(LoginPageLocators.REMEMBER_ME_CHECKBOX);
        }
    }
    
    public String getErrorMessage() {
        logger.info("Getting error message");
        if (isElementDisplayed(LoginPageLocators.ERROR_MESSAGE)) {
            return getText(LoginPageLocators.ERROR_MESSAGE);
        }
        return "";
    }
    
    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(LoginPageLocators.ERROR_MESSAGE);
    }
}
