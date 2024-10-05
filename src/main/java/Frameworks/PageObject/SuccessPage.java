package Frameworks.PageObject;

import Frameworks.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessPage extends AbstractComponent {
    private WebDriver driver;
    public SuccessPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    @FindBy(css=".page-title .base")
    WebElement successMessage;

    @FindBy(css=".order-number strong")
    WebElement orderId;

    public boolean validateSuccessMessage(){
        exWait.until(ExpectedConditions.visibilityOf(orderId));
        return successMessage.getText().contains("Thank you for your purchase!");
    }
    public String getOrderId(){
        exWait.until(ExpectedConditions.visibilityOf(orderId));
        return orderId.getText();
    }

}
