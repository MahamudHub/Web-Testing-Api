# Web-Testing-Api


To run a test you would need to create an instance of WebDriver & POM class in your testing class
The POM provides you with methods you could use to call it through the assertion to run the appropriate tests you require.

 ```java 
    WebDriver webDriver = new ChromeDriver();
    RegistrationFormPOM formPOM = new RegistrationFormPOM(webDriver);
 ```
