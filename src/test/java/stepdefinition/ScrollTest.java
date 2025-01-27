package stepdefinition;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import pages.PracticePage;
import utils.BaseTestClass;
import utils.CommonMethods;
import utils.ExtentManager;

public class ScrollTest extends BaseTestClass {
    private static String url = null;
    ExtentTest test;
    PracticePage page;

    public ScrollTest() {
        url = CommonMethods.readPropertiesFile("URL");
        if (driver != null) {
            page = new PracticePage(driver);
        } else {
            throw new IllegalStateException("Driver is not initialized");
        }
    }

    @When("click on Home Button")
    public void clickHomeButton() {
        if (driver != null) {
            test = ExtentManager.createTest("User clicks on Home Button");
            driver.findElements(By.cssSelector("button[class='btn btn-primary']")).stream().filter(e -> e.getText().equals("Home")).findFirst().get().click();
            test.pass("User clicked on Home Button.");
        } else {
            throw new IllegalStateException("Driver is not initialized");
        }
    }

    @And("Navigate to Home page")
    public void navigateToHomePage() {
        if (driver != null) {
            test = ExtentManager.createTest("User navigates to Home Page");
            Assert.assertTrue(driver.getTitle().contains("Selenium, API Testing"), "User is not on Home page");
            test.pass("User is on Home page");
        } else {
            throw new IllegalStateException("Driver is not initialized");
        }
    }

    @Then("Scroll to the bottom of the page")
    public void scrollToTheBottomOfThePage() {
        if (driver != null) {
            test = ExtentManager.createTest("User scrolls to the bottom of the page");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(".subscribe-style-one >div")));
        } else {
            throw new IllegalStateException("Driver is not initialized");
        }
    }

    @When("select the option2 from dropdown")
    public void selectDropdown() {
        if (driver != null) {
            test = ExtentManager.createTest("Select Dropdown");
            page.selectDropdown("Option2");
        } else {
            throw new IllegalStateException("Driver is not initialized");
        }
    }

    @And("check Option{int} in checkbox")
    public void checkOptionInCheckbox(int arg0) {
        if (driver != null) {
            page.setCheckbox("Option" + arg0);
            if (page.isChecked("Option" + arg0)) {
                test.pass("checkbox is selected ");
            } else {
                test.fail("checkbox is not selected ");
            }
        } else {
            throw new IllegalStateException("Driver is not initialized");
        }
    }

    @Then("select Radio{int} from Radio list")
    public void selectRadioFromRadioList(int arg0) {
        if (driver != null) {
            test = ExtentManager.createTest("select Radio");
            page.selectRadioButton("Radio" + arg0);
            if (page.isChecked("Option" + arg0)) {
                test.pass("Radio is selected ");
            } else {
                test.fail("Radio is not selected ");
            }
        } else {
            throw new IllegalStateException("Driver is not initialized");
        }
    }

    @Then("Verify the Page {string}")
    public void verifyThePage(String expectedTitle) {
        if (driver != null) {
            Assert.assertEquals(driver.getTitle(), expectedTitle, "Title Doesn't matches");
        } else {
            throw new IllegalStateException("Driver is not initialized");
        }
    }

    @When("click on open Tab button")
    public void clickOnOpenTabButton() {
        if (driver != null) {
            page.clickOnNewTab();
        } else {
            throw new IllegalStateException("Driver is not initialized");
        }
    }

    @And("Switch to new Tab or Window")
    public void switchToNewTab() {
        if (driver != null) {
            page.switchWindow("QAClick Academy - A Testing Academy to Learn, Earn and Shine");
        } else {
            throw new IllegalStateException("Driver is not initialized");
        }
    }

    @When("click on open Window button")
    public void clickOnOpenWindowButton() {
        if (driver != null) {
            driver.switchTo().newWindow(WindowType.WINDOW);
            driver.get("https://www.qaclickacademy.com/");
        } else {
            throw new IllegalStateException("Driver is not initialized");
        }
    }

    @When("click on {string} button")
    public void clickOnButtonToAppearAlert(String alert) throws InterruptedException {
        if (driver != null) {
            page.clickOnAlertButton(alert);
        } else {
            throw new IllegalStateException("Driver is not initialized");
        }
    }

    @And("verify the alert message {string}")
    public void verifyTheAlertMessage(String arg0) throws InterruptedException {
        if (driver != null) {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            Assert.assertEquals(alertText, arg0, "Alert message not matches");
        } else {
            throw new IllegalStateException("Driver is not initialized");
        }
    }

    @Then("Click on  alert {string} button")
    public void clickOnAlertButton(String alertbutton) {
        if (driver != null) {
            Alert alert = driver.switchTo().alert();
            if (alertbutton.equals("OK"))
                alert.accept();
            if (alertbutton.equals("CANCEL"))
                alert.dismiss();
        } else {
            throw new IllegalStateException("Driver is not initialized");
        }
    }
}