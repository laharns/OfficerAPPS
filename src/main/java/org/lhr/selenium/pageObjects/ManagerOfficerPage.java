package org.lhr.selenium.pageObjects;

import org.lhr.selenium.AbstractComponents.AbstractComponent;
import org.lhr.selenium.utils.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class ManagerOfficerPage extends AbstractComponent {
    private WebDriver driver;
    private PropertyFileReader propertyFileReader;

    public ManagerOfficerPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        this.propertyFileReader = new PropertyFileReader(System.getProperty("user.dir") + "/src/main/java/org/lhr/selenium/utils/Xpath.properties");
    }
    public void navigateToManageOfficers() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ngx-overlay")));
        wait.until(ExpectedConditions.elementToBeClickable(propertyFileReader.getLocator("officer_menu")));
        clickElement(propertyFileReader.getLocator("officer_menu"));
    }
    public  void clickmanageofficer(){
        clickElement(propertyFileReader.getLocator("manage_officer"));
    }
    public void clickAddOfficer(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ngx-overlay")));
        wait.until(ExpectedConditions.elementToBeClickable(propertyFileReader.getLocator("add_officer")));
        clickElement(propertyFileReader.getLocator("add_officer"));

    }
    public void enterOfficerDetails(String firstname, String lastname,String email,String phone,String employeeNumber, String userName, String password, String confirmPassword, String address1, String address2 ,String city, String state,String country, String postalCode, String branch, boolean hasCustomerPortalAccess, boolean isSupervisor){
        enterText(propertyFileReader.getLocator("officer_firstname"),firstname);
        enterText(propertyFileReader.getLocator("officer_lastname"),lastname);
        enterText(propertyFileReader.getLocator("officer_email"),email);
        enterText(propertyFileReader.getLocator("officer_phonenumber"),phone);
        enterText(propertyFileReader.getLocator("offiecer_employeeNumber"),employeeNumber);
        enterText(propertyFileReader.getLocator("officer_userName"),userName);
        enterText(propertyFileReader.getLocator("officer_password"),password);
        enterText(propertyFileReader.getLocator("officer_confirmPassword"),confirmPassword);
        enterText(propertyFileReader.getLocator("officer_address1"),address1);
        enterText(propertyFileReader.getLocator("officer_address2"),address2);
        enterText(propertyFileReader.getLocator("officer_city"),city);
        enterText(propertyFileReader.getLocator("officer_state"),state);
        WebElement countryDropdown = driver.findElement(propertyFileReader.getLocator("officer_country"));
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
        enterText(propertyFileReader.getLocator("officer_postalcode"), postalCode);
        WebElement branchField = driver.findElement(propertyFileReader.getLocator("officer_branch"));
        branchField.clear();
        branchField.sendKeys(branch);

        if (hasCustomerPortalAccess) {
            clickElement(propertyFileReader.getLocator("officer_applycheckbox"));
        }

        if (isSupervisor) {
            clickElement(propertyFileReader.getLocator("officer_supervisor"));
        }
    }
    public void uploadPhoto(){
        clickElement(propertyFileReader.getLocator("officer_upload_photo"));
    }
    public void submitOfficerForm(){
        clickElement(propertyFileReader.getLocator("officer_submit"));
    }

    public void cancelOfficerForm(){
        clickElement(propertyFileReader.getLocator("officer_cancel"));
    }
}
