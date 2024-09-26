package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest{
    private final By CONTEXT_MENU = By.xpath(String.format(PRECISE_TEXT_XPATH, "Context Menu"));

    @Test
    public void contextMenuTest() {
        driver.findElement(CONTEXT_MENU).click();
        WebElement contextMenuElement = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenuElement).perform();
        Assert.assertTrue(driver.switchTo().alert().getText().contains("You selected a context menu"), "Alert message is not displayed");
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertTrue(alertMessage.contains("You selected a context menu"), "Alert message is not displayed");
        System.out.println("Alert message: " + alertMessage);
        driver.switchTo().alert().accept();
    }
}
