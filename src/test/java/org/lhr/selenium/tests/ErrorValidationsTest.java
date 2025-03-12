package org.lhr.selenium.tests;

import org.lhr.selenium.base.BaseTest;
import org.lhr.selenium.pageObjects.ForgotPage;
import org.lhr.selenium.pageObjects.LandingPage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidationsTest extends BaseTest {

    private ForgotPage forgotPage;

    @BeforeClass
    public void setup() throws IOException {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        forgotPage = new ForgotPage(driver);
        landingPage.goTo();
    }
    @Test
    public void LoginErrorValidation() {
        landingPage.loginApplication("MarryIND", "Test@12345");
        Assert.assertEquals( "You have entered an incorrect password...",landingPage.getErrorMessage());
    }

    @Test
    public void forgotPageTest() {
        landingPage.clickForgotPassword();

        forgotPage.enterUserForReset("test");
        forgotPage.submitForgotPassword();
        Assert.assertEquals("User Does Not Exist..",forgotPage.getForgotErrorMessage());
        forgotPage.clickHomeButton();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}