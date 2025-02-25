package org.lhr.selenium.pageObjects;

import org.lhr.selenium.AbstractComponents.AbstractComponent;
import org.lhr.selenium.utils.PropertyFileReader;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LandingPage extends AbstractComponent {
    private WebDriver driver;
    private PropertyFileReader propertyFileReader;

    public LandingPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        this.propertyFileReader = new PropertyFileReader(System.getProperty("user.dir") + "/src/main/java/org/lhr/selenium/utils/Xpath.properties");
    }

    public void loginApplication(String email, String password) {
        enterText(propertyFileReader.getLocator("user_email_selector"), email);
        enterText(propertyFileReader.getLocator("user_password_selector"), password);
        clickElement(propertyFileReader.getLocator("login_button_selector"));
    }
    public String getErrorMessage() {
        waitForElementVisible(propertyFileReader.getLocator("error_message_selector"), 5);
        return driver.findElement(propertyFileReader.getLocator("error_message_selector")).getText();
    }

    public void goTo() {
        driver.get("https://staging.officerapps.net/login");
    }
}
