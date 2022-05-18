package pages;

import utils.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;


public class UserHomePage extends BasePage {

    /**
     * Constructor
     */
    public UserHomePage(WebDriver driver) {
        super(driver);
    }
    /**
     * Variables
     */
    String baseURL = "https://courses.letskodeit.com/";
    /**
     * Web Elements
     */
    By signInButtonClass = By.xpath("//*[@id=\"navbar-inverse-collapse\"]/div/div/a");
    By homePageHeader    = By.xpath("//*[@id=\"zen_all_courses_dynamic\"]/div[1]/h1");
    /**
     * Page Methods
     */
    //Go to Homepage
    public UserHomePage goToCubicsHomePage() {
        Log.info("Opening Cubics Website.");
        driver.get(baseURL);
        return this;
    }
    //Go to LoginPage
    public LoginPage goToLoginPage() {
        Log.info("Going to Login Page.");
        click(signInButtonClass);
        return new LoginPage(driver);
    }

    //Verify Home Page
    public UserHomePage verifyHomePage(String expectedText) {
        Log.info("Verifying home page.");
        waitVisibility(homePageHeader);
        assertEquals(readText(homePageHeader), expectedText);
        return this;
    }
}
