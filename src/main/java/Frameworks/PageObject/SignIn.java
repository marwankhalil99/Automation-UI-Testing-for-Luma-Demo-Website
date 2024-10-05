package Frameworks.PageObject;

import Frameworks.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn extends AbstractComponent {
    WebDriver driver;
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

    public void signIn(String email, String password) {
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        SignInBtnElement.click();
    }
    public void goToLogin(){
        driver.get("https://demo-m2.bird.eu/customer/account/login");
    }
}
