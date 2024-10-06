package Frameworks.PageObject;

import Frameworks.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MyAccount extends AbstractComponent {
    private WebDriver driver;
    public MyAccount(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".message-success")
    WebElement successMessage;

    @FindBy(className = "base")
    WebElement myAccountElement;

    @FindBy(css=".action.change-password")
    WebElement changePasswordElement;

    public boolean validateSuccessMessage(){
        exWait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();
    }
    public boolean validateSignInSuccess(){
        exWait.until(ExpectedConditions.visibilityOf(myAccountElement));
        return myAccountElement.isDisplayed();
    }
    public boolean validateSignOutSuccess(){
        exWait.until(ExpectedConditions.visibilityOf(myAccountElement));
        return myAccountElement.isDisplayed();
    }

    public void changePasswordClick(){
        exWait.until(ExpectedConditions.visibilityOf(changePasswordElement)).click();
    }
}
