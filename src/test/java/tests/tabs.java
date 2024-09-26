package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;


public class tabs extends BaseTest {
    private final By MULTIPLE_WINDOWS = By.xpath(String.format(PRECISE_TEXT_XPATH, "Multiple Windows"));
    private final By CLICK_BUTTON = By.linkText("Click Here");
    private final By HEADER_TEXT = By.tagName("h3");


    @Test
    public void test() {
        driver.findElement(MULTIPLE_WINDOWS).click();
        String firstWindow = driver.getWindowHandle();
        driver.findElement(CLICK_BUTTON);

        Assert.assertEquals(driver.getWindowHandles().size(), 2);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(numberOfWindowsToBe(2));

        for (String winHandle : driver.getWindowHandles()) {
            if (!firstWindow.contentEquals(winHandle)) {
                driver.switchTo().window(winHandle);
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_TEXT));
        WebElement headerText = driver.findElement(HEADER_TEXT);
        Assert.assertTrue(headerText.isDisplayed());
    }
}


