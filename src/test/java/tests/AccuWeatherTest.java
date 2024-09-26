package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AccuWeatherTest extends BaseTest{
    private final String KEY = "New York";
    private final By COOKIE_ACCEPT_BUTTON = By.xpath("//div[@class='banner-button policy-accept']");
    private final By SEARCH_BAR = By.xpath("//input[@name ='query']");
    private final By SEARCHED_LOCATION_LIST = By.xpath("//p[contains (@class, 'search-bar-result__name')]");
    private final By CITY_NAME_LOCATOR = By.xpath("//h1[@class = 'header-loc']");

    @Test
    public void testSearchForNewYorkWeather() {
        WebElement acceptButton = driver.findElement(COOKIE_ACCEPT_BUTTON);
        acceptButton.click();

        WebElement searchInput = driver.findElement(SEARCH_BAR);
        searchInput.sendKeys(KEY);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCHED_LOCATION_LIST));
        List<WebElement> elements = driver.findElements(SEARCHED_LOCATION_LIST);
        elements.get(0).click();
        Assert.assertFalse(elements.isEmpty(), "The list of Searched Locations is Not Displayed");

        String cityName = wait.until(ExpectedConditions.visibilityOfElementLocated(CITY_NAME_LOCATOR)).getText();
        Assert.assertTrue(cityName.contains(KEY), "The Weather Page does not contain City Name");
    }
}
