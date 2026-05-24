package com.example.appium.locators;

import org.openqa.selenium.By;

/**
 * LoginPageLocators - Chứa tất cả locators cho Login Page
 * 
 * Quy ước:
 * - Đặt tên rõ ràng theo tên element: USERNAME_INPUT, PASSWORD_INPUT, SUBMIT_BUTTON
 * - Định nghĩa locator theo thứ tự ưu tiên: ID → XPath → ClassName → CSS Selector
 * - Thêm comment mô tả nếu locator phức tạp
 */
public class LoginPageLocators extends BaseLocators {
    
    // Username/Email Input Field
    public static final By USERNAME_INPUT = By.id("username_input");
    // Alternative: By.xpath("//input[@placeholder='Enter username']");
    
    // Password Input Field
    public static final By PASSWORD_INPUT = By.id("password_input");
    
    // Login Button
    public static final By LOGIN_BUTTON = By.id("login_button");
    // Alternative: By.xpath("//button[@text='Login']");
    
    // Forgot Password Link
    public static final By FORGOT_PASSWORD_LINK = By.id("forgot_password");
    
    // Sign Up Link
    public static final By SIGN_UP_LINK = By.xpath("//a[@text='Sign Up']");
    
    // Error Message
    public static final By ERROR_MESSAGE = By.id("error_message");
    
    // Remember Me Checkbox
    public static final By REMEMBER_ME_CHECKBOX = By.id("remember_me_checkbox");
}
