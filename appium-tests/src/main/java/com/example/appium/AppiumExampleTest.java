package com.example.appium;

import com.example.appium.config.DriverManager;
import com.example.appium.pages.LoginPage;
import com.example.appium.pages.HomePage;
import com.example.appium.listeners.TestListener;
import org.testng.annotations.*;
import org.apache.log4j.Logger;

/**
 * AppiumExampleTest - Ví dụ test class theo Page Object Model
 * 
 * Cấu trúc:
 * 1. @BeforeClass - Thiết lập test suite
 * 2. @BeforeMethod - Thiết lập trước mỗi test (khởi tạo driver)
 * 3. @Test - Test methods
 * 4. @AfterMethod - Teardown sau mỗi test (đóng driver)
 * 5. @AfterClass - Teardown test suite
 * 
 * Cách sử dụng:
 * - Tạo page objects trong @BeforeMethod
 * - Gọi page methods để interact với UI
 * - Verify results dùng assertions
 * - Tránh direct element interaction, luôn qua page objects
 * 
 * Ví dụ:
 * @Test
 * public void testValidLogin() {
 *     LoginPage loginPage = new LoginPage();
 *     loginPage.login("user@example.com", "password123");
 *     
 *     HomePage homePage = new HomePage();
 *     homePage.verifyPageLoaded();
 *     assert homePage.getWelcomeMessage().contains("Welcome");
 * }
 */
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
        logger.info("✓ Driver initialized");
        
        // Khởi tạo page objects
        loginPage = new LoginPage();
        homePage = new HomePage();
    }
    
    /**
     * Test Case 1: Verify Login Page loaded successfully
     */
    @Test(description = "Verify login page loads successfully")
    public void testLoginPageLoaded() {
        logger.info("Test: Login Page Loaded");
        loginPage.verifyPageLoaded();
        logger.info("✓ Test Passed");
    }
    
    /**
     * Test Case 2: Verify login with valid credentials
     * 
     * Steps:
     * 1. Enter username
     * 2. Enter password
     * 3. Click login button
     * 4. Verify home page is displayed
     */
    @Test(description = "Login with valid credentials")
    public void testValidLogin() {
        logger.info("Test: Valid Login");
        
        // Step 1-3: Login
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        logger.info("✓ Login action completed");
        
        // Step 4: Verify
        homePage.verifyPageLoaded();
        String welcomeMsg = homePage.getWelcomeMessage();
        assert welcomeMsg.contains("Welcome") : "Welcome message not found";
        logger.info("✓ Test Passed");
    }
    
    /**
     * Test Case 3: Verify login with invalid credentials
     * 
     * Steps:
     * 1. Enter invalid username
     * 2. Enter invalid password
     * 3. Click login button
     * 4. Verify error message is displayed
     */
    @Test(description = "Login with invalid credentials")
    public void testInvalidLogin() {
        logger.info("Test: Invalid Login");
        
        // Step 1-3: Try to login with invalid credentials
        loginPage.login(Constants.INVALID_USERNAME, Constants.INVALID_PASSWORD);
        
        // Step 4: Verify error
        boolean isErrorDisplayed = loginPage.isErrorMessageDisplayed();
        assert isErrorDisplayed : "Error message not displayed";
        
        String errorMsg = loginPage.getErrorMessage();
        assert !errorMsg.isEmpty() : "Error message is empty";
        logger.info("✓ Error message displayed: " + errorMsg);
        logger.info("✓ Test Passed");
    }
    
    /**
     * Test Case 4: Test Logout functionality
     * 
     * Precondition: User is logged in
     * Steps:
     * 1. Click logout button
     * 2. Confirm logout
     * 3. Verify login page is displayed
     */
    @Test(description = "Logout from application", dependsOnMethods = "testValidLogin")
    public void testLogout() {
        logger.info("Test: Logout");
        
        // Precondition: Login first
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        homePage.verifyPageLoaded();
        logger.info("✓ User logged in");
        
        // Step 1-2: Logout
        homePage.logout();
        logger.info("✓ Logout completed");
        
        // Step 3: Verify login page
        loginPage.verifyPageLoaded();
        logger.info("✓ Test Passed");
    }
    
    /**
     * Test Case 5: Test Remember Me functionality
     */
    @Test(description = "Remember me functionality")
    public void testRememberMe() {
        logger.info("Test: Remember Me");
        
        // Check remember me checkbox
        loginPage.checkRememberMe();
        logger.info("✓ Remember me checked");
        
        boolean isChecked = loginPage.isElementSelected(
            com.example.appium.locators.LoginPageLocators.REMEMBER_ME_CHECKBOX
        );
        assert isChecked : "Remember me checkbox not checked";
        logger.info("✓ Test Passed");
    }
    
    @AfterMethod
    public void tearDown() {
        logger.info("========== Test Method Teardown ==========");
        DriverManager.quitDriver();
        logger.info("✓ Driver quit");
    }
    
    @AfterClass
    public void teardownClass() {
        logger.info("========== Test Class Teardown ==========");
        logger.info("Cleaning up test environment...");
    }
}
