package com.example.appium;

import com.example.appium.config.DriverManager;
import com.example.appium.pages.LoginPage;
import com.example.appium.pages.HomePage;
import com.example.appium.listeners.TestListener;
import org.testng.annotations.*;
import org.apache.log4j.Logger;




























@Listeners(TestListener.class)
public class AppiumExampleTest extends AppiumBaseClass {
    
    private static final Logger logger = Logger.getLogger(AppiumExampleTest.class);
    private LoginPage loginPage;
    private HomePage homePage;
    
    @BeforeClass
    public void setupClass() {
        logger.info("========== Test Class Setup ==========");
        logger.info("Initializing test environment...");
    }
    
    @BeforeMethod
    public void setup() throws Exception {
        logger.info("========== Test Method Setup ==========");
        DriverManager.initializeDriver();
        logger.info("âœ“ Driver initialized");
        
        
        loginPage = new LoginPage();
        homePage = new HomePage();
    }
    
    


    @Test(description = "Verify login page loads successfully")
    public void testLoginPageLoaded() {
        logger.info("Test: Login Page Loaded");
        loginPage.verifyPageLoaded();
        logger.info("âœ“ Test Passed");
    }
    
    








    @Test(description = "Login with valid credentials")
    public void testValidLogin() {
        logger.info("Test: Valid Login");
        
        
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        logger.info("âœ“ Login action completed");
        
        
        homePage.verifyPageLoaded();
        String welcomeMsg = homePage.getWelcomeMessage();
        assert welcomeMsg.contains("Welcome") : "Welcome message not found";
        logger.info("âœ“ Test Passed");
    }
    
    








    @Test(description = "Login with invalid credentials")
    public void testInvalidLogin() {
        logger.info("Test: Invalid Login");
        
        
        loginPage.login(Constants.INVALID_USERNAME, Constants.INVALID_PASSWORD);
        
        
        boolean isErrorDisplayed = loginPage.isErrorMessageDisplayed();
        assert isErrorDisplayed : "Error message not displayed";
        
        String errorMsg = loginPage.getErrorMessage();
        assert !errorMsg.isEmpty() : "Error message is empty";
        logger.info("âœ“ Error message displayed: " + errorMsg);
        logger.info("âœ“ Test Passed");
    }
    
    








    @Test(description = "Logout from application", dependsOnMethods = "testValidLogin")
    public void testLogout() {
        logger.info("Test: Logout");
        
        
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        homePage.verifyPageLoaded();
        logger.info("âœ“ User logged in");
        
        
        homePage.logout();
        logger.info("âœ“ Logout completed");
        
        
        loginPage.verifyPageLoaded();
        logger.info("âœ“ Test Passed");
    }
    
    


    @Test(description = "Remember me functionality")
    public void testRememberMe() {
        logger.info("Test: Remember Me");
        
        
        loginPage.checkRememberMe();
        logger.info("âœ“ Remember me checked");
        
        boolean isChecked = loginPage.isElementSelected(
            com.example.appium.locators.LoginPageLocators.REMEMBER_ME_CHECKBOX
        );
        assert isChecked : "Remember me checkbox not checked";
        logger.info("âœ“ Test Passed");
    }
    
    @AfterMethod
    public void tearDownMethod() {
        logger.info("========== Test Method Teardown ==========");
        DriverManager.quitDriver();
        logger.info("âœ“ Driver quit");
    }
    
    @AfterClass
    public void teardownClass() {
        logger.info("========== Test Class Teardown ==========");
        logger.info("Cleaning up test environment...");
    }
}
