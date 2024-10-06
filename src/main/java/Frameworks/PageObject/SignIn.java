package Frameworks.PageObject;

import Frameworks.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignIn extends AbstractComponent {
    private WebDriver driver;
    public SignIn(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @FindBy(id="email")
    WebElement emailElement;
    @FindBy(id="password")
    WebElement passwordElement;
    @FindBy(xpath = "(//button[@id='send2'])[2]")
    WebElement SignInBtnElement;

    @FindBy(id = "email-error")
    WebElement emailErrorElement;
    @FindBy(css = ".message-error")
    WebElement passwordErrorElement;

    @FindBy(css=".message-success.success.message")
    WebElement changePasswordSuccessMessageElement;

    public void signIn(String email, String password) {
        exWait.until(ExpectedConditions.visibilityOf(emailElement));
        emailElement.clear();
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        SignInBtnElement.click();
    }
    public boolean InvalidEmailErrorMessage(){
        exWait.until(ExpectedConditions.visibilityOf(emailErrorElement));
        return emailErrorElement.isDisplayed();
    }
    public boolean InvalidPasswordErrorMessage(){
        exWait.until(ExpectedConditions.visibilityOf(passwordErrorElement));
        return passwordErrorElement.isDisplayed();
    }
    public boolean ChangePasswordSuccessMessage(){
        exWait.until(ExpectedConditions.visibilityOf(changePasswordSuccessMessageElement));
        return changePasswordSuccessMessageElement.isDisplayed();
    }

}
