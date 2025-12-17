package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Model for Dashboard Page
 */
public class DashboardPage {
    private WebDriver driver;

    // Locators
    private By dashboardHeading = By.xpath("//h1[text()='Dashboard']");
    private By shopLink = By.linkText("Shop");
    private By accountLink = By.linkText("My Account");
    private By logoutButton = By.xpath("//button[text()='Logout']");
    private By welcomeMessage = By.xpath("//div[@class='welcome']");

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public boolean isDashboardVisible() {
        try {
            return driver.findElement(dashboardHeading).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickShop() {
        driver.findElement(shopLink).click();
    }

    public void clickMyAccount() {
        driver.findElement(accountLink).click();
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }
}
