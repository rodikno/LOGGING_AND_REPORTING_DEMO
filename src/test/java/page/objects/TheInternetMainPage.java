package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TheInternetMainPage {

    WebDriver driver;

    public TheInternetMainPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getTextInput() {
        //Locating elements
        return driver.findElement(By.name("my-text"));
    }

    public WebElement submitForm() {
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        submitButton.click();
        return submitButton;
    }

}
