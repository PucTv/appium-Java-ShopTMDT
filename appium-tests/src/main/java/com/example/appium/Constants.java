package com.example.appium;

public class Constants {
    
    public static final String APP_PACKAGE = "com.example.myapp";
    public static final String APP_ACTIVITY = ".MainActivity";
    
    public static final int IMPLICIT_WAIT = 10;
    public static final int EXPLICIT_WAIT = 15;
    public static final int PAGE_LOAD_TIMEOUT = 30;
    
    public static final String LOGIN_BUTTON_TEXT = "Login";
    public static final String LOGOUT_BUTTON_TEXT = "Logout";
    public static final String WELCOME_TEXT = "Welcome";
    public static final String ERROR_MESSAGE = "Login failed";
    
    public static final String VALID_USERNAME = "user@example.com";
    public static final String VALID_PASSWORD = "password123";
    public static final String INVALID_USERNAME = "invalid@example.com";
    public static final String INVALID_PASSWORD = "wrongpassword";
    
    public static final String BASE_URL = "https://api.example.com";
    public static final String LOGIN_ENDPOINT = "/auth/login";
    public static final String LOGOUT_ENDPOINT = "/auth/logout";
}
