package pages;

import utils.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginPage extends BasePage {
    /**
     * Constructor
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    /**
     * Web Elements
     */
    By userNameId                = By.id("email");
    By passwordId                = By.id("password");
    By loginButtonId             = By.xpath("//*[@id=\"page\"]/div[2]/div/div/div/div/form/div[4]/div[1]/input");
    By successMessageFromPage    = By.xpath("//*[@id=\"course-list\"]/div");
    By forgotPasswordButton      = By.xpath("//*[@id=\"page\"]/div[2]/div/div/div/div/form/div[4]/div[2]/a");
    /**
     * Page Methods
     */
    public LoginPage loginToCubics(String username, String password) {
        Log.info("Trying to login the Cubics.");
        writeText(userNameId, username);
        writeText(passwordId, password);
        click(loginButtonId);
        return this;
    }

    //Verify Success Login
    public LoginPage verifySuccessLogin(String expectedText) {
        Log.info("Verifying login for home page.");
        waitVisibility(successMessageFromPage);
        assertEquals(readText(successMessageFromPage), expectedText);
        return this;
    }

    //Verify HTML5 required field for Login Page
    private boolean isAttribtuePresent(String attribute) {
        Boolean result = false;
        try {
            String value = waitVisibility(userNameId).getAttribute(attribute);
            if (value != null){
                result = true;
            }
        } catch (Exception e) {}
        return result;
    }
}
