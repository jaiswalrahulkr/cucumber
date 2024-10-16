package stepdefinition;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HelperPage;
import pages.TextBoxPage;
import utils.CommonMethods;
import utils.DriverSetup;
import utils.ExtentManager;

import java.time.Duration;

public class TextBox {
    WebDriver driver = DriverSetup.getDriver();
    String URL;
    ExtentTest test;


    public TextBox() {
        PageFactory.initElements(driver, TextBoxPage.class);
        PageFactory.initElements(driver, HelperPage.class);

        URL = CommonMethods.readPropertiesFile("URL");
    }


    @Given("I open the Browser and navigate to the URL")
    public void openTheBrowserAndNavigateTOURL() {
        test = ExtentManager.createTest("User navigates to TextBox Page");
        driver.get(URL);
        test.pass("User is on the TextBox page.");

    }

    @When("I click on TextBox Link")
    public void ClickOnTextBoxLink() throws InterruptedException {
        HelperPage.clickCollapse();
        Thread.sleep(5000);
        HelperPage.clickListElement("Text Box");
        git
        test.pass("Clicked on TextBox Link.");
    }

    @And("I enter {string} and {string} in the TextBox from the below")
    public void iEnterAndInTheTextBoxFromTheBelow(String field, String value) {
        switch (field) {

            case "Full Name":
                TextBoxPage.enterFullName(value);
                break;
            case "Email":
                TextBoxPage.enterEmail(value);
                break;
            case "Current Address":
                TextBoxPage.enterCurrentAddress(value);
                break;
            case "Password":
                TextBoxPage.enterPassword(value);
                break;
            default:
                System.out.println("Invalid Field");
        }
        test.pass("Entered the texts.");
    }

    @Then("click on Submit Button")
    public void clickOnSubmitButton() {
        TextBoxPage.clickSubmitButton();
        test.pass("Clicked on Submit Button.");
    }



}
