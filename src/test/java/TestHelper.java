import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestHelper {

    public static Path takeScreenshot(WebDriver driver, String screenshotName) {
        try {
            File screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            // specify the path where screenshots will be saved
            // make sure the path already exists, if not - create the directory
            Path destination = Paths.get(".screenshots", screenshotName);
            
            //Copy the File object to the desired location for reporting
            Files.copy(screenshot.toPath(), destination);
            
            return destination;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot", e);
        }
    }
}