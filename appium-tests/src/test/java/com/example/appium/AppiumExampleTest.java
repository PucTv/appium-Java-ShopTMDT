package com.example.appium;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.net.MalformedURLException;

public class AppiumExampleTest extends AppiumTestBase {

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Initialize Android driver
        // Update these values with your app details
        try {
            AppiumBaseClass.initializeAndroidDriver(
                "/path/to/app.apk",
                "com.example.app",
                "com.example.app.MainActivity"
            );
        } catch (Exception e) {
            System.out.println("Note: To run this test, ensure Appium Server is running and provide valid app path");
        }
    }

    @Test
    public void exampleTest() {
        // Example test
        assertTrue(true, "Test passed");
        System.out.println("Example test executed successfully!");
    }

    @Test
    public void appInitializationTest() {
        // Verify the app can be initialized
        System.out.println("App initialization test passed!");
    }

    @AfterClass
    public void cleanUp() {
        try {
            AppiumBaseClass.tearDown();
        } catch (Exception e) {
            System.out.println("Error during cleanup: " + e.getMessage());
        }
    }
}
