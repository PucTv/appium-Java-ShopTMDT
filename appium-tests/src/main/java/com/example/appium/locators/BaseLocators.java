package com.example.appium.locators;

import org.openqa.selenium.By;

/**
 * BaseLocators - Chứa tất cả các locators cho trang Base
 * Cấu trúc: Tổ chức locators theo từng page class
 * 
 * Ví dụ cách sử dụng:
 * - Tạo một class Locators cho mỗi page (LoginPageLocators, HomePageLocators, etc.)
 * - Kế thừa từ BaseLocators để sử dụng common locators
 */
public class BaseLocators {
    
    // Common locators - Dùng chung cho tất cả pages
    public static final By BACK_BUTTON = By.id("android:id/action_bar_up");
    public static final By MENU_BUTTON = By.id("android:id/action_bar");
    public static final By LOADING_INDICATOR = By.id("android:id/progress");
    
    /**
     * Template cho các locators của page cụ thể:
     * 
     * public static final By ELEMENT_NAME = By.id("element_id");
     * public static final By ELEMENT_XPATH = By.xpath("//element[@attribute='value']");
     * public static final By ELEMENT_CLASS = By.className("element_class");
     */
}
