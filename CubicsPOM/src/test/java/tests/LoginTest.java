package tests;

import org.testng.annotations.Test;
import java.lang.reflect.Method;
import static utils.extentreports.ExtentTestManager.startTest;

public class LoginTest extends BaseTest {

    @Test(priority = 0, description = "Valid Login Scenario with valid username and password.")
    public void SuccessLoginTest_ValidUsernameAndPassword(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "Valid Login Scenario with username and password.");
        userhomePage
                .goToCubicsHomePage()
                .verifyHomePage("All Courses")
                .goToLoginPage()
                .loginToCubics("gokcenveysel@gmail.com", "vycll1985")
                .verifySuccessLogin("You have not enrolled to any courses.");
    }
}
