package Frameworks.PageObject;

import Frameworks.AbstractComponent.AbstractComponent;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccount extends AbstractComponent {
    private WebDriver driver;
    @FindBy(id="firstname")
    WebElement firstName;
    @FindBy(id="lastname")
    WebElement lastName;
    @FindBy(id="email_address")
    WebElement emailAddress;
    @FindBy(id="password")
    WebElement  passwordField;
    @FindBy(id="password-confirmation")
    WebElement confirmPassword;
    @FindBy(css="input[name='show-password']")
    WebElement showPasswordChkBox;
    @FindBy(xpath="//div/button[contains(@class,'submit')]")
    WebElement createAccountBtn;
    @FindBy(id="email_address-error")
    WebElement emailErrorElement;

    public CreateAccount(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public MyAccount createAccount(String fname , String lname , String email , String password){
        exWait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        emailAddress.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPassword.sendKeys(password);
        showPasswordChkBox.click();
        createAccountBtn.click();
        MyAccount myAccount = new MyAccount(driver);
        return myAccount;
    }

    public Boolean validateErrorMessage(){
        return emailErrorElement.isDisplayed();
    }
}
