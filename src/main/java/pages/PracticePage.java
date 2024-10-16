package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class PracticePage extends HelperPage {
    @FindBy(id = "dropdown-class-example")
    private static WebElement Select;

    @FindBy(css = "#checkbox-example input")
    private static List<WebElement> checkbox;

    @FindBy(css = "#radio-btn-example input")
    private static List<WebElement> radioButton;

    @FindBy(id = "opentab")
    private static WebElement newTab;

    @FindBy(id = "openwindow")
    private static WebElement newWindow;

    @FindBy(id = "alertbtn")
    private static WebElement alertButton;

    @FindBy(id = "confirmbtn")
    private static WebElement confirmbtn;

    public PracticePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectDropdown(String option) {
        Select select = new Select(Select);
        List<WebElement> options = select.getOptions();
        for (WebElement opt : options) {
            if (opt.getText().equals(option)) {
                opt.click();
            }
        }

    }

    public void setCheckbox(String option) {

        for (int i = 0; i < checkbox.size(); i++) {
            if (checkbox.get(i).getAttribute("value").equalsIgnoreCase(option)) {
                checkbox.get(i).click();
            }

        }
    }

    public boolean isChecked(String option) {
        boolean value = false;
        for (int i = 0; i < checkbox.size(); i++) {
            if (checkbox.get(i).getAttribute("value").equalsIgnoreCase(option)) {
                value = checkbox.get(i).isSelected();
            }

        }
        return value;
    }

    public void selectRadioButton(String option) {
        radioButton.stream().filter(e -> e.getAttribute("value").equalsIgnoreCase(option)).findFirst().get().click();
    }

    public void clickOnNewTab() {
        newTab.click();
    }

    public void clickOnNewWindow() {
        newWindow.click();
    }

    public void switchWindow(String title) {
        Set<String> window = driver.getWindowHandles();
        for (String wdw : window) {
            driver.switchTo().window(wdw);
            if (driver.getTitle().contains(title)) {

            }
        }
    }

    public void clickOnAlertButton(String alert) throws InterruptedException {

        if(alert.equals("alert")) {
            alertButton.click();
        }
        if(alert.equals("Confirm")) {
            confirmbtn.click();
        }

    }

}
