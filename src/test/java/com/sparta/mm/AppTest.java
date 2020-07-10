package com.sparta.mm;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    WebDriver webDriver = new ChromeDriver();
    RegistrationFormPOM formPOM = new RegistrationFormPOM(webDriver);

    @Test
    public void openUrlLinks(){
        String testLink = "http://localhost:9292/";
        assertEquals(testLink, formPOM.getOpenURL());
        webDriver.quit();
    }

    @Test
    public void checkNameBox(){
        formPOM.selectGenderFemale();
        //assertEquals("First Name *", );
        webDriver.quit();
    }
}
