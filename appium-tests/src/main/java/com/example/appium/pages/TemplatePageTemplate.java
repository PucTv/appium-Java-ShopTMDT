package com.example.appium.pages;

import com.example.appium.locators.BaseLocators;
import org.openqa.selenium.By;

/**
 * TEMPLATE PAGE CLASS - Sao chép file này khi tạo page mới
 * 
 * Hướng dẫn sử dụng:
 * 1. Sao chép file này và đổi tên thành [PageName]Page.java
 * 2. Thay thế "TemplatePage" bằng tên page mới
 * 3. Import locator class của page
 * 4. Implement các methods cần thiết
 * 5. Gọi verifyPageLoaded() trong @BeforeMethod của test
 * 
 * Ví dụ:
 * - Tạo file: ProductListPage.java
 * - Locators: ProductListPageLocators.java (tạo trước)
 * - Methods: searchProduct(), filterByPrice(), clickProduct()
 */
public class TemplatePageTemplate extends BasePage {
    
    // ============ STEP 1: Import Locators ============
    // TODO: Thay thế bằng locator class của page này
    // import com.example.appium.locators.TemplatepageLocators;
    
    // ============ STEP 2: Khai báo Locators ============
    // Sử dụng locator class thay vì khai báo ở đây
    // Ví dụ: TemplatePageLocators.ELEMENT_NAME
    
    /**
     * STEP 3: Verify Page Load
     * Implement này để check page load thành công
     */
    @Override
    public void verifyPageLoaded() {
        logger.info("Verifying TemplatePage loaded...");
        
        // TODO: Kiểm tra element chính của page có visible không
        // if (!isElementDisplayed(TemplatePageLocators.MAIN_ELEMENT)) {
        //     throw new RuntimeException("TemplatePage did not load properly.");
        // }
        
        logger.info("✓ TemplatePage loaded successfully");
    }
    
    // ============ STEP 4: Implement Page Methods ============
    
    /**
     * Ví dụ method 1: Click element
     */
    public void clickPrimaryButton() {
        logger.info("Clicking primary button");
        // TODO: Thay thế bằng locator thực tế
        // click(TemplatePageLocators.PRIMARY_BUTTON);
    }
    
    /**
     * Ví dụ method 2: Type text
     */
    public void enterSearchText(String searchText) {
        logger.info("Entering search text: " + searchText);
        // TODO: Thay thế bằng locator thực tế
        // type(TemplatePageLocators.SEARCH_INPUT, searchText);
    }
    
    /**
     * Ví dụ method 3: Get text
     */
    public String getHeaderText() {
        logger.info("Getting header text");
        // TODO: Thay thế bằng locator thực tế
        // return getText(TemplatePageLocators.HEADER);
        return "";
    }
    
    /**
     * Ví dụ method 4: Business-level method (chaining múi actions)
     */
    public void performMainAction(String inputData) {
        logger.info("Performing main action with input: " + inputData);
        
        // Action 1
        // clickSomeElement();
        
        // Action 2
        // enterSearchText(inputData);
        
        // Action 3
        // clickPrimaryButton();
        
        logger.info("✓ Main action completed");
    }
    
    /**
     * Ví dụ method 5: Verification method
     */
    public boolean isElementPresent(By locator) {
        return isElementDisplayed(locator);
    }
    
    // ============ STEP 5: Add Mobile Gesture Methods (nếu cần) ============
    /**
     * Ví dụ: Scroll action
     */
    public void scrollDownInPage() {
        logger.info("Scrolling down in page");
        scrollDown();
    }
    
    /**
     * Ví dụ: Swipe action
     */
    public void swipeFromLeftToRight() {
        logger.info("Swiping from left to right");
        // Swipe từ trái sang phải
        // swipe(100, 400, 400, 400, 500);
    }
}

/**
 * ============ QUICK START GUIDE ============
 * 
 * 1. Tạo Locators File (nếu chưa có):
 * ----
 * package com.example.appium.locators;
 * 
 * public class TemplatepageLocators extends BaseLocators {
 *     public static final By ELEMENT_1 = By.id("element_1");
 *     public static final By ELEMENT_2 = By.xpath("//element");
 * }
 * ----
 * 
 * 2. Sao chép Template và Customize:
 * ----
 * public class TemplatePage extends BasePage {
 *     @Override
 *     public void verifyPageLoaded() {
 *         if (!isElementDisplayed(TemplatepageLocators.ELEMENT_1)) {
 *             throw new RuntimeException("Page not loaded");
 *         }
 *     }
 *     
 *     public void clickElement1() {
 *         click(TemplatepageLocators.ELEMENT_1);
 *     }
 * }
 * ----
 * 
 * 3. Viết Test:
 * ----
 * @BeforeMethod
 * public void setup() throws Exception {
 *     DriverManager.initializeDriver();
 *     templatePage = new TemplatePage();
 *     templatePage.verifyPageLoaded();
 * }
 * 
 * @Test
 * public void testSomething() {
 *     templatePage.clickElement1();
 * }
 * ----
 * 
 * 4. Run test!
 */
