package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

public class DynamicContentTest extends BaseTest {

    private final By DYNAMIC_CONTENT_LINK = By.xpath(String.format((PRECISE_TEXT_PATH), "Dynamic Content"));
    private final By CONTENT_DIVS = By.className("row");

    @Test
    public void dynamicContentTest() {

        driver.findElement(DYNAMIC_CONTENT_LINK).click();

        String initialContent = driver.findElements(CONTENT_DIVS)
                .stream().map(WebElement::getText).collect(Collectors.joining());

        driver.navigate().refresh();

        String newContent = driver.findElements(CONTENT_DIVS)
                .stream().map(WebElement::getText).collect(Collectors.joining());

        Assert.assertNotEquals(initialContent, newContent, "Dynamic content did not change after page refresh");
    }
}
