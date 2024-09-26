package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ShiftingContentTest extends BaseTest {

    @Test
    public void shiftingContentTest() {

        driver.get("http://the-internet.herokuapp.com/shifting_content");
        List<WebElement> menuElements = driver.findElements(By.cssSelector("ul li"));
        List<WebElement> imageElements = driver.findElements(By.cssSelector("img"));

        // Verify the presence of shifting content elements
        System.out.println("Number of menu elements: " + menuElements.size());
        System.out.println("Number of image elements: " + imageElements.size());

        // Print the text of menu elements
        for (WebElement menuElement : menuElements) {
            System.out.println(menuElement.getText());
        }

        // Print the src attribute of image elements
        for (WebElement imageElement : imageElements) {
            System.out.println(imageElement.getAttribute("src"));
        }
    }

}


