package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowsTest extends BaseTest{
    private final By MULTIPLE_WINDOWS=By.xpath(String.format((PRECISE_TEXT_PATH),"Multiple Windows"));
    private final By CLICK_HERE=By.xpath("//a[@href='/windows/new']");
    private final By HEADER_TEXT=By.className("example");

    @Test
    public void multipleWindowsTest(){
        driver.findElement(MULTIPLE_WINDOWS).click();
        driver.findElement(CLICK_HERE).click();
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        WebElement header = driver.findElement(HEADER_TEXT);
        Assert.assertTrue(header.isDisplayed(), "Header text 'New Window' is not displayed");
    }

    }

