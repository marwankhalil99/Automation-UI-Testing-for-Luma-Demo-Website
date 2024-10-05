package Frameworks.AbstractComponent;

import Frameworks.PageObject.CheckOut_Shipping;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractComponent {
    public WebDriver driver;
    public WebDriverWait exWait;
    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        exWait = new WebDriverWait(driver , Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="ui-id-13")
    WebElement menNavBar;

    @FindBy(id="ui-id-14")
    WebElement topMenList;

    @FindBy(css="div[class*='minicart-wrapper']")
    WebElement cartLink;

    @FindBy(css="ol[id='mini-cart'] li[class*='product-item']")
    List<WebElement> cartProductsElements;

    @FindBy(id="top-cart-btn-checkout")
    WebElement proceedToCheckOutElement;

    public void goToHomePage(){
        menNavBar.click();
        exWait.until(ExpectedConditions.visibilityOf(topMenList)).click();
    }
    public CheckOut_Shipping goToCheckOut(){
        cartLink.click();
        proceedToCheckOutElement.click();
        CheckOut_Shipping checkOutShipping = new CheckOut_Shipping(driver);
        return checkOutShipping;
    }
    public boolean validateCartContent(String productName){
        cartLink.click();
        exWait.until(ExpectedConditions.visibilityOf(cartProductsElements.getFirst()));
        boolean flag = cartProductsElements.stream().anyMatch(s -> s.getText().contains(productName));
        cartLink.click();
        return flag;
    }

}
