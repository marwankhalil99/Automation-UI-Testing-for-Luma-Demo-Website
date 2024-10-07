package Frameworks.PageObject;

import Frameworks.AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Products extends AbstractComponent {
    WebDriver driver;
    static int flagAddToCart = 1;
    static int flagSuccessMessage = 1;
    public Products(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    @FindBy(css="div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement messageElement;

    @FindBy(css=".product-item")
    List<WebElement> productsElement;

    @FindBy(css=".product-item")
    WebElement productsWaitElement;

    @FindBy(css=".swatch-attribute-options")
    List<WebElement> colorElements;

    @FindBy(xpath="//span[@class='swatch-label']")
    By productNameLocator = By.cssSelector(".product-item-link");

    By colorElement = By.xpath("(//div[@class='swatch-option color'])[1]");

    By addToCartElement = By.cssSelector(".action.tocart.primary");

    public List<WebElement> getProducts() {
        exWait.until(ExpectedConditions.visibilityOf(productsWaitElement));
        return productsElement;
    }

    public WebElement getProductByName(String name) {
        if(flagAddToCart == 1) {
            exWait.until(ExpectedConditions.visibilityOf(productsWaitElement));
            flagAddToCart = 0;
        }
        WebElement prod = productsElement.stream().filter(s -> s.findElement(productNameLocator).getText().contains(name)).findFirst().orElse(null);
        return prod;
    }
    public void addToCart(String productName , String color , String size)  {
        WebElement prod = getProductByName(productName);
        prod.findElement(By.cssSelector("div[aria-label='"+color+"']")).click();
        prod.findElement(By.cssSelector("div[data-option-tooltip-value='"+size+"']")).click();
        exWait.until(ExpectedConditions.visibilityOf(prod.findElement(addToCartElement)));
        prod.findElement(addToCartElement).click();
    }
    public boolean addToCartSuccessMessage(String productName){
        if(flagSuccessMessage == 1) {
            exWait.until(ExpectedConditions.visibilityOf(messageElement));
            flagSuccessMessage = 0;
        }else{
            exWait.until(ExpectedConditions.textToBePresentInElement(messageElement , productName));
        }
        return messageElement.getText().contains("You added "+productName);
    }



}
