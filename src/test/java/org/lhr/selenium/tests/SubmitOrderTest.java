package org.lhr.selenium.tests;

import org.lhr.selenium.base.BaseTest;
import org.lhr.selenium.pageObjects.LandingPage;
import org.lhr.selenium.pageObjects.ManagerOfficerPage;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SubmitOrderTest extends BaseTest {
    private ManagerOfficerPage managerOfficerPage;

    @BeforeClass
    public void setup() throws IOException {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        managerOfficerPage =new ManagerOfficerPage(driver);
        landingPage.goTo();
    }

    @Test
    public void submitOrder() throws InterruptedException {
        landingPage.loginApplication("MarryIND", "Test@123");
        Thread.sleep(3000);
        managerOfficerPage.navigateToManageOfficers();
        managerOfficerPage.clickmanageofficer();
        managerOfficerPage.clickAddOfficer();
        managerOfficerPage.enterOfficerDetails(
                "Marrymodh","modhpat","Marrymodh@yopmail.com","9878976544","145",
                "userMarrymodh1","Test@123","Test@123","9528 25 Hwy Halton Hills",
                "201 James St N ","Hamilton","Ontario","Canada","L8R 2L2");
        managerOfficerPage.submitOfficerForm();
        System.out.println("New officer added successfully.");
        Thread.sleep(3000);
        managerOfficerPage.resetofficerpassword("Test@123","Test@123");
        managerOfficerPage.newpassowrdsubmit();
        System.out.println("New password Changes");
    }

    @AfterClass
    public void tearDown() {
     driver.quit();
    }

}