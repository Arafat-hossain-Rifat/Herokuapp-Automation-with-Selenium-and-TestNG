package tests;

import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class JQueryUIMenusTest extends BaseTest {
    private final By JQUERY_UI_MENUS=By.xpath(String.format((PRECISE_TEXT_PATH),"JQuery UI Menus"));
    private final By ENABLED_MENU=By.id("ui-id-3");
    private final By DOWNLOADS_MENU=By.id("ui-id-4");
    private final By PDF_MENU=By.id("ui-id-5");
    private final String FILE_NAME = "menu.pdf";
    private final String FILE_PATH = Paths.get(DOWNLOADS_DIR, FILE_NAME).toString();
    private final File downloadedFile = new File(FILE_PATH);

    @Test
    public void testJQueryUIMenus() {
        // Step 1: Click "JQuery UI Menus" link on the Main page.
        driver.findElement(JQUERY_UI_MENUS).click();

        // Step 2: Interact with the menus.
        WebElement enabledMenu = driver.findElement(ENABLED_MENU);
        WebElement downloadsMenu = driver.findElement(DOWNLOADS_MENU);
        WebElement pdfMenu = driver.findElement(PDF_MENU);

        Actions actions = new Actions(driver);
        actions.moveToElement(enabledMenu).perform();
        wait.until(driver -> downloadsMenu.isDisplayed());
        actions.moveToElement(downloadsMenu).perform();
        wait.until(driver -> pdfMenu.isDisplayed());
        actions.moveToElement(pdfMenu).click().perform();
        // Verify the menu items are selectable and functional.
        Assert.assertTrue(enabledMenu.isDisplayed(), "Enabled menu is not displayed");
        // Wait for the file to be downloaded and check if it exists
        Assert.assertTrue(isFileExists(downloadedFile), "File is not downloaded");
    }
    private boolean isFileExists(File file) {
        try {
            Awaitility.await().atMost(MAX_WAIT, TimeUnit.SECONDS).until(file::exists);
        } catch (ConditionTimeoutException exception) {
            return false;
        }
        return true;
    }
}

