package org.lhr.selenium.tests;

import org.lhr.selenium.base.BaseTest;
import org.lhr.selenium.pageObjects.LandingPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidationsTest extends BaseTest {

    @BeforeClass
    public void setup() throws IOException {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
    }
    @Test
    public void LoginErrorValidation() throws IOException {
        landingPage.loginApplication("MarryIND", "Test@12345");
        Assert.assertEquals( "You have entered an incorrect password...",landingPage.getErrorMessage());
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
