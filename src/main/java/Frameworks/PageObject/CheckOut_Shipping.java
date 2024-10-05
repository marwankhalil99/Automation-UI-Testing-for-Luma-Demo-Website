package Frameworks.PageObject;

import Frameworks.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOut_Shipping extends AbstractComponent {
    private WebDriver driver;
    public CheckOut_Shipping(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @FindBy(name="firstname")
    WebElement fnameElement;

    @FindBy(name="lastname")
    WebElement lnameElement;

    @FindBy(name="street[0]")
    WebElement streetElement;

    @FindBy(name="city")
    WebElement cityElement;

    @FindBy(name="postcode")
    WebElement zipCodeElement;

    @FindBy(name="telephone")
    WebElement phoneElement;

    @FindBy(css="input[value='flatrate_flatrate']")
    WebElement fixedRadioBtn;

    @FindBy(css="input[value='tablerate_bestway']")
    WebElement tableRateRadioBtn;

    @FindBy(css=".button.action.continue.primary")
    WebElement nextBtnElement;

    @FindBy(name="country_id")
    WebElement countryElement;

    Select countrySelect = new Select(countryElement);

    @FindBy(name="region_id")
    WebElement stateElement;

    Select stateSelect = new Select(stateElement);

    public CheckOut_Review setShoppingAddress(String fname, String lname, String street , String country , String state , String city , String zipCode , String phone , String ShippingMethod){
        exWait.until(ExpectedConditions.visibilityOf(fnameElement));
        fnameElement.sendKeys(fname);
        lnameElement.sendKeys(lname);
        streetElement.sendKeys(street);
        cityElement.sendKeys(city);
        zipCodeElement.sendKeys(zipCode);
        phoneElement.sendKeys(phone);
        countrySelect.selectByVisibleText(country);
        stateSelect.selectByVisibleText(state);
        exWait.until(ExpectedConditions.elementToBeClickable(fixedRadioBtn));
        if(ShippingMethod.equalsIgnoreCase("Fixed")){
            fixedRadioBtn.click();
        }else if(ShippingMethod.equalsIgnoreCase("Table Rate")){
            tableRateRadioBtn.click();
        }
        nextBtnElement.click();
        CheckOut_Review checkOutReview = new CheckOut_Review(driver);
        return checkOutReview;
    }
}
