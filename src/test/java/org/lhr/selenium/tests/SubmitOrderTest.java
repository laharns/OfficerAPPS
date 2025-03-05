package org.lhr.selenium.tests;

import org.lhr.selenium.base.BaseTest;
import org.lhr.selenium.pageObjects.LandingPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SubmitOrderTest extends BaseTest {
    @BeforeClass
    public void setup() throws IOException {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
    }

    @Test
    public void submitOrder() {
        landingPage.loginApplication("MarryIND", "Test@123");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}