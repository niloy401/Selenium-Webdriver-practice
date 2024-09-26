package tests;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileDownloadTest extends BaseTest {
    private final By FILE_DOWNLOAD = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Download"));
    private final String FILE_NAME = "some-file.txt";
    private final By FILE_NAME_XPATH = By.xpath(String.format(PRECISE_TEXT_XPATH, FILE_NAME));
    private  final String relativePath = RELATIVE_RESOURCE_PATH;
    private  final File downloadedFile = new File(relativePath);
    //File file = new File(relativePath);
    //String absolutePath = file.getAbsolutePath();

    @Test
    public void filedownloadTest() {
        driver.findElement(FILE_DOWNLOAD).click();
        Assert.assertTrue(driver.findElement(FILE_NAME_XPATH).isDisplayed(), "File is not displayed");
        driver.findElement(FILE_NAME_XPATH).click();
        Assert.assertTrue(isFileExists(downloadedFile), "The File is not downloaded");
    }

    private boolean isFileExists(File file){
        try{
            Awaitility.await().atMost(MAX_WAIT, TimeUnit.SECONDS).until(file::exists);
        }
        catch(ConditionTimeoutException exception) {
            return false;
        }
        return true;
    }
    @AfterMethod
    public void deleteFile(){
        if (downloadedFile.exists()){
            downloadedFile.delete();
        }
    }
}