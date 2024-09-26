package tests;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicLoadingTest extends BaseTest {
    private final By DYNAMIC_LOADING = By.xpath(String.format(PRECISE_TEXT_XPATH, "Dynamic Loading"));
    private final By EXAMPLE_1 = By.linkText("Example 1: Element on page that is hidden");
    private final By START_BUTTON = By.xpath("//button[contains(text(), 'Start')]");
    private  final By LOADING_BAR = By.xpath("//div[@id='loading']");
    private final By HELLO_WORLD_TEXT = By.xpath("//h4[contains(text(), 'Hello World!')]");

@Test
    public void dynamicLoadingTest() {
    driver.findElement(DYNAMIC_LOADING).click();
    driver.findElement(EXAMPLE_1).click();
    driver.findElement(START_BUTTON).click();
    driver.findElement(LOADING_BAR).getAttribute("style").contains("display: none;");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
     wait.until(driver -> driver.findElement(HELLO_WORLD_TEXT).isDisplayed());

    Assert.assertTrue(driver.findElement(HELLO_WORLD_TEXT).isDisplayed(), "Hello World text is not displayed");
    }
}
