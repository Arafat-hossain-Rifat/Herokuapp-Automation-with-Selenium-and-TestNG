package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthTest extends BaseTest{
    private final By FORM_AUTHENTICATION_LINK = By.xpath(String.format((PRECISE_TEXT_PATH), "Form Authentication"));
    private final By USERNAME_FIELD = By.id("username");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.cssSelector("button[type='submit']");
    private final By SUCCESS_MESSAGE = By.cssSelector(".flash.success");
    private final By LOGOUT_BUTTON = By.cssSelector(".icon-2x.icon-signout");
    private final By LOGOUT_SUCCESS_MESSAGE = By.cssSelector(".flash.success");

     String VALID_USERNAME = "tomsmith";
     String VALID_PASSWORD = "SuperSecretPassword!";

    @Test
    public void formAuthenticationTest() {
        // Navigate to the Form Authentication page
        driver.findElement(FORM_AUTHENTICATION_LINK).click();

        // Enter valid credentials
        driver.findElement(USERNAME_FIELD).sendKeys(VALID_USERNAME);
        driver.findElement(PASSWORD_FIELD).sendKeys(VALID_PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();

        // Verify the success message is displayed
        String successMessage = driver.findElement(SUCCESS_MESSAGE).getText();
        Assert.assertTrue(successMessage.contains("You logged into a secure area!"), "Success message is incorrect or not displayed.");
        // Perform logout action
        driver.findElement(LOGOUT_BUTTON).click();

        // Verify the logout success message is displayed
        String logoutSuccessMessage = driver.findElement(LOGOUT_SUCCESS_MESSAGE).getText();
        Assert.assertTrue(logoutSuccessMessage.contains("You logged out of the secure area!"), "Logout success message is incorrect or not displayed.");
    }
}

