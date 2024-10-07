package Frameworks.PageObject;

import Frameworks.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangePassword extends AbstractComponent {
    private WebDriver driver;
    public ChangePassword(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @FindBy(css="input[name='current_password']")
    WebElement currentPasswordElement;

    @FindBy(css="input[name='password'][data-input='new-password']")
    WebElement newPasswordElement;

    @FindBy(css="input[name='password_confirmation']")
    WebElement confirmPasswordElement;

    @FindBy(css="button[title='Save']")
    WebElement saveChangesBtnElement;

    @FindBy(css = "[name='login[username]']")
    WebElement emailField;

    @FindBy(css = "[name='login[password]']")
    WebElement passwordField;

    @FindBy(xpath = "(//button[@id='send2'])[2]")
    WebElement signInBtnElement;

    public void changePassword(String currentPassword, String newPassword) {
        currentPasswordElement.sendKeys(currentPassword);
        newPasswordElement.sendKeys(newPassword);
        confirmPasswordElement.sendKeys(newPassword);
        saveChangesBtnElement.click();
    }
    public void reSignIn(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInBtnElement.click();
    }
}
