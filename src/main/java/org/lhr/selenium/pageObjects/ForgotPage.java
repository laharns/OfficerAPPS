package org.lhr.selenium.pageObjects;

import org.lhr.selenium.AbstractComponents.AbstractComponent;
import org.lhr.selenium.utils.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class ForgotPage extends AbstractComponent {
    private WebDriver driver;
    private PropertyFileReader propertyFileReader;

    public ForgotPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        this.propertyFileReader = new PropertyFileReader(System.getProperty("user.dir") + "/src/main/java/org/lhr/selenium/utils/Xpath.properties");
    }

    public void enterUserForReset(String user) {

        enterText(propertyFileReader.getLocator("user_forgot_passowrd"), user);
    }

    public void submitForgotPassword() {
        clickElement(propertyFileReader.getLocator("forgot_submit"));
    }

    public String getForgotErrorMessage() {
        waitForElementVisible(propertyFileReader.getLocator("forgot_error"), 5);
        return driver.findElement(propertyFileReader.getLocator("forgot_error")).getText();
    }
    public void clickHomeButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(propertyFileReader.getLocator("home")));
        clickElement(propertyFileReader.getLocator("home"));
    }

}