package org.lhr.selenium.tests;

import org.lhr.selenium.base.BaseTest;
import org.lhr.selenium.pageObjects.LandingPage;
import org.lhr.selenium.pageObjects.ManagerOfficerPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CancelbuttonTest extends BaseTest {
    private ManagerOfficerPage managerOfficerPage;

    @BeforeClass
    public void setup() throws IOException {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        managerOfficerPage =new ManagerOfficerPage(driver);
        landingPage.goTo();
    }
    @Test
    public void cancelOfficerCreation() throws InterruptedException {
        landingPage.loginApplication("MarryIND", "Test@123");
        Thread.sleep(2000);
        managerOfficerPage.navigateToManageOfficers();
        managerOfficerPage.clickAddOfficer();
        managerOfficerPage.enterOfficerDetails(
                "John", "Doe", "john.doe@yopmail.com", "9876543210", "123",
                "userjohn", "Test@123", "Test@123", "123 Main St",
                "Suite 101", "Toronto", "Ontario", "Canada", "M5A 1A1",
                "ABC", false, false);
        managerOfficerPage.uploadPhoto();
        managerOfficerPage.cancelOfficerForm();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
