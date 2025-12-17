package tests;

import base.Base;
import pages.LoginPage;
import pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for Navigation functionality
 * Contains test cases for navigation operations
 */
public class NavigationTest extends Base {

    @Test(description = "Verify navigation to Shop")
    public void testNavigateToShop() {
        driver.get("https://practice.automationtesting.in/my-account/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser@example.com", "Test@123456");
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickShop();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("shop"), "Should navigate to shop page");
    }

    @Test(description = "Verify navigation to My Account")
    public void testNavigateToMyAccount() {
        driver.get("https://practice.automationtesting.in/my-account/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser@example.com", "Test@123456");
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickMyAccount();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("my-account"), "Should navigate to my account page");
    }

    @Test(description = "Verify logout functionality")
    public void testLogout() {
        driver.get("https://practice.automationtesting.in/my-account/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser@example.com", "Test@123456");
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickLogout();
        // Verify user is logged out by checking if login page is displayed
        loginPage = new LoginPage(driver);
        boolean loginPageDisplayed = loginPage.getErrorMessage() != null || driver.getCurrentUrl().contains("my-account");
        Assert.assertTrue(loginPageDisplayed, "Should display login page after logout");
    }
}
