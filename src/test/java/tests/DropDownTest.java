package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest extends BaseTest{
    private final By DROP_DOWN_LINK=By.xpath(String.format((PRECISE_TEXT_PATH),"Dropdown"));
    private final By SELECT_AN_OPTION=By.id("dropdown");
    String VISIBLE_TEXT_1="Option 1";
    String VISIBLE_TEXT_2="Option 2";

    @Test
    public void dropDownTest(){
        driver.findElement(DROP_DOWN_LINK).click();
        WebElement dropdownElement=driver.findElement(SELECT_AN_OPTION);
        dropdownElement.click();

        Select dropdown = new Select(dropdownElement);

        // Select option by visible text and verify
        dropdown.selectByVisibleText(VISIBLE_TEXT_1);
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        Assert.assertEquals(selectedOption.getText(), VISIBLE_TEXT_1, "Selected option is incorrect");

        // Select another option by visible text and verify
        dropdown.selectByVisibleText(VISIBLE_TEXT_2);
         WebElement selectedOption2 = dropdown.getFirstSelectedOption();
        Assert.assertEquals(selectedOption2.getText(), VISIBLE_TEXT_2, "Selected option is incorrect");

        dropdown.selectByValue("1");
        WebElement selectedOption3 = dropdown.getFirstSelectedOption();
        Assert.assertEquals(selectedOption3.getText(), "Option 1", "Selected option is incorrect");






    }
}
