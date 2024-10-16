package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.PracticePage;
import utils.BaseTestClass;
import utils.CommonMethods;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class FrameTest extends BaseTestClass {
    private static String url = null;
    PracticePage practicePage;

    public FrameTest() {
        url = CommonMethods.readPropertiesFile("URL");
        practicePage = new PracticePage(driver);
    }

    @When("Switch to new frame")
    public void switchToFrame() {
        driver.switchTo().frame((driver.findElement(By.id("courses-iframe"))));
    }

    @And("Scroll to the bottom of the page and verify the Text {string}")
    public void scrollToTheBottomOfThePageAndVerifyTheText(String arg0) {
        js.executeScript("window.scroll(0,document.body.scrollHeight)");
        driver.findElement(By.cssSelector(".subscribe-style-one >div")).getText();

    }

    @And("Switch back to main content")
    public void switchBackToMainContent() {
        driver.switchTo().defaultContent();
    }


    @When("MouseHover on MouseHover bottom")
    public void mousehoverOnMouseHoverBottom() {
        WebElement element = driver.findElement(By.id("mousehover"));
        scrollToElement(element);

        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    @And("click on {string}")
    public void clickOn(String arg0) throws InterruptedException {
        Thread.sleep(4000);
        driver.findElements(By.cssSelector((".mouse-hover-content>a"))).stream().filter(e -> e.getText().equals(arg0)).findFirst().get().click();
    }

    private void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @When("pick one element and drag and drop in another box")
    public void pickElementAndDragAndDropInAnotherBox() {
        Actions actions = new Actions(driver);
        WebElement e1 = driver.findElement(By.id("box2"));
        WebElement e2 = driver.findElement(By.id("box101"));

        actions.dragAndDrop(e1, e2).perform();
        actions.contextClick(e1);
        actions.doubleClick(e1);
        actions.sendKeys(Keys.ALT,"S").sendKeys(Keys.ENTER);
    }

    @When("click on broswer and upload the file")
    public void clickOnBroswerAndUploadTheFile() {
        WebElement uploadBtn = driver.findElement(By.id("file-upload"));
        uploadBtn.sendKeys("C:\\Users\\rahul.chaudhary\\OneDrive - PowerSchool\\Pictures\\logo.png");
    }

    @And("click on Upload button")
    public void clickOnUploadButton() {
        driver.findElement(By.id("file-submit")).click();
    }

    @Then("verify the success message {string}")
    public void verifyTheSuccessMessage(String expectedtext) {
        String actualText = driver.findElement(By.cssSelector("#content h3")).getText();
        Assert.assertEquals(actualText, expectedtext);
    }

    @When("Hover On {string} then {string} and then click on {string}")
    public void hoverOnEnabledThenDownloadsAndThenClickOnPDF(String button1,String button2,String button3) throws InterruptedException {
        Actions actions= new Actions(driver);
        WebElement enbledBtn = driver.findElements(By.cssSelector("li[class='ui-menu-item']>a")).stream().filter(e -> e.getText().equals(button1)).findFirst().get();

        actions.moveToElement(enbledBtn).clickAndHold().perform();
        Thread.sleep(5000);
        //fluentWait.until(driver->driver.findElement(By.cssSelector("li[class='ui-menu-item']>a")).getText().equals(button2));
        WebElement downloadBtn = driver.findElements(By.cssSelector("li[class='ui-menu-item']>a")).stream().filter(e -> e.getText().equals(button2)).findFirst().get();
        actions.moveToElement(downloadBtn).perform();
        Thread.sleep(5000);
        WebElement pdfBtn = driver.findElements(By.cssSelector("li[class='ui-menu-item']>a")).stream().filter(e -> e.getText().equals(button3)).findFirst().get();
        actions.moveToElement(pdfBtn).click().perform();
    }

    @When("get the texts of shadow Dom")
    public void getTheTextsOfShadowDom() {
        WebElement shadowHost = driver.findElement(By.id("content"));

        WebElement shadowRoot= (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        shadowRoot.findElement(By.cssSelector("ul[slot='my-text']>li")).getText();
    }
}
