package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.logs.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.UserHomePage;

public class BaseTest {
    public WebDriver driver;
    public UserHomePage  userhomePage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        Log.info("Tests is starting!");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @BeforeMethod
    public void methodLevelSetup() {

        userhomePage = new UserHomePage(driver);
    }

    @AfterClass
    public void teardown() {
        Log.info("Tests are ending!");
        driver.quit();
    }
}
