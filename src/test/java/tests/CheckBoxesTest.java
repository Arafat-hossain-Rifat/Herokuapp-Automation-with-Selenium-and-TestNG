package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxesTest extends BaseTest{
    private final By CHECK_BOXES_LINK=By.xpath(String.format((PRECISE_TEXT_PATH),"Checkboxes"));
    private final By CHECK_BOXES=By.xpath("//input[@type='checkbox']");

    @Test
    public void checkBoxesTest(){
        driver.findElement(CHECK_BOXES_LINK).click();

        List<WebElement> checkboxes=driver.findElements(CHECK_BOXES);
        WebElement firstCheckBox=checkboxes.get(0);
        firstCheckBox.click();
        Assert.assertTrue(firstCheckBox.isSelected(),"First Checkbox is not selected");

        WebElement secondCheckBox=checkboxes.get(1);
        secondCheckBox.click();
        Assert.assertFalse(secondCheckBox.isSelected(),"SecondCheckBox is Selected");
    }
}
