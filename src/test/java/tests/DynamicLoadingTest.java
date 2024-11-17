package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BaseTest {

    private final By DYNAMIC_LOADING_LINK = By.xpath(String.format(PRECISE_TEXT_PATH, "Dynamic Loading"));
    private final By EXAMPLE_1_LINK = By.partialLinkText("Example 1: Element on page that is hidden");
    private final By START_BUTTON = By.cssSelector("#start button");
    private final By LOADING_INDICATOR = By.id("loading");
    private final By FINISH_TEXT = By.id("finish");

    @Test
    public void dynamicLoadingTest() {
        // Navigate to the Dynamic Loading page
        driver.findElement(DYNAMIC_LOADING_LINK).click();

        // Click on Example 1 link
        driver.findElement(EXAMPLE_1_LINK).click();

        // Click the Start button
        driver.findElement(START_BUTTON).click();

        // Wait for the loading indicator to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(LOADING_INDICATOR));

        // Verify the finish text is displayed
        WebElement finishTextElement = driver.findElement(FINISH_TEXT);
        wait.until(ExpectedConditions.visibilityOf(finishTextElement));
        String finishText = finishTextElement.getText();

        Assert.assertEquals(finishText, "Hello World!", "The loaded text is incorrect or not displayed.");
    }
}
