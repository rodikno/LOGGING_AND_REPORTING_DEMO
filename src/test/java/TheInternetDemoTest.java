import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.objects.WebFormPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class TheInternetDemoTest {

    // allure:serve
    ChromeDriver driver;

    @DataProvider
    public Object[][] formData() {
        return new Object[][]{
                {"12345"},
                {"Hello"},
                {"!@#$%^"}
        };
    }

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test(dataProvider = "formData")
    @Epic("Web Interface")
    @Feature("Essential Features")
    @Story("General Web Form")
    @Description("Enters a value into a text field and submits the form, verifies that the form was submitted successfully")
    @Severity(CRITICAL)
    @Owner("Rodion Baronov")
    @Link(name = "Website", url = "https://www.selenium.dev/selenium/web/web-form.html")
    @Issue("TI-123")
    public void webFormTest(String text) throws IOException {
        Allure.attachment("data.txt", "This is the file content");

        //Opening the page
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.manage().window().fullscreen();

        WebFormPage page = new WebFormPage(driver);
        page.getTextInput().sendKeys(text);

        //Take screenshot
        Path screenshotPath = TestHelper.takeScreenshot(driver, "screenshot_" + System.currentTimeMillis() + ".png");
        Allure.addAttachment("Screenshot", "image/png", Files.newInputStream(screenshotPath), ".png");

        String submitionResult = page.submitFormAndReturnFinalMessage();

        Assert.assertTrue(submitionResult.contains("Form submitted"));
    }

//    @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
//    public byte[] attachScreenshotPNG() throws IOException {
//        return Files.readAllBytes(Paths.get("/path/to/image.png"));
//    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
