package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void createNewTest(String testName) {
        // Navigate to the tests management section
        WebElement testsLink = driver.findElement(By.xpath("//a[.//span[contains(text(),'Tests')]]"));
        testsLink.click();

        // Click the "New Test" button
        WebElement newTestButton = driver.findElement(By.cssSelector("button[data-testid='TestsActions.CreateNewTest']"));
        newTestButton.click();

        // Fill in the test name and other details
        WebElement testNameInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("name")));

        testNameInput.sendKeys(testName);

        // Submit the form to create the test
        WebElement createButton = driver.findElement(By.cssSelector("button[type='submit']"));
        createButton.click();

        //Go back to the tests management section
        testsLink.click();

    }

    public static void createNewSuite() {
// XPath that targets the "Suites" link specifically by its text
        WebElement suitesLink = driver.findElement(By.xpath("//a[.//span[contains(text(), 'Suites')]]"));
        suitesLink.click();

        WebElement createSuite = driver.findElement(By.cssSelector("button[data-testid='SuitesActions.CreateNewSuite']"));
        createSuite.click();

        WebElement suiteName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
        suiteName.sendKeys("suite1");

        WebElement suiteIcon = driver.findElement(By.cssSelector("button[data-testid=\"IconButton\"]"));
        suiteIcon.click();

        WebElement createBtnSuite = driver.findElement(By.cssSelector("button.sc-tagGq.fxwkFr.sc-fXSgeo.cLzWpS"));
        createBtnSuite.click();
    }




    /*public static void deleteTest() {
        // Identify the test row that you want to delete by using a unique identifier, not shown in this code.
        WebElement testRow = driver.findElement(By.xpath("//button[@data-testid='Dropdown.IconButton']"));

        // Hover over the test row to make the dropdown button visible
        Actions actions = new Actions(driver);
        actions.moveToElement(testRow).perform();

        // Wait for the dropdown button to be clickable after the hover action
        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid='Dropdown.IconButton']")));
        dropdownButton.click(); // Now it's safe to click

        // Wait for the delete option to become visible and click it
        WebElement deleteOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Delete')]")));
        deleteOption.click();

        // Wait for the confirm delete button and click it
        WebElement confirmDeleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Confirm Delete')]")));
        confirmDeleteButton.click();
    }*/


    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "/Users/lee/Downloads/chromedriver-mac-arm64");

        try {
            driver.get("https://app.bugbug.io/sign-in/");
            //driver.wait(3);

            WebElement emailField = driver.findElement(By.name("email"));
            WebElement passwordField = driver.findElement(By.name("password"));
            emailField.sendKeys("zhoujianpingzx@gmail.com"); // replace with your actual email
            passwordField.sendKeys("156897123468Zx!");
            WebElement signInBtn = driver.findElement(By.tagName("button"));
            signInBtn.click();
            //test for sign in page
            WebElement newProjectButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid='ProjectList.NewProjectButton']")));
            newProjectButton.click();
            // After sign-in, wait for navigation and ensure the new page is loaded

            WebElement newProjectName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='Input']")));
            newProjectName.sendKeys("newProject");
            WebElement websiteToTest = driver.findElement(By.name("homepageUrl"));
            websiteToTest.sendKeys("https://www.google.com");
            WebElement createProjectBtn = driver.findElement(By.cssSelector("button[data-testid='Button']"));
            createProjectBtn.click();
            WebElement createTestBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='EditTestModal.SubmitButton']")));
            createTestBtn.click();
            //create new project page


            createNewTest("test for create new tests");
//            deleteTest();
            createNewSuite();

//            WebElement startRecordingButton = driver.findElement(By.xpath("//button[.//div[text()='Start recording']]"));
//            startRecordingButton.click();

//            test the creating project page
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            driver.quit();
//        }
    }
}