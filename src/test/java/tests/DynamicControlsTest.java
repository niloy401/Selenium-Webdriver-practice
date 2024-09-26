package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;

public class DynamicControlsTest extends BaseTest {
    private final By DYNAMIC_CONTROL = By.xpath(String.format(PRECISE_TEXT_XPATH, "Dynamic Controls"));
    private final By ENABLE = By.xpath(String.format(PRECISE_TEXT_XPATH, "Enable"));
    private final By INPUT = By.xpath("//*[@id='input-example']//input");
    private final String RANDOM_TEXT = UUID.randomUUID().toString();

    @Test
    public void dynamicControlsTest() {
        driver.findElement(DYNAMIC_CONTROL).click();
        driver.findElement(ENABLE).click();
        WebElement input = driver.findElement(INPUT);
        Assert.assertTrue(isClickable(input), "element was not enabled");
        input.sendKeys(RANDOM_TEXT);
        Assert.assertEquals(driver.findElement(INPUT).getAttribute("value"), RANDOM_TEXT, "Text is not displayed");
    }

    private boolean isClickable( WebElement element){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (TimeoutException exception){
            return false;
        }
        return true;
    }
}
