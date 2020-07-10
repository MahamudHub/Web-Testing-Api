# Web-Testing-Api


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.


### Prerequisites

What things you need to install the software and how to install them

```
Ruby

RubyInstaller is the easiest and most used Ruby environment on Windows.

 # https://rubyinstaller.org/

```

### Application set-up

```bash
bundle
rackup
```
#### Go to http://localhost:9292

## Running the tests

To run a test you would need to create an instance of WebDriver & POM class in your testing class
The POM provides you with methods you could use to call it through the assertion to run the appropriate tests you require.

 ```java 
    WebDriver webDriver = new ChromeDriver();
    RegistrationFormPOM formPOM = new RegistrationFormPOM(webDriver);
 ```
 ## Example tests
 
 ```java  
   @Test
    public void openUrlLinkTest(){
        String testLink = "http://localhost:9292/";
        assertEquals(testLink, formPOM.goToHomePage().getCurrentUrlURL());
        webDriver.quit();
    }
  ```
  
  ## Built With
 * [Maven](https://maven.apache.org/) - Dependency Management
 * [Junit](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.6.2) - Dependency
 * [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59/) - Dependency
 * [Chrome Driver](https://chromedriver.chromium.org/downloads) - Driver
 
 
