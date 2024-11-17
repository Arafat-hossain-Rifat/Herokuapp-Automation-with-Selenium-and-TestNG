package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    private final By CONTEXT_MENU_LINK = By.xpath(String.format((PRECISE_TEXT_PATH), "Context Menu"));
    private final By CONTEXT = By.id("hot-spot");


    @Test
    public void contextMenuTest() {
        driver.findElement(CONTEXT_MENU_LINK).click();

        WebElement context = driver.findElement(CONTEXT);
        Actions actions = new Actions(driver);
        actions.contextClick(context).perform();

        // Handle the alert and verify its text
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "You selected a context menu", "Alert text is incorrect");
        driver.switchTo().alert().accept();

    }
}