package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessagesTest extends BaseTest {

    @Test
    public void testNotificationMessages() {
        // Step 1: Click "Notification Messages" link on the Main page.
        WebElement notificationMessagesLink = driver.findElement(By.linkText("Notification Messages"));
        notificationMessagesLink.click();

        // Step 2: Trigger notifications.
        WebElement clickHere = driver.findElement(By.xpath("//a[@href='/notification_message']"));
        clickHere.click();

        // Expected Result: Notifications are displayed as expected.
        WebElement Notification = driver.findElement(By.id("flash"));
        Assert.assertTrue(Notification.isDisplayed(), "Notification message is not displayed");

    }
}
