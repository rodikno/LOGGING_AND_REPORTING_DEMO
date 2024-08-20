import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.objects.TheInternetMainPage;

public class TheInternetDemoTest {

    ChromeDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void hoversTest() throws InterruptedException {

        //Opening the page
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.manage().window().fullscreen();

        TheInternetMainPage page = new TheInternetMainPage(driver);
        page.getTextInput().sendKeys("Hello");
        page.submitForm();
    }




    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
