package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveTest extends BaseTest{
    private final By ADD_REMOVE_ELEMENTS=By.xpath(String.format((PARTICULAR_TEXT_PATH),"Add/Remove Elements"));
    private final By ADD_BUTTON=By.xpath("//button[text()='Add Element']");
    private final By DELETE_BUTTON=By.xpath("//button[@class='added-manually']");

    @Test
    public void addRemoveTest() {
        driver.findElement(ADD_REMOVE_ELEMENTS).click();

        driver.findElement(ADD_BUTTON).click();
        WebElement deleteButton = driver.findElement(DELETE_BUTTON);
        Assert.assertTrue(deleteButton.isDisplayed(), "'Delete' button is not displayed");

        deleteButton.click();
        Assert.assertTrue(driver.findElements(DELETE_BUTTON).isEmpty(), "'Delete' button is not removed");

    }
}
