package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        Main.driver = this.driver;
    }

    @Test
    void testCreateNewTest() {
        String testName = "My new test";
        Main.createNewTest(testName);
         assertTrue(driver.getPageSource().contains(testName));
    }

    @Test
    void testCreateNewSuite() {
        String suiteName = "My new suite";
        Main.createNewSuite();


         assertTrue(driver.getPageSource().contains(suiteName));
    }

    @AfterEach
    void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
