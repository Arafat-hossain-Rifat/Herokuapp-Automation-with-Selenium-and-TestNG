package tests;

import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class FileDownloadTest extends BaseTest{
    private final String FILE_NAME = "test.txt";
    private final By FILE_DOWNLOAD_LINK=By.xpath(String.format((PRECISE_TEXT_PATH),"File Download"));
    private final By FILE_NAME_XPATH=By.xpath(String.format((PRECISE_TEXT_PATH),FILE_NAME));
    private final String FILE_PATH = Paths.get(DOWNLOADS_DIR, FILE_NAME).toString();
    private final File downloadedFile = new File(FILE_PATH);

    @Test
    public void fileDownloadTest(){
        driver.findElement(FILE_DOWNLOAD_LINK).click();
        WebElement fileName= driver.findElement(FILE_NAME_XPATH);
        Assert.assertTrue(fileName.isDisplayed(),"File name is not displayed");
        fileName.click();
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
