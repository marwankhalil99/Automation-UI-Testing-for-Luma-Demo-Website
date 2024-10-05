package Frameworks.PageObject;

import Frameworks.AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckOut_Review extends AbstractComponent {
    private WebDriver driver;
    public CheckOut_Review(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @FindBy(css=".payment-method-title")
    List<WebElement> paymentMethodsElements;

    By paymentMethodsLabelBy = By.cssSelector("label span");
    By radioBtnBy = By.cssSelector("input[name='payment[method]']");
//    By radioBtnBy = By.xpath("//input[@id='checkmo']");
    By placeOrderBy = By.cssSelector("button[class*='checkout']");
    @FindBy(css="button[class*='checkout']")
    WebElement placeOrderBtnElement;

    @FindBy(css="input[name='payment[method]']")
    WebElement radioMethodElement;

    public SuccessPage setPaymentMethod(int paymentMethodIndex) {
        exWait.until(ExpectedConditions.elementToBeClickable(radioMethodElement));
        paymentMethodsElements.get(paymentMethodIndex).findElement(radioBtnBy).click();
        exWait.until(ExpectedConditions.elementToBeClickable(placeOrderBtnElement));
        placeOrderBtnElement.click();
        SuccessPage successPage = new SuccessPage(driver);
        return  successPage;
    }

}
