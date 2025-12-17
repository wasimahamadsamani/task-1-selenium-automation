package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

/**
 * Base class for WebDriver initialization and teardown
 * Implements common setup and cleanup methods for all test classes
 */
public class Base {
    protected static WebDriver driver;

    /**
     * Setup method - Initializes WebDriver before each test
     * Sets up Chrome browser with WebDriverManager
     */
    @BeforeMethod
    public void setup() {
        // Setup Chrome WebDriver automatically
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        // Configure WebDriver settings
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }

    /**
     * Teardown method - Closes WebDriver after each test
     */
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
