package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {
    private final By JS_ALERT = By.xpath(String.format((PRECISE_TEXT_PATH), "JavaScript Alerts"));
    private final By CLICK_FOR_ALERT=By.xpath("//button[@onclick='jsAlert()']");
    private final By SUCCESS_MESSAGE=By.xpath(String.format((PRECISE_TEXT_PATH),"You successfully clicked an alert"));

    @Test
    public void alertTest(){
        driver.findElement(JS_ALERT).click();
        driver.findElement(CLICK_FOR_ALERT).click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(SUCCESS_MESSAGE).isDisplayed());

    }
}