package com.sparta.mm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationFormPOM {
    WebDriver webDriver;
    WebElement webElement;
    By title = new By.ByClassName("main-content");
    By form = new By.ByClassName("form-control");
    By formGroup = new By.ByClassName("form-group");
    By submit = new By.ByClassName("btn btn-primary");
    By male = new By.ByCssSelector("div.custom-control:nth-child(6) > label:nth-child(2)");
    By female = new By.ByCssSelector("div.custom-control:nth-child(7) > label:nth-child(2)");
    By terms = new By.ById("terms");
    By termsSelected = new By.ByClassName("form-check-label");
    By signIn = new By.ByXPath("/html/body/div/form/button");
    By SDET = new By.ByCssSelector("div.custom-control:nth-child(1) > label:nth-child(2)");
    By DevOps = new By.ByCssSelector("div.custom-control:nth-child(2) > label:nth-child(2)");

    public RegistrationFormPOM(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().window().maximize();
    }

    public RegistrationFormPOM goToHomePage(){
        webDriver.get("http://localhost:9292");
        return this;
    }

    public String getOpenURL() {
        return webDriver.getCurrentUrl();
    }

    public boolean isAppTitleCorrect(){
        String appTitle = webDriver.findElement(title).getText();
        return appTitle.contains("Sparta Global Registration Form");
    }


    public String titleName() {
        String title = webDriver.findElement(By.xpath("form/div[1]/div/label")).toString();
        String text = "First Name *";
        return title;
    }

    //--------------------Placeholder--------------------//

    public Boolean isFisrtNamePlaceholderCorrect() {
        String firstName = webDriver.findElement(form).getAttribute("placeholder");
        String text = "Enter First Name";
        return firstName.contains(text);
    }

    public Boolean isLastNamePlaceholderCorrect() {
        String lastName = webDriver.findElement(By.id("lastName")).getAttribute("placeholder");
        String text = "Enter Last Name";
        return lastName.contains(text);
    }

    public Boolean isAgePlaceholderCorrect() {
        String age = webDriver.findElement(By.xpath("/html/body/div/form/div[3]/div/input")).getAttribute("placeholder");
        String text = "Enter Age";
        return age.contains(text);
    }

    public Boolean isDegreePlaceholderCorrect() {
        String degree = webDriver.findElement(By.xpath("/html/body/div/form/div[7]/div/input")).getAttribute("placeholder");
        String text = "Enter Degree";
        return degree.contains(text);
    }

    public Boolean isAddressPlaceholderCorrect() {
        String address = webDriver.findElement(By.id("inputAddress")).getAttribute("placeholder");
        String text = "1234 Main St";
        return address.contains(text);
    }

    public Boolean isAddressTwoPlaceholderCorrect() {
        String address = webDriver.findElement(By.id("inputAddress2")).getAttribute("placeholder");
        String text = "Apartment, studio, or floor";
        return address.contains(text);
    }

    public Boolean isEmailAddressTwoPlaceholderCorrect() {
        String emailAddress = webDriver.findElement(By.id("inputemailaddress")).getAttribute("placeholder");
        String text = "name@example.com";
        return emailAddress.contains(text);
    }

    public Boolean islinkedInTwoPlaceholderCorrect() {
        String linkedIn = webDriver.findElement(By.xpath("/html/body/div/form/div[17]/div/input")).getAttribute("placeholder");
        String text = "Enter LinkedIn  url";
        return linkedIn.contains(text);
    }

    //--------------------Number of choices--------------------//

    public int numberUniversityChoices() {
        Actions actions = new Actions(webDriver);
        WebElement select = webDriver.findElement(By.id("inputUni"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        return options.size();
    }

    public int numberCountyChoices() {
        Actions actions = new Actions(webDriver);
        WebElement select = webDriver.findElement(By.id("inputCounty"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        return options.size();
    }

    //--------------------Dropdown list choice--------------------//

    public String universityChoice() {
        WebElement selectElement = webDriver.findElement(By.id("inputUni"));
        Select selectObject = new Select(selectElement);
        // selectObject.selectByIndex(1);
        selectObject.selectByVisibleText("University of Oxford");
        return selectObject.toString();
    }

    public String countyChoice() {
        Actions actions = new Actions(webDriver);
        WebElement selectElement = webDriver.findElement(By.id("inputCounty"));
        Select selectObject = new Select(selectElement);
        selectObject.selectByIndex(2);
        return selectObject.toString();
    }

    //--------------------Radio Click--------------------//


    public String selectGenderMale() {
        webDriver.findElement(male).click();
        return webDriver.findElement(male).getCssValue("color");
    }
    public String selectGenderFemale() {
        webDriver.findElement(female).click();
        return webDriver.findElement(female).getCssValue("color");
    }

    public String isTermsClicked(){
        webDriver.findElement(terms).click();
        webDriver.findElement(signIn).click();
        return webDriver.findElement(termsSelected).getCssValue("color");
    }

    public String isSDETclicked(){
        webDriver.findElement(SDET).click();
        return webDriver.findElement(SDET).getCssValue("color");
    }

    public String isDevOpsclicked(){
        webDriver.findElement(DevOps).click();
        return webDriver.findElement(DevOps).getCssValue("color");
    }

    public Color checkIsEmailBoxRed () {
        WebElement email = webDriver.findElement(By.id("userEmail"));
        email.sendKeys("Hello");
        email.submit();
        Color colourValue = Color.fromString(email.getCssValue("border-color"));
        return colourValue;
    }

}
