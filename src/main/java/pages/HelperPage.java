package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HelperPage {
    protected WebDriver driver;
    @FindBy(css = "button[type='button']")
    private static WebElement Collapse;

    @FindBy(css = "ul[class='list-group rounded']>li")
    private static List<WebElement> ListElement;


    public static void clickCollapse() {
        Collapse.click();
    }

    public static void clickListElement(String element) {
        for (WebElement ele : ListElement) {
            if (ele.getText().equals(element)) {
                ele.click();
                break;
            }
        }
    }

    public void clickButton(WebElement element) {
        element.click();
    }
}
