package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage {

    @FindBy(id="fullname")
    private static WebElement FirstName;

    @FindBy(id="email")
    private static WebElement Email;

    @FindBy(css="textarea[id='address']")
    private static WebElement CurrentAddress;

    @FindBy(id="password")
    private static WebElement password;

    @FindBy(css="input[type='submit']")
    private static WebElement submitButton;

    public static void enterFullName(String name) {
        FirstName.sendKeys(name);
    }
    public static void enterEmail(String email) {
        Email.sendKeys(email);
    }
    public static void enterCurrentAddress(String address) {
        CurrentAddress.sendKeys(address);
    }
    public static void enterPassword(String pass) {
        password.sendKeys(pass);
    }
    public static void clickSubmitButton() {
        submitButton.click();
    }

}
