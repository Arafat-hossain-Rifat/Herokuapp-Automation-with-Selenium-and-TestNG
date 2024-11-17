package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    @Test
    public void testDragAndDrop() {
        // Step 1: Click "Drag and Drop" link on the Main page.
        WebElement dragAndDropLink = driver.findElement(By.linkText("Drag and Drop"));
        dragAndDropLink.click();

        // Step 2: Drag and drop the elements.
        WebElement sourceElement = driver.findElement(By.id("column-a"));
        WebElement targetElement = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).perform();

        // Expected Result: Elements are draggable and droppable successfully.
        String sourceTextAfterDrop = sourceElement.getText();
        String targetTextAfterDrop = targetElement.getText();

        Assert.assertEquals(sourceTextAfterDrop, "B", "Drag and drop failed: Source text not updated");
        Assert.assertEquals(targetTextAfterDrop, "A", "Drag and drop failed: Target text not updated");
    }
}
