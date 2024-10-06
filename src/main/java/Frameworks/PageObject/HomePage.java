package Frameworks.PageObject;

import Frameworks.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends AbstractComponent {
    WebDriver driver;
    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    @FindBy(id="ui-id-13")
    WebElement menNavBar;

    @FindBy(id="ui-id-14")
    WebElement topMenList;

    @FindBy(css="div[class*='minicart-wrapper']")
    WebElement cartLink;

    @FindBy(css="ol.minicart-items .product-item")
    List<WebElement> cartProductsElements;

    @FindBy(id="top-cart-btn-checkout")
    WebElement proceedToCheckOutElement;

    @FindBy(xpath="(//li/a[contains(@href,'create')])[1]")
    WebElement createAccountBtnElement;

    @FindBy(xpath="(//li/a[contains(@href,'login')])[1]")
    WebElement signInBtnElement;

    @FindBy(css="div[class='panel header'] button[type='button']")
    WebElement dropDownElement;

    @FindBy(xpath = "(//a[contains(.,'My Account')])[1]")
    WebElement myAccountElement;

    public void goToStartPoint(){
        driver.get("https://demo-m2.bird.eu");
    }
    public void createAccountClick(){
        createAccountBtnElement.click();
    }
    public void goToHomePage(){
        menNavBar.click();
        exWait.until(ExpectedConditions.visibilityOf(topMenList)).click();
    }
    public void signInClick(){
        signInBtnElement.click();
    }
    public CheckOut_Shipping goToCheckOut(){
        cartLink.click();
        proceedToCheckOutElement.click();
        CheckOut_Shipping checkOutShipping = new CheckOut_Shipping(driver);
        return checkOutShipping;
    }
    public boolean validateCartContent(String productName){
        cartLink.click();
        exWait.until(ExpectedConditions.visibilityOf(proceedToCheckOutElement));
        boolean flag = cartProductsElements.stream().anyMatch(s -> s.getText().contains(productName));
        cartLink.click();
        return flag;
    }
    public void goToMyAccount(){
        dropDownElement.click();
        myAccountElement.click();
    }

}
