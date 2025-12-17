# task-1-selenium-automation

CODTECH Internship Task 1: Selenium WebDriver Test Automation - Automated testing of login and navigation functionality using Page Object Model (POM)

## Project Overview

This is a comprehensive Selenium WebDriver automation framework implementing the Page Object Model (POM) design pattern for testing web applications. The project demonstrates industry-standard practices for automated testing including locator strategies, wait mechanisms, and test organization.

## Table of Contents

1. [Features](#features)
2. [Prerequisites](#prerequisites)
3. [Installation](#installation)
4. [Project Structure](#project-structure)
5. [Selenium Concepts](#selenium-concepts)
6. [Running Tests](#running-tests)
7. [Test Scenarios](#test-scenarios)
8. [Page Object Model](#page-object-model)

## Features

- Automated login functionality testing
- Navigation flow validation
- Page Object Model implementation
- TestNG framework integration
- Cross-browser testing support
- Explicit wait strategies
- Custom locators (ID, XPath, CSS Selectors)
- Detailed test reporting

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Chrome/Firefox browser
- ChromeDriver/GeckoDriver
- Git

## Installation

### Step 1: Clone the Repository
```bash
git clone https://github.com/wasimahamadsamani/task-1-selenium-automation.git
cd task-1-selenium-automation
```

### Step 2: Install Dependencies
```bash
mvn clean install
```

### Step 3: Setup WebDriver

Download appropriate driver:
- ChromeDriver: https://chromedriver.chromium.org/
- GeckoDriver (Firefox): https://github.com/mozilla/geckodriver/releases

Place driver in project root or system PATH

## Project Structure

```
task-1-selenium-automation/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pages/
│   │       │   ├── LoginPage.java          # Login page objects and methods
│   │       │   └── DashboardPage.java      # Dashboard page objects
│   │       ├── utils/
│   │       │   ├── DriverManager.java      # WebDriver management
│   │       │   └── WaitManager.java        # Wait strategies
│   │       └── base/
│   │           └── BaseTest.java           # Base test class
│   └── test/
│       └── java/
│           └── tests/
│               ├── LoginTest.java          # Login test cases
│               └── NavigationTest.java     # Navigation test cases
├── pom.xml                                  # Maven configuration
├── testng.xml                               # TestNG configuration
└── README.md
```

## Selenium Concepts

### 1. Locator Strategies

**ID Locator:**
```java
driver.findElement(By.id("element_id"));
```

**XPath:**
```java
driver.findElement(By.xpath("//input[@name='username']"));
```

**CSS Selector:**
```java
driver.findElement(By.cssSelector("input.username-field"));
```

### 2. Explicit Waits

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button")));
```

### 3. Implicit Waits

```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```

### 4. Handling Alerts

```java
Alert alert = driver.switchTo().alert();
alert.accept();
```

## Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=LoginTest
```

### Run with TestNG
```bash
mvn test -DsuiteXmlFile=testng.xml
```

## Test Scenarios

### Scenario 1: Valid Login
- User enters valid credentials
- System authenticates user
- User redirected to dashboard
- Expected: Login successful

### Scenario 2: Invalid Credentials
- User enters invalid username/password
- System rejects login
- Error message displayed
- Expected: Error message shown

### Scenario 3: Navigation Flow
- User logs in
- User navigates to different pages
- Page content loads correctly
- Expected: All navigation successful

## Page Object Model

The POM pattern separates test scripts from page-specific code:

**LoginPage.java:**
```java
public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
    
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
```

**LoginTest.java:**
```java
public class LoginTest extends BaseTest {
    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("testuser");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }
}
```

## Best Practices

1. Use explicit waits instead of Thread.sleep()
2. Follow Page Object Model pattern
3. Keep locators separate from test logic
4. Use meaningful test names
5. Implement proper error handling
6. Generate test reports
7. Use version control

## Troubleshooting

**WebDriver not found:**
- Ensure ChromeDriver/GeckoDriver is in PATH
- Set webdriver.chrome.driver system property

**Element not found:**
- Verify element locator is correct
- Check if element is visible/enabled
- Use explicit waits

**Timeout exception:**
- Increase wait timeout duration
- Verify element load conditions
- Check network connectivity

## Dependencies

- Selenium: 4.x
- TestNG: 7.x
- Maven: 3.6+

## Status

✅ Framework Ready
✅ Page Objects Implemented
✅ Tests Configured
✅ Documentation Complete

## Author

Wasim Ahamad Samani

## License

MIT License
