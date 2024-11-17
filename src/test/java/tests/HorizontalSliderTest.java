package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTest extends BaseTest {
    private  final By HORIZONTAL_SLIDER=By.xpath(String.format((PRECISE_TEXT_PATH),"Horizontal Slider"));
    private final By SLIDER=By.className("sliderContainer");
    private final By SLIDER_VALUE=By.id("range");

    @Test
    public void testHorizontalSlider() {
        // Step 1: Click "Horizontal Slider" link on the Main page.
        driver.findElement(HORIZONTAL_SLIDER).click();

        // Step 2: Move the slider.
        WebElement slider = driver.findElement(SLIDER);
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(50, 0).release().perform();

        // Expected Result: Slider value changes as it is moved.
        String sliderValue = driver.findElement(SLIDER_VALUE).getText();
        Assert.assertEquals(sliderValue,"0","Slider value did not change");
    }
}
