package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseTest {
    protected final String URL="https://the-internet.herokuapp.com/";
    protected final int MAX_WAIT=10;
    protected final String PRECISE_TEXT_PATH="//*[text()='%s']";
    protected final String PARTICULAR_TEXT_PATH="//*[contains(text(),'%s')]";
    protected final String DOWNLOADS_DIR = "src/test/resources/downloads";
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", Paths.get(DOWNLOADS_DIR).toAbsolutePath().toString());
        options.setExperimentalOption("prefs", prefs);

        // Initialize ChromeDriver with options
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT));

        // Navigate to the test URL
        driver.get(URL);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
