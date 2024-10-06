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
    private WebDriver driver;
    public WebDriverWait exWait;
    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        exWait = new WebDriverWait(driver , Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
    }


}
