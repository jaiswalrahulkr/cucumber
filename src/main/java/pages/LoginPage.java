package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
    @FindBy(id = "email")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = "input[type='submit']")
    WebElement loginButton;

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

    }
}
