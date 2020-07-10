package com.sparta.mm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationFormPOM {
    WebDriver webDriver;
    WebElement webElement;
    By form = new By.ByClassName("form-control");
    By formGroup = new By.ByClassName("form-group");
    By submit = new By.ByClassName("btn btn-primary");
    By clickGender = new By.ByClassName("customRadioInline2");

    public RegistrationFormPOM(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().window().maximize();
        webDriver.get("http://localhost:9292/");
    }

    public RegistrationFormPOM getOpenURL() {
        selectGenderMale();
        return this;
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

    //--------------------Number of choices--------------------//


    public void clickSubmit() {
        webDriver.findElement(submit).click();
        //Actions actionProvider = new Actions(webDriver);
       // actionProvider.clickAndHold(searchBtn).build().perform();
    }

    public void selectGenderMale() {
      webElement =  webDriver.findElement(By.id("customRadioInline1"));
      webElement.click();
    }
    public void selectGenderFemale() {
        webElement =  webDriver.findElement(clickGender);
        Actions actions = new Actions(webDriver);
        actions.clickAndHold(webElement).build().perform();
        //webElement.click();
    }

}
