package org.lhr.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.lhr.selenium.pageObjects.ForgotPage;
import org.lhr.selenium.pageObjects.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected LandingPage landingPage;
    protected static WebDriver driver;
    protected ForgotPage fogotpage;

    public static WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\org\\lhr\\selenium\\utils\\GlobleData.properties");
        prop.load(fis);

        String browserName = System.getProperty("browser", prop.getProperty("browser"));

        if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("chrome-headless")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if (browserName.contains("headless")) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }


}