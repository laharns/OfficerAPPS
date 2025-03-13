package org.lhr.selenium.tests;

import org.lhr.selenium.base.BaseTest;
import org.lhr.selenium.pageObjects.LandingPage;
import org.lhr.selenium.pageObjects.ManagerOfficerPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditbuttonTest extends BaseTest {
    private ManagerOfficerPage managerOfficerPage;

    @BeforeClass
    public void setup() throws IOException {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        managerOfficerPage =new ManagerOfficerPage(driver);
        landingPage.goTo();
    }

    @Test
    public void editOfficerDetails() throws InterruptedException {
        landingPage.loginApplication("MarryIND", "Test@123");
        Thread.sleep(3000);
        managerOfficerPage.navigateToManageOfficers();
        managerOfficerPage.clickmanageofficer();
        Thread.sleep(3000);
        managerOfficerPage.editofficer();

        managerOfficerPage.editofficerapp(
                "mrryINDupdate","modhupdate","mrryIND@yopmail.com","9878976545","145","9528 25 Hwy Halton Hills",
                "201 James St N ","Hamilton","Ontario","Canada","L8R 2L2");
        managerOfficerPage.submitOfficerForm();
        System.out.println("Update officer added successfully.");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

