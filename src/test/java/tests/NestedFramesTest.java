package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NestedFramesTest extends BaseTest {

    @Test
    public void testNestedFrames() {
        // Step 1: Click "Nested Frames" link on the Main page
        driver.findElement(By.linkText("Nested Frames")).click();

        // Step 2: Interact with the nested frames

        // Switch to the main frame
        driver.switchTo().frame("frame-top");

        // Switch to the left frame within the top frame
        driver.switchTo().frame("frame-left");

        // Verify content within the left frame
        WebElement leftFrameBody = driver.findElement(By.tagName("body"));
        String leftFrameText = leftFrameBody.getText();
        System.out.println(leftFrameText);
        assertTrue(leftFrameText.contains("LEFT"), "Left frame does not contain expected text");

        // Switch back to the main frame
        driver.switchTo().defaultContent();

        // Switch to the bottom frame
        driver.switchTo().frame("frame-bottom");

        // Verify content within the bottom frame
        WebElement bottomFrameBody = driver.findElement(By.tagName("body"));
        String bottomFrameText = bottomFrameBody.getText();
        System.out.println(bottomFrameText);
        assertTrue(bottomFrameText.contains("BOTTOM"), "Bottom frame does not contain expected text");

        // Switch back to the main content
        driver.switchTo().defaultContent();
    }

}
