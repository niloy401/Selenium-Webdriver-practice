package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MultiTabsTest extends BaseTest {
    private final By MULTIPLE_WINDOWS= By.xpath(String.format(PRECISE_TEXT_XPATH, "Multiple Windows"));
    private final By CLICK_HERE_BUTTON = By.linkText("Click Here");
    private final By PAGE_CONTENT = By.xpath("//div[@id='flash-messages']");
    private final By TEXT = By.tagName("h3");


    @Test
    public void MultipleWindowTest() {
        driver.findElement(MULTIPLE_WINDOWS).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(driver -> driver.findElement(PAGE_CONTENT).isDisplayed());
        Assert.assertTrue(driver.findElement(PAGE_CONTENT).isDisplayed(), "Page Content is not displayed");

        driver.findElement(CLICK_HERE_BUTTON).click();
        String windowone = driver.getWindowHandle();

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(windowone)) {
                driver.switchTo().window(window);
                break;
            }
        }
        driver.findElement(TEXT).isDisplayed();
        driver.close();
        driver.switchTo().window(windowone);
        Assert.assertTrue(driver.findElement(TEXT).isDisplayed(), "Text is not displayed");
    }
}
