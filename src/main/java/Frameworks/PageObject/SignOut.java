package Frameworks.PageObject;

import Frameworks.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignOut extends AbstractComponent {
    WebDriver driver;
    public SignOut (WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @FindBy(css="div[class='panel header'] button[type='button']")
    WebElement dropDownElement;

    @FindBy(xpath="(//a[contains(text(),'Sign Out')])[1]")
    WebElement logOutElement;

    public void signOut() {
        exWait.until(ExpectedConditions.elementToBeClickable(dropDownElement));
        dropDownElement.click();
        logOutElement.click();
    }

}
