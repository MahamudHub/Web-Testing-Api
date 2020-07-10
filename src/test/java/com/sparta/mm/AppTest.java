package com.sparta.mm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    WebDriver webDriver = new ChromeDriver();
    RegistrationFormPOM formPOM = new RegistrationFormPOM(webDriver);


    @Test
    public void testExample() {
        WebDriver driver = new ChromeDriver();
        By form = new By.ByClassName("form-control");
        driver.manage().window().maximize();
        driver.get("http://localhost:9292");
        String firstName = driver.findElement(form).getAttribute("placeholder");
        assertEquals("Enter First Name", firstName);
        driver.quit();
    }

    @Test
    void agePlaceholderTest() {
        assertEquals(true, formPOM.isAgePlaceholderCorrect());
        webDriver.quit();
    }

    @Test
    public void openUrlLinksTest() {
        String testLink = "http://localhost:9292/";
        assertEquals(testLink, formPOM.goToHomePage().getCurrentUrlURL());
        webDriver.quit();
    }

    @Test
    public void testTitle() {
        assertEquals(true, formPOM.goToHomePage().isAppTitleCorrect());
        webDriver.quit();
    }

    @Test
    public void testMaleRadioBox() {
        assertEquals("rgba(33, 37, 41, 1)", formPOM.goToHomePage().selectGenderMale());
        webDriver.quit();
    }
}
