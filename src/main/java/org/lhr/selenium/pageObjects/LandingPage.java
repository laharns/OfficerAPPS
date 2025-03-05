package org.lhr.selenium.pageObjects;

import org.lhr.selenium.AbstractComponents.AbstractComponent;
import org.lhr.selenium.utils.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LandingPage extends AbstractComponent {
    private  WebDriver driver;
    private WebDriverWait wait;
    private  PropertyFileReader propertyFileReader;

    public LandingPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize explicit wait
        this.propertyFileReader = new PropertyFileReader(System.getProperty("user.dir") + "/src/main/java/org/lhr/selenium/utils/Xpath.properties");
    }

    public void loginApplication(String user, String password) {
        enterText(propertyFileReader.getLocator("user_email_selector"), user);
        enterText(propertyFileReader.getLocator("user_password_selector"), password);
        clickElement(propertyFileReader.getLocator("login_button_selector"));
    }
    public String getErrorMessage() {
        waitForElementVisible(propertyFileReader.getLocator("error_message_selector"), 5);
        return driver.findElement(propertyFileReader.getLocator("error_message_selector")).getText();
    }
    public String clickForgotPassword()  {
        By forgotPasswordLink = propertyFileReader.getLocator("forgot_password");
        By forgotTextLocator = propertyFileReader.getLocator("forgot_text");

        clickElement(forgotPasswordLink);
        WebElement forgotTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(forgotTextLocator));
        return forgotTextElement.getText(); // Returns the displayed forgot password text
        // Thread.sleep(5000);
    }

    public void goTo() {
        driver.get("https://staging.officerapps.net/login");
    }
}