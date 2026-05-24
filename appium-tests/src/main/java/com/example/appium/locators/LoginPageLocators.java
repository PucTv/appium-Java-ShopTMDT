package com.example.appium.locators;

import org.openqa.selenium.By;

public class LoginPageLocators extends BaseLocators {
    
    public static final By USERNAME_INPUT = By.id("username_input");
    
    public static final By PASSWORD_INPUT = By.id("password_input");
    
    public static final By LOGIN_BUTTON = By.id("login_button");
    
    public static final By FORGOT_PASSWORD_LINK = By.id("forgot_password");
    
    public static final By SIGN_UP_LINK = By.xpath("//a[@text='Sign Up']");
    
    public static final By ERROR_MESSAGE = By.id("error_message");
    
    public static final By REMEMBER_ME_CHECKBOX = By.id("remember_me_checkbox");
}
