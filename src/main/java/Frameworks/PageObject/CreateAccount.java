package Frameworks.PageObject;

import Frameworks.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public CreateAccount(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public MyAccount createAccount(String fname , String lname , String email , String password){
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
    public void goTo(){
        driver.get("https://demo-m2.bird.eu/customer/account/create/");
    }
}
