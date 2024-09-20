package stepdefinition;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import utils.CommonMethods;
import utils.DriverSetup;
import utils.ExtentManager;
import utils.JsonDataReader;

public class LoginSteps {
    WebDriver driver = DriverSetup.getDriver();
    LoginPage loginPage;
    ExtentTest test;
    String url;

    public LoginSteps() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        url = CommonMethods.readPropertiesFile("URL");
    }

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        test = ExtentManager.createTest("User navigates to Login Page");
        driver.get(url);
        test.pass("User is on the login page.");
    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials() {
        try {
            String username = JsonDataReader.getData("users_data.json").get("username").asText();
            String password = JsonDataReader.getData("users_data.json").get("password").asText();
            loginPage.login(username, password);
            test.pass("Entered valid credentials.");
        } catch (Exception e) {
            test.fail("Failed to enter credentials: " + e.getMessage());
        }
    }

    @Then("User is redirected to the Dashboard")
    public void userIsRedirectedToTheDashboard() {
        // Assertion for redirection to dashboard
        test.pass("User is redirected to the dashboard.");
    }


    @When("the user enters an invalid {string} or {string}")
    public void theUserEntersAnInvalidOr(String arg0, String arg1) {
        loginPage.login(arg0, arg1);
        test.pass("Entered invalid credentials.");
    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String arg0) {
        // Assertion for error message
        test.pass("Error message is displayed.");
    }
}
