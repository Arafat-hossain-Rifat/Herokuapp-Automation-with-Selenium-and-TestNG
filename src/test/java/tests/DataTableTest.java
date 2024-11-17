package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DataTableTest extends BaseTest {

    private final By DATA_TABLES=By.xpath(String.format((PRECISE_TEXT_PATH),"Sortable Data Tables"));
    private final By DUE_LOCATOR=By.xpath("//*[@id='table1']//td[4]");
     Double EXPECTED_RESULT=251.0;
    String CURRENCY_REGEX="[^\\d.]";

    @Test
    public  void dataTableTest(){
         driver.findElement(DATA_TABLES).click();

        List<WebElement> dueList=driver.findElements(DUE_LOCATOR);
        Double actualSum=0.0;
        for(WebElement element:dueList){
            String elementText= element.getText();
            actualSum += Double.parseDouble(elementText.replaceAll(CURRENCY_REGEX,""));
        }
        Assert.assertEquals(actualSum,EXPECTED_RESULT,"Sum is not correct");
    }
}
