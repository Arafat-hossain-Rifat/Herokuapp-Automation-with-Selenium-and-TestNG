package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTest extends BaseTest {

    @Test
    public void testHovers() {
        // Step 1: Click "Hovers" link on the Main page.
        WebElement hoversLink = driver.findElement(By.linkText("Hovers"));
        hoversLink.click();

        // Step 2: Hover over the elements.
        WebElement avatar1 = driver.findElement(By.xpath("//div[@class='example']//div[1]//img"));
        WebElement avatar2 = driver.findElement(By.xpath("//div[@class='example']//div[2]//img"));
        WebElement avatar3 = driver.findElement(By.xpath("//div[@class='example']//div[3]//img"));

        Actions actions = new Actions(driver);
        actions.moveToElement(avatar1).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//div[1]/div/a")).isDisplayed(), "Hover effect not displayed for avatar 1");

        actions.moveToElement(avatar2).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//div[2]/div/a")).isDisplayed(), "Hover effect not displayed for avatar 2");

        actions.moveToElement(avatar3).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//div[3]/div/a")).isDisplayed(), "Hover effect not displayed for avatar 3");

        // Expected Result: Hover effect and additional information are displayed.
    }
}
