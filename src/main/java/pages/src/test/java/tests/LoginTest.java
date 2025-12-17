package tests;

import base.Base;
import pages.LoginPage;
import pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for Login functionality
 * Contains test cases for login operations
 */
public class LoginTest extends Base {

    @Test(description = "Verify valid login with correct credentials")
    public void testValidLogin() {
        driver.get("https://practice.automationtesting.in/my-account/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser@example.com", "Test@123456");
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard should be displayed");
    }

    @Test(description = "Verify login with invalid password")
    public void testInvalidPassword() {
        driver.get("https://practice.automationtesting.in/my-account/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser@example.com", "wrongpassword");
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(!errorMsg.isEmpty(), "Error message should be displayed");
    }

    @Test(description = "Verify login with empty username")
    public void testEmptyUsername() {
        driver.get("https://practice.automationtesting.in/my-account/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "Test@123456");
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(!errorMsg.isEmpty(), "Error message should be displayed for empty username");
    }

    @Test(description = "Verify login with empty password")
    public void testEmptyPassword() {
        driver.get("https://practice.automationtesting.in/my-account/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser@example.com", "");
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(!errorMsg.isEmpty(), "Error message should be displayed for empty password");
    }

    @Test(description = "Verify login with both fields empty")
    public void testBothFieldsEmpty() {
        driver.get("https://practice.automationtesting.in/my-account/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(!errorMsg.isEmpty(), "Error message should be displayed when both fields are empty");
    }
}
