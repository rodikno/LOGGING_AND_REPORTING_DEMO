import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.objects.WebFormPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class TheInternetDemoTest {

    ChromeDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    @Description("Enters a value into a text field and submits the form, verifies that the form was submitted successfully")
    @Severity(CRITICAL)
    @Owner("Rodion Baronov")
    @Link(name = "Website", url = "https://www.selenium.dev/selenium/web/web-form.html")
    @Issue("TI-123")
    public void webFormTest() throws InterruptedException {

        //Opening the page
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.manage().window().fullscreen();

        WebFormPage page = new WebFormPage(driver);
        page.getTextInput().sendKeys("Hello");
        String submitionResult = page.submitFormAndReturnFinalMessage();

        Assert.assertTrue(submitionResult.contains("Form submitted"));
    }




    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
