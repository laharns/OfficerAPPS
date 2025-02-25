package org.lhr.selenium.AbstractComponents;

import org.lhr.selenium.utils.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class AbstractComponent {
    protected WebDriver driver;
    private PropertyFileReader propertyFileReader;

    public AbstractComponent(WebDriver driver) throws IOException {
        this.driver = driver;
        this.propertyFileReader = new PropertyFileReader(System.getProperty("user.dir") + "/src/main/java/org/lhr/selenium/utils/Xpath.properties");
    }
    public void waitForElementVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }
}
