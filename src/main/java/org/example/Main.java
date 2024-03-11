package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "/Users/lee/Downloads/chromedriver-mac-arm64");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Define an explicit wait

        try {
            driver.get("https://app.bugbug.io/sign-in/");
//            driver.wait(3);

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
//            create new project page

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