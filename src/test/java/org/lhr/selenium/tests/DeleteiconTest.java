package org.lhr.selenium.tests;

import org.lhr.selenium.base.BaseTest;
import org.lhr.selenium.pageObjects.LandingPage;
import org.lhr.selenium.pageObjects.ManagerOfficerPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteiconTest extends BaseTest {
    private ManagerOfficerPage managerOfficerPage;

    @BeforeClass
    public void setup() throws IOException {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        managerOfficerPage =new ManagerOfficerPage(driver);
        landingPage.goTo();
    }

    @Test
    public void deleteOfficerDetails() throws InterruptedException {
        landingPage.loginApplication("MarryIND", "Test@123");
        Thread.sleep(3000);
        managerOfficerPage.navigateToManageOfficers();
        managerOfficerPage.clickmanageofficer();
        Thread.sleep(3000);
        managerOfficerPage.deleteofficerForm(false);
    }

}
