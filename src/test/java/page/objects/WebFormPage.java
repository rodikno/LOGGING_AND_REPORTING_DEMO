package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.TestNGException;

public class WebFormPage {

    WebDriver driver;

    public WebFormPage(WebDriver driver) {
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

    public String submitFormAndReturnFinalMessage() {
        submitForm();
        WebElement submitionResultHeaderElement = driver.findElement(By.xpath("//h1[normalize-space()='Form submitted']"));

        if (submitionResultHeaderElement.isDisplayed()) {
            return submitionResultHeaderElement.getText();
        } else {
            throw new ElementNotInteractableException("Page header is not displayed on the form results page");
        }
    }

}
