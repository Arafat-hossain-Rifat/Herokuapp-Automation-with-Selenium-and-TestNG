package tests;

import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class SecureFileDownloadTest extends BaseTest{
    private final By FILE_DOWNLOAD_LINK=By.xpath(String.format((PRECISE_TEXT_PATH),"Secure File Download"));
    private final String FILE_NAME="some-file.txt";
    private final By FILE_NAME_XPATH=By.xpath(String.format((PRECISE_TEXT_PATH),FILE_NAME));
    private final String FILE_PATH= Paths.get(DOWNLOADS_DIR,FILE_NAME).toString();
    private final File downloadedFile=new File(FILE_PATH);

    @BeforeMethod
    public void secureFileDownload(){
        HasAuthentication authentication=(HasAuthentication) driver;
        authentication.register(()->new UsernameAndPassword("admin","admin"));
    }

    @Test
    public void secureFileDownloadTest(){
        driver.findElement(FILE_DOWNLOAD_LINK).click();

        Assert.assertTrue(driver.findElement(FILE_NAME_XPATH).isDisplayed(),"File is not displayed");
        driver.findElement(FILE_NAME_XPATH).click();
        Assert.assertTrue(isFileExists(downloadedFile),"File is not downloaded");
    }
    private boolean isFileExists(File file){
        try{
            Awaitility.await().atMost(MAX_WAIT, TimeUnit.SECONDS).until(file::exists);
        } catch (ConditionTimeoutException exception){
            return false;
        }
        return true;
    }
    @AfterMethod
    public void deleteFile(){
        if(downloadedFile.exists()){
            downloadedFile.delete();

        }
    }
}
