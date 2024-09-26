package tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {
    private final By JS_ALERT = By.xpath(String.format(PRECISE_TEXT_XPATH, "JavaScript Alerts"));
    private final By CLICK_FOR_JS_ALERT_BUTTON = By.xpath("//button[@onclick='jsAlert()']");
    private final By SUCCESS_MSSG_LOCATOR = By.xpath("//p[@id='result']");

    @Test
    public void alertTest() {
        driver.findElement(JS_ALERT).click();
        driver.findElement(CLICK_FOR_JS_ALERT_BUTTON).click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(SUCCESS_MSSG_LOCATOR).isDisplayed(), "Success Message is not displayed");
    }

}
