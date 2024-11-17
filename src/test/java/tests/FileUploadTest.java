package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;

public class FileUploadTest extends BaseTest{
    private final By UPLOAD_FILE_LINK=By.xpath(String.format((PRECISE_TEXT_PATH),"File Upload"));
    private final String FILE_NAME="some-file.txt";
    private final String FILE_PATH= Paths.get(DOWNLOADS_DIR,FILE_NAME).toString();
    private final File fileTOUpload=new File(FILE_PATH);
    private final By CHOOSE_FILE=By.id("file-upload");
    private final By UPLOAD_BUTTON=By.id("file-submit");
    private final By UPLOADED_FILE=By.id("uploaded-files");

    @Test
    public void fileUploadTest(){
        driver.findElement(UPLOAD_FILE_LINK).click();
        driver.findElement(CHOOSE_FILE).sendKeys(fileTOUpload.getAbsolutePath());
        driver.findElement(UPLOAD_BUTTON).click();
        Assert.assertEquals(driver.findElement(UPLOADED_FILE).getText(),FILE_NAME,"File name on Upload page is not correct");


    }
}
